import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**

 * Servlet implementation class Lab3task1

 */

@WebServlet("/Lab3Task1")

public class Lab3Task1 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    /**

     * @see HttpServlet#HttpServlet()

     */

    public Lab3Task1() 
    {
    	// TODO Auto-generated constructor stub
    	super();
    }
	/**
	
	* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	
	*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		/*
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("Hello World");
		
		
		 response.setContentType("text/html");

	      PrintWriter out = response.getWriter();
		  String title = "Using GET Method to Read Form Data Changed";
	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
	      "transitional//en\">\n";
	      out.println(docType +
	                "<html>\n" +
	                "<head><title>" + title + "</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" +
	                "<h1 align=\"center\">" + title + "</h1>\n" +
	                "<ul>\n" +
	                "  <li><b>First Name</b>: "
	                + request.getParameter("firstname") + "\n" +
	                "  <li><b>Last Name</b>: "
	                + request.getParameter("lastname") + "\n" +
	                "</ul>\n" +
	                "</body></html>");
	       */
	}
	
	/**
	
	* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	
	*/
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");

	      PrintWriter out = response.getWriter();
		  String title = "Using GET Method to Read Form Data Changed";
	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
	      "transitional//en\">\n";
	      out.println(docType +
	                "<html>\n" +
	                "<head><title>" + title + "</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" +
	                "<h1 align=\"center\">" + title + "</h1>\n" +
	                "<ul>\n" +
	                "  <li><b>First Name</b>: "
	                + request.getParameter("firstname") + "\n" +
	                "  <li><b>Last Name</b>: "
	                + request.getParameter("lastname") + "\n" +
	                "</ul>\n" +
	                "</body></html>");

		
		
	}
}