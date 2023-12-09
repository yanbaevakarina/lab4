<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Добавление/Редактирование товара</title>
</head>
<body>
<style type="text/css">
  	a.headerer{
  	font-family:Verdana;
  	colour:#8458B3;
  	}
   a{
   text-decoration: none;
   colour: black;
   font-family:Verdana;
   }
   h3{
   text-align: center;
   font-family:Verdana;
   color:#e5eaf5;
   font-size: 30px;
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
  	color: #8458B3; 
	}
	a:visited {
  	color: #8458B3;
	}
	a:hover {
  	color: purple; 
	}
	body{
	background:#e5eaf5;}
	
	fieldset{
  	max-width:500px;
  	padding:16px;
  	margin-left: auto;
    margin-right: auto;
    border: 10px white;
    font-family:Verdana;
    color: #8458B3;}
    button{
    border-color: #8458B3;
    background: #8458B3;
    border-width: 1px;
    padding: 1px 7px 2px;
    color: #e5eaf5;
    display: inline-block;
    font-family:Verdana;
    margin-left: auto;
    margin-right: auto;
    border-radius: 5px;
    width: 100%;
    height: 8%;
    }
    nav{
    margin-left: auto;
    margin-right: auto;
    width: 30%;
    border: solid #8458B3;
    border-radius: 5px;
    }
    input{
    border-color: #8458B3;
    border: solid 1;
  	border-radius: 5px;
  	width: 100%;
  	height: 5%;
    }

  </style>
	<header><br>
				<a href="<%=request.getContextPath()%>/list_pr" class="headerer"><h4>Товары</h4></a>
				<c:if test="${product != null}"><form action="update_pr" method="post">
				</c:if>
				<c:if test="${product == null}"><form action="insert_pr" method="post">
				</c:if>

					<h3>
						<c:if test="${product != null}">
            			Редактирование товара
            		</c:if>
						<c:if test="${product == null}">
            			Добавление товара
            		</c:if>
					</h3>
					<br>
	</header><br>
	<nav>
				<c:if test="${product != null}">
					<input type="hidden" name="id" value="<c:out value='${product.id}' />" />
				</c:if>
				<fieldset>
					<label>Название<br></label> 
					<input type="text" value="<c:out value='${product.name}' />" name="name" required="required">
				</fieldset>

				<fieldset>
					<label>Цена<br></label>
					<input type="text" value="<c:out value='${product.price}' />"name="price" required="required">
				</fieldset>
				
				
				<fieldset>
				<button type="submit" >Сохранить</button><br>
				</fieldset>
	</nav>
</body>
</html>