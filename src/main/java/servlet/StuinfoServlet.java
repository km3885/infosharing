package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		String key = request.getParameter("id");
		
		if (key == null) {
			// stuinfo.jspへフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/stuinfo.jsp");
			dispatcher.forward(request, response);	
		} else {
			int id = Integer.parseInt(key);
			// チェック
			System.out.println("パラメータ" + id);
			
			StudentBean stu = new StudentBean(id);
			StuInfoLogic sl = new StuInfoLogic();
			StudentBean stu1 = new StudentBean();
			stu1 = sl.findAccount(stu);
			
			// チェック
			System.out.println(stu1.getId());
			System.out.println(stu1.getNo());
			System.out.println(stu1.getName());
			System.out.println(stu1.getState());
			System.out.println(stu1.getCoName());
			
			// stuinforesult.jspへフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/stuinforesult.jsp");
			dispatcher.forward(request, response);	
		}

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
		
		// パラメータチェック
		System.out.println("パラメータは" + stuNo);
		
		// stuinforesult.jspへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/stuinforesult.jsp");
		dispatcher.forward(request, response);
	}

}
