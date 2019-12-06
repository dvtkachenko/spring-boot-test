package io.spring.boot.service;

import io.spring.boot.entity.Post;
import io.spring.boot.entity.User;
import io.spring.boot.exception.UserNotFoundException;
import io.spring.boot.repository.PostRepository;
import io.spring.boot.repository.UserRepository;
import io.spring.boot.service.api.PostService;
import io.spring.boot.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Repository
@Transactional
public class PostServiceJpaRepositoryImpl implements PostService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post create(Long userId, Post post) {
        Optional<User> userOptional = userRepository.findById(userId.intValue());

        if(!userOptional.isPresent()) {
            throw new UserNotFoundException("id-" + userId);
        }

        User user = userOptional.get();
        post.setUser(user);

        return postRepository.save(post);
    }
}
