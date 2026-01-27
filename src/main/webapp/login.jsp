<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login | ST Bank</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="login.css" rel="stylesheet">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Merriweather:wght@300;400;600;700;900&display=swap" rel="stylesheet">
</head>

<body>

<h1 class="display-6 text-center" id="head">Secure Login</h1>

<%@include file="msg.jsp" %>

<div class="login-container">
    <form action="/login" method="post" class="login-card">

        <label for="uid">User ID</label>
        <input type="text" name="uid" id="uid" class="form-control" required>

        <label for="upass">Password</label>
        <input type="password" name="upass" id="upass" class="form-control" required>

        <button class="btn btn-success login-btn mt-4">Login</button>

        <div class="login-footer text-center">
            Don’t have an account?
            <a href="signupu">Sign Up</a>
        </div>

    </form>
</div>

</body>
</html>
