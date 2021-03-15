

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.simpleEmp;

/**
 * Servlet implementation class employeeStoredProceduceServlet
 */
@WebServlet("/employeeStoredProceduceServlet")
public class employeeStoredProceduceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employeeStoredProceduceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//connetDB
		String url="jdbc:mysql://localhost:3306/classicmodels";
		String user="root";
		String password="1234";
		String Drever="com.mysql.jdbc.Driver";
		
		try {
			Class.forName(Drever);
			Connection conn=DriverManager.getConnection(url, user, password);
			
			CallableStatement cst=conn.prepareCall("Call GetEmpInOffice(?)");
			cst.setString(1, request.getParameter("city"));
			
			ResultSet rs=cst.executeQuery();
			ArrayList<simpleEmp> list=new ArrayList<>();
			toList(rs, list);
			
			request.getSession().setAttribute("emps", list);
			request.getRequestDispatcher("ShowEmpInCity.jsp").forward(request, response);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	public void toList(ResultSet rs, ArrayList<simpleEmp> list) {
		try {
			while(rs.next()) {
				simpleEmp semp=new simpleEmp(
						rs.getInt("employeeNumber"),
						rs.getString("lastName"),
						rs.getString("firstName"),
						rs.getString("email")
						);
				list.add(semp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
