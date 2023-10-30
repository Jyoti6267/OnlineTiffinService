<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>History - Online Tiffin Service</title>
    <link rel="stylesheet" href="css/admin_section.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/toast.css">
    <script src="js/toast.js"></script>
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="home">Online Tiffin Service</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="profile">Profile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Log Out</a>
                    </li>
                </ul>

            </div>
        </nav>
    </header>

    <section class="admin-orders">
        <br>
        <div class="container">
            <h2 class="text-center">Subscription History</h2>
            <div class="table-responsive">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Order Date</th>
                            <th>Days Left</th>
                            <th>Meal Details</th>
                        </tr>
                    </thead>
                    <tbody>
                    
                        <c:forEach var="order" items="${orders}">
                         <tr>
                            <td>${order.id}</td>
                            <td>${order.order_date}</td>
                            <td>${order.days}</td>
                            <td><button class="btn btn-success" data-toggle="modal" data-target="#id_${order.menu_id}">Check</button>
                            </td>
                            
                        </tr>
                        </c:forEach>

                     
                    </tbody>
                </table>
            </div>
        </div>
    </section>
    



    <c:forEach var="m" items="${menus}">

    <div class="modal fade" id="id_${m.id}" tabindex="-1" role="dialog" aria-labelledby="${m.id}Label" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="tiffinDetailsModal1Label">Details for ${m.title}</h5>
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



    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


    <c:if test="${message!= null}">

        <div id="snackbar">${message}</div>
        
        <script>
        
        myFunction();
        
        
        </script>
        
        
    </c:if>


    <footer class="bg-dark text-white text-center py-3">
        &copy; 2023 Online Tiffin Service - Admin Section
    </footer>


</body>
</html>
