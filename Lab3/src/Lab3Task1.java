import java.io.*;
import java.util.*;

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
		/*String requestString = request.getQueryString();
		String httpRequest = request.getScheme();
		String serverName = request.getServerName();
		int serverPortString = request.getServerPort();*/
		
		BufferedReader req = request.getReader();
		 
		String line = req.readLine();	
		
		int cntEntries=0;
		String fileEntry = "";
		response.setContentType("text/html");
		PrintWriter writeToFile;
	      PrintWriter out = response.getWriter();
	      
	     Enumeration<String> params = request.getParameterNames();
	      
	     
	      while(params.hasMoreElements())
	      {
	    	  String paramN = (String)params.nextElement();
	    	  String[] paramV =
	    			  request.getParameterValues(paramN);
	    			  if (paramV.length == 1) {
	    			  String paramValue = paramV[0];
	    			  if (paramValue.length() == 0)
	    			  fileEntry = fileEntry+"null"+" ";
	    			  else
	    			  fileEntry = fileEntry+paramValue+" ";
	    			  }
	    			  
	    			  else {
	    			  for(int i=0; i<paramV.length; i++) 
	    			  {
	    				  
	    				  if (paramV[i].length() == 0)
	    	    			  fileEntry = fileEntry+"null"+" ";
	    	    			  else
	    	    			  fileEntry = fileEntry+paramV[i]+" ";
	    			  }
	    			  }
	    			 
	      }
	      
	      File file  = new File("/Users/Cynosure/Downloads/ResultEntries.txt");
	      if(!file.exists())
	      {
	    	  file.createNewFile();
	    	 writeToFile = new PrintWriter(file); 
	    	 writeToFile.write(fileEntry);
	    	 writeToFile.append("\n");
	      }
	      
	      else {
	    	   writeToFile = new PrintWriter(new FileWriter(file,true)); 
	      writeToFile.append(fileEntry);
	      writeToFile.append("\n");
	      }
	      
	      writeToFile.close();
		fileEntry="";
	    			  
	    	BufferedReader read = new BufferedReader(new FileReader(file.getAbsoluteFile()));
	      
	    	fileEntry=read.readLine();
	    		while(fileEntry!=null)
	    		{
	    			++cntEntries;
	    			fileEntry=read.readLine();
	    		}
	    		
	    		read.close();
	    		
	    		
	    			  
	   out.println("<html>"+"<body>Transaction successful<br>Number of entries are:"+cntEntries+"<br><a href=\"http://localhost:8080/Lab3/Form1.html\">click here to go back</a>"+line+"</body></html>");
	      
		 /* String title = "Using GET Method to Read Form Data Changed";
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
	                "</body></html>");*/

		
		
	}
}