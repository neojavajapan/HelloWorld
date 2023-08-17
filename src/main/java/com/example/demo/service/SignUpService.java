package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.repository.SignUpRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SignUpService {
    @Autowired
    SignUpRepository signUpRepository;

    // 実行結果変数
    int serviceResult;

    public int execute(User user) {
	// 実行結果変数に初期値をセット
	serviceResult = 0;
	// 入力されたユーザーIDが既に使われているかをチェック
	Optional<User> result = signUpRepository.findById(user.getUser_id());
	if (result.isPresent()) {
	    // 使用済みならエラー
	    serviceResult = 1;
	} else {
	    // 未使用なら登録

	    signUpRepository.save(user);
	}
	return serviceResult;
    }

}
