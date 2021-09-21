package com.example.demo.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupForm {
	
	private String userId;
	private String password;
	private String userName;
	
	//*Date型にバインドする際@DateTimeFormatアノテーションを使う
	//*pattern属性に設定したフォーマットで入力されれば、Date型にバインドできる
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date birthday;
	
	private Integer age;
	private Integer gender;
	
}
