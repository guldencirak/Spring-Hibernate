package com.springdemo.testdb;

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
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//setup connection variables
				String user="spstudent";
				String pass="spstudent";
				String jdbcUrl="jdbc:mysql://localhost:3306/FlyingWeb?useSSL=false";
				
				String driver="com.mysql.jdbc.Driver";
				
				PrintWriter out= response.getWriter();
				
				try {
					
					
					out.println("Connecting to db: "+jdbcUrl);
					
					Class.forName(driver);
					
					Connection myConn=DriverManager.getConnection(jdbcUrl,user,pass);
					
					out.println("Connection successful");
					
					myConn.close();
					
				}catch(Exception exc) 
				{
					out.println("HATA HATA HATA HATA HATA");
					exc.printStackTrace();
					throw new ServletException();
				}
				
				//get connection to db
	}
}
