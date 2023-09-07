package org.example.springboot230906.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=1000, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){

        this.title= title;
        this.content = content;
        this.author = author;
    }

    //수정추가
    public void update(String title, String content){
        System.out.println("클래스 Posts update() 수정메소드 진입 ");
        this.title =title;
        this.content=content;
    }

}
