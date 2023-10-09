
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration - Online Tiffin Service</title>
    <link rel="stylesheet" href="css/registration.css">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    <style>
    #otpField {
                display: none;
            }
    </style>
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
                    <li class="nav-item">
                        <a class="nav-link" href="#">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Register</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>

    <section class="user-registration">
        <div class="container">
            <h2 class="text-center">User Registration</h2>
            <form>
                <div class="form-group">
                    <label for="fullName">Full Name</label>
                    <input type="text" class="form-control" id="fullName" placeholder="Enter your full name">
                </div>
                <div class="form-group">
                    <label for="email">Email Address</label>
                    <input type="email" class="form-control" id="email" placeholder="Enter your email address">
                </div>
                <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address" placeholder="Enter your address">
                </div>
                <div class="form-group">
                    <label for="district">District</label>
                    <select class="form-control" id="district">
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
                    <input type="text" class="form-control" id="address" placeholder="Enter Pin Code">
                </div>
                <div class="form-group">
                    <label for="mobileNumber">Mobile Number</label>
                    <input type="tel" class="form-control" id="mobileNumber" placeholder="Enter your mobile number">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" placeholder="Enter your password">
                </div>

                <button type="button" class="btn btn-primary" id="getOTPButton">Get OTP</button>

                 <div id="otpField">
                        <div class="form-group">
                              <label for="otp">OTP</label>
                                  <input type="text" class="form-control" id="otp" placeholder="Enter OTP">
                          </div>
                  </div>


                <button type="submit" class="btn btn-primary">Register</button>
            </form>
        </div>
    </section>
    <footer class="bg-dark text-white text-center py-3" style="margin-top: 5%;">
        &copy; 2023 Online Tiffin Service
    </footer>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
