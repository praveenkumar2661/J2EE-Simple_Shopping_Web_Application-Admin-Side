<%@page import="DTO.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "DAO.ProductDAO" %>
    <%@ page import = "DTO.ProductDTO" %>
    <%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
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
        width: 10px;
        height: 20px;
        background: transparent;
        border: none;
        outline: none;
        border-radius: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, .1);
        cursor: pointer;
        font-size: 16px;
        color: Black;
        font-weight: 300;
        align: center;
        transition-duration: 0.4s;
    }
    .btn :hover{
        background-color: Red ;
        color: Red;
    }
    .btn1{
    	width: 130px;
       height: 30px;
       background: transparent;
        border: none;
        outline: none;
        border-radius: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, .1);
        cursor: pointer;
        font-size: 16px;
        color: Black;
        font-weight: 600;
        align: center;
        transition-duration: 0.4s;
    }
  

</style>
<body>
    <main class="table" id="customers_table">
        <section class="table__header">
            <h1>Product Details</h1><br>
			<button class = "btn1" onclick= "window.location.href = 'product.jsp';">Add Product</button>
        </section>
        <section class="table__body">
            <table>
                <thead>
                    <tr>
                        <th> ID </th>
                        <th> Name </th>
                        <th> Brand </th>
                        <th> Price </th>
                        <th> Discount</th>
                        <th> Image </th>
						<th> Edit </th>
						<th> Delete </th>
                    </tr>
                </thead>
                </section>
                <tbody>
	<%ProductDAO PDAO = new ProductDAO(); 
	ArrayList<ProductDTO> product = PDAO.findAll();
	%>
	<%
	for (ProductDTO dto: product)
	{
	%>
        <tr>
        <td><%= dto.getId() %></td>
		<td><%= dto.getName() %></td>
		<td><%= dto.getBrand() %></td>
		<td><%= dto.getPrice() %></td>
		<td><%= dto.getDiscount() %></td>
		<% String base64Image = Base64.getEncoder().encodeToString(dto.getImage()); %>
		<td class = "img"><img src = "data:image/jpeg;base64,<%= base64Image %>" alt = "Image" style = "height 100px; width: 200px;"/></td>
		<td><button class = "btn" onclick= "window.location.href = 'edit?id=<%= dto.getId()%>'">Edit</button></td>
		<td><button class = "btn" onclick= "window.location.href = 'delete?id=<%= dto.getId()%>'">Delete</button></td>
		</tr>
<%} %>
</table>
    </main>
    <br>
    <br>
   <a href = "logut">logout</a>
   

</body>

</html>
