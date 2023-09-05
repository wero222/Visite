package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.DB;
import entities.Specializzazione;

public class SpecializzazioniController {
	
	public static ArrayList<Specializzazione> getAll(){
		
		ArrayList<Specializzazione> list = new ArrayList<>();
		try {
			ResultSet rs = DB.getStmt().executeQuery(
				"SELECT * FROM specializzazioni ORDER BY nome ASC"
			);
			while(rs.next()) {
				list.add(
					new Specializzazione(rs.getInt("id"), rs.getString("nome"))
				);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	public static boolean idExists(int idSpec) {
		try {
			PreparedStatement stmt = DB.getPreparedStmt(
				"SELECT COUNT(*) FROM specializzazioni WHERE id = ?"
			);
			stmt.setInt(1, idSpec);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int c = rs.getInt(1); // prendo l'unico campo che la select ritorna
			return c == 1;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
