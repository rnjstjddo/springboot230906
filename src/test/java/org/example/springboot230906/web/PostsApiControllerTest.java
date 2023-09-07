package org.example.springboot230906.web;

import org.example.springboot230906.domain.posts.Posts;
import org.example.springboot230906.domain.posts.PostsRepository;
import org.example.springboot230906.web.dto.PostsSaveRequestDto;
import org.example.springboot230906.web.dto.PostsUpdateRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate trt;

    @Autowired
    private PostsRepository pr;

    @After
    public void tearDown() throws Exception{
        pr.deleteAll();
    }

    @Test
    public void Posts_등록된다() throws Exception{

        String title="title";
        String content ="content";

        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .title(title)
                .content(content)
                .author("author")
                .build();

        String url="http://localhost:"+port+"/api/v1/posts";

        //when
        ResponseEntity<Long> response = trt.postForEntity(url, dto, Long.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isGreaterThan(0L);

        List<Posts> list = pr.findAll();
        assertThat(list.get(0).getTitle()).isEqualTo(title);
        assertThat(list.get(0).getContent()).isEqualTo(content);
    }

    //수정
    @Test
    public void Posts_수정된다() throws Exception{

        Posts p =pr.save(Posts.builder()
                        .title("title")
                        .content("content")
                        .author("author")
                .build());

        Long id = p.getId();

        String title ="update";
        String content = "update";

        PostsUpdateRequestDto dto = PostsUpdateRequestDto.builder()
                .title(title)
                .content(content)
                .build();

        String url ="http://localhost:"+port+"/api/v1/posts/"+id;

        HttpEntity<PostsUpdateRequestDto> http = new HttpEntity<>(dto);

        //when
        ResponseEntity<Long> response = trt.exchange(url, HttpMethod.PUT, http, Long.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isGreaterThan(0L);

        List<Posts> list= pr.findAll();

        assertThat(list.get(0).getTitle()).isEqualTo(title);
        assertThat(list.get(0).getContent()).isEqualTo(content);
    }
}