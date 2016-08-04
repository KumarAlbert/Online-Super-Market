function registerValidation() {
    var firstName = document.getElementById('firstName').value;
    var lastName = document.getElementById('lastName').value;
    var mobileNumber = document.getElementById('mobileNumber').value;
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('confirmPassword').value;
    console.log(firstName);
	  var string = /^[a-zA-Z ]{2,30}$/;
    var number = /^[789][0-9]{9}$/;
    if (string.test(firstName)) {
    	if (string.test(lastName)) {
    		if(number.test(mobileNumber)) {
    			if(password == confirmPassword){
    				return true;
    			}
	    		else {
	    	    	alert("Confirm password mismatch!!!");
	    	    }
    		}
    		else {
    	    	alert("Enter valid mobile number!!!");
    	    }
    	}
    	else {
        	alert("Enter valid last name!!!");
        }
    }
    else {
    	alert("Enter valid first name!!!");
    }
}