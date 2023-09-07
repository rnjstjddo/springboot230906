package org.example.springboot230906.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {


    //전체게시글목록
    @Query("select p from Posts p order by p.id desc")
    List<Posts> findAllDesc();


}
