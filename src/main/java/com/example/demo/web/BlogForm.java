package com.example.demo.web;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BlogForm {
    @NotNull
    @Size(min = 1, max = 30)
    private String title;
    @NotNull
    @Size(min = 1, max = 100)
    private String content;
    private Integer id;

}
