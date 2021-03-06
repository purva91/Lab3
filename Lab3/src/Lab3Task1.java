import java.io.*;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Servlet implementation class Lab3task1
 */

@WebServlet("/Lab3Task1")
public class Lab3Task1 extends HttpServlet {

	static File file ;
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @see HttpServlet#HttpServlet()
	 */

	public Lab3Task1() {
		// TODO Auto-generated constructor stub
		super();
	}

	/**
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Map<String,String[]> queryParams = request.getParameterMap();
		boolean set = false;
		ArrayList<String> result = new ArrayList<String>();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Hashtable<String,String[]> param = new Hashtable<String,String[]>(); 
		
		Set<String> keys = param.keySet();
		
		BufferedReader read = new BufferedReader(new FileReader(
				file.getAbsoluteFile()));
		
	String query = request.getQueryString();
	
	String[] paramArray = query.split("&");
for (int i=0;i<paramArray.length;i++){
	String[] indivParams = paramArray[i].split("=");
	String[] values = indivParams[1].split("\\+");
	param.put(indivParams[0], values);	
}
	
		String fileEntry = read.readLine();
		String saveEntry = fileEntry;
		while (fileEntry != null) {
			HashMap<String, String> fileMap = new HashMap<String, String>();
			String[] fileValues = fileEntry.split(",");
			/*
			 * TODO split the file entry and store in the fileHashMap in
			 * corresponding values
			 */
			fileMap.put("firstname", fileValues[0]);
			fileMap.put("lastname", fileValues[1]);
			fileMap.put("dob ", fileValues[2]);
			fileMap.put("languages", fileValues[3]);
			fileMap.put("days", fileValues[4]);

			/*
			 * TODO: pass the keys of query parameter map to file HashMap to
			 * check if the value of fileHashMap contains the same value or
			 * substring of value .
			 */

			for(String paramN:keys){
				/*
				 * Get the value of each parameter, pass the parameter as the
				 * key in fileHasMap
				 */
				String[] paramV = param.get(paramN);
				if (paramV.length == 1) 
				{
					String paramValue = paramV[0];
					String checkValue = fileMap.get(paramN);
					if (checkValue.contains(paramValue))
						set = true;
					else 
					{
						set = false;
						break;
					}
				}

				else 
				{
					for (int i = 0; i < paramV.length; i++) 
					{
						String paramValue = paramV[i];
						String checkValue = fileMap.get(paramN);
						if (checkValue.contains(paramValue))
							set = true;
					}
				}
							}
			if (set==true)
				result.add(saveEntry);
			fileEntry = read.readLine();
			saveEntry = fileEntry;
			set=false;
		}

		read.close();
		
		String user = request.getHeader("User-Agent");
		
		if (!result.isEmpty()) 
		{
			for (int i = 0; i < result.size(); i++) 
			{
				if(user.indexOf("Mobile") != -1) 
				{
					out.println("<html><body bgcolor=\"pink\"><font size=8>\"" +result.get(i)+"\"<font></body></html>");
				    //you're in mobile land
				} 
				else 
				{
					  out.println("<html><body bgcolor=\"pink\"><font size=12>\"" +result.get(i)+"\"<font></body></html>");
				}
				
			}

		}
		
		else{
			
			if(user.indexOf("Mobile") != -1) 
			{
				out.println("<html><body bgcolor=\"pink\"><font size=8>No Results<font></body></html>");
			    //you're in mobile land
			} 
			else 
			{
				  out.println("<html><body bgcolor=\"pink\"><font size=12>No Results<font></body></html>");
			}
		}
		
	}

	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		String fileName = "/WEB-INF/ResultEntries.txt";
		ServletContext context = request.getServletContext();
		String path = context.getRealPath(fileName);
		
		file = new File(path);
		
		int cntEntries = 0;
		String fileEntry = "";
		response.setContentType("text/html");
		PrintWriter writeToFile;
		PrintWriter out = response.getWriter();

		Enumeration<String> params = request.getParameterNames();

		while (params.hasMoreElements()) {
			String paramN = (String) params.nextElement();
			String[] paramV = request.getParameterValues(paramN);
			if (paramV.length == 1) {
				String paramValue = paramV[0];
				if (paramValue.length() == 0)
					fileEntry = fileEntry + "no value" + ",";
				else
					fileEntry = fileEntry + paramValue + ",";
			}

			else {
				for (int i = 0; i < paramV.length; i++) {

					if (paramV[i].length() == 0)
						fileEntry = fileEntry + "no value" + " ";
					else
						fileEntry = fileEntry + paramV[i] + " ";
				}
			}

		}

		if (!file.exists()) {
			file.createNewFile();
			writeToFile = new PrintWriter(file);
			writeToFile.write(fileEntry);
			writeToFile.append("\n");
		}

		else {
			writeToFile = new PrintWriter(new FileWriter(file, true));
			writeToFile.append(fileEntry);
			writeToFile.append("\n");
		}

		writeToFile.close();
		fileEntry = "";

		BufferedReader read = new BufferedReader(new FileReader(
				file.getAbsoluteFile()));

		fileEntry = read.readLine();
		while (fileEntry != null) {
			++cntEntries;
			fileEntry = read.readLine();
		}

		read.close();

		out.println("<html>"
				+ "<body>Transaction successful<br>Number of entries are:"
				+ cntEntries + "<br><a href=\".." + request.getContextPath()
				+ "/Form1.html\">click here to go back</a></body></html>");

		/*
		 * String title = "Using GET Method to Read Form Data Changed"; String
		 * docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
		 * "transitional//en\">\n"; out.println(docType + "<html>\n" +
		 * "<head><title>" + title + "</title></head>\n" +
		 * "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title +
		 * "</h1>\n" + "<ul>\n" + "  <li><b>First Name</b>: " +
		 * request.getParameter("firstname") + "\n" + "  <li><b>Last Name</b>: "
		 * + request.getParameter("lastname") + "\n" + "</ul>\n" +
		 * "</body></html>");
		 */

	}
}