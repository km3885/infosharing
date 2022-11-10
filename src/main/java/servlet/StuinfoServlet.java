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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// stuinfo.jspへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/stuinfo.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String stuName = request.getParameter("stu_name");
		System.out.println(stuName);
		
		// DBから訓練生情報取得し表示
		// 訓練生インスタンスを生成
		StudentBean stu = new StudentBean();
		stu.setName(stuName);
		StuInfoLogic bo = new StuInfoLogic();
		StudentBean stu1 = bo.execute(stu);
		
		// 取得した訓練生の情報をリクエストスコープに保存
		request.setAttribute("stu1", stu1);
		
		// stuinfo.jspへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/stuinfo.jsp");
		dispatcher.forward(request, response);
	}

}
