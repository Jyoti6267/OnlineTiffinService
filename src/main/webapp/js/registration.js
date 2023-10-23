function validatePassword(){

    let pas = document.getElementById("password");

    password = pas.value;

    password == password == null ? null : password.trim();

    if(password == null || password.length < 5 ) {

        pas.style.borderColor = "red";

        pas.placeholder = "At least 5 characters Required"; 

        return false;
    }

    pas.style.borderColor = "gray";

    pas.placeholder = "Enter your password";

    return true;

}

function validateAddress(){

    let ad = document.getElementById("address");

    address = ad.value; 

    address = address == null ? null : address.trim();

    if(address == null || address == 0 ) {
        
        

        ad.style.borderColor = "red";

        ad.placeholder = "Enter valid address";
        
        return false;
    }

    ad.style.borderColor = "gray";

    ad.placeholder = "Enter your address";

    return true;

}

function validateFullName(){


    let fName = document.getElementById("name");

    let name = fName.value;

    name = name == null ? null : name.trim();

    if(name == null || name.length == 0 ) {



        fName.style.borderColor = "red";

        fName.placeholder = "Enter valid name";

        
        return false;


    }

    fName.style.borderColor = "gray";

    fName.placeholder = "Enter your full name";

    return true;

}

function validatePinCode(){

    let pin = document.getElementById("pincode");

    let code = pin.value;
    

    code = code == null ? null : code.trim();

    if(code == null || code.length != 6 ) {
     
        

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


    pin.style.borderColor = "gray";

    pin.placeholder = "Enter Pin Code";


    return true;

}


function validateOtp(){

    let otp = document.getElementById("otp").value;

    if(otp == null){

        toast("Please enter OTP");
        return false;
    }
    else {

        if(otp.length != 6) {
            toast("Otp is not valid");
            return false;
        }
        else return true;

    }

}

function validate(){


    let a = validateFullName() ;
    let b =  validateAddress() ;
    let c =  validatePassword() ;
    let d =  validatePinCode();
    let e =  validateOtp();
    return a && b && c && d && e;

}


function toast(message){

    let snackbar = document.getElementById("snackbar");

    snackbar.innerText = message;

    myFunction();

}

function validateEmail(email){

    email = email == null ? null : email.trim();

    if(email == null || email.length<3) return false;

    for(let i = 0 ; i < email.length;i++){

        if(email[i]=='@' && email.length - 1 - i >= 1 && i >0  ) return true;

    }

    return false;

}


function otprequest(event) {

    event.preventDefault();

    let email_id = document.getElementById("email").value;

    let url = document.getElementById("link").value;

    let status = validateEmail(email_id);
    
    if(status){

    let promise = fetch(url+"?email="+email_id);

    promise.then((response)=>{
        if(response.ok){
            
            let otp = document.getElementById("otpField");

            otp.style.display="block";
            
            toast("Otp is sent successfully");
        }
        else{
            toast("Not able to send OTP");
        }
    });

    
    
    }
    else {
        toast("Email is not valid");
    }

}