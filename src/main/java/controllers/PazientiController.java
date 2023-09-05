package controllers;

import java.sql.ResultSet;
import java.util.ArrayList;

import db.DB;
import entities.Paziente;

public class PazientiController {
	
	public static ArrayList<Paziente> getAll(){
		
		ArrayList<Paziente> list = new ArrayList<>();
		try {
			ResultSet rs = DB.getStmt().executeQuery(
				"SELECT * FROM pazienti ORDER BY cognome ASC"
			);
			while(rs.next()) {
				list.add(
					new Paziente(
						rs.getInt("id"), 
						rs.getString("nome"),
						rs.getString("cognome"),
						new java.util.Date(
							rs.getDate("dataNascita").getTime()
						)
					)
				);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}

}
