package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.user.model.MUser;

//*MyBatisでリポジトリーを作成するために、Javaのインターフェースに@Mapperアノテーションを付ける
@Mapper
public interface UserMapper {
	
	//*ユーザー登録
	public int insertOne(MUser user);
	
	//*ユーザー取得
	//*select文の実行結果が複数件になる場合、メソッドの戻り値をListにする
	public List<MUser> findMany(MUser user);
	
	//*ユーザー取得（１件）
	public MUser findOne(String userId);
	
	//*複数のパラメーターを使用する場合、メソッドの引数に@Paramアノテーションを付ける
	//*このアノテーションの値にはパラメーター名を指定する
	//*ユーザー更新（１件）
	public void updateOne(@Param("userId") String userId,
			@Param("password") String password,
			@Param("userName") String userName);
	
	//*ユーザー削除（１件）
	public int deleteOne(@Param("userId") String userId);
	
}
