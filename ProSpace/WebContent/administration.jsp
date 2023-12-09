<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Администрирование</title>
</head>
<body>
<style type="text/css">

   a{
   text-decoration: none;
   colour: black;
   font-family:Verdana;
   }

   h4{
   text-align: center;
   font-family:Verdana;
   color:#8458B3;
   font-size: 15px;
   }

   a:link {
  	color: #8458B3; 
  	text-
	}
	a:visited {
  	color: #8458B3;
	}
	a:hover {
  	color: purple; 
	}
	body{
	background:#e5eaf5;}

    nav{
    margin-left: auto;
    margin-right: auto;
    width: 30%;
    border: solid #8458B3;
    border-radius: 5px;
    }

  </style>
	<nav>
<br>
					<a href="<%=request.getContextPath()%>/list"><h4>Пользователи</h4></a>
<br>
					<a href="<%=request.getContextPath()%>/list_pr"><h4>Товары</h4></a>
<br>
				
	</nav>
</body>
</html>