package entities;

import java.util.ArrayList;

public class Medico {
	
	private int id;
	private String nome;
	private String cognome;
	private ArrayList<Specializzazione> specs;
	
	public Medico(int id, String nome, String cognome, ArrayList<Specializzazione> specs) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.specs = specs;
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

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public ArrayList<Specializzazione> getSpecs() {
		return specs;
	}

	public void setSpecs(ArrayList<Specializzazione> specs) {
		this.specs = specs;
	}
	
	
	

}
