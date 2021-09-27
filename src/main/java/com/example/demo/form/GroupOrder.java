package com.example.demo.form;

import javax.validation.GroupSequence;

//*@GroupSequenceアノテーション　バリデーションの順番を設定する
//*左から設定されたインターフェースの順番でバリデーションしていく
@GroupSequence({ValidGroup1.class, ValidGroup2.class, ValidGroup3.class})
public interface GroupOrder {

}
