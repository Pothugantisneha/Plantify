package p2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signServlet
 */
@WebServlet("/signServlet")
public class signServlet extends HttpServlet {
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
		int i=st.executeUpdate("insert into login values('"+name+"','"+pwd+"')");
		if(i>0) {
			out.println("SIGNUP SUCCESSFULL");
			response.sendRedirect("login.html");
		}
		else
			out.println("SIGNUP UNSUCCESSFULL");
	}
		catch(Exception e)
		{
			out.print(e);
		}
		}

}
