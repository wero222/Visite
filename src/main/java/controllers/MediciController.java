package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.DB;
import entities.Medico;
import entities.Specializzazione;

public class MediciController {
	
	public static ArrayList<Medico> getMediciByIdSpec(int idSpec) throws Exception {
		
		ArrayList<Medico> list = new ArrayList<>();
		
		// seleziono i medici di quella specializzazione
		PreparedStatement stmt = DB.getPreparedStmt(
				  "SELECT m.* from "
				+ "medici_specializzazioni AS ms "
				+ "INNER JOIN medici AS m "
				+ "ON ms.idMedico = m.id "
				+ "WHERE idSpecializzazione = ?"
		);
		stmt.setInt(1, idSpec);
		ResultSet rs = stmt.executeQuery();
		
		// per ogni medico, seleziono tutte le sue specializzazioni
		while(rs.next()) {
			list.add(
				new Medico(
					rs.getInt("id"),
					rs.getString("nome"),
					rs.getString("cognome"),
					getSpecsByIdMedico(idSpec)
				)
			);
		}		
		
		return list;
		
	}
	
	public static ArrayList<Specializzazione> getSpecsByIdMedico(int idMedico) throws Exception {
		ArrayList<Specializzazione> specs = new ArrayList<>();
		PreparedStatement stmt = DB.getPreparedStmt(
				  "SELECT s.* FROM "
				+ "medici_specializzazioni AS ms "
				+ "INNER JOIN specializzazioni AS s "
				+ "ON ms.idSpecializzazione = s.id "
				+ "WHERE ms.idMedico = ?"
		);
		stmt.setInt(1, idMedico);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			specs.add(
				new Specializzazione(rs.getInt("id"), rs.getString("nome"))
			);
		}
		return specs;
		
	}

}
