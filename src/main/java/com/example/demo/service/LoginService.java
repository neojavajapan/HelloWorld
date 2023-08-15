package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.repository.LoginRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LoginService {
    @Autowired
    LoginRepository loginRepository;

    public Optional<User> findById(Integer id) {
	return loginRepository.findById(id);
    }

}
