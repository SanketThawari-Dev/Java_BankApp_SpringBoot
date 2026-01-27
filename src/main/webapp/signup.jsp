<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link href="signup.css" rel="stylesheet" type="text/css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Merriweather:ital,wght@0,300;0,400;0,700;0,900;1,300;1,400;1,700;1,900&display=swap" rel="stylesheet">
</head>
<body>
<h1 class="display-6 text-center" id="head">SignUp Page</h1>
<%@include file="msg.jsp" %>

<div class="container w-50" id="bg">
<form action="signup" method="post">

<div class="row">
<div class="col">
    <label for="acholname">Enter Account holder Name</label>
    <input type="text" name="acholname" class="form-control" id="acholname">
</div>
<div class="col">
    <label for="uid">Enter User Id</label>
    <input type="text" name="uid" class="form-control" id="uid">
</div>
</div>

<div class="row">
<div class="col">
    <label for="uphone">Enter Contact</label>
    <input type="text" name="uphone" class="form-control" id="uphone">
</div>
<div class="col">
    <label for="uemail">Enter Email</label>
    <input type="email" name="uemail" class="form-control" id="uemail">
</div>
</div>

<div class="row">
<div class="col">
    <label for="city">Enter City</label>
    <input type="text" name="city" class="form-control" id="city">
</div>
<div class="col">
    <label for="upass">Enter Password</label>
    <input type="password" name="upass" class="form-control" id="upass">
</div>
</div>

<div class="row text-center">
<div class="col">
    <p class="mt-3">Select Account Type</p>
    <div>
        <label for="ac1" class="form-check-label">Saving</label>
        <input type="radio" name="actype" class="form-check-input" id="ac1" value="saving">
    </div>
    <div>
        <label for="ac2" class="form-check-label">current</label>
        <input type="radio" name="actype" class="form-check-input" id="ac2" value="current">
    </div>
</div>
<div class="col">
    <p class="mt-3">Atm Card</p>
    <div>
        <label for="y" class="form-check-label">Yes</label>
        <input type="radio" name="atm" class="form-check-input" id="y" value="allocated">
    </div>
    <div>
        <label for="n" class="form-check-label">No</label>
        <input type="radio" name="atm" class="form-check-input" id="n" value="Not allocated">
    </div>  
</div>
</div>

<div class="text-center" id="btn">
    <button class="btn btn-success d" >SignUp</button> 
</div>
<div class="text-center">
   Already have an Account <a href="loginu">login</a>
</div>

</form>
</div>
</body>
</html>
