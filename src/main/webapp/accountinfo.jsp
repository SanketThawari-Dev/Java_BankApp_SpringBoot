<%@page import="com.bank.entity.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Details</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="accinfo.css" rel="stylesheet">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Merriweather:wght@300;400;600;700;900&display=swap" rel="stylesheet">
</head>

<body>

<%
String check = (String) session.getAttribute("check");
if (check != null) {
    Account ac = (Account) session.getAttribute("ac");
%>

<h1 class="display-6 text-center text-light" id="head">
    Account Overview
</h1>

<div class="container mt-4">
    <div class="account-card text-light">
        <div class="row">

            <div class="col-md-4">
                <div class="info-box">
                    <div class="info-label">User ID</div>
                    <div class="info-value"><%= ac.getUserid() %></div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="info-box">
                    <div class="info-label">Password</div>
                    <div class="info-value"><%= ac.getPass() %></div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="info-box">
                    <div class="info-label">Contact</div>
                    <div class="info-value"><%= ac.getContact() %></div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="info-box">
                    <div class="info-label">Email</div>
                    <div class="info-value"><%= ac.getEmail() %></div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="info-box">
                    <div class="info-label">City</div>
                    <div class="info-value"><%= ac.getCity() %></div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="info-box">
                    <div class="info-label">Account Holder</div>
                    <div class="info-value"><%= ac.getAcholname() %></div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="info-box">
                    <div class="info-label">Account Type</div>
                    <div class="info-value"><%= ac.getActype() %></div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="info-box">
                    <div class="info-label">ATM Enabled</div>
                    <div class="info-value"><%= ac.getAtm() %></div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="info-box">
                    <div class="info-label">Account Number</div>
                    <div class="info-value"><%= ac.getAcno() %></div>
                </div>
            </div>

        </div>
    </div>
</div>

<a href="accountu" class="btn btn-warning" id="back-btn">
    ← Back to Dashboard
</a>

<% } %>

</body>
</html>
