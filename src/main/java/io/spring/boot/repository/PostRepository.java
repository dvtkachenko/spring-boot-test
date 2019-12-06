package io.spring.boot.repository;

import io.spring.boot.entity.Post;
import io.spring.boot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("select p from Post p where p.description like %:description%")
    List<Post> findByDescription(String description);
}
