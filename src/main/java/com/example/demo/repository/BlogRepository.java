package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.BlogContent;

public interface BlogRepository extends JpaRepository<BlogContent, Integer> {
    @Query(value = "SELECT * FROM Blogs ORDER BY update_time", nativeQuery = true)
    List<BlogContent> findAll();

    @Query(value = "SELECT * FROM Blogs ORDER BY update_time DESC", nativeQuery = true)
    List<BlogContent> findAllSortedByLatest();

    @Query(value = "SELECT * FROM Blogs WHERE user_id = :user_id ORDER BY update_time", nativeQuery = true)
    List<BlogContent> findByUserId(@Param("user_id") int user_id);

    @Query(value = "SELECT * FROM Blogs WHERE user_id = :user_id ORDER BY update_time DESC", nativeQuery = true)
    List<BlogContent> findByUserIdSortedByLatest(@Param("user_id") int user_id);

}
