<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Meal Details - Admin Panel</title>
    <link rel="stylesheet" href="css/meal_registration.css">
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
                        <a class="nav-link" href="#">Add Meal</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Log Out</a>
                    </li>
                </ul>

            </div>
        </nav>
    </header>

    <section class="admin-add-meal">
        <div class="container">
            <h2 class="text-center">Add Meal Details</h2>
            <form id="mealForm" enctype="multipart/form-data" method="post" action="meal_registration">
                <div class="form-group">
                    <label for="mealImage">Upload Image</label>
                    <input type="file" class="form-control-file" id="mealImage" name="image" accept="image/*" required>
                </div>
                <div class="form-group">
                    <label for="mealName">Meal Name</label>
                    <input type="text" class="form-control" id="mealName" name="title" placeholder="Enter meal name" required>
                </div>
                <div class="form-group">
                    <label for="mealPrice">Meal Price (Rs)</label>
                    <input type="number" class="form-control" id="mealPrice" name= "price" placeholder="Enter meal price" required>
                </div>
                <div class="form-group">
                    <label for="descriptionMonday">Monday Description</label>
                    <textarea class="form-control" id="descriptionMonday" rows="3" name="monday" placeholder="Enter description for Monday"></textarea>
                </div>
                <div class="form-group">
                    <label for="descriptionTuesday">Tuesday Description</label>
                    <textarea class="form-control" id="descriptionTuesday" rows="3" name="tuesday" placeholder="Enter description for Tuesday"></textarea>
                </div>
                <div class="form-group">
                    <label for="descriptionWednesday">Wednesday Description</label>
                    <textarea class="form-control" id="descriptionWednesday" rows="3" name="wednesday" placeholder="Enter description for Wednesday"></textarea>
                </div>
                <div class="form-group">
                    <label for="descriptionThursday">Thursday Description</label>
                    <textarea class="form-control" id="descriptionThursday" rows="3" name="thursday" placeholder="Enter description for Thursday"></textarea>
                </div>
                <div class="form-group">
                    <label for="descriptionFriday">Friday Description</label>
                    <textarea class="form-control" id="descriptionFriday" rows="3" name="friday" placeholder="Enter description for Friday"></textarea>
                </div>
                <div class="form-group">
                    <label for="descriptionSaturday">Saturday Description</label>
                    <textarea class="form-control" id="descriptionSaturday" rows="3" name="saturday" placeholder="Enter description for Saturday"></textarea>
                </div>
                <div class="form-group">
                    <label for="descriptionSunday">Sunday Description</label>
                    <textarea class="form-control" id="descriptionSunday" rows="3" name="sunday" placeholder="Enter description for Sunday"></textarea>
                </div>

                <input type="submit" class="btn btn-primary" value="Add Meal"/>
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
