<%@page import="controllers.SpecializzazioniController"%>
<%@page import="entities.Specializzazione"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="controllers.PazientiController"%>
<%@page import="entities.Paziente"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Specializzazione> specs = SpecializzazioniController.getAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Visite</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<script src="./js/visite.js"></script>
</head>
<body>

<div class="container my-5">
	<h1>Seleziona un medico</h1>
	<p class="text-muted">Scegli una specializzazione e un medico</p>
	<hr>
	<form action="./check-calendar.jsp">
		<div class="row">
			<div class="col-6">
				<div class="bg-light p-4">
					<h4>Specializzazione</h4>
					<select class="form-select" onchange="loadMedici()" id="selectSpec">
						<option value="0">Scegli...</option>
						<% for(Specializzazione s : specs) { %>
							<option value="<%= s.getId() %>"><%= s.getNome() %></option>
						<% } %>
						<option value="99">** Non esiste **</option>
					</select>
				</div>
			</div>
			<div class="col-6">
				<div class="bg-light p-4">
					<h4>Medico</h4>
					<select class="form-select" id="selectMedici" name="idMedico">
						
					</select>
				</div>
			</div>
		</div>
		<input type="hidden" name="idPaziente" value="<%= request.getParameter("idPaziente") %>">
		<button type="submit" class="float-end btn btn-primary mt-3">Avanti &raquo;</button>
	</form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>