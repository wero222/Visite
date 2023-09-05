package entities;

import java.util.Date;

public class Paziente {
	
	private int id;
	private String nome;
	private String cognome;
	private Date dataNascita;
	
	public Paziente(int id, String nome, String congome, Date dataNascita) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = congome;
		this.dataNascita = dataNascita;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String congome) {
		this.cognome = congome;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	

}
