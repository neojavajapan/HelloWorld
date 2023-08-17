package com.example.demo.web;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignUpForm {
    @NotNull
    private Integer user_id;
    @NotNull
    @Size(min = 1, max = 30)
    private String login_password;
    @NotNull
    @Size(min = 1, max = 30)
    private String user_name;

}
