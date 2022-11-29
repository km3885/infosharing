package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StuInfoLogic;
import model.bean.StudentBean;

/**
 * Servlet implementation class StuinfoServlet
 */
@WebServlet("/StuinfoServlet")
public class StuinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StuinfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//
		request.setCharacterEncoding("UTF-8");

		// stuinfo.jspへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/stuinfo.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String stuNo = request.getParameter("stu_name");
		// System.out.println("パラメータは" + stuNo);

		// 訓練生情報の取得
		StuInfoLogic sl = new StuInfoLogic();
		List<StudentBean> stuList = sl.findAccount();

		// 訓練生情報をアプリケーションスコープに保存
		ServletContext application = this.getServletContext();
		application.setAttribute("stulist", stuList);

		// stuinfo.jspへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/stuinfo.jsp");
		dispatcher.forward(request, response);
	}

}
