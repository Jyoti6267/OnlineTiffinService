<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Page</title>
    <link rel="stylesheet" href="css/payment.css">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="js/payment.js"></script>
    <link rel="stylesheet" href="css/toast.css">
    <script src="js/toast.js"></script>
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Online Tiffin Service</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Menu</a>
                    </li>
                    
                </ul>
            </div>
        </nav>
    </header>

    <section class="payment-form">
        <div class="container">
            <h2 class="text-center">Payment Details</h2>
            <form id="paymentForm" method="POST" action="payment_handler">
                <div class="form-group">
                    <label for="cardNumber">Card Number</label>
                    <input type="text" class="form-control" id="cardNumber" placeholder="Enter card number" required>
                </div>
                <div class="form-group">
                    <label for="expirationDate">Expiration Date</label>
                    <input type="month" class="form-control" id="expirationDate" placeholder="YYYY-MM" required>
                </div>
                <div class="form-group">
                    <label for="cvv">CVV</label>
                    <input type="text" class="form-control" id="cvv" placeholder="CVV" required>
                </div>
                <div class="form-group">
                    <label for="amount">Amount</label>
                    <input type="text" class="form-control" id="amount" placeholder="Enter the amount" value = "${menu.price}" readonly>
                </div>

                <input type="hidden" class="form-control" id="actual_amount" value = "${menu.price}">

               
                <div class="form-group" style="width:35%">
                    <label for="days">Days</label>
                    <select class="form-control" id="days" name="days">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                        <option value="13">13</option>
                        <option value="14">14</option>
                        <option value="15">15</option>
                        <option value="16">16</option>
                        <option value="17">17</option>
                        <option value="18">18</option>
                        <option value="19">19</option>
                        <option value="20">20</option>
                        <option value="21">21</option>
                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                        <option value="25">25</option>
                        <option value="26">26</option>
                        <option value="27">27</option>
                        <option value="28">28</option>
                        <option value="29">29</option>
                        <option value="30">30</option>

                    </select>
                </div>




                <input type="hidden" class="form-control" id="menu_id" value="${menu.id}">

                <br>

                <input type="submit"  onclick="return validate();" class="btn btn-primary" value="Pay Now"></input>
            </form>
        </div>
    </section>

   

    <script>
       

        let days = document.getElementById("days");
        
        days.onchange = function(event){
            let target = evenet.target;
            let d = target.options[e.selectedIndex].value;

            let amount = document.getElementById("amount");

            let acutal_amount = document.getElementById("actual_amount");

            actual_amount = Number(acutal_amount.value);

            amount.value = Math.ceil((actual_amount/30)*d);

        };



    </script>

<c:if test="${message!= null}">

    <div id="snackbar">${message}</div>
    
    <script>
    
    myFunction();
    
    
    </script>
    
    
</c:if>

     <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
