//受電日時
function setDate(){
    let today=new Date();
    let nowYear=today.getFullYear();
    let nowMonth=today.getMonth()+1;
    let nowDay=today.getDate();

    document.getElementById("today_year").value=nowYear;
    document.getElementById("today_month").value=nowMonth;
    document.getElementById("today_day").value=nowDay;
}

// システム日時
//function setTime() {
//	let today = new Date();
//	let nowHour = today.getHours();
//	let nowMinute = today.getMinutes();
//	
//	if(nowHour >= 0 && nowHour <= 11) {
//		if(nowHour == 0) {
//			document.getElementById("hour").value = nowHour + 12;
//		} else {
//			document.getElementById("hour").value = nowHour;
//		}
//		let check_am = document.getElementById("radio_1");
//		check_am.checked = true;
//	} else {
//		if(nowHour >= 13) {
//			document.getElementById("hour").value = nowHour - 12;
//		} else {
//			document.getElementById("hour").value = nowHour;
//		}
//		let check_pm = document.getElementById("radio_2");
//		check_pm.checked = true;
//	}
//	
//	document.getElementById("minute").value = nowMinute;
//}

function setTime() {
	let today = new Date();
    let hours = today.getHours();
    let minutes = today.getMinutes(); 

   document.getElementById("hour").value = hours;
   document.getElementById("minute").value = minutes;

   // 13時以降の場合
   if (hours > 12) {
       document.getElementById("hour").value = hours - 12;
   } else if (hours == 0) {
        document.getElementById("hour").value = 12;
   } else {
        document.getElementById("hour").value = hours;
   }

    // AM・PMのチェック
    if (hours >= 0 && hours <= 11) {
        document.getElementById("am").checked = true;
    } else if(hours >= 12 && hours <= 23) {
       document.getElementById("pm").checked = true;
    }
    
}

//チェックボックス
function checkbox(){
    document.forms['form'].elements['check1'].onclick=ckbox1;
    document.forms['form'].elements['check2'].onclick=ckbox2;
    document.forms['form'].elements['check3'].onclick=ckbox3;
}
function ckbox1(){
    document.forms['form'].elements['check2'].checked=false;
    document.forms['form'].elements['check3'].checked=false;
    check_readonly();
 }
 function ckbox2(){
    document.forms['form'].elements['check1'].checked=false;
    document.forms['form'].elements['check3'].checked=false;
    check_readonly();
 }
 function ckbox3(){
    document.forms['form'].elements['check1'].checked=false;
    document.forms['form'].elements['check2'].checked=false;
    check_readonly();
 }
  window.addEventListener('DOMContentLoaded',checkbox,false);

  //印刷ボタン
document.getElementById("print").onclick = function(){
    window.print();
}

//読み取り専用
function check_readonly(){
	let t = document.getElementById("target");
	let c3= document.getElementById("check3");//check_add=3
	let result = c3.checked; //resultはcheck3がチェックされてる
  if (result == true) {
      t.readOnly = false;
  } else {
      t.readOnly = true;
      target.value ="";
  }
}



//入力チェック
// チェックボックスのいずれかにチェックされていない場合は、メッセージ（「対応のいづれかにチェックしてください」など）を表示すること
//「伝言あります」にチェックが入っている場合にのみ、メモは必須になります
function formCheck(){  
	let flag = 0;
    if( document.form.check1.checked == false && document.form.check2.checked == false && document.form.check3.checked == false){
        flag = 1;
        document.getElementById( 'notice-input-text-1' ).style.display = "block";
       
    }else{
        document.getElementById( 'notice-input-text-1' ).style.display = "none";
        
    }
    
    if( document.form.check3.checked == true && document.form.memo.value == ""){
    	flag = 1;
        document.getElementById( 'notice-input-text-2' ).style.display = "block";
     
    }else{
        document.getElementById( 'notice-input-text-2' ).style.display = "none";
     
    }
    
    if( flag ){ // 入力必須項目に未入力があった場合
        return false; // 送信中止
    }else{ // 入力必須項目が全て入力済みだった場合
        return true; // 送信実行
    }

 }


