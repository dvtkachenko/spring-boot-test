package io.spring.boot.service.api;

import io.spring.boot.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    void save(User user);
    User create(User user);
    User update(User user);
    void delete(User user);
    List<User> findByName(String name);
    List<User> findByAge(Long age);
    default List<User> findByComment(String comment) { return null; };
}
