package com.example.MessageMemo; 


import java.sql.Timestamp; 

import javax.persistence.Column; //javax.persistenceパッケージ
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="T_MESSAGE") 
public class Message {   
	@Id 
	@Column(name="M_ID" ,columnDefinition = "int(11)") //フィールド
	private int m_id;
	
	@Column(name="TO_NAME" ,nullable = false ,columnDefinition = "VARCHAR(40)") // nullable = falseはnullはダメ TableではNOT NULLとある
	private String to_name;
	
	@Column(name="RECEIVER_CD" ,nullable = false ,columnDefinition = "VARCHAR(5)")
	private String receiver_cd;
	
	@Column(name="RECEIV_TIME" ,nullable = false ,columnDefinition = "datetime")
	private Timestamp receiv_time;
	
	@Column(name="CUSTOMER_CD" ,columnDefinition = "VARCHAR(4)") 
	private String customer_cd;
	
	@Column(name="SENDER" ,nullable = false ,columnDefinition = "VARCHAR(40)")
	private String sender;
	
	@Column(name="MESSAGE_CD",nullable = false ,columnDefinition = "CHAR(1)")
	private String message_cd;
	
	@Column(name="MEMO" ,columnDefinition = "VARCHAR(256)") 
	private String memo;
	
	@Column(name="UPDATE_DATE" ,columnDefinition = "datetime") 
	private Timestamp update_date;
	
	@Column(name="UPDATE_USER" ,columnDefinition = "VARCHAR(40)") 
	private String update_user;
	
	@Column(name="CREATE_DATE" ,columnDefinition = "datetime") 
	private Timestamp create_date;
	
	@Column(name="CREATE_USER" ,columnDefinition = "VARCHAR(40)") 
	private String create_user;
	
	public int getM_id() { //ゲッタとセッタ
		return m_id;
	}
	
	public void setM_id (int m_id) {
		this.m_id = m_id;
	}
	
	public String getTo_name() {
		return to_name;
	}
	public void setTo_name(String to_name) {
		this.to_name = to_name;
	}
	
	public String getReceiver_cd() {
		return receiver_cd;
	}
	
	public void setReceiver_cd(String receiver_cd) {
		this.receiver_cd = receiver_cd;
	}	

	public Timestamp getReceiv_time() {
		return receiv_time;
	}
	
	public void setReceiv_time(Timestamp receiv_time) { 
		this.receiv_time = receiv_time;
	}
	
	public String getCustomer_cd(){
		return customer_cd;
	}
	
	public void setCustomer_cd(String customer_cd) {
		this.customer_cd = customer_cd;
	}
	
	public String getSender(){
		return sender;
	}
	
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public String getMessage_cd(){
		return message_cd;
	}
	
	public void setMessage_cd(String message_cd) {
		this.message_cd = message_cd;
	}
	
	public String getMemo(){
		return memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	//setAll
	public void setAll(  int m_id  
						,String to_name
						,String receiver_cd
						,Timestamp receiv_time //Timestamp Timestamp クライアント(html)で何年何月何日と文字列で入力されたらTimestamp Timestampに変換されフィールドに入る
						,String customer_cd
						,String sender
						,String message_cd
						,String memo
						) {
		this.m_id = m_id;
		this.to_name = to_name;
		this.receiver_cd = receiver_cd;
		this.receiv_time = receiv_time; 
		this.customer_cd = customer_cd;
		this.sender = sender;
		this.message_cd = message_cd;
		this.memo = memo;
	}
	
	public Timestamp getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Timestamp update_date) {
		this.update_date = update_date;
	}
	public String getUpdate_user() {
		return update_user;
	}
	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreatedate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	public String getCreate_user() {
		return create_user;	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
}
