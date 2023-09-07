package org.example.springboot230906.web.dto;

import lombok.Getter;
import lombok.ToString;
import org.example.springboot230906.domain.posts.Posts;

@Getter
@ToString
public class PostsResponseDto {

    private Long id;

    private String title, content, author;

    public PostsResponseDto(Posts p){
        System.out.println("클래스 PostsResponseDto 생성자 진입");
        this.id = p.getId();
        this.title= p.getTitle();
        this.content = p.getContent();
        this.author=p.getAuthor();
    }

}


