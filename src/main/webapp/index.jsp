<%@page import="java.text.SimpleDateFormat"%>
<%@page import="controllers.PazientiController"%>
<%@page import="entities.Paziente"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Paziente> list = PazientiController.getAll();
	SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Visite</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>

<div class="container my-5">
	<h1>Prenota visita</h1>
	<p class="text-muted">Seleziona un paziente</p>
	<hr>
	<a href="#" class="btn btn-primary">Aggiungi un nuovo paziente</a>
	<table class="table table-striped my-3">
		<thead>
			<th>Paziente</th>
			<th>Data di nascita</th>
			<th></th>
		</thead>
		<tbody>
			<% for(Paziente p : list) { %>
			<tr>
				<td><%= p.getCognome() %> <%= p.getNome() %></td>
				<td><%= sdf.format(p.getDataNascita()) %></td>
				<td>
					<a href="./choose-doc.jsp?idPaziente=<%= p.getId() %>" class="btn btn-outline-primary btn-sm">Seleziona</a>
				</td>
			</tr>
			<% } %>
		</tbody>
	</table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>