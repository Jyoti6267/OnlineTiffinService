<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration - Online Tiffin Service</title>
    <link rel="stylesheet" href="css/registration.css">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="js/registration.js"></script>
    <link rel="stylesheet" href="css/toast.css">
    <script src="js/toast.js"></script>
    <style>
    #otpField {
                display: none;
            }
    </style>
</head>
<body>

    <input type = hidden value="${link}" id="link">

    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="home">Online Tiffin Service</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="home">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login">Login</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>

    <section class="user-registration">
        <div class="container">
            <h2 class="text-center">User Registration</h2>
            <form method="post" action="registration">
                <div class="form-group">
                    <label for="fullName">Full Name</label>
                    <input type="text" class="form-control" id="name"  value="${user.name}" placeholder="Enter your full name" name="name">
                </div>
                <div class="form-group">
                    <label for="email">Email Address</label>
                    <input type="email" class="form-control" id="email" value="${user.username}" placeholder="Enter your email address" name="username">
                </div>
                <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address"  value="${user.address}" placeholder="Enter your address" name="address">
                </div>
                <div class="form-group">
                    <label for="district">District</label>
                    <select class="form-control" id="district" name="district" required>
                        <option value="">Select District</option>
                        <option value="Central Delhi">Central Delhi</option>
                        <option value="East Delhi">East Delhi</option>
                        <option value="New Delhi">New Delhi</option>
                        <option value="North Delhi">North Delhi</option>
                        <option value="North East Delhi">North East Delhi</option>
                        <option value="North West Delhi">North West Delhi</option>
                        <option value="Shahdara">Shahdara</option>
                        <option value="South Delhi">South Delhi</option>
                        <option value="South East Delhi">South East Delhi</option>
                        <option value="South West Delhi">South West Delhi</option>
                        <option value="West Delhi">West Delhi</option>


                    </select>
                </div>
                <div class="form-group">
                    <label for="address">Pin Code</label>
                    <input type="text" class="form-control" id="pincode" value="${user.pincode}" placeholder="Enter Pin Code" name="pincode">
                </div>
                <div class="form-group">
                    <label for="mobile">Mobile Number</label>
                    <input type="tel" class="form-control" id="mobile" value="${user.mobile}" placeholder="Enter your mobile number" name="mobile">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" placeholder="Enter your password" name="password">
                </div>



                 <div id="otpField">
                        <div class="form-group">
                              <label for="otp">OTP</label>
                                  <input type="password" class="form-control" id="otp" placeholder="Enter OTP" name="otp">
                          </div>
                  </div>

                <button type="button" class="btn btn-primary" id="getOTPButton" onclick = "otprequest(event)">Get OTP</button>

                <br>
                <br>

                <input type="submit"  onclick="return validate();"  class="btn btn-primary" value="Register"></input>
            </form>
        </div>
    </section>

    <div id="snackbar"></div>

    <c:if test="${message!= null}">

        
        
        <script>
        
        toast("${message}")
        
        
        </script>
        
        
    </c:if>
    <footer class="bg-dark text-white text-center py-3" style="margin-top: 5%;">
        &copy; 2023 Online Tiffin Service
    </footer>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>