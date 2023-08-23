package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.BlogContent;
import com.example.demo.repository.BlogRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BlogService {
    @Autowired
    BlogRepository blogRepository;

    public List<BlogContent> findAll() {
	List<BlogContent> list = blogRepository.findAll();
	return list;
    }

    public Optional<BlogContent> findById(Integer id) {
	return blogRepository.findById(id);
    }

    public BlogContent create(BlogContent blogContent) {
	return blogRepository.save(blogContent);
    }

    public BlogContent update(BlogContent blogContent) {
	return blogRepository.save(blogContent);
    }

    public void delete(Integer id) {
	blogRepository.deleteById(id);
    }

    public List<BlogContent> findByUserId(int user_id) {
	return blogRepository.findByUserId(user_id);
    }

}
