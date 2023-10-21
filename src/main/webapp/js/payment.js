function validateCard(card_number){

    let card = document.getElementById("cardNumber");

    if(card_number.length()!=12){

        card.style.borderColor = "red";

        card.placeholder = "Enter valid card number";

        return false;

    }
    else {

        for(let i = 0 ; i <= 11 ; i++){

            let temp = card_number.charCodeAt(i);

            if(!(temp>=48 && temp <= 57)) {

                card.style.borderColor = "red";

                card.placeholder = "Enter valid card number";

                return false;
                
            }

        }

        return true;


    }

}

function validateCVV(cvv_number){

    let cvv = document.getElementById("cvv");

    if(cvv_number.length()!=3){

        cvv.style.borderColor = "red";

        cvv.placeholder = "Enter valid cvv number";

        return false;

    }
    else {

        for(let i = 0 ; i <= 2 ; i++){

            let temp = cvv_number.charCodeAt(i);

            if(!(temp>=48 && temp <= 57)) {

                cvv.style.borderColor = "red";

                cvv.placeholder = "Enter valid cvv number";

                return false;
                
            }

        }

        return true;


    }

}


function validate(){


    console.log("Hello world");
    

    return validateCard() && validateCVV();
}