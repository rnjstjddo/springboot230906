package org.example.springboot230906.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository pr;

    @After
    public void cleanup(){
        pr.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        String title= "테스트게시글";
        String content ="테스트본문";

        pr.save(Posts.builder()
                        .title(title)
                        .content(content)
                        .author("author@email.com")
                .build());

        //when
        List<Posts> list= pr.findAll();

        //then
        Posts p = list.get(0);
        assertThat(p.getTitle()).isEqualTo(title);
        assertThat(p.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록(){

        LocalDateTime now = LocalDateTime.of(2023,9,6,0,0,0);

        pr.save(Posts.builder()
                        .title("title")
                        .content("content")
                        .author("author")
                .build());

        //when
        List<Posts> list= pr.findAll();

        Posts p = list.get(0);

        System.out.println("테스트 등록 -> "+ p.getCreatedDate()+", "+p.getModifiedDate());

        assertThat(p.getCreatedDate()).isAfter(now);
        assertThat(p.getModifiedDate()).isAfter(now);
    }

}