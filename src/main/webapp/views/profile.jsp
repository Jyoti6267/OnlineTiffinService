<html>
    <head>

    <style>
    .main-body {
        padding: 15px;
    }
    .card {
        box-shadow: 0 1px 3px 0 rgba(0,0,0,.1), 0 1px 2px 0 rgba(0,0,0,.06);
    }

    .card {
        position: relative;
        display: flex;
        flex-direction: column;
        min-width: 0;
        word-wrap: break-word;
        background: linear-gradient(to top, #fff1eb 0%, #ace0f9 100%);
        background-clip: border-box;
        border: 0 solid rgba(0,0,0,.125);
        border-radius: .25rem;
    }

    .card-body {
        flex: 1 1 auto;
        min-height: 1px;
        padding: 1rem;
    }

    .gutters-sm {
        margin-right: -8px;
        margin-left: -8px;
    }

    .gutters-sm>.col, .gutters-sm>[class*=col-] {
        padding-right: 8px;
        padding-left: 8px;
    }
    .mb-3, .my-3 {
        margin-bottom: 1rem!important;
    }

    .bg-gray-300 {
        background:linear-gradient(to top, #fff1eb 0%, #ace0f9 100%);
    }
    .h-100 {
        height: 100%!important;
    }
    .shadow-none {
        box-shadow: none!important;
    }


    </style>



    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="toast.js"></script>
    <link rel="stylesheet" href="toast.css">
    <link rel="stylesheet" href="css/profile.css">
    <title>Profile</title>

    </head>


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



    <body>

          <div class="container">
            <div class="main-body">

                  <div class="row gutters-sm">
                    <div class="col-md-4 mb-3">
                      <div class="card mt-3">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <a href="animal_section" style="text-decoration:none ;color:black;height:100%;width:100%;"><button class="btn btn-warning" style="height:100%;width:100%"><i class="	fa fa-hand-o-right"></i>Update Profile</button></a>
                              </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                            <a href="animal_section" style="text-decoration:none ;color:black;height:100%;width:100%;"><button class="btn btn-primary" style="height:100%;width:100%"><i class="	fa fa-hand-o-right"></i>Menu</button></a>
                          </li>
                          <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                            <a href="logout" style="text-decoration:none;color:black;height:100%;width:100%;"><button class="btn btn-warning" style="height:100%;width:100%"><i class="fa fa-sign-out"></i> Log out</button></a>
                          </li>

                          <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                            <a href="animal_section" style="text-decoration:none ;color:black;height:100%;width:100%;"><button class="btn btn-primary" style="height:100%;width:100%"><i class="	fa fa-hand-o-right"></i>Transaction History</button></a>
                          </li>

                          <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                            <a href="delete_user" style="text-decoration:none; color:black;height:100%;width:100%;"><button class="btn btn-danger" style="height:100%;width:100%">&#10005; Delete Account</button></a>
                          </li>
                        </ul>
                      </div>
                    </div>
                    <div class="col-md-8">
                      <div class="card mb-3">
                        <div class="card-body">
                          <div class="row">
                            <div class="col-sm-3">
                              <h6 class="mb-0">Full Name</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                              ${userDetails.name}
                            </div>
                          </div>
                          <hr>
                          <div class="row">
                            <div class="col-sm-3">
                              <h6 class="mb-0">Email</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                              ${userDetails.username}
                            </div>
                          </div>
                          <hr>
                          <hr>
                          <div class="row">
                            <div class="col-sm-3">
                              <h6 class="mb-0">Mobile</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                              ${userDetails.mobile}
                            </div>
                          </div>
                          <hr>
                          <div class="row">
                            <div class="col-sm-3">
                              <h6 class="mb-0">Location</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                              ${userDetails.address}
                            </div>
                          </div>
                          <hr>
                          
                          <hr>
                          <div class="row">
                            <div class="col-sm-3">
                              <h6 class="mb-0">District</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                              ${userDetails.district}
                            </div>
                          </div>
                          <hr>
                          <div class="row">
                            <div class="col-sm-3">
                              <h6 class="mb-0">Pincode</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                              ${userDetails.pincode}
                            </div>
                          </div>
                          <hr>
                        </div>
                      </div>





                    </div>
                  </div>

                </div>
            </div>


    <c:if test="${message!= null}">

    <div id="snackbar">${message}</div>

    <script>

    myFunction();


    </script>


    </c:if>



    </body>

    <footer class="bg-dark text-white text-center py-3">
        &copy; 2023 Online Tiffin Service
    </footer>

    </html>