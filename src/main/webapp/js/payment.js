function validateCard(){

    let card = document.getElementById("cardNumber");

    let card_number = card.value;

    if(card_number.length!=12){

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


        card.style.borderColor = "gray";

        card.placeholder = "Enter card number";

        return true;


    }

}

function validateCVV(){

    let cvv = document.getElementById("cvv");

    let cvv_number = cvv.value;

    if(cvv_number.length!=3){

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

        cvv.style.borderColor = "gray";

        cvv.placeholder = "CVV";


        return true;


    }

}


function validate(){

    let a = validateCard();
    let b = validateCVV();
    return a && b;
}
