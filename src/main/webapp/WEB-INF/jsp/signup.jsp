<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up | ST Bank</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="signup.css" rel="stylesheet">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Merriweather:wght@300;400;600;700;900&display=swap" rel="stylesheet">
</head>

<body>

<h1 class="display-6 text-center" id="head">
    Create Your Account
</h1>

<%@include file="msg.jsp" %>

<div class="container mt-4 mb-5">
    <div class="signup-card">
        <form action="signup">

            <!-- Row 1 -->
            <div class="row">
                <div class="col-md-6">
                    <label>Account Holder Name</label>
                    <input type="text" name="acholname" class="form-control" required>
                </div>
                <div class="col-md-6">
                    <label>User ID</label>
                    <input type="text" name="uid" class="form-control" required>
                </div>
            </div>

            <!-- Row 2 -->
            <div class="row">
                <div class="col-md-6">
                    <label>Contact Number</label>
                    <input type="text" name="uphone" class="form-control" required>
                </div>
                <div class="col-md-6">
                    <label>Email Address</label>
                    <input type="email" name="uemail" class="form-control" required>
                </div>
            </div>

            <!-- Row 3 -->
            <div class="row">
                <div class="col-md-6">
                    <label>City</label>
                    <input type="text" name="city" class="form-control" required>
                </div>
                <div class="col-md-6">
                    <label>Password</label>
                    <input type="password" name="upass" class="form-control" required>
                </div>
            </div>

            <!-- Account type -->
            <div class="row">
                <div class="col-md-6">
                    <div class="section-title">Account Type</div>
                    <div class="form-check">
                        <input type="radio" name="actype" value="saving" class="form-check-input" id="saving">
                        <label class="form-check-label" for="saving">Savings</label>
                    </div>
                    <div class="form-check">
                        <input type="radio" name="actype" value="current" class="form-check-input" id="current">
                        <label class="form-check-label" for="current">Current</label>
                    </div>
                </div>

                <!-- ATM -->
                <div class="col-md-6">
                    <div class="section-title">ATM Card</div>
                    <div class="form-check">
                        <input type="radio" name="atm" value="allocated" class="form-check-input" id="atm-yes">
                        <label class="form-check-label" for="atm-yes">Yes</label>
                    </div>
                    <div class="form-check">
                        <input type="radio" name="atm" value="Not allocated" class="form-check-input" id="atm-no">
                        <label class="form-check-label" for="atm-no">No</label>
                    </div>
                </div>
            </div>

            <button class="btn btn-success signup-btn">
                Create Account
            </button>

            <div class="signup-footer text-center">
                Already have an account?
                <a href="login.jsp">Login</a>
            </div>

        </form>
    </div>
</div>

</body>
</html>
