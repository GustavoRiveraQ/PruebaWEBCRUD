import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletConsultas")
public class ServletConsultas extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletConsultas() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        Connection conn;
        String vret = null;

		try {
			// Inicializa Conexion
			conn = ConexionDB.initializeDatabase();
			
			// Utiliza el select del Crud
			switch(request.getParameter("operation")) {
				case "select":
					vret = Title_Types.select(conn,request.getParameter("title_no"));
					break;
				case "insert":
					if(Title_Types.insert(conn,request.getParameter("title_no"),request.getParameter("title"))) {
						vret = "Exito";
					};
					break;
				case "update":
					if(Title_Types.update(conn,request.getParameter("title"),request.getParameter("title_no"))) {
						vret = "Exito";
					};
					break;
				case "delete":
					if(Title_Types.delete(conn,request.getParameter("title_no"))) {
						vret = "Exito";
					};
					break;	
				
			};
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		response.getWriter().append(vret);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
