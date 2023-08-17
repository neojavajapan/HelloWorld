package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.BlogContent;
import com.example.demo.domain.User;
import com.example.demo.mapping.FormMapping;
import com.example.demo.service.BlogService;
import com.example.demo.service.LoginService;
import com.example.demo.service.SignUpService;
import com.example.demo.web.BlogForm;
import com.example.demo.web.LoginForm;
import com.example.demo.web.SignUpForm;

@Controller
public class MainController {
    @Autowired
    FormMapping formMapping;

    @Autowired
    BlogService blogService;

    @Autowired
    LoginService loginService;

    @Autowired
    SignUpService signUpService;

    @ModelAttribute
    BlogForm setUpBlogForm() {
	return new BlogForm();
    }

    @ModelAttribute
    LoginForm setUpLoginForm() {
	return new LoginForm();
    }

    @ModelAttribute
    SignUpForm setSignUpForm() {
	return new SignUpForm();
    }

    @RequestMapping("/")
    String pageTop(Model model) {
	List<BlogContent> blogContents = blogService.findAll();
	model.addAttribute("blogContents", blogContents);
	return "pageTop";
    }

    @RequestMapping(path = "create", params = "commit", method = RequestMethod.POST)
    String create(@Validated BlogForm form, BindingResult result, Model model) {
	if (result.hasErrors()) {
	    model.addAttribute(model);
	    return "createBlog";
	}
	BlogContent blogContent = new BlogContent();
	BeanUtils.copyProperties(form, blogContent);
	blogService.create(blogContent);
	return "redirect:/";
    }

    @RequestMapping(path = "create", params = "back")
    String back() {
	return "redirect:/";
    }

    @RequestMapping(path = "header", params = "write")
    String goEdit() {
	return "createBlog";
    }

    @RequestMapping(path = "header", params = "login")
    String goLogin() {
	return "login";
    }

    @RequestMapping(path = "edit")
    String edit(@RequestParam Integer id, Model model) {
	Optional<BlogContent> blogContent = blogService.findById(id);
	blogContent.ifPresent(x -> {
	    model.addAttribute("blogForm", x);
	});
	return "createBlog";
    }

    @RequestMapping(path = "create", params = "edit")
    String edit(@Validated BlogForm form, @RequestParam Integer id, BindingResult result, Model model) {
	if (result.hasErrors()) {
	    model.addAttribute(model);
	    return "createBlog";
	}
	BlogContent blogContent = new BlogContent();
	BeanUtils.copyProperties(form, blogContent);
	blogService.update(blogContent);
	return "redirect:/";
    }

    @RequestMapping(path = "create", params = "delete")
    String delete(BlogForm form, @RequestParam Integer id, Model model) {
	blogService.delete(id);
	return "redirect:/";
    }

    @RequestMapping(path = "login", params = "login")
    String login(@Validated LoginForm form, BindingResult result, Model model) {
	if (result.hasErrors()) {
	    model.addAttribute(model);
	    return "login";
	}
	Optional<User> user = loginService.findById(form.getUser_id());
	if (user.isPresent()) {
	    user.stream().forEach(x -> model.addAttribute("user", x));
	    return "success";
	} else {
	    model.addAttribute(model);
	    return "login";
	}
    }

    @RequestMapping(path = "login", params = "signUp")
    String goSignup() {
	return "signUpInput";
    }

    @RequestMapping(path = "signUp", params = "signUp")
    String signUp(@Validated SignUpForm form, BindingResult result, Model model) {
	if (result.hasErrors()) {
	    model.addAttribute(model);
	    return "signUpInput";
	}
	// マッピング処理を行います。
	User user = new User();
	user = formMapping.userMapping(user, form);
	int serviceResult = signUpService.execute(user);
	if (serviceResult == 1) {
	    System.out.println("入力されたユーザーIDは既に使用されています。");
	    model.addAttribute(model);
	    return "signUpInput";
	}
	return "signUpComp";
    }

}
