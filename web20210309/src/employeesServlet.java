

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.dbcp2.DriverManagerConnectionFactory;

import model.employees;

/**
 * Servlet implementation class employeesServlet
 */
@WebServlet("/employeesServlet")
public class employeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employeesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String URL="jdbc:mysql://localhost:3306/classicmodels";
		String user="root";
		String password="1234";
		String SQL="select * from classicmodels.employees";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(URL, user, password);
			
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(SQL);
			List<employees> employees=getEmployeesList(rs);
			request.setAttribute("employees", employees);
			//response.getWriter().append(employees.toString());
			request.getRequestDispatcher("viewEmployees.jsp").forward(request, response);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
	}

	private List<employees> getEmployeesList(ResultSet rs) throws SQLException {
		List<employees> list=new ArrayList<>();
		
		while(rs.next()) {
			Integer en=rs.getInt("employeeNumber");
			String ln=rs.getString("lastName");
			String fn=rs.getString("firstName");
			String et=rs.getString("extension");
			String em=rs.getString("email");
			String oc=rs.getString("officeCode");
			Integer rt=rs.getInt("reportsTO");
			String jt=rs.getString("jobTitle");
			
			list.add(new employees(en,ln,fn,et,em,oc,rt,jt));		
		}
		return list;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
