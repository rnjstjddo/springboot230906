package org.example.springboot230906.web;

import lombok.RequiredArgsConstructor;
import org.example.springboot230906.service.posts.PostsService;
import org.example.springboot230906.web.dto.PostsListResponseDto;
import org.example.springboot230906.web.dto.PostsResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {


    private final PostsService ps;


    @GetMapping("/")
    public String index(Model model){
        System.out.println("컨트롤러 IndexController index() 진입");
        List<PostsListResponseDto> dto = ps.findAllDesc();
        System.out.println("List<PostsListResponseDto> 출력 -> ");
        System.out.println(dto.toArray());
        System.out.println("--");
        System.out.println(dto.toString());
        System.out.println("--");
        System.out.println(Arrays.asList(dto));
        model.addAttribute("posts", dto);
        return "index";
    }

    @GetMapping("/posts/save")
    public String postSave(){
        System.out.println("컨트롤러 IndexController postSave() 진입");

        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model){
        System.out.println("컨트롤러 IndexController postUpdate() 진입");
        System.out.println("컨트롤러 IndexController postUpdate() 진입 게시글번호 -> "+id);

        PostsResponseDto dto = ps.findById(id);
        System.out.println("컨트롤러 IndexController postUpdate() 진입 PostsResponseDto -> "+dto.toString());

        model.addAttribute("post", dto);
        return "posts-update";
    }


}
