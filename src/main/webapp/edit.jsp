<%@page import="DTO.ProductDTO"%>
<%@page import="DAO.ProductDAO"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<style>

* {
    margin: 0;
    padding: 0;

    box-sizing: border-box;
    font-family: sans-serif;
}
media print {
 .table, .table__body {
  overflow: visible;
  height: auto !important;
  width: auto !important;
 }
}
body {
    min-height: 100vh;
    background: url(desktop-1920x1080.jpg) center / cover;
    display: flex;
    justify-content: center;
    align-items: center;
}

main.table {
    width: 82vw;
    height: 90vh;
    background-color: #fff5;

    backdrop-filter: blur(7px);
    box-shadow: 0 .4rem .8rem #0005;
    border-radius: .8rem;

    overflow: hidden;
}

.table__header {
    width: 100%;
    height: 10%;
    background-color: #fff4;
    padding: .8rem 1rem;

    display: flex;
    justify-content: space-between;
    align-items: center;
}



.table__body {
    width: 95%;
    max-height: calc(89% - 1.6rem);
    background-color: white;
	align: center;
    margin: .8rem auto;
    border-radius: .6rem;

    overflow: auto;
    overflow: overlay;
}


table {
    width: 100%;
}

td img {
    width: 120px;
    height: 240px;
    margin-right: .5rem;
    border-radius: 0;

    vertical-align: middle;
}

table, th, td {
    border-collapse: collapse;
    padding: 1rem;
    text-align: left;
}

thead th {
    position: sticky;
    top: 0;
    left: 0;
    background-color: #d5d1defe;
    cursor: pointer;
    text-transform: capitalize;
}

tbody tr:nth-child(even) {
    background-color: #0000000b;
}

tbody tr {
    --delay: .1s;
    transition: .5s ease-in-out var(--delay), background-color 0s;
}

tbody tr.hide {
    opacity: 0;
    transform: translateX(100%);
}

tbody tr:hover {
    background-color: #fff6 !important;
}

tbody tr td,
tbody tr td p,
tbody tr td img {
    transition: .2s ease-in-out;
}

tbody tr.hide td,
tbody tr.hide td p {
    padding: 0;
    font: 0 / 0 sans-serif;
    transition: .2s ease-in-out .5s;
}

thead th:hover {
    color: #6c00bd;
}
    .btn{
        width: 150px;
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
    .btn :hover{
        background-color: black;
        color: white;
    }
    .input-box{
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
        color: black;
        padding: 20px 45px 20px 20px;
    }
    
    .center{
    	
    	padding:25px 100px 75px 550px;
    }


</style>
<body>
<% String message = (String)request.getAttribute("message") ;%>
<% if(message!=null){ %>
<h1><%= message %></h1>
<%} %>

<main class="table" id="customers_table">
        <section class="table__header">
            <h1>Edit</h1><br>
        </section>
        <section class="table__body">
        <form action = "update" method = "post" enctype = "multipart/form-data">
            <table>
                <thead>
                    <tr>
                        <th> ID </th>
                        <th> Name </th>
                        <th> Brand </th>
                        <th> Price </th>
                        <th> Discount</th>
                        <th> Image </th>
                    </tr>
                </thead>
                

<% ProductDAO PDAO = new ProductDAO(); %>
<% ProductDTO PDTO = (ProductDTO)request.getSession().getAttribute("editp"); %>
	<tbody>
	
	
		<td>	<div class = "input-box"><input type = "number" name ="id" value = "<%= PDTO.getId() %>" readonly></div> </td>
		<td> 	<div class = "input-box"><input type = "text" name = "name"  value = "<%= PDTO.getName() %>"></div></td>
		<td> 	<div class = "input-box"><input type = "text" name = "brand"  value = "<%= PDTO.getBrand()%>"></div></td>
		<td> 	<div class = "input-box"><input type = "text" name = "price" value = "<%= PDTO.getPrice()%>"></div></td>
		<td> 	<div class = "input-box"><input type = "text" name = "discount" value = "<%= PDTO.getDiscount()%>"></div></td>
		<% String base64Image = Base64.getEncoder().encodeToString(PDTO.getImage()); %>
		<td class = "img"><img src = "data:image/jpeg;base64,<%= base64Image%>" alt = "Image" style = "height: 150px; width: 100px;">
		<div class = "input-box"><input type = "file" name = "image" value = ""></div></td>
		</tbody>
		</table>
		</section><br><br>
		<div class = "center"><button type = "submit" class = "btn">Save Changes</button></div>
		
	</form>
	</body>
</html>