<%@page import="com.Entity.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Dashboard</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="account.css" rel="stylesheet">

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

<%@include file="msg.jsp" %>

<!-- NAVBAR -->
<nav class="navbar navbar-custom container">
    <div class="d-flex gap-2">
        <form action="logout" method="post">
    <button class="btn btn-danger">Logout</button>
        </form>
        <form action="readtxn" method="post">
            <input type="hidden" name="uid" value="<%=check %>">
            <button class="btn btn-info">Transaction History</button>
        </form>
        <a class="btn btn-warning" href="accountinfo.jsp">Account Info</a>
    </div>
</nav>

<!-- PAGE TITLE -->
<h1 class="display-6 text-center text-light" id="aservice">
    Account Services
</h1>

<!-- DASHBOARD -->
<div class="container">
    <div class="dashboard-card text-light">
        <div class="row">

            <!-- Deposit -->
            <div class="col-md-4">
                <div class="service-card">
                    <div class="service-title">Deposit Money</div>
                    <form action="deposit" method="post">
                        <label>Enter Amount</label>
                        <input type="text" name="am" class="form-control">
                        <input type="hidden" name="uid" value="<%=check%>">
                        <button class="btn btn-success btn-action mt-3">Deposit</button>
                    </form>
                </div>
            </div>

            <!-- Withdraw -->
            <div class="col-md-4">
                <div class="service-card">
                    <div class="service-title">Withdraw Money</div>
                    <form action="withdraw" method="post">
                        <label>Enter Amount</label>
                        <input type="text" name="am" class="form-control">
                        <input type="hidden" name="uid" value="<%=check%>">
                        <button class="btn btn-success btn-action mt-3">Withdraw</button>
                    </form>
                </div>
            </div>

            <!-- Transfer -->
            <div class="col-md-4">
                <div class="service-card">
                    <div class="service-title">Transfer Money</div>
                    <form action="transfer" method="post">
                        <label>Enter Amount</label>
                        <input type="text" name="am" class="form-control">

                        <label class="mt-2">Recipient Account No</label>
                        <input type="text" name="acb" class="form-control">

                        <input type="hidden" name="uid" value="<%=check%>">
                        <button class="btn btn-success btn-action mt-3">Transfer</button>
                    </form>
                </div>
            </div>

            <!-- Balance -->
            <div class="col-md-12 mt-3">
                <div class="balance-card">
                    Available Balance
                    <div class="balance-amount">
                        ₹ <%= ac.getBal() %>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

<% } else {
    response.sendRedirect("login.jsp");
} %>

</body>
</html>
