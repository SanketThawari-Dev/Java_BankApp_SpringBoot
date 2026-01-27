<%@page import="java.util.List"%>
<%@page import="com.bank.entity.TxnHistory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction History</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="readtxn.css" rel="stylesheet">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Merriweather:wght@300;400;600;700;900&display=swap" rel="stylesheet">
</head>

<body>

<%
String check = (String) session.getAttribute("check");
if (check != null) {
    List<TxnHistory> al = (List<TxnHistory>) session.getAttribute("al");
%>

<h1 class="display-6 text-center text-light" id="head">
    Transaction History
</h1>

<div class="container mt-4">
    <div class="txn-card text-light">
        <div class="table-responsive">
            <table class="table table-dark table-hover table-bordered">
                <thead>
                    <tr>
                        <th>Account No</th>
                        <th>Amount</th>
                        <th>Status</th>
                        <th>Date</th>
                        <th>Balance</th>
                    </tr>
                </thead>
                <tbody>
                <%
                for (TxnHistory txn : al) {
                %>
                    <tr>
                        <td><%= txn.getAcno() %></td>
                        <td>₹ <%= txn.getAmount() %></td>
                        <td><%= txn.getTstatus() %></td>
                        <td><%= txn.getDate() %></td>
                        <td>₹ <%= txn.getBal() %></td>
                    </tr>
                <%
                }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>

<a href="accountu" class="btn btn-warning btn-lg back-btn">
    ← Back to Account
</a>

<%
} else {
    response.sendRedirect("login.jsp");
}
%>

</body>
</html>
