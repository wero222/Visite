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
<link id="bsdp-css" href="https://unpkg.com/bootstrap-datepicker@1.9.0/dist/css/bootstrap-datepicker3.min.css" rel="stylesheet">
</head>
<body>

<div class="container my-5">
	<h1>Quando vuoi effettuare la visita?</h1>
	<p class="text-muted">Scegli una data e un orario</p>
	<hr>
	<form>
		<div class="row">
			<div class="col-6">
				<div class="bg-light p-4">
					<h4>Data appuntamento</h4>
					<input type="text" class="form-control" id="datepicker">
				</div>
			</div>
			<div class="col-6">
				<div class="bg-light p-4">
					<h4>Orario</h4>
					<div class="d-flex">
						<select class="form-select">
							<% for(int i = 1; i <= 24; i++) { %>
								<option value="<%= i %>"><%= i %></option>
							<% } %>
						</select>
						<select class="form-select ms-1">
							<% for(int i = 1; i <= 59; i++) { %>
								<option value="<%= i %>"><%= i %></option>
							<% } %>
						</select>
					</div>
				</div>
			</div>
		</div>
		<input type="hidden" name="idMedico" value="<%= request.getParameter("idMedico") %>" id="idMedico">
		<input type="hidden" name="idPaziente" value="<%= request.getParameter("idPaziente") %>">
		<button type="button" class="btn btn-outline-primary mt-3 float-start" onclick="checkDate()">Verifica data</button>
		<button type="submit" class="float-end btn btn-primary mt-3">Avanti &raquo;</button>
	</form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script src="https://unpkg.com/bootstrap-datepicker@1.9.0/dist/js/bootstrap-datepicker.min.js"></script>
<script src="https://unpkg.com/bootstrap-datepicker@1.9.0/dist/locales/bootstrap-datepicker.it.min.js" charset="UTF-8"></script>
<script>
	$("#datepicker").datepicker({ format: 'dd/mm/yyyy', language: 'it' })
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>