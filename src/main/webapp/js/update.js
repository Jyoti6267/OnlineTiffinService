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
function validate(){


    let a = validateFullName() ;
    let b =  validateAddress() ;
    let c =  validatePassword() ;
    let d =  validatePinCode();
    return a && b && c && d ;

}