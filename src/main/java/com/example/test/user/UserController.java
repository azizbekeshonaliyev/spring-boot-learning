package com.example.test.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping
    public List<User> index(){
        return userService.getAll();
    }

    @PostMapping
    public void store(@RequestBody User user){
        userService.create(user);
    }

    @GetMapping(path = "{id}")
    public User show(@PathVariable Long id){
        return userService.show(id);
    }

    @PutMapping(path = "{id}")
    public void update(@RequestBody User user, @PathVariable Long id){
        userService.update(user,id);
    }
}
