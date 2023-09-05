package ajax;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.google.gson.Gson;

import db.DB;

/**
 * Servlet implementation class CheckClalendar
 */
public class CheckCalendar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCalendar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data = request.getParameter("data");
		String idMedico = request.getParameter("idMedico");
		PrintWriter pw = response.getWriter();
		Gson gson = new Gson();
		response.setContentType("application/json");
		
		java.util.Date utilDate = null;
		try {
			utilDate = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		}
		catch(ParseException e) {
			response.setStatus(400);
			pw.print(gson.toJson(new ResponseError("Data non valida")));
			return;
		}
		
		// andrebbe fatto nell'AppuntamentoController...
		try {
			PreparedStatement stmt = DB.getPreparedStmt(
				"SELECT COUNT(*) FROM appuntamento WHERE idMedico = ? AND data = ?"
			);
			stmt.setInt(1, Integer.parseInt(idMedico));
			stmt.setDate(2, new java.sql.Date(utilDate.getTime()));
			ResultSet rs = stmt.executeQuery();
			rs.next();
			if(rs.getInt(1) == 0) {
				pw.print(gson.toJson(new GenericResponse(true)));
			}
			else {
				pw.print(gson.toJson(new GenericResponse(false)));
			}
		}
		catch(Exception e) {
			response.setStatus(500);
			pw.print(gson.toJson(new ResponseError("Impossibile verificare il calendario")));
			return;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
