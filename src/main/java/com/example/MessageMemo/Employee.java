package com.example.MessageMemo; //フィールド


//import java.sql.Timestamp;        //import名前を宣言  java.sql.Timestampは小数点以下の時間数値(ミリ秒)まで保持することが出来る

import javax.persistence.Column;  //javax.persistenceパッケージ
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="M_EMPLOYEE") 
public class Employee {   
	@Id 
	@Column(name="E_NUM" ,columnDefinition = "VARCHAR(5)") 
	private String e_num;
	
	@Column(name="E_NAME" ,nullable = false ,columnDefinition = "VARCHAR(40)")
	private String e_name;
	
	public String getE_num() { //ゲッタとセッタ
		return e_num;
	}
	
	public String getE_name() {
		return e_name;
	}
	public void setE_num(String e_num) {
		this.e_num = e_num;
	}
	
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public void setAll(  String e_num     
						,String e_name) {
		this.e_num = e_num;
		this.e_name = e_name;              
	}
}
