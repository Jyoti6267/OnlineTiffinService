<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%

request.setAttribute("message",request.getParameter("message"));

%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>User Login - Online Tiffin Service</title>
        <link rel="stylesheet" href="css/login.css">
        <link rel="stylesheet" href="css/toast.css">
        <script src="js/toast.js"></script>
         <script src="js/login.js"></script>

        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
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
                            <a class="nav-link" href="home">Home</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
    
        <section class="user-registration">
            <div class="container">
                <h2 class="text-center">Admin Login</h2>
                <form method="post" action="admin_section">
    
                    <div class="form-group">
                        <label for="email">Email Address</label>
                        <input type="email" class="form-control" id="email" placeholder="Enter your email address" name="username">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password">
                    </div>
    
                    <input type="submit" value="Login" onclick = "return validate();" class="btn btn-primary"></input>
                </form>
            </div>
        </section>
        <footer class="bg-dark text-white text-center py-3" style="margin-top: 15%;">
            &copy; 2023 Online Tiffin Service
        </footer>

        <c:if test="${message!= null}">

<div id="snackbar">${message}</div>

<script>

myFunction(false);


</script>


</c:if>
    
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
    </body>
    </html>
    