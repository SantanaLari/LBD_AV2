<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Quartas de Final</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>

	<div align="center">
		<H1><b> JOGOS DAS QUARTAS </b></H1>
		<form action="quartas" method="post">
			<table>
				<tr>
					<td>
						<input type="submit" id="botao" name="botao" value="Criar Quartas">
					</td>
				</tr>
			</table>
		</form>	
	</div>


	<div class="principal">
		<div style="float:left;">
			<c:if test="${not empty listGA }">
				<p><b> 1° </b></p>
				<table border = "1" class="table_round">
					<tbody>
					<c:forEach items="${listGA }" var="gp">
						<tr>
							<td><c:out value="${gp.codigoTime.nomeTime }"/></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	
		<div style="float:left;">
			<c:if test="${not empty listGB }">
				<p><b> Rodada </b></p>
				<table border = "1" class="table_round">
					<tbody>
					<c:forEach items="${listGB }" var="gp">
						<tr>
							<td><c:out value="${gp.codigoTime.nomeTime }"/></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
		
		<div style="float:right;">
			<c:if test="${not empty listGC }">
				<p><b> Rodada </b></p>
				<table border = "1" class="table_round">
					<tbody>
					<c:forEach items="${listGC }" var="gp">
						<tr>
							<td><c:out value="${gp.codigoTime.nomeTime }"/></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
		<div style="float:right;">
			<c:if test="${not empty listGD }">
				<p><b> 2° </b></p>
				<table border = "1" class="table_round">
					<c:forEach items="${listGD }" var="gp">
						<tr>
							<td><c:out value="${gp.codigoTime.nomeTime }"/></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</c:if>	
		</div>
	</div>	

</body>
</html>