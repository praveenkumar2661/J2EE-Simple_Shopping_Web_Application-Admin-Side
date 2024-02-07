<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<style>
	*{
        margin:0;
        padding: 0;
        box-sizing: border-box;
        font-family: "Poppins", sans-serif;
    }
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        background: url("desktop-1920x1080.jpg")no-repeat;
        background-size: cover;
        background-position: center;
    }
    .wrapper
    {
        width: 420px;
        background: transparent;
        border: 2px solid rgba(255, 255, 255, .2);
        backdrop-filter: blur(20px);
        box-shadow: 0 0 10px rgba(0, 0, 0, .2);
        color: white;
        border-radius: 10px;
        padding: 30px 40px;
    }
    .wrapper h1{
        font-size: 36px;
        text-align: center;
    }
    .wrapper .input-box{
        position: relative;
        width: 100%;
        height: 50px;
        margin: 30px 0;
    }
    .input-box input
    {
        width: 100%;
        height: 100%;
        background: transparent;
        border: none;
        border: 2px solid rgba(255,255,255, .2);
        border-radius: 40px;
        font-size: 16px;
        color: #fff;
        padding: 20px 45px 20px 20px;
    }
    .input-box input::placeholder{
        color: #fff;
    }
    .input-box i{
        position: absolute;
        right: 20px;
        top: 30%;
        transform: translateY(-50);
        font-size: 20px;
    }
    .wrapper .btn{
        width: 340px;
        height: 45px;
        background: #fff;
        border: none;
        outline: none;
        border-radius: 40px;
        box-shadow: 0 0 10px rgba(0, 0, 0, .1);
        cursor: pointer;
        font-size: 16px;
        color: #333;
        font-weight: 600;
        align: center;
    }
    .wrapper .register-link{
        font-size: 14.5px;
        text-align: center;
        margin: 20px 0 15px;
    }
    .register-link p a {
        color: #fff;
        text-decoration: none;
        font-weight: 600;
    }
    .register-link p a:hover{
        text-decoration: underline;
    }
    .message{
    	font-size: 16px;
    	font-weight: 600px;
    	text-decoration: underline;
    }
    
</style>
<body>




<div class = "wrapper">
<h1>Login</h1>
<form action = "login" method = "post">
<div class = "input-box">
<input type = "text" name = "mail" placeholder = "Mail ID" required>
<i class='bx bxs-user'></i>
</div>
<div class = "input-box">
<input type = "password" name = "password" placeholder = "Password" required>
<i class='bx bxs-lock-alt' ></i>
</div>
<button type = "submit" class = "btn">Login</button>
<div class = "register-link"><br>
<p>Don't have an account? <a href = "signup.jsp">SignUp</a></p><br><br>
<div class = "message">
<% String message = (String)request.getAttribute("message"); %>
<% if(message!=null){ %>
<%= message %>
<% }%></div>
</div>
</form>
</div>
</body>
</html>