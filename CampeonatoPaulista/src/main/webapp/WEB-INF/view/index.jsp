<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type ="text/css" href='<c:url value="./resources/css/styles.css"/>'>
<title>Grupos</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	<div align="center">
		<h1><b>Campeonato Paulista</b></h1>
		<hr>
		<h1><b>GRUPOS</b></h1>
		<form action="grupos" method="post">
			<table>
				<tr>
					<td>
						<input type="submit" id="botao" name="botao" value="Criar Grupo">
					</td>
					<td>
						<input type="submit" id="botao" name="botao" value="Exibir Grupo">
					</td> 
				</tr>
			</table>
		</form>	
	</div>
	
	<div align="center">
		<c:if test="${not empty erro }">
			<H2><c:out value="${erro }" /></H2>
		</c:if>
	</div>
	<div align="center">
		<c:if test="${not empty saida }">
			<H3><c:out value="${saida }" /></H3>
		</c:if>
	</div>
	
	<br />
	<br />
	
	<div align="center">
		<c:if test="${not empty listGPA }">
			<table class="table_round">
				<thead>
					<tr>
						<th class="th_dash"><b>Grupo A</b></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${listGPA }" var="gp">
					<tr>
						<td class="td_groove"><c:out value="${gp.codigoTime.nomeTime }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	
	<br />
	
	<div align="center">
		<c:if test="${not empty listGPB }">
			<table class="table_round">
				<thead>
					<tr>
						<th class="th_dash"><b>Grupo B</b></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${listGPB }" var="gp">
					<tr>
						<td class="td_groove"><c:out value="${gp.codigoTime.nomeTime }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	
	<br />
	
	<div align="center">
		<c:if test="${not empty listGPC }">
			<table class="table_round">
				<thead>
					<tr>
						<th class="th_dash"><b>Grupo C</b></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${listGPC }" var="gp">
					<tr>
						<td class="td_groove"><c:out value="${gp.codigoTime.nomeTime }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	
	<br />
	
	<div align="center">
		<c:if test="${not empty listGPD }">
			<table class="table_round">
				<thead>
					<tr>
						<th class="th_dash"><b>Grupo D</b></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${listGPD }" var="gp">
					<tr>
						<td class="td_groove"><c:out value="${gp.codigoTime.nomeTime }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	
</body>
</html>