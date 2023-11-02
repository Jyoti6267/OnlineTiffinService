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


function validate(){

    return validatePassword() ;

}