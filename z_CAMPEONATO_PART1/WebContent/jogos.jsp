<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Jogos</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	
	<div align="center">
	<H1><b> JOGOS FORMADOS </b></H1>
	<hr>
	</div>
	<div align="center">
			<form action="jogosFormados" method="get">
				<table>
					<tr>
						<td colspan="3">
							<input class="input_data_id" type="date" id="data" name="data" placeholder="Data">
						</td>
						<td>
							<input type="submit" id="botao" name="botao" value="Buscar">
							<input type="submit" id="botao" name="botao" value="Listar">
						</td>
					</tr>
				</table>
			</form>	
	</div>
	
	<div align="center">
		<c:if test="${not empty listJG }">
			<table class="table_round">
				<thead>
					<tr>
						<th class="th_dash">Codigo Time A</th>
						<th class="th_dash">Codigo Time B</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${listJG }" var="jg">
					<tr>
						<td class="td_groove" align="center"><c:out value="${jg.codigoTimeA }"/></td>
						<td class="td_groove" align="center"><c:out value="${jg.codigoTimeB }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	
</body>
</html>