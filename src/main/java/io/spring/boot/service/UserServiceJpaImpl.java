package io.spring.boot.service;

import io.spring.boot.entity.User;
import io.spring.boot.service.api.UserService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Repository
@Transactional
public class UserServiceJpaImpl implements UserService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findAll() {
        return em.createNamedQuery(User.NQ_FIND_ALL).getResultList();
    }

    @Override
    public User findById(Long id) {
        return em.find(User.class, id.intValue());
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public User update(User user) {
        if (user.getId() != null) {
            return em.merge(user);
        }
        return null;
    }

    @Override
    public void delete(User user) {
        em.remove(user);
    }

    @Override
    public List<User> findByName(String name) {
        return null;
    }

    @Override
    public List<User> findByAge(Long age) {
        return null;
    }
}
