
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
 * Servlet implementation class InsertCoffeeServlet
 */
@WebServlet("/InsertCoffeeServlet")
public class InsertCoffeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertCoffeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet InsertCoffee</title>");
			out.println("</head>");
			out.println("<body>");

			String coffee = request.getParameter("coffee");
			String sale = request.getParameter("sale");
			String total = request.getParameter("total");
			String supplier = request.getParameter("supplier");
			String price = request.getParameter("price");

			boolean flag = true;

			try {
				flag = InsertCoffee(coffee, sale, total, supplier, price);
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

			out.println("新增完成:" + flag);
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
	}

	private boolean InsertCoffee(String coffee, String sale, String total, String supplier, String price)
			throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;

		String SQL = "insert into COFFEES( COF_NAME , SUP_ID , PRICE , SALES ,TOTAL)"
				+ "values ( ? , ? ,? ,? ,?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/coffeedb?useUnicode=true&characterEncoding=utf8", "root", "1234");
			conn.setAutoCommit(false);
			
			ps = conn.prepareStatement(SQL);
			ps.setString(1, coffee);
			ps.setInt(2, Integer.parseInt(supplier));
			ps.setDouble(3, Double.parseDouble(price));
			ps.setInt(4, Integer.parseInt(sale));
			ps.setInt(5, Integer.parseInt(total));
			
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
