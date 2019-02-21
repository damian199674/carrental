<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <title>Car Rental</title>
    <link rel="shortcut icon" href="static/img/favicon.png" />
    <link rel="stylesheet" type="text/css" href="static/css/style.css">
</head>
<body>
       <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/carrental/strona/home">Car Rental</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link btn active btn-primary" href="/products/rentals">My Rentals</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/carrental/strona/home">Home</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="/carrental/strona/product_list">Cars</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/carrental/strona/about">About</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="{% url 'login' %}">Login</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/logout">Logout</a>
            </li>
        </ul>
    </div>
</nav>
<div class="product-detail-content">
    <a href="{% url 'products:product-list' %}">Back</a>
<div class="card mb-3">
    <h5 class="card-header">{{ object.name }}</h5>
    <div class="card-body">
        <h5 class="card-title">Only for {{ object.price }} $ per hour!</h5>
        <p class="card-text">{{ object.description }}</p>
        {% if object.available %}
                <strong>Car available!</strong>
                <br>
                <br>
                <a href="{{ object.get_rent_url }}" class="btn btn-primary">Rent IT!</a>
        <strong>Car already rented. Please visit later.</strong>

        <br>
        <br>
        <img class="card-img-top car-img" src="/static/img/maluch.jpg" alt="maluch.jpg">
    </div>
</div>
</div>

    <footer class="footer">
      <div class="container">
        <span class="text-muted">Car Rental App 2019 &copy;.</span>
      </div>
    </footer>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</body>
</html>