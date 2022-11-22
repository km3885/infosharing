package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		// ログイン処理の実行
		StudentBean stu = new StudentBean(stuNo);
		StuInfoLogic bo = new StuInfoLogic();
		StudentBean stu1 = bo.execute(stu);

		// ログイン処理の成否によって処理を分岐
		if (stu1 != null) {
			// ログイン成功
			// セッションスコープにユーザIDを保存
			HttpSession session = request.getSession();
			session.setAttribute("stu", stu1);

			// stuinfo.jspへフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/stuinfo.jsp");
			dispatcher.forward(request, response);
		}

	}
}
