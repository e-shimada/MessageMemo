package com.example.MessageMemo;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;

//import com.example.MysqlAccess.Customer;

//import com.example.MysqlAccess.Customer;
//import com.example.MysqlAccess.CustomerRepository;
//import com.example.MysqlAccess.EmployeeRepository;

@Controller
public class MessageMemoController {
	@Autowired	// This means to get the bean called CustomerRepository
	// Which is auto-generated by Spring, we will use it to handle the data
    private CustomerRepository customerRepository;
    @Autowired
	private EmployeeRepository employeeRepository;
    @Autowired
    private MessageMemoRepository messageRepository;
    
    @Autowired
    private MessageRepository rep;
	
	@RequestMapping("/msgmemo/inputForm")
    public String index(Model model) {
		
		// M_CUSTOMER M_EMPLOYEE テーブルの全データを取得
		Iterable<Customer> customerList = customerRepository.findAll();
		Iterable<Employee> employeeList = employeeRepository.findAll();
		//Iterable<Message> messageList = messageRepository.findAll();		
		
		// モデルに属性追加
		model.addAttribute("customerlist",customerList);
		model.addAttribute("employeelist",employeeList);
		//model.addAttribute("messagelist",messageList);
		
		// DBアクセスTop画面を表示
        return "messagememo.html"; 
    }
	
	// DB登録処理
		@PostMapping(path="/msgmemo/inputForm")
		public String addNewMessage(	 Model model 
				   									, @RequestParam String to_name
													, @RequestParam String receiver_cd 
													, @RequestParam String receiv_time
													, @RequestParam String customer_cd
													, @RequestParam String sender
													, @RequestParam String message_cd
													, @RequestParam String memo) {  
			
			
		     //受電日時の文字列を分割をする処理
			 //文字列の分割
			 String[] split = receiv_time.split(",", 0);
		    
		     //文字列の結合
		     // pm3:13→15:13に登録する処理
		     int num = Integer.parseInt(split[4]); //整数型に変換
		     String StrH = " ";
		    	 
		    	 if(split[3].equals("pm")) { //文字列の比較 文字列1.equals(文字列2) split[3]がpmという文字列が入ったとき
		    		 StrH = Integer.toString(num+12);
		    	 }else {
		    		 StrH = split[4]; //[4]の文字列がStrHに入る
		    		
		    	 }
		    	 String Str = split[0] + "-" + split[1] + "-" + split[2] + " " + StrH + ":" + split[5];
		    	 System.out.println("StrHは" + StrH + "です");
		    	 
		    	  
		    	 try{        //try文
                     Timestamp ts = new Timestamp(new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(Str).getTime());
                     System.out.println("tsは" + ts+ "です");
                 
		    	 
			
			//自動採番する処理
			int cnt = rep.loadT_message(); //rep(Repository)のloadT_message()→rep.loadT_message()
			int m_id;
			
			//該当テーブルのデータ件数が0件の場合は採番の初期値は1とする
			if (cnt == 0) {
				m_id=1;
			}else {
				m_id=cnt+1;
			}
			
			Message messageAddData = new Message();
			messageAddData.setAll(m_id, to_name, receiver_cd, ts, customer_cd, sender, message_cd, memo); 
			
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			messageAddData.setCreate_date(timestamp);
			messageAddData.setCreate_user("springuser");
			messageAddData.setUpdate_date(timestamp);
			messageAddData.setUpdate_user("springuser");
			
			messageRepository.save(messageAddData);
			
			} catch (ParseException e){        //catch文
			e.printStackTrace();
			}
	
		    //「さん宛てのメッセージを登録しました。」のメッセージ表示
		    model.addAttribute("call",  to_name + "さん宛てのメッセージを登録しました。");
		    
		 // M_CUSTOMER M_EMPLOYEE テーブルの全データを取得
			Iterable<Customer> customerList = customerRepository.findAll();
			Iterable<Employee> employeeList = employeeRepository.findAll();
			
		// モデルに属性追加
			model.addAttribute("customerlist",customerList);
			model.addAttribute("employeelist",employeeList);
			
			return "MessageMemo.html";
		}
	
		
	
	
	
	
	
	
	
}
	