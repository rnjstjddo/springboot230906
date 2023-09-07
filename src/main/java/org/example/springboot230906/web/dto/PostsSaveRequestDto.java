package org.example.springboot230906.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.springboot230906.domain.posts.Posts;

@Getter
@NoArgsConstructor
@ToString
public class PostsSaveRequestDto {

    private String title, content, author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        System.out.println("클래스 PostsSaveRequestDto 생성자진입");
        this.title = title;
        this.content= content;
        this.author= author;
    }

    public Posts toEntity(){
        System.out.println("클래스 PostsSaveRequestDto toEntity() 진입 Posts 엔티티 반환");

        return Posts.builder().title(title).content(content).author(author).build();
    }


}
