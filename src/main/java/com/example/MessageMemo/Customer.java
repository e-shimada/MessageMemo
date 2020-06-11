package com.example.MessageMemo; 


//import java.sql.Timestamp; 

import javax.persistence.Column; //javax.persistenceパッケージ
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="M_CUSTOMER") 
public class Customer {   
	@Id 
	@Column(name="C_CD" ,columnDefinition = "VARCHAR(4)") 
	private String c_num;
	
	@Column(name="C_NAME" ,nullable = false ,columnDefinition = "VARCHAR(100)")
	private String c_name;
	

	public String getC_num() { //ゲッタとセッタ
		return c_num;
	}
	
	public String getC_name() {
		return c_name;
	}
	public void setC_num(String c_num) {
		this.c_num = c_num;
	}
	
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	
	public void setAll(  String c_num  
						,String c_name) {
		this.c_num = c_num;
		this.c_name = c_name;
	}
	
}
