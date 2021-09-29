package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.user.model.MUser;

//*MyBatisでリポジトリーを作成するために、Javaのインターフェースに@Mapperアノテーションを付ける
@Mapper
public interface UserMapper {
	
	//*ユーザー登録
	public int insertOne(MUser user);
	
	//*ユーザー取得
	//*select文の実行結果が複数件になる場合、メソッドの戻り値をListにする
	public List<MUser> findMany();
	
	//*ユーザー取得（１件）
	public MUser findOne(String userId);
	
}
