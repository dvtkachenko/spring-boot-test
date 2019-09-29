package io.spring.boot.web.rest;

import io.spring.boot.entity.User;
import io.spring.boot.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MainRestController {

    @Autowired
    @Qualifier("userServiceJpaRepositoryImpl")
//    @Qualifier("userServiceJpaImpl")
//    @Qualifier("userServiceHibernateImpl")
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "It is main Spring boot rest controller!";
    }

    @GetMapping("/users")
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/by")
    public List<User> getUserByName(@RequestParam Map<String, String> allParams) {
        if(allParams.get("name") != null) {
            return userService.findByName(allParams.get("name"));
        }
        if(allParams.get("age") != null) {
            return userService.findByAge(Long.valueOf(allParams.get("age")));
        }
        if(allParams.get("comment") != null) {
            return userService.findByComment(allParams.get("comment"));
        }
        return null;
    }

//    @GetMapping("/users/by")
//    public List<User> getUserByName(@RequestParam(name="name", required = false) String name) {
//        return userService.findByName(name);
//    }

//    @GetMapping("/users")
//    public List<User> getUserByAge(@RequestParam(name="age", defaultValue = "18", required = false) long age) {
//        return userService.findByAge(age);
//    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") long id) {
        return userService.findById(id);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        userService.save(user);
    }

    @PutMapping("/users")
    public void updateUser(@RequestBody User user) {
        userService.update(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        final User deletedUser = userService.findById(id);
        userService.delete(deletedUser);
    }
}
