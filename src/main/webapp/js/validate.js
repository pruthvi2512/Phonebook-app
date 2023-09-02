 function validatename(str){
	
	var reg=/[a-zA-Z' ']+$/;
	var result=str.match(reg);
	//alert(result);
	if(result==null){
		var span=document.getElementById("span");
		span.innerHTML="incorrect input";
		span.style.color="red";
		
	}
	else{var span=document.getElementById("span");
		span.innerHTML="";
		span.style.color="white";
		
	}
}
function validateemail(str){
	
	if(str.match(/[^A-Z' ' # ! $ % & * < > ? <= >= =]+$/)==null||((str.match(/@/g)!=null)&& ((str.indexOf("@")==0)||(str.match(/@/g).length>1)))){
		var span=document.getElementById("e");
		span.innerHTML="incorrect input";
		span.style.color="red";
	}
	else{
		var span=document.getElementById("e");
		span.innerHTML="";
		span.style.color="white";
	}
	
}
function validatenumber(str){
	var result= /^\d{10}$/;
	//alert(result.test(str));
	if(result.test(str)){
		var span=document.getElementById("nu");
		span.innerHTML="";
		span.style.color="white";
		
	}
	else{
		var span=document.getElementById("nu");
		span.innerHTML="invalid number";
		span.style.color="red";
		//document.getElementById("num").style.borderColor="red";
	}


}
function ajaxcall(str){
	
	let xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(this.readyState==4 && this.status==200){
		  var span=	document.getElementById("e1").innerHTML=this.responseText;
			span.style.color="red";
		}
	};
	xhttp.open("GET",'verifyemail?email='+str,true);
	xhttp.send();
}
function searchname(str){
	
	let xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(this.readyState==4 && this.status==200){
		  	document.getElementById("d").innerHTML=this.responseText;
			
		}
	};
	xhttp.open("GET",'searchname?data='+str,true);
	xhttp.send();
	
	
}







/**
 * 
 */