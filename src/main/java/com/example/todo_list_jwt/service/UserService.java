package com.example.todo_list_jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.todo_list_jwt.dto.RegisterRequest;
import com.example.todo_list_jwt.model.User;
import com.example.todo_list_jwt.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(RegisterRequest request) {

        // valida se já existe
        repository.findByUsername(request.getUsername())
            .ifPresent(u -> {
                throw new RuntimeException("Usuário já existe");
            });

        User user = new User();
        user.setUsername(request.getUsername());

        // 🔐 criptografar senha
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return repository.save(user);
    }
}