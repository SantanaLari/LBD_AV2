<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Datas</title>
</head>
<body>

	<div>
		<jsp:include page="menu.jsp" />
	</div>
	
	<div align="center">
	
		<h1><b>Digite a data do jogo</b></h1>
	
		<form action="jogosFormados" method="post">
			<table>
				<tr>
					<td colspan="3">
						<input class="input_data_id" type="text" id="data" name="data" placeholder="Data"
						value='<c:out value= "${jogos.Data }" />'>
					</td>
					<td>
						<input type="submit" id="botao" name="botao" value="Buscar">
					</td>
				</tr>
			</table>
		</form>	
	</div>
	
	<div align="center">
		<c:if test="${not empty listJG }">
			<c:forEach items="${jogos }" var="j">
				<c:forEach items="${listJG }" var="jg">
					<c:if test="${j.Data eq jg.Data }">
						<table class="table_round">
							<thead>
							<tr>
								<th>Codigo Time A</th>
								<th>Codigo Time B</th>
							</tr>
							</thead>
							<tbody>
							<tr>
								<td><c:out value="${jg.codigoTimeA }"/></td>
								<td><c:out value="${jg.codigoTimeB }"/></td>
							</tr>
							</tbody>
						</table>
					</c:if>
				</c:forEach>
			</c:forEach>
		</c:if>
	</div>
	
</body>
</html>