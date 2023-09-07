package org.example.springboot230906.web.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class PostsUpdateRequestDto {

    private String title, content;

    @Builder
    public PostsUpdateRequestDto(String title, String content){

        System.out.println("클래스 PostsUpdateRequestDto 생성자진입");
        this.title = title;
        this.content = content;
    }

}
