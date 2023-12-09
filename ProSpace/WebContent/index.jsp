<%
	if (session.getAttribute("name")==null){
		response.sendRedirect("login.jsp");
	}
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="" />
<meta name="author" content="" />
<title>ProSpace - интернет-магазин профессиональной косметики</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
<style type="text/css">
	body{
	background: #e5eaf5;
	min-width: 500px;
  	overflow-x: auto;
  	max-width: 3000px;
	}
   a{
   font-family:Verdana;
   color:#e5eaf5;
   font-size: 15px;
   text-decoration:none;
   text-transform:uppercase;
   font-weight: bold;
   }
   h4{
   font-family:Verdana;
   color:#e5eaf5;
   font-size: 15px;
   }
   h5{
   font-family:Verdana;
   color:black;
   font-size: 30px;
   padding-right: 1rem;
   text-align: right;
   margin-top:0rem;
   }
   h3{
   font-family:Verdana;
   color:black;
   font-size: 30px;
   padding-right: 1rem;
   text-align: right;
   margin-top:0rem;
   }
   h3:hover {
   color: purple; 
   }
   h6{
   font-family:Verdana;
   color:black;
   font-size: 20px;
   padding-right: 1rem;
   text-align: right;
   margin-bottom: 0rem;
	
   }
   header{
   	background: #8458B3;
   	margin-bottom: 0rem;
	margin-left: -1rem;
	margin-right: 2rem;
	margin-top:-1rem;
	padding-left: 3%;
   	width: 100%;}
   
   	a:link {
  	color: white; 
	}
	a:visited {
  	color: white;
	}
	a:hover {
  	color: yellow; 
	}
	body{
	background:#e5eaf5;}
	
    footer{
    text-align: center;
    background: #4f1678;
    margin-bottom: 0rem;
	margin-left: -1rem;
	margin-right: 2rem;
	margin-top:-1rem;
	padding-left: 3%;
    width: 100%;
    font-family:Verdana;
    color:#e5eaf5;
    font-size: 15px;
    }
    table{
    width: 90%;
    margin-left: auto;
    margin-right: auto;}
	b{
	   font-family:Verdana;
	   color:#e5eaf5;
	   font-size:25px;
	   text-decoration:none;
	   text-transform:uppercase;
	   font-weight: bold;
	}
	
	#content {
    background: #e5eaf5;
    height: 80%; 
    font-family:Verdana;
    color:#e5eaf5;
    font-size: 15px;
	}
	#choose{
	font-family:Verdana;
   	color:black;
   	font-size: 20px;
   	text-decoration:none;
    text-transform:uppercase;
    font-weight: bold;
	}
	
	input{
    border-color: white;
    font-size: 1px;
	color:white;
    border: 10px solid transparent;
  	border-radius: 1px;
  	width: 1%;
  	height: 1%;
  	
    }
	button{
	border: 10px solid transparent;
	background: white;
	font-family:Verdana;
   	color:black;
   	font-size: 20px;
   	
	}
	.product {
	display: block;
	border: 1px solid #d8c2ff;
	border-radius: 3px;
	position: relative;
	background: #fff;
	margin: 0 20px 20px 0;
	text-decoration: none;
	color: #474747;
	z-index: 0;
	}
		.product-wrapper {
	display: block;
	width: 100%;
	height: 100% rem;
	float: left;
	transition: width .2s;
}

	@media only screen and (min-width: 450px) {
		.product-wrapper {
			width: 50%;
		}
	}
	
	@media only screen and (min-width: 768px) {
		.product-wrapper {
			width: 33.333%;
		}
	}
	
	@media only screen and (min-width: 1000px) {
		.product-wrapper {
			width: 25%;
		}
	}
	.product-photo {
	padding-bottom: 10%;
	margin-right: 5%;
	margin-left:5%;
	}
	.product-photo img {
	max-width: 100%;
	transition: transform .4s ease-out;
	}
	.product:hover .product-photo img {
	transform: scale(1.05);
	}
  </style>
	<!-- НАВИГАЦИЯ-->
<header><br>
<table><td>

<b>PROSPACE</b></td>

<td>
<p align="right">
	<a href="basket_id?idusers=<%=session.getAttribute("id")%>">КОРЗИНА</a>
	<a href="<%=request.getContextPath()%>/logout">ВЫЙТИ</a>
	<a><%=session.getAttribute("name") %></a>
	</td>
</table>	
	<br></p>
</header>


<div id="content">
<ul>

<c:forEach var="product" items="${listProduct}">		
	<li class="product-wrapper">
							<div class="product-photo">
							<a href="" class="product">
							<img src="images/<c:out value="${product.name}" />.jpg">
							<h6><c:out value="${product.name}" /></h6>
							<h5><c:out value="${product.price}"/></h5>
							
							<form action="new_pr_basket" method="post">
							<input type="text" value="<%=session.getAttribute("id")%>" name="idusers" required="required">
							<input type="text" value="<c:out value='${product.id}'/>" name="idproduct" required="required">
							<input type="text" value="<c:out value='${product.price}'/>"name="price" required="required">
							<br><button type="submit" ><h3>ДОБАВИТЬ</h3></button><br>
							</form>
							</div>
							</a>
	</li>	
	</c:forEach>			
	</ul>

<br>
	<!-- ПОДВАЛ ПОДВАЛА -->
	<br>
	<hr width="100%" size="10" color="#4f1678">
	<footer><br>Янбаева Карина Ириковна ИКПИ-15<br><br></footer>
</body>
</html>
