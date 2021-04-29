package com.example.test.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void create(User user) {
        userRepository.save(user);
    }

    public User show(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User "  + id + " not found"));
    }

    public void update(User user, Long id) {
        userRepository.findById(id)
                .map(item -> {
                    item.setName(user.getName());
                  return userRepository.save(item);
                })
                .orElseThrow(() -> new IllegalStateException("User "  + id + " not found"));
    }
}
