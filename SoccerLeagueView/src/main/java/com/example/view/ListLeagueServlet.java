package com.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.League;

public class ListLeagueServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private List<League> list = null;
   
    public ListLeagueServlet()
    {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ProcessRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		//doGet(request, response);
		ProcessRequest(request, response);
	}
	
	protected void ProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			list = new ArrayList<League>();
			list.add(new League("Autumn", 2019, "Hockey"));
			list.add(new League("Summer", 2019, "Cricket"));
			out.println("<html><title>List all Available Titles</title><body>");
			out.println("<table><tr><td>Season</td><td>Title</td><td>Year</td></tr>");
			
			for(League l: list)
			{
				out.println("<tr><td>" + l.getSeason() +"</td><td>"+ l.getTitle() +" </td><td>" + l.getYear());
			}
			
			out.println("</table><a href= 'index.html'>Go To Home Page</a></body></html>");
		
	}
}
