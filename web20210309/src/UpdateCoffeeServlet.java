

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
 * Servlet implementation class UpdateCoffeeServlet
 */
@WebServlet("/UpdateCoffeeServlet")
public class UpdateCoffeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCoffeeServlet() {
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
			out.println("<title>Servlet UpdateCoffee</title>");
			out.println("</head>");
			out.println("<body>");

			String coffee = request.getParameter("coffee");
			String sale = request.getParameter("sale");
			String total = request.getParameter("total");

			boolean flag = true;

			try {
				flag = UpdateCoffee(coffee, sale, total);
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

			out.println("修改完成:" + flag);
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
	}

	private boolean UpdateCoffee(String coffee, String sale, String total) throws SQLException {
		Connection conn = null;
		PreparedStatement psSales = null;
		PreparedStatement psTotal = null;

		String SQLSales = "update COFFEES set SALES=? where COF_NAME=?";
		String SQLTotal = "update COFFEES set TOTAL= TOTAL+ ? where COF_NAME=?";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/coffeedb?useUnicode=true&characterEncoding=utf8", "root", "1234");
			conn.setAutoCommit(false);			
			psSales = conn.prepareStatement(SQLSales);
			psTotal = conn.prepareStatement(SQLTotal);
			
			psSales.setInt(1, Integer.parseInt(sale));
			psSales.setString(2, coffee);			
			int rSales = psSales.executeUpdate();
						
			psTotal.setInt(1, Integer.parseInt(total));
			psTotal.setString(2, coffee);
			int rTotal=psTotal.executeUpdate();
			
			conn.commit();
			
			if (rSales>0 && rTotal>0)
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
			if (psSales != null) {
				psSales.close();
			}
			
			if (psTotal != null) {
				psTotal.close();
			}
			
			conn.setAutoCommit(true);
		}
		return false;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
