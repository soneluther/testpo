
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteCoffeeServlet
 */
@WebServlet("/DeleteCoffeeServlet")
public class DeleteCoffeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteCoffeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet DeleteCoffee</title>");
			out.println("</head>");
			out.println("<body>");

			String coffee = request.getParameter("coffee");

			boolean flag = true;

			try {
				flag = DeleteCoffee(coffee);
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

			out.println("刪除完成:" + flag);
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
	}

	private boolean DeleteCoffee(String coffee) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;

		String SQL = "delete from COFFEES where COF_NAME=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/coffeedb?useUnicode=true&characterEncoding=utf8", "root", "1234");
			conn.setAutoCommit(false);
			
			ps = conn.prepareStatement(SQL);
			ps.setString(1, coffee);
			
			int r = ps.executeUpdate();
			conn.commit();
			
			if (r > 0)
				return true;
			else
				return false;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (conn != null) {
				try {
					System.err.print("Transaction is being rolled back");
					conn.rollback();
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}
		} finally {
			if (ps != null) {
				ps.close();
			}
			conn.setAutoCommit(true);
		}
		
		return false;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
