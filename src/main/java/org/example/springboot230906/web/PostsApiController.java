package org.example.springboot230906.web;

import lombok.RequiredArgsConstructor;
import org.example.springboot230906.service.posts.PostsService;
import org.example.springboot230906.web.dto.PostsResponseDto;
import org.example.springboot230906.web.dto.PostsSaveRequestDto;
import org.example.springboot230906.web.dto.PostsUpdateRequestDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService ps;


    //등록
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto dto){
        System.out.println("컨트롤러 PostsApiControllerTest save() /api/v1/posts 진입");
        System.out.println("파라미터 PostsSaveRequestDto -> "+ dto.toString());
        return ps.save(dto);
    }

    //수정
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto dto){
        System.out.println("컨트롤러 PostsApiContentTest update() /api/v1/posts/{id} 진입");
        return ps.update(id, dto);
    }

    //조회
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        System.out.println("컨트롤러 PostsApiContenetTest() findById() /api/v1/posts/{id} 진입 ");
        return ps.findById(id);
    }
    

}
