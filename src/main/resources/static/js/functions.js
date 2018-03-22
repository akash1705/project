$(document).ready(function(){
	
	var resturl="";
	//alert("I am in.");
	
	$("#postBtn").click(function(){
		//event.preventDefault();
		
		var option=$('input[name=userType]:checked').val();
		//alert(option);
		if(option=="hospital")
			resturl="http://localhost:8087/hospital/auth";
		else
			resturl="http://localhost:8087/lab/auth";
		//alert(resturl);
		ajaxLogin(resturl);
	});

	function ajaxLogin(resturl){
		
		//alert("I am in ajaxLogin");
		var formData ={
				email : $("#email").val(),
				password : $("#password").val(),
		}
		
		//alert(resturl);
		
		$.ajax({
		    type : "POST",
            contentType : "application/json",
            url : resturl,
            data : JSON.stringify(formData),
            dataType : 'json',
            success : function(result) {
                //alert(result);
            	if(result==0){
                
                	$("#msg").html("<strong>" + "Post Successfully!</strong>");
                }else{
                	
                	$("#msg").html("<strong>" + "Something Went wrong.</strong>");
                }
                console.log(result);
            },
            error : function(e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });
         
        // Reset FormData after Posting
        resetData();
 
    }
	
	$("#postRegister").click(function(){
		//event.preventDefault();
		
		var option=$('input[name=userType]:checked').val();
		if(option=="hospital")
			resturl="http://localhost:8087/hospital/register";
		else
			resturl="http://localhost:8087/lab/register";
		alert(resturl);
		ajaxRegister(resturl);
		
	});


	function ajaxRegister(resturl){
		var formData ={
				name : $("#name").val(),
				email : $("#email").val(),
				password : $("#password").val(),
				mobileNumber : $("#mobile").val(),
				address : $("#add").val(),
		}
		var email=$("#email").val();
		
		
		$.ajax({
		    type : "POST",
            contentType : "application/json",
            url : resturl,
            data : JSON.stringify(formData),
            dataType : 'text',
            success : function(result) {
            	alert("I am in success of register "+result+" "+email);
                if(result ==email){
                
                	$("#message").html("<strong>" + "Post Successfully!</strong>");
                }else{
                	
                	$("#message").html("<strong>" + "Something Went wrong!</strong>");
                }
                console.log(result);
            },
            error : function(e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });
         
        // Reset FormData after Posting
        resetData();
 
    }

    function resetData(){
        $("#password").val("");
        $("#email").val("");
        resturl="";
        $("#message").val("");
        $("#msg").val("");
    }
});