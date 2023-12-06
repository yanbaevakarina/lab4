<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Регистрация</title>

</head>
<body>
<form action="registration" method="post">
<style type="text/css">
   a{
   text-decoration: none;
   colour: black;
   font-family:Verdana;
   }
   h3{
   text-align: center;
   font-family:Verdana;
   color:#8458B3;
   font-size: 25px;
   }
   h4{
   font-family:Verdana;
   color:#e5eaf5;
   font-size: 15px;
   }

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
	background:white;}
	
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
    color: white;
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
    border: solid #8458B3 5px;
    border-radius: 5px;
    }
    input{
    border-color: #8458B3;
    border: solid 1;
  	border-radius: 5px;
  	width: 100%;
  	height: 5%;
    }
	td{
	width: 50%;
	}
	td.login{
	text-align: center;
	}
  </style>
  
	<nav>
	<h3>Регистрация</h3>
	<table>
			<td class="login">
		<a href="login.jsp">Войти</a>
</td>
		<td>
			<table>
				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>
				<fieldset>
					<label>Логин<br></label> 
					<input type="text" value="<c:out value='${user.name}' />" name="name" required="required">
				</fieldset>

				<fieldset>
					<label>Почта<br></label>
					<input type="text" value="<c:out value='${user.email}' />"name="email" required="required">
				</fieldset>
				
				<fieldset>
					<label>Пароль<br></label>
					<input type="text" value="<c:out value='${user.password}' />" name="password" required="required">
				</fieldset>
				
				<fieldset>
				 <a href="login.jsp">
				<button type="submit">Зарегистрироваться</button><br>
				</fieldset>


			      
			    	</tr>
			    </table>
			</td>

	</table>
	</nav>
</body>
</html>