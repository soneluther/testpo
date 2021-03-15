
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.GuessGameLogic;

/**
 * Servlet implementation class GameGuessServlet
 */
@WebServlet("/GameGuessServlet")
public class GameGuessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GameGuessServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		GuessGameLogic ggl=(GuessGameLogic) session.getAttribute("ggl");
		
		//確認session是否為null
		if(ggl==null) {
			ggl=new GuessGameLogic(1, 10);
			session.setAttribute("ggl", ggl);
		}
		
		String guessNum=request.getParameter("guessNum");
		
		if(ggl.isCorrectNum(Integer.valueOf(guessNum))) {
			generateYouWinResponse(request, response);
			session.invalidate();
		}else {
			if(ggl.getGuessCountdown()>0) {
				generateTryAgainResponse(request, response, ggl.getGuessCountdown(), ggl.getHint());
			}else {
				generateTooManyGuessesResponse(request, response);
				session.invalidate();
			}
		}
		
		
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

	public void generateTryAgainResponse(HttpServletRequest request, HttpServletResponse response, int remainder ,String hint)
			throws IOException {
		String guess = request.getParameter("guessNum");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println("所猜的數字 : " + guess + " 是錯的 ! </br>");
		out.println("還有 " + remainder + " 次機會.再試試看</br>");
		out.println("提示 : " + hint +"</br>");
		out.println("<a href='guess.html'>再試一次 !!</a>");
		out.println("</body></html>");
		out.close();
	}

	public void generateYouWinResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println("恭喜你猜對了! <BR>");
		out.println("**<a href='guess.html'>新遊戲 !!</a>**");
		out.println("</body></html>");
		out.close();
	}

	public void generateTooManyGuessesResponse(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String guess = request.getParameter("guessNum");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println("所猜的數字 : " + guess + " 是錯的 ! </br>");
		out.println("抱歉，已沒有次數了</br>");
		out.println("**<a href='guess.html'>新遊戲 !!</a>**");
		out.println("</body></html>");
		out.close();
	}

}
