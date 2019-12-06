package io.spring.boot.service.api;

import io.spring.boot.entity.Post;

public interface PostService {
    Post create(Long userId, Post post);
}
