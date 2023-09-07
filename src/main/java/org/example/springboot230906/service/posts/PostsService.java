package org.example.springboot230906.service.posts;

import lombok.RequiredArgsConstructor;
import org.example.springboot230906.domain.posts.Posts;
import org.example.springboot230906.domain.posts.PostsRepository;
import org.example.springboot230906.web.dto.PostsListResponseDto;
import org.example.springboot230906.web.dto.PostsResponseDto;
import org.example.springboot230906.web.dto.PostsSaveRequestDto;
import org.example.springboot230906.web.dto.PostsUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository pr;

    
    //저장
    @Transactional
    public Long save(PostsSaveRequestDto dto){
        System.out.println("클래스 PostsService save() 진입");
        return pr.save(dto.toEntity()).getId();
    }

    //수정
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto dto){
        System.out.println("클래스 PostsService update() 진입 ");
        Posts p = pr.findById(id).orElseThrow( () -> new IllegalArgumentException("해당게시글이없습니다. id -> "+id));

        p.update(dto.getTitle(), dto.getContent());

        return id;
    }

    //조회
    public PostsResponseDto findById(Long id){
        System.out.println("클래스 PostsService findById() 진입");
        Posts entity = pr.findById(id).orElseThrow( () -> new IllegalArgumentException("해당게시글이 없습니다. id->"+ id));

        return new PostsResponseDto(entity);
    }

    //목록
    @Transactional(readOnly= true)
    public List<PostsListResponseDto> findAllDesc(){
        System.out.println("클래스 PostsService findAllDesc() 진입");
        return pr.findAllDesc().stream().map(p -> {

                    System.out.println("클래스 PostsService Posts출력 목록-> "+p.toString());
                 return   new PostsListResponseDto(p);
                })
                .collect(Collectors.toList());
    }

}
