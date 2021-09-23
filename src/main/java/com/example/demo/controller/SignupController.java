package com.example.demo.controller;

import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.application.service.UserApplicationService;
import com.example.demo.form.GroupOrder;
import com.example.demo.form.SignupForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")

//*@Slf4j　Lombokのアノテーション　クラスに付けるとログ出力ができる　
//*アノテーションをクラスに付けると、logというstatic変数が用意される　その変数がメソッドを使うと簡単にログが出力出来る
@Slf4j
public class SignupController {
	
	@Autowired
	private UserApplicationService userApplicationService;
	
	
	//*ユーザー登録画面を表示
	//*@ModelAttribute 自動でModelにインスタンスを登録してくれる
	@GetMapping("/signup")
	public String getSignup(Model model, Locale locale, @ModelAttribute SignupForm form) {
		
		//*性別を取得
		Map<String, Integer> genderMap = userApplicationService.getGenderMap(locale);
		model.addAttribute("genderMap", genderMap);
		
		//*ユーザー登録画面に遷移
		return "user/signup";
	}
	
	//*ユーザー登録処理
	//*@ModelAttribute 自動でModelにインスタンスを登録してくれる
	//*@Validatedアノテーションをクラスに付けると、バリデーションが実行する
	//*@Validatedアノテーション内に、GroupOrder.classを指定して、バリデーションの順番設定を反映させる
	@PostMapping("/signup")
	public String postSignup(Model model, Locale locale, 
			@ModelAttribute @Validated(GroupOrder.class)SignupForm form,
			BindingResult bindingResult) {
		
		//*入力チェック結果
		if (bindingResult.hasErrors()) {
			//NG:ユーザー登録画面に戻る
			return getSignup(model, locale, form);
		}
				
		log.info(form.toString());
		
		//*ログイン画面にリダイレクト
		return "redirect:/login";
	}
}
