package com.example.demo.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupForm {
	
	//*バリデーションの順番をマッピングするために、各アノテーションのgroupa属性にインターフェースを指定する
	
	@NotBlank(groups = ValidGroup1.class)
	@Email(groups = ValidGroup2.class)
	private String userId;
	
	@NotBlank(groups = ValidGroup1.class)
	@Length(min = 4, max = 100, groups = ValidGroup2.class)
	
	/* "[\\w]*" 英数字かアンダーバーを表す（a-z,A-Z,0-9) 
	 * 脆弱生につながる可能生があり、
	 * 文字列の先頭にマッチする（\A)と文字列の末尾でマッチする（\z,\Z)を使用ほうがよい
	 */
	@Pattern(regexp = "\\w*", groups = ValidGroup3.class)
	private String password;
	
	@NotBlank(groups = ValidGroup1.class)
	private String userName;
	
	//*Date型にバインドする際@DateTimeFormatアノテーションを使う
	//*pattern属性に設定したフォーマットで入力されれば、Date型にバインドできる
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@NotNull(groups = ValidGroup1.class)
	private Date birthday;
	
	@Min(value = 20, groups = ValidGroup2.class)
	@Max(value = 100, groups = ValidGroup2.class)
	private Integer age;
	
	@NotNull(groups = ValidGroup1.class)
	private Integer gender;
	
}
