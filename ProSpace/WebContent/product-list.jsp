<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<title>Товары</title>
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
   h5{
   font-family:Verdana;
   color:#8458B3;
   font-size: 10px;
   text-align: right;
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
				<a href="<%=request.getContextPath()%>/new_pr" class="headerer""><h4>Добавить товар</h4></a>


	</header><br>
				
			<br>
			<div style="text-align: center;">
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>НАЗВАНИЕ</th>
						<th>ЦЕНА</th>
						<th>ДЕЙСТВИЕ</th>
					</tr>
				</thead>
					<c:forEach var="product" items="${listProduct}">

						<tr>
							<td><c:out value="${product.id}" /></td>
							<td><c:out value="${product.name}" /></td>
							<td><c:out value="${product.price}" /></td>
							<td><a href="edit_pr?id=<c:out value='${product.id}' />">Редактировать</a> &nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="delete_pr?id=<c:out value='${product.id}' />">Удалить</a></td>
						</tr>
					</c:forEach>

			</table>
<a href="<%=request.getContextPath()%>/administration.jsp" class="headerer"><h5>Администрирование</h5></a>
</body>
</html>
