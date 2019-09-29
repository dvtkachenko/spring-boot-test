package io.spring.boot.service;

import io.spring.boot.entity.User;
import io.spring.boot.repository.UserRepository;
import io.spring.boot.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
@Repository
@Transactional
public class UserServiceJpaRepositoryImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User update(User user) {
        if (user.getId() != null) {
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<User> findByAge(Long age) {
        return userRepository.findByAge(age.intValue());
    }

    @Override
    public List<User> findByComment(String comment) {
        return userRepository.findByComment(comment);
    }
}
