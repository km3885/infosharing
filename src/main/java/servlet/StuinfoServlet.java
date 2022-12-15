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
		int id;
		StudentBean stu;
		StuInfoLogic sl = new StuInfoLogic();
		StudentBean stu1 = new StudentBean();
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
			case "index":
				// stuinfo.jspへフォワード
				dispatcher = request.getRequestDispatcher("WEB-INF/jsp/stuinfo.jsp");
				dispatcher.forward(request, response);	
				break;
			case "create":
				// 新規登録画面へフォワード
				dispatcher = request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
				dispatcher.forward(request, response);	
				break;
		}
		
					
			case "999":
				id = Integer.parseInt(trash);
				stu = new StudentBean(id);
				stu1 = sl.findAccount(stu);
				// リクエストスコープにインスタンスを保存
				request.setAttribute("stu1", stu1);
				// delete.jspへフォワード
				dispatcher = request.getRequestDispatcher("WEB-INF/jsp/deleteStudent.jsp");
				dispatcher.forward(request, response);	
				break;
				
			default:
				id = Integer.parseInt(key);
				stu = new StudentBean(id);
				stu1 = sl.findAccount(stu);
				// リクエストスコープにインスタンスを保存
				request.setAttribute("stu1", stu1);
				// editstudent.jspへフォワード
				dispatcher = request.getRequestDispatcher("WEB-INF/jsp/editstudent.jsp");
				dispatcher.forward(request, response);	
				break;
		}
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
		
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		stu.setId(Integer.parseInt(request.getParameter("id")));
		stu.setNo(request.getParameter("no"));
		stu.setName(request.getParameter("name"));
		stu.setState(request.getParameter("state"));
		stu.setCoName(request.getParameter("coName"));
		
		// パラメータチェック
//		System.out.println(stu.getId());
//		System.out.println(stu.getNo());
//		System.out.println(stu.getName());
//		System.out.println(stu.getState());
//		System.out.println(stu.getCoName());
		
		String btn = request.getParameter("btn");
		// 
		
		switch(btn) {
			case "":
				boo = stuinfo.insertStudent(stu);
				break;
				
			case "update":
				boo = stuinfo.updateStudent(stu);
				break;
				
			case "delete":
				boo = stuinfo.deleteStudent(stu);
				break;
		}
		
		
		// 
		System.out.println("boo:" + boo);
		
		// 訓練生情報の取得
		StuInfoLogic sl = new StuInfoLogic();
		List<StudentBean> stuList = sl.findAccount();
		// リクエストスコープに保存
		request.setAttribute("stulist", stuList);
		
		// stuinforesult.jspへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/stuinfo.jsp");
		dispatcher.forward(request, response);
	}

}
