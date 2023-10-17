function validatePassword(password){

    password == password == null ? null : password.trim();

    if(password == null || password.length() < 5 ) {
     
        let pas = document.getElementById("password");

        pas.style.borderColor = "red";

        pas.placeholder = "At least 5 characters Required"; 

        return false;
    }

    return true;

}

function validateAddress(address){

    address = address == null ? null : address.trim();

    if(address == null || address.length() == 0 ) {
        
        let ad = document.getElementById("address");

        ad.style.borderColor = "red";

        ad.placeholder = "Enter valid address";
        
        return false;
    }

    return true;

}

function validateFullName(name){

    name = name == null ? null : name.trim();

    if(name == null || name.length() == 0 ) {


        let fName = document.getElementById("name");

        fName.style.borderColor = "red";

        fName.placeholder = "Enter valid name";

        
        return false;

    }

    return true;

}

function validatePinCode(code){

    code = code == null ? null : code.trim();

    if(code == null || code.length() != 6 ) { 
     
        
        let pin = document.getElementById("pincode");

        pin.style.borderColor = "red";

        pin.placeholder = "Enter valid pincode";

        return false;

    }

    for(let i = 0 ; i < 5 ; i++){

        let temp = code.charCodeAt(i);

        if(!(temp>=48 && temp <= 57)) {
         
            
            let pin = document.getElementById("pincode");

            pin.style.borderColor = "red";

            pin.placeholder = "Enter valid pincode";

            return false;
            
        }
    }


    return true;

}


function validate(){


    return validateFullName() && validateAddress() && validatePassword() && validatePinCode();

}


function validateEmail(email){

    email = email == null ? null : email.trim();

    if(email.length()<3) return false;

    for(let i = 0 ; i < email.length();i++){

        if(email[i]=='@' && email.length() - 1 - i >= 1 ) return true;

    }

    return false;

}


function otprequest(event) {

    event.preventDefault();

    let email_id = document.getElementById("email").value;

    let status = validateEmail(email_id);
    
    if(status){

    let promise = fetch("http://"+window.location.host+"/otp_request?email="+email_id);

    promise.then((response)=>{
        if(response.ok){
            
            let otp = document.getElementById("otpField");

            otp.style.display="block";
            
            toast("Otp is send successfully");
        }
        else{
            toast("Not able to send OTP");
        }
    });

    
    
    }

}