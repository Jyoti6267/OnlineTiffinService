<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu - Online Tiffin Service</title>
    <link rel="stylesheet" href="css/menu.css">
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
                    <li class="nav-item">
                        <a class="nav-link" href="profile">Profile</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>

    <section class="menu">
        <div class="container">
            <h2 class="text-center">Our Special Tiffin Menu</h2>

            <c:forEach var = "menu" items="${menus}">
                <div class="row">
                    <c:forEach var = "m" items="${menu}">
                        <div class="col-md-4">
                            <div class="card mb-4 food-card">
                                <img src="${m.url}" class="card-img-top" alt="${m.title}">
                                <div class="card-body">
                                    <h3 class="card-title">${m.title}</h3>
                                    <p class="card-text">
                                        <strong>Cost per Month:</strong> Rs. ${m.price}<br>
                                    </p>
                                    <button class="btn btn-primary" data-toggle="modal" data-target="#${m.id}">Details</button>
                                    <a style="text-decoration:none;" href="payment/${m.id}"><button class="btn btn-primary">Purchase</button></a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </c:forEach>

        </div>
    </section>


    <c:forEach var="menu" items = "${menus}">

        <c:forEach var="m" items="${menu}">

            <div class="modal fade" id="${m.id}" tabindex="-1" role="dialog" aria-labelledby="${m.id}Label" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="tiffinDetailsModal1Label">Details for Special Tiffin 1</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Weekday</th>
                                        <th>Menu</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Sunday</td>
                                        <td>${m.sunday}</td>
                                    </tr>
                                    <tr>
                                        <td>Monday</td>
                                        <td>${m.monday}</td>
                                    </tr>
                                    <tr>
                                        <td>Tuesday</td>
                                        <td>${m.tuesday}</td>
                                    </tr>
                                    <tr>
                                        <td>Wednesday</td>
                                        <td>${m.wednesday}</td>
                                    </tr>
                                    <tr>
                                        <td>Thursday</td>
                                        <td>${m.thursday}</td>
                                    </tr>
                                    <tr>
                                        <td>Friday</td>
                                        <td>${m.friday}</td>
                                    </tr>
        
                                    <tr>
                                        <td>Saturday</td>
                                        <td>${m.saturday}</td>
                                    </tr>
        
                                </tbody>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">OK</button>
                        </div>
                    </div>
                </div>
            </div>

        </c:forEach>


    </c:forEach>


    

    <footer class="bg-dark text-white text-center py-3">
        &copy; 2023 Online Tiffin Service
    </footer>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
