<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<title>Список пользователей</title>
</head>
<body>
  <style type="text/css">
  	a.headerer{
  	font-family:Verdana;
  	colour:#8458B3;
  	}
   table {
    color: #8458B3; /* Цвет текста */
    margin-left: auto;
    margin-right: auto;
    font-family:Verdana;
    border-spacing: 45px 5px; /* Расстояние между границ */
   }
   th {
   colour: #8458B3;
   border: 10px white;
   margin-left: auto;
   margin-right: auto;
   text-decoration: none;
   font-family:Verdana;
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

  </style>
  
	<header> <br>
				<a href="<%=request.getContextPath()%>/new" class="headerer""><h4>Добавить пользователя</h4></a>


			<a class="headerer" href="<%=request.getContextPath()%>/list"><h3>Список пользователей</h3></a><br>
	</header><br>
				
			<br>
			<div style="text-align: center;">
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>ИМЯ</th>
						<th>ПОЧТА</th>
						<th>ПАРОЛЬ</th>
						<th>ДЕЙСТВИЕ</th>
					</tr>
				</thead>
					<c:forEach var="user" items="${listUser}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.name}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><c:out value="${user.password}" /></td>
							<td><a href="edit?id=<c:out value='${user.id}' />">Редактировать</a> &nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="delete?id=<c:out value='${user.id}' />">Удалить</a></td>
						</tr>
					</c:forEach>

			</table>
</body>
</html>
