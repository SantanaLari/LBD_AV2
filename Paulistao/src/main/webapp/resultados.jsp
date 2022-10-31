<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Resultados</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	
	<div align="center">
	<H1><b> INSERIR RESULTADOS </b></H1>
		<form action="resultados" method="post">
			<table>
				<tr>
					<td colspan="3">
						<input class="input_data" type="text" id="timeA" name="timeA" placeholder="Time A">
					</td>
					<td colspan="4">
						<input class="input_data_id" type="number" id="golsA" name="golsA" placeholder="Gols A">
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<input class="input_data" type="text" id="timeB" name="timeB" placeholder="Time B">
					</td>
					<td colspan="4">
						<input class="input_data_id" type="number" id="golsB" name="golsB" placeholder="Gols B">
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" id="botao" name="botao" value="Inserir">
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
</body>
</html>