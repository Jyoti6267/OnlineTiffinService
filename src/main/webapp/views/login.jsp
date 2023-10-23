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
                        <a class="nav-link" href="home">Home</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="register">Register</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>

    <section class="user-registration">
        <div class="container">
            <h2 class="text-center">User Login</h2>
            <form method="post" action="profile">

                <div class="form-group">
                    <label for="email">Email Address</label>
                    <input type="email" class="form-control" name="username" id="email" placeholder="Enter your email address">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password">
                </div>

                <input type="submit" class="btn btn-primary" value="Login"></input>
            </form>
        </div>
    </section>

    <c:if test="${message!= null}">

        <div id="snackbar">${message}</div>
        
        <script>
        
        myFunction();
        
        
        </script>
        
        
    </c:if>

    <footer class="bg-dark text-white text-center py-3" style="margin-top: 15%;">
        &copy; 2023 Online Tiffin Service
    </footer>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
