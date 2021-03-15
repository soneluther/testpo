

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Model.student;

/**
 * Servlet implementation class JsonAddServlet
 */
@WebServlet("/JsonAddServlet")
public class JsonAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//建立JSON物件
		GsonBuilder gBuilder=new GsonBuilder();
		gBuilder.setPrettyPrinting();
		Gson gson=gBuilder.create();
		
		//將date的資料映射到student物件中
		String jsonString=request.getParameter("data");
		student student=gson.fromJson(jsonString, student.class);
		
		request.setAttribute("student", student);
		request.getRequestDispatcher("student.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
