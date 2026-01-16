<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<link href="css/msg.css" rel="stylesheet">

<%
String msg = (String) session.getAttribute("msg");
if (msg != null) {

    String cssClass = "msg-info";

    if (msg.toLowerCase().contains("fail") ||
        msg.toLowerCase().contains("invalid") ||
        msg.toLowerCase().contains("insufficient")) {
        cssClass = "msg-error";
    } else if (msg.toLowerCase().contains("success") ||
               msg.toLowerCase().contains("created") ||
               msg.toLowerCase().contains("deposit") ||
               msg.toLowerCase().contains("withdraw")) {
        cssClass = "msg-success";
    }
%>

<div class="msg-wrapper">
    <div class="msg-box <%=cssClass%>">
        <%= msg %>
    </div>
</div>

<%
    session.removeAttribute("msg");
}
%>
