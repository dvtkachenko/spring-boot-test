package io.spring.boot.repository;

import io.spring.boot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.comment like %:comment%")
    List<User> findByComment(String comment);

    List<User> findByName(String name);
    List<User> findByAge(Integer age);
}
