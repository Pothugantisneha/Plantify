package p2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try {
			String name=request.getParameter("t1");
			String pwd=request.getParameter("t2");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ttproject","root","tiger");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from login where "+"username='"+name+"' AND  password='"+pwd+"'");
		if(rs.next()) {
			out.println("LOGIN SUCCESSFULL");
			response.sendRedirect("Home.html");
		}
		else
			out.println("incorrect username and password");
		}
		catch(Exception e)
		{
			out.print(e);
		}
		
	}

}
