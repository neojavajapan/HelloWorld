package com.example.demo.sessionBeans;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.domain.BlogContent;
import com.example.demo.domain.User;

import lombok.Data;

@SessionScope
@Component
@Data
public class UserBean {
    private User user;
    private List<BlogContent> blogContent;
}
