<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Profile - Online Tiffin Service</title>
    <link rel="stylesheet" href="css/registration.css">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
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
            <h2 class="text-center">Update Profile</h2>
            <form>
                <div class="form-group">
                    <label for="fullName">Full Name</label>
                    <input type="text" class="form-control" id="name" placeholder="Enter your full name" name="name">
                </div>
                <div class="form-group">
                    <label for="email">Email Address</label>
                    <input type="email" class="form-control" id="email" placeholder="Enter your email address" name="username" readonly>
                </div>
                <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address" placeholder="Enter your address" name="address">
                </div>
                <div class="form-group">
                    <label for="district">District</label>
                    <select class="form-control" id="district" name="district">
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
                    <input type="text" class="form-control" id="pincode" placeholder="Enter Pin Code" name="pincode">
                </div>
                <div class="form-group">
                    <label for="mobile">Mobile Number</label>
                    <input type="tel" class="form-control" id="mobile" placeholder="Enter your mobile number" name="mobile">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" placeholder="Enter your password" name="password">
                </div>


                <br>

                <button type="submit" class="btn btn-primary">Update</button>
            </form>
        </div>
    </section>
    <footer class="bg-dark text-white text-center py-3" style="margin-top: 5%;">
        &copy; 2023 Online Tiffin Service
    </footer>

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
