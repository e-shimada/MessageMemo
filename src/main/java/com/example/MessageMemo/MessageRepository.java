package com.example.MessageMemo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
//ここでは、エンティティのクラスとエンティティIDのクラス、 CustomerEntity と String を指定します。
public interface MessageRepository extends CrudRepository<Message, String> {
	
	@Query(value = "SELECT COUNT(M_ID) FROM T_MESSAGE", nativeQuery = true) //SQL レコードの件数をcountする
	public int loadT_message();

}





