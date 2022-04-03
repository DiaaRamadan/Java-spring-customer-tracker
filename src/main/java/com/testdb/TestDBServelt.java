package com.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServelt
 */
@WebServlet("/TestDBServelt")
public class TestDBServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = "springstudent";
        String password = "springstudent";

        String jdbcUrl = "jdbc:mysql://localhost:3366/web_customer_tracker?useSSL=false";
        
        String driver = "com.mysql.jdbc.Driver";
        
        try {
        	
        	PrintWriter out = response.getWriter();
        	
        	out.print("Connecting to database: " + jdbcUrl);
        	
        	Class.forName(driver);
        	Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
        	
        	out.print("Success!!!");
        	conn.close();
        	
        }catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}

}
