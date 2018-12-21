package com.exf.pagination;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

/**
 * Servlet implementation class ExfPagination
 */
public class ExfPagination extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExfPagination() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 PrintWriter out=response.getWriter();  
         
	        String spageid=request.getParameter("page");  
	        int pageid=Integer.parseInt(spageid);  
	        int total=5;  
	        if(pageid==1){}  
	        else{  
	            pageid=pageid-1;  
	            pageid=pageid*total+1;  
	        }  
	        List<Document> list=FetchRecords.getRecords(pageid,total);  
	  
	        out.print("<h1>Page No: "+spageid+"</h1>");  
	        out.print("<table border='1' cellpadding='4' width='60%'>");  
	        out.print("<tr><th>NPI</th><th>City</th><th>First Name</th>");  
	        for(Document e:list){  
	            out.print("<tr><td>"+e.getString("NPI")+"</td><td>"+e.getString("Provider_Business_Practice_Location_Address_City_Name")+"</td><td>"+e.getString("Provider_First_Name")+"</td></tr>");  
	        }  
	        out.print("</table>");  
	          
	        out.print("<a href='ExfPagination?page=1'>1</a> ");  
	        out.print("<a href='ExfPagination?page=2'>2</a> ");  
	        out.print("<a href='ExfPagination?page=3'>3</a> ");  
	          
	        out.close();  
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
