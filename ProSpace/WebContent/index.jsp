<%
	if (session.getAttribute("name")==null){
		response.sendRedirect("login.jsp");
	}
%>
<%@ page contentType="text/html;charset=UTF-8"%>
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
	
	nav{
	text-align: center;
    background: #e5eaf5;
    height: 80%; 
    font-family:Verdana;
    color:#e5eaf5;
    font-size: 15px;
	}
	
	.product-wrapper {
	display: block;
	width: 100%;
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
	
	.product {
	display: block;
	border: 1px solid #b5e9a7;
	border-radius: 3px;
	position: relative;
	background: #fff;
	margin: 0 20px 20px 0;
	text-decoration: none;
	color: #474747;
	z-index: 0;
	height: 300px;
}
	.product-photo {
	position: relative;
	padding-bottom: 100%;
	overflow: hidden;
}
  </style>
	<!-- НАВИГАЦИЯ-->
<header><br>
<table><td>
<b>PROSPACE</b></td>
<td>
<p align="right">
<a>КОРЗИНА</a>
	<a href="logout">ВЫЙТИ</a>
	<a><%=session.getAttribute("name") %></a>
	</td>
</table>	
	<br></p>
</header>

<nav>
<br>
<ul class="products clearfix">
	<li class="product-wrapper">
		<a href="" class="product"><div class="product-photo">
								<img src="mascara.jpg" alt="sing up image">
</div>
		</a>
	</li>
	<li class="product-wrapper">
		<a href="" class="product"></a>
	</li>
	<li class="product-wrapper">
		<a href="" class="product"></a>
	</li>
	<li class="product-wrapper">
		<a href="" class="product"></a>
	</li>
	<li class="product-wrapper">
		<a href="" class="product"></a>
	</li>
	<li class="product-wrapper">
		<a href="" class="product"></a>
	</li>
	<li class="product-wrapper">
		<a href="" class="product"></a>
	</li>
	<li class="product-wrapper">
		<a href="" class="product"></a>
	</li>
</ul>
</nav>


	<!-- ПОДВАЛ ПОДВАЛА -->
	<footer><br>Янбаева Карина Ириковна ИКПИ-15<br><br></footer>
</body>
</html>
