package com.example.demo.mapping;

import org.springframework.stereotype.Component;

import com.example.demo.domain.User;
import com.example.demo.web.SignUpForm;

@Component
public class FormMapping {
    public User userMapping(User target, SignUpForm signUpForm) {
	target.setUser_id(signUpForm.getUser_id());
	target.setLogin_password(signUpForm.getLogin_password());
	target.setUser_name(signUpForm.getUser_name());
	return target;
    }

}
