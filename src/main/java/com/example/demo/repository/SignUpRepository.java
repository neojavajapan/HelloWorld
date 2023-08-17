package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.User;

public interface SignUpRepository extends JpaRepository<User, Integer> {

}
