async function loadMedici(){
	const idSpec = document.getElementById("selectSpec").value
	// AJAX
	const r = await fetch("http://localhost:8080/Visite/getMediciBySpec?idSpec=" + idSpec)
	if(r.ok){
		const medici = await r.json()
		const s = document.getElementById("selectMedici")
		s.innerHTML = ""
		let html = "<option value=\"0\" selected>Scegli</option>"
		for(let medico of medici){
			html +=
			"<option value=\"" + medico.id + "\">" + medico.nome + " " + medico.cognome + "</option>"
		}
		s.innerHTML = html
	}
	else {
		console.error(r)
	}
}

async function checkDate(){
	const data = document.getElementById("datepicker").value
	const idMedico = document.getElementById("idMedico").value
	const r = await fetch("http://localhost:8080/Visite/checkCalendar?data=" + data + "&idMedico=" + idMedico)
	if(r.ok){
		console.log(r)
	}
	else {
		console.error("ERRORE")
	}
}

