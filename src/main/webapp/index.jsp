<html>
<title>Index</title>
<head>

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
    .wrapper h2{
        font-size: 36px;
        text-align: center;
    }
   
     
   	 	.btn{
        width: 340px;
        height: 45px;
        background: transparent;
        border: none;
        outline: none;
        border-radius: 40px;
        box-shadow: 0 0 10px rgba(0, 0, 0, .1);
        cursor: pointer;
        font-size: 16px;
        color: white;
        font-weight: 600;
        align: center;
        transition-duration: 0.4s;
    }
    .btn :hover{
        background-color: white;
        color: black;
    }
    
   
    
</style>
</head>
<body>
<div class = "wrapper">
<h2>Welcome!</h2><br>
<p>
	
	<button class = "btn" onclick= "window.location.href = 'login.jsp';">Login</button><br><br>
	<button class = "btn" onclick= "window.location.href = 'signup.jsp';">Sign Up</button>
	
	
</p>
</div>
</body>
</html>
