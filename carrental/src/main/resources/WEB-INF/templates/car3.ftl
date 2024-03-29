<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
        crossorigin="anonymous">
    <title>Car Rental</title>
    <link rel="shortcut icon" href="#" />
    <!-- <link rel="stylesheet" type="text/css" href="static/css/style.css"> -->
</head>
<style>
    html {
  position: relative;
  min-height: 100%;
}
body {
  margin-bottom: 10%;
}
.footer {
  text-align: center;
  position: absolute;
  bottom: 0;
  width: 100%;
  height: 60px;
  line-height: 60px;
  background-color: #f5f5f5;
}

.container {
  width: auto;
  padding: 0 15px;
}

.product-list-content {
    margin-top: 5rem;
}

.product-detail-content {
    margin-top: 5rem;
}
</style>

<body>
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="/">Car Rental</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav"
                aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link btn active btn-primary" href="#">My Rentals</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/cars">Cars</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/about">About</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/login">Login</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/logout">Logout</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <div class="container">

<div class="product-detail-content">
    <a href="../">Back</a>
    <div class="card mb-3">
        <h5 class="card-header">Ferrari</h5>
        <div class="card-body">
            <h5 class="card-title">Only for  14$ per hour!</h5>
            <p class="card-text">The Ferrari Testarossa is a 12-cylinder mid-engine sports car manufactured by Ferrari, which went into production in 1984 as the successor to the Ferrari Berlinetta Boxer. The Pininfarina-designed car was originally produced from 1984 to 1991, with two model revisions following the end of Testarossa production dubbed the 512 TR and F512 M which were produced from 1992 to 1996. Almost 10,000 Testarossas, 512 TRs, and F512 Ms were produced, making it one of the mass-produced Ferrari models.</p>
            <strong>Car available!</strong>
            <br>
            <br>
            <a href="/file/ferrari" class="btn btn-primary">PHOTO</a>
            <a href="/rentCar" class="btn btn-primary">Rent IT!</a>
            <br>
            <br>
        </div>
    </div>
</div>


    <footer class="footer">
        <div class="container">
            <span class="text-muted">Car Rental App 2018-2019 &copy;.</span>
        </div>
    </footer>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
        crossorigin="anonymous"></script>
</body>

</html>