package composition.java.patterns.service_locator.examples;

import java.io.IOException;

import javax.naming.ServiceUnavailableException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import composition.java.patterns.service_locator.*;



/**
 * Servlet implementation class ServletPrueba
 */
@WebServlet("/ServletPrueba")
public class ServletPrueba extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		ServiceLocator serviceLocator=null;
		try {
			serviceLocator = ServiceLocator.getInstance();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
	      ProfileLocal profileHome = (ProfileLocal)
	        serviceLocator.getLocal(
	          "java:global/PruebaProyectoDeployment/ProfileEJB!pdg.service_locator.ejb.ejemplos.ProfileLocal");
	      //"java:global/ACADEM-EAR/ACADEM-EJB/EvaluacionBean!co.edu.icesi.academ.evaluaciones.EvaluacionBeanRemote"
	      String s= ""+profileHome.funciona();
	      
	      System.out.println(""+s);
	      response.getWriter().append("Y funcionó? tan tan  ").append(""+s);
	    }
	    catch (ServiceUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
