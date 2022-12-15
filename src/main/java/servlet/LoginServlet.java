package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import model.UserLogic;
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
				
				// パラメータチェック
				// System.out.println("パラメータ" + userId);
				// System.out.println("パラメータ" + pass);
				
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
					// System.out.println("bbb" +ac.getUserName());

				
					// アカウント情報をすべて取得
					UserLogic ul = new UserLogic();
					List<AccountBean> userList = new ArrayList<>();
					userList = ul.findAccount();
					
					// userListをアプリケーションスコープに保存
					ServletContext app = this.getServletContext();
					app.setAttribute("userlist", userList);
				
				// 訓練生情報の取得
				StuInfoLogic sl = new StuInfoLogic();
				List<StudentBean> stuList = sl.findAccount();
				// リクエストスコープに保存
				request.setAttribute("stulist", stuList);
				
				// EmploymentData headerリスト
				List<String> headerList = new ArrayList<String>(Arrays.asList("入力", "科名", "氏名", "管轄", "新卒", "適用", "ジョブカード", "希望地", "就職先", "実習先", "勤務地住所", "雇用形態", "雇用保険", "雇用期間", "就職経路", "関連", "職種", "内定日"));
				
				
				// selectBOX用リスト
				// 就活状況
				List<String> selectList = new ArrayList<String>(Arrays.asList("内定", "選考中", "書類作成中", "応募済み", "未応募"));
				// 科名
				List<String> categoryList = new ArrayList<>(Arrays.asList("情報システム科"));
				// 管轄
				List<String> jurisdictionList = new ArrayList<>(Arrays.asList("那覇", "沖縄", "名護"));
				// 新卒
				List<String> newGradList = new ArrayList<>(Arrays.asList("", "○"));
				// 適用
				List<String> applyList = new ArrayList<>(Arrays.asList("雇保", "推進法", "訓給", "一般", "支援"));
				// ジョブカード
				List<String> jobCardList = new ArrayList<>(Arrays.asList("無", "有"));
				// 希望地
				List<String> prefList = new ArrayList<>(Arrays.asList("県内", "県外"));
				// 実習先
				List<String> internshipList = new ArrayList<>(Arrays.asList("", "○"));
				// 雇用形態
				List<String> empStatusList = new ArrayList<>(Arrays.asList("正社員", "派遣", "パート", "アルバイト", "契約社員", "日雇", "その他就職", "臨時・季節", "自営", "未就職", "就職状況報告書の内容不備（求職者支援訓練のみ）", "修了者のうち公的職業訓練の連続受講", "進学", "未回答、追跡不能", "中退（就職理由以外）・ 未修了"));
				// 雇用保険
				List<String> empInsuranceList = new ArrayList<>(Arrays.asList("雇用保険被保険者", "雇用保険未加入雇用者", "雇用保険適用事業主", "雇用保険未加入事業主"));
				// 雇用期間
				List<String> empperiodList = new ArrayList<>(Arrays.asList("１日以上７日未満", "７日以上８日未満", "３１日以上４か月未満", "４か月以上６か月未満", "６か月以上１年未満", "１年以上", "期間の定め無し", "期間の定め不明"));
				// 就職経路
				List<String> empRouteList = new ArrayList<>(Arrays.asList("ハローワーク", "民間職業紹介会社", "新聞・雑誌等求人広告", "実習先事業所への就職", "訓練実施機関への就職", "友人･知人の紹介", "その他"));
				// 関連
				List<String> relationList = new ArrayList<>(Arrays.asList("関連", "非関連"));
				
				
				// アプリケーションスコープに保存
				app.setAttribute("headerlist", headerList);
				app.setAttribute("selectlist", selectList);
				app.setAttribute("categorylist", categoryList);
				app.setAttribute("jurisdictionlist", jurisdictionList);
				app.setAttribute("newGradlist", newGradList);
				app.setAttribute("applylist", applyList);
				app.setAttribute("jobCardlist", jobCardList);
				app.setAttribute("preflist", prefList);
				app.setAttribute("internshiplist", internshipList);
				app.setAttribute("empStatuslist", empStatusList);
				app.setAttribute("empInsurancelist", empInsuranceList);
				app.setAttribute("empperiodlist", empperiodList);
				app.setAttribute("empRoutelist", empRouteList);
				app.setAttribute("relationlist", relationList);
				
					
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
