package org.example.springboot230906.web.dto;


import lombok.Getter;
import lombok.ToString;
import org.example.springboot230906.domain.posts.Posts;

import java.time.LocalDateTime;

@Getter
@ToString
public class PostsListResponseDto {

    private Long id;
    private String title, author;

    private LocalDateTime modifiedDate, createdDate;

    public PostsListResponseDto(Posts entity){
        System.out.println("클래스 PostsListResponseDto 생성자진입 Posts 파라미터로 받는다.");
        System.out.println("파라미터 Posts -> "+ entity);
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author=entity.getAuthor();
        this.createdDate=entity.getCreatedDate();
        this.modifiedDate=entity.getModifiedDate();
        System.out.println(this.toString());
    }

}
