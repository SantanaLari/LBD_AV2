<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Classificação Geral</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	
	<div align="center">
	<H1><b> Classificação Geral </b></H1>
	<hr>
	</div>
	
	<div align="center">
	<form action="placar" method="post">
			<table>
				<tr>
					<td>
						<input type="submit" id="botao" name="botao" value="Mostrar Classificacao">
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
		<c:if test="${not empty listaGeral }">
			<table class="table_round">
				<thead>
					<tr>
						<th colspan="10"><b> CLASSIFICAÇÃO </b></th>
					</tr>
					<tr>
						<th class="th_dash"><b> Nome </b></th>
						<th class="th_dash"><b> Disputados </b></th>
						<th class="th_dash"><b> Vitorias </b></th>
						<th class="th_dash"><b> Empates </b></th>
						<th class="th_dash"><b> Derrotas </b></th>
						<th class="th_dash"><b> Gols Marcados </b></th>
						<th class="th_dash"><b> Gols Sofridos </b></th>
						<th class="th_dash"><b> Saldo </b></th>
						<th class="th_dash"><b> Pontos </b></th>
					</tr>
				</thead>
				<tbody>
		 			<c:forEach items="${listaGeral }" var="gp">
					
					<c:set var="cond" value="0" scope="page"> </c:set>
					
					<c:forEach var="rebaixado" items="${listaRebaixado }">
						<c:if test="${gp.nomeTime.nomeTime == rebaixado.nomeTime.nomeTime }">
						
							<c:set var ="cond" value="2" scope="page"> </c:set>
							<tr style="background-color:#FF0000" align="center">
								<td class="td_groove"><c:out value="${gp.nomeTime.nomeTime }"/></td>
								<td class="td_groove"><c:out value="${gp.num_jogos_disputados }"/></td>
								<td class="td_groove"><c:out value="${gp.vitorias }"/></td>
								<td class="td_groove"><c:out value="${gp.empates }"/></td>
								<td class="td_groove"><c:out value="${gp.derrotas }"/></td>
								<td class="td_groove"><c:out value="${gp.gols_marcados }"/></td>
								<td class="td_groove"><c:out value="${gp.gols_sofridos }"/></td>
								<td class="td_groove"><c:out value="${gp.saldo_gols }"/></td>
								<td class="td_groove"><c:out value="${gp.pontos }"/></td>
							</tr> 
						</c:if>
						</c:forEach>
						
	 				<c:if test="${cond == 0 }">						
							<tr align="center">
								<td class="td_groove"><c:out value="${gp.nomeTime.nomeTime }"/></td>
								<td class="td_groove"><c:out value="${gp.num_jogos_disputados }"/></td>
								<td class="td_groove"><c:out value="${gp.vitorias }"/></td>
								<td class="td_groove"><c:out value="${gp.empates }"/></td>
								<td class="td_groove"><c:out value="${gp.derrotas }"/></td>
								<td class="td_groove"><c:out value="${gp.gols_marcados }"/></td>
								<td class="td_groove"><c:out value="${gp.gols_sofridos }"/></td>
								<td class="td_groove"><c:out value="${gp.saldo_gols }"/></td>
								<td class="td_groove"><c:out value="${gp.pontos }"/></td>
							</tr>
						</c:if> 	
					</c:forEach> 
					
				</tbody>
			</table>
		</c:if>
	</div>
	
	
	
</body>
</html>