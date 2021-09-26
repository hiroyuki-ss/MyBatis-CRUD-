package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.user.model.MUser;

//*MyBatisでリポジトリーを作成するために、Javaのインターフェースに@Mapperアノテーションを付ける
@Mapper
public interface UserMapper {
	
	//*ユーザー登録
	public int insertOne(MUser user);
	
}
