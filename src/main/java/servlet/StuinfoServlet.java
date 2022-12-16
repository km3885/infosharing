package servlet;

import java.io.IOException;
import java.util.List;

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
		// 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 宣言。初期化
		StuInfoLogic sl = new StuInfoLogic();
		RequestDispatcher dispatcher;
		
		// リクエストパラメータ取得
		request.setCharacterEncoding("UTF-8");
		String btn = request.getParameter("btn");
		
		// 就活状況の取得
		List<StudentBean> stuList = sl.findAccount();
		// リクエストスコープに保存
		request.setAttribute("stulist", stuList);

	
		// パラメータによってフォワード先を変更
		switch(btn) {
			case "normal":
//				// stuinfo.jspへフォワード
				dispatcher = request.getRequestDispatcher("WEB-INF/jsp/stuinfo.jsp");
				dispatcher.forward(request, response);	
				break;
			case "create":
				// 新規登録画面へフォワード
				dispatcher = request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
				dispatcher.forward(request, response);	
				break;
		}
		// stuinfo.jspへフォワード
//		dispatcher = request.getRequestDispatcher("WEB-INF/jsp/stuinfo.jsp");
//		dispatcher.forward(request, response);	
	}

			

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentBean stu = new StudentBean();
		StuInfoLogic stuinfo = new StuInfoLogic();
		boolean boo = false;
		RequestDispatcher dispatcher;
		StuInfoLogic sl = new StuInfoLogic();
		
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String hoge = request.getParameter("hoge");
		String btn = request.getParameter("btn");
		
		if(hoge.equals("foo")) {
			String code = request.getParameter("id");
			switch(btn) {	
				case "edit":
					int id = Integer.parseInt(code);
					StudentBean editstu = new StudentBean(id);
					editstu = sl.findAccount(editstu);
					// リクエストスコープにインスタンスを保存
					request.setAttribute("editstu", editstu);
					// editstudent.jspへフォワード
					dispatcher = request.getRequestDispatcher("WEB-INF/jsp/editstudent.jsp");
					dispatcher.forward(request, response);	
					break;
					
				case "trash":
					int trashId = Integer.parseInt(code);
					StudentBean trashStu = new StudentBean(trashId);
					trashStu = sl.findAccount(trashStu);
					// リクエストスコープにインスタンスを保存
					request.setAttribute("trashStu", trashStu);
					// delete.jspへフォワード
					dispatcher = request.getRequestDispatcher("WEB-INF/jsp/deleteStudent.jsp");
					dispatcher.forward(request, response);	
					break;
			}
		} else {
			stu.setNo(request.getParameter("no"));
			stu.setName(request.getParameter("name"));
			stu.setState(request.getParameter("state"));
			stu.setCoName(request.getParameter("coName"));
			
			switch(btn) {
			case "register":
				boo = stuinfo.insertStudent(stu);
				// stuinfo.jspへフォワード
				dispatcher = request.getRequestDispatcher("WEB-INF/jsp/stuinfo.jsp");
				dispatcher.forward(request, response);	
				break;
				
			case "update":
				boo = stuinfo.updateStudent(stu);
				// stuinfo.jspへフォワード
				dispatcher = request.getRequestDispatcher("WEB-INF/jsp/stuinfo.jsp");
				dispatcher.forward(request, response);	
				break;
				
			case "delete":
				boo = stuinfo.deleteStudent(stu);
				// stuinfo.jspへフォワード
				dispatcher = request.getRequestDispatcher("WEB-INF/jsp/stuinfo.jsp");
				dispatcher.forward(request, response);	
				break;
				
			}
		}
	}
}