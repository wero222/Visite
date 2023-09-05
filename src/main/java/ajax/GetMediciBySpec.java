package ajax;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;

import controllers.MediciController;
import controllers.SpecializzazioniController;
import entities.Medico;
import entities.Specializzazione;

/**
 * Servlet implementation class GetMediciBySpec
 */
public class GetMediciBySpec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMediciBySpec() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// INPUT: ?idSpec=X
		
		String idSpec = request.getParameter("idSpec");
		int idSpecInt = 0;
		Gson gson = new Gson();
		PrintWriter pw = response.getWriter();
		response.setContentType("application/json");
		
		try {
			idSpecInt = Integer.parseInt(idSpec);
		}
		catch(NumberFormatException e) {
			// 400 -> Bad request (errore client-side)
			// { message: "L'id specializzazione non è valido" }
			response.setStatus(400);
			pw.print(gson.toJson(new ResponseError("L'id specializzazione non è valido")));
			return;
		}
		// 404 -> Not found (spec che non esiste)
		// { message: "La specializzazione cercata non esiste" }
		if(!SpecializzazioniController.idExists(idSpecInt)) {
			response.setStatus(404);
			pw.print(gson.toJson(new ResponseError("L'id " + idSpec + " specializzazione non esiste")));
			return;
		}
		
		// 200 OK -> success
		try {
			ArrayList<Medico> r = MediciController.getMediciByIdSpec(idSpecInt);
			pw.print(gson.toJson(r, ArrayList.class));
		}
		catch(Exception e) {
			// 500 -> Internal server error (errore server-side)
			// { message: "Impossibile recuperare l'elenco dei medici" }
			pw.print(gson.toJson(new ResponseError("Impossibile recuperare l'elenco dei medici")));
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
