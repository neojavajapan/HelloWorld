package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.User;

public interface LoginRepository extends JpaRepository<User, Integer> {

}
