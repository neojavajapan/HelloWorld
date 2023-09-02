package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.BlogContent;
import com.example.demo.repository.BlogRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BlogContentSortService {
    @Autowired
    BlogRepository blogRepository;

    public List<BlogContent> execute(String value) {
	switch (value) {
	case "1":
	    return blogRepository.findAllSortedByLatest();
	case "2":
	    return blogRepository.findAll();
	case "3":
	    return blogRepository.findAllSortedByLatest();
	default:
	    return blogRepository.findAllSortedByLatest();
	}
    }

    public List<BlogContent> executeFromMyPageTop(String value, Integer user_id) {
	switch (value) {
	case "1":
	    return blogRepository.findByUserIdSortedByLatest(user_id);
	case "2":
	    return blogRepository.findByUserId(user_id);
	case "3":
	    return blogRepository.findByUserIdSortedByLatest(user_id);
	default:
	    return blogRepository.findByUserIdSortedByLatest(user_id);
	}
    }
}
