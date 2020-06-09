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

// 受電日時
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

////document.getElementById("check3"").onclick = function() {
//    let target = document.getElementById("target");
//        if (document.getElementById("check3").checked) {
//            target.readOnly = false;
//        } else {
//            target.readOnly = true;
//        }
//}


