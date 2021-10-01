package com.example.demo.domain.user.model;

import lombok.Data;

//*部署のエンティティクラス（データの入れ物）
@Data
public class Department {
	
	private Integer departmentId;
	private String departmentNameString;
	
}
