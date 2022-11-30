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
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.StuInfoLogic;
import model.bean.AccountBean;
import model.bean.StudentBean;

/**
 * Servlet implementation class sample
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログイン画面へフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
				request.setCharacterEncoding("UTF-8");
				String userId = request.getParameter("userId");
				String pass = request.getParameter("pass");
				
				// ログイン処理の実行
				AccountBean login = new AccountBean(userId, pass);
				LoginLogic bo = new LoginLogic();
				boolean result = bo.findAccount(login);
				
				// ログイン処理の成否によって処理を分岐
				if (result) {
					// ログイン成功
					// セッションスコープにアカウント情報を保存
					
					AccountBean ac = new AccountBean();
					LoginLogic bo1 = new LoginLogic();
					ac = bo1.getAccountInfo(login);
					HttpSession session = request.getSession();
					session.setAttribute("ac", ac);
					
					// セッションスコープチェック
					System.out.println(ac.getUserName());
				
				// 訓練生情報の取得
				StuInfoLogic sl = new StuInfoLogic();
				List<StudentBean> stuList = sl.findAccount();
					
				// 訓練生情報をアプリケーションスコープに保存
					ServletContext application = this.getServletContext();
					application.setAttribute("stulist", stuList);
					
					
					// index.jspへフォワード
					RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/index.jsp");
					dispatcher.forward(request, response);
				} else {
					// ログイン失敗
					// loginerror.jspへフォワード
					// response.sendRedirect("WEB-INF/jsp/loginerror.jsp");
					RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/loginerror.jsp");
					dispatcher.forward(request, response);
				}
	}

}
