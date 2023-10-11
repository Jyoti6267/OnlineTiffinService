<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard - Online Tiffin Service</title>
    <link rel="stylesheet" href="css/admin_section.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
                        <a class="nav-link" href="#">Add Meal</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Log Out</a>
                    </li>
                </ul>

            </div>
        </nav>
    </header>

    <section class="admin-orders">
        <br>
        <div class="container">
            <h2 class="text-center">Orders to Dispatch Today</h2>
            <div class="table-responsive">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Customer Name</th>
                            <th>Delivery Address</th>
                            <th>Delivery Time</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>

                        <tr>
                            <td>1</td>
                            <td>Jyoti</td>
                            <td>123 Main St, City</td>
                            <td>12:00 PM</td>
                            <td><button class="btn btn-success" data-toggle="modal" data-target="#confirmationModal">Dispatch</button>
                            </td>
                        </tr>


                        <tr>
                            <td>1</td>
                            <td>Jyoti</td>
                            <td>123 Main St, City</td>
                            <td>12:00 PM</td>
                            <td><button class="btn btn-success" data-toggle="modal" data-target="#confirmationModal">Dispatch</button>
                            </td>
                        </tr>


                         <tr>
                            <td>1</td>
                            <td>Jyoti</td>
                            <td>123 Main St, City</td>
                            <td>12:00 PM</td>
                            <td><button class="btn btn-success" data-toggle="modal" data-target="#confirmationModal">Dispatch</button>
                            </td>
                        </tr>

                         <tr>
                            <td>1</td>
                            <td>Jyoti</td>
                            <td>123 Main St, City</td>
                            <td>12:00 PM</td>
                            <td><button class="btn btn-success" data-toggle="modal" data-target="#confirmationModal">Dispatch</button>
                            </td>
                        </tr>

                         <tr>
                            <td>1</td>
                            <td>Jyoti</td>
                            <td>123 Main St, City</td>
                            <td>12:00 PM</td>
                            <td><button class="btn btn-success" data-toggle="modal" data-target="#confirmationModal">Dispatch</button>
                            </td>
                        </tr>

                         <tr>
                            <td>1</td>
                            <td>Jyoti</td>
                            <td>123 Main St, City</td>
                            <td>12:00 PM</td>
                            <td><button class="btn btn-success" data-toggle="modal" data-target="#confirmationModal">Dispatch</button>
                            </td>
                        </tr>


                         <tr>
                            <td>1</td>
                            <td>Jyoti</td>
                            <td>123 Main St, City</td>
                            <td>12:00 PM</td>
                            <td><button class="btn btn-success" data-toggle="modal" data-target="#confirmationModal">Dispatch</button>
                            </td>
                        </tr>


                         <tr>
                            <td>1</td>
                            <td>Jyoti</td>
                            <td>123 Main St, City</td>
                            <td>12:00 PM</td>
                            <td><button class="btn btn-success" data-toggle="modal" data-target="#confirmationModal">Dispatch</button>
                            </td>
                        </tr>

                         <tr>
                            <td>1</td>
                            <td>Jyoti</td>
                            <td>123 Main St, City</td>
                            <td>12:00 PM</td>
                            <td><button class="btn btn-success" data-toggle="modal" data-target="#confirmationModal">Dispatch</button>
                            </td>
                        </tr>

                         <tr>
                            <td>1</td>
                            <td>Jyoti</td>
                            <td>123 Main St, City</td>
                            <td>12:00 PM</td>
                            <td><button class="btn btn-success" data-toggle="modal" data-target="#confirmationModal">Dispatch</button>
                            </td>
                        </tr>

                         <tr>
                            <td>1</td>
                            <td>Jyoti</td>
                            <td>123 Main St, City</td>
                            <td>12:00 PM</td>
                            <td><button class="btn btn-success" data-toggle="modal" data-target="#confirmationModal">Dispatch</button>
                            </td>
                        </tr>

                         <tr>
                            <td>1</td>
                            <td>Jyoti</td>
                            <td>123 Main St, City</td>
                            <td>12:00 PM</td>
                            <td><button class="btn btn-success" data-toggle="modal" data-target="#confirmationModal">Dispatch</button>
                            </td>
                        </tr>


                    </tbody>
                </table>
            </div>
        </div>
    </section>
    <div class="modal fade" id="confirmationModal" tabindex="-1" role="dialog" aria-labelledby="confirmationModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="confirmationModalLabel">Confirmation</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Are you sure you want to dispatch this order?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="button" class="btn btn-success">Confirm Dispatch</button>
                </div>
            </div>
        </div>
    </div>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>



    <footer class="bg-dark text-white text-center py-3">
        &copy; 2023 Online Tiffin Service - Admin Section
    </footer>


</body>
</html>
