package com.example.demo.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Blogs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(updatable = false)
    private Timestamp create_time;
    @Column
    private Timestamp update_time;
    @Column
    private Integer user_id;

    @PrePersist
    public void onPrePersist() {
	setCreate_time(new Timestamp(System.currentTimeMillis()));
	setUpdate_time(new Timestamp(System.currentTimeMillis()));
    }

    @PreUpdate
    public void onPreUpdate() {
	setUpdate_time(new Timestamp(System.currentTimeMillis()));
    }

}
