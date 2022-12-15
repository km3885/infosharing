package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StuEmpLogic;
import model.bean.StudentCsvBean;

/**
 * Servlet implementation class ManagementServlet
 */
@WebServlet("/ManagementServlet")
public class ManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 宣言・初期化
		StuEmpLogic scl = new StuEmpLogic();
		StudentCsvBean[] dataArray = new StudentCsvBean[20];
		
		
		// 就職データ取得（全員分）
		dataArray = scl.getEmpData();
		
		// 就職データ情報をリクエストスコープに保存
		  request.setAttribute("dataArray", dataArray);

		// リクエストパラメータの取得
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");
			
//			if(id != null) {
//				// editSelectStu.jspへフォワード
//				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/editSelectStu.jsp");
//				dispatcher.forward(request, response);
//			}
//		

		// stuManagement.jspへフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/stuManagement.jsp");
			dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 宣言・初期化
		StuEmpLogic scl = new StuEmpLogic();
		StudentCsvBean[] dataArray = new StudentCsvBean[20];
		StudentCsvBean stu = new StudentCsvBean();
		StudentCsvBean stu2 = new StudentCsvBean();
		RequestDispatcher dispatcher;
		boolean boo;
		
		// 就職データ取得（全員分）
		dataArray = scl.getEmpData();
		
		// 就職データ情報をリクエストスコープに保存
		  request.setAttribute("dataArray", dataArray);
		
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String btn = request.getParameter("btn");
		
		System.out.println(btn);
		
		switch (btn) {
			case "select":
				// 就職データ更新する訓練生選択画面へフォワード
				dispatcher = request.getRequestDispatcher("WEB-INF/jsp/editSelectStu.jsp");
				dispatcher.forward(request, response);
				break;
				
			case "edit":
				// 就職データ更新対象の訓練生編集画面へフォワード
				String id = request.getParameter("id");
				int no = Integer.parseInt(id);
				
				// 選択した更新対象訓練生をリクエストスコープに保存
				stu = dataArray[no];
				request.setAttribute("stu", stu);
				
				// stuManagement.jspへフォワード
				dispatcher = request.getRequestDispatcher("WEB-INF/jsp/editStuCsv.jsp");
				dispatcher.forward(request, response);
				break;
				
			case "update":
				// 就職データ更新（1人分）
				// 更新情報を受け取り訓練生インスタンスを生成
				stu2.setId(request.getParameter("id"));
				stu2.setCategory(request.getParameter("category"));
				stu2.setName(request.getParameter("name"));
				stu2.setJurisdiction(request.getParameter("jurisdiction"));
				stu2.setNewGrad(request.getParameter("newGrad"));
				stu2.setApply(request.getParameter("apply"));
				stu2.setJobCard(request.getParameter("jobCard"));
				stu2.setPref(request.getParameter("pref"));
				stu2.setCoName(request.getParameter("coName"));
				stu2.setInternship(request.getParameter("internship"));
				stu2.setWorkAddress(request.getParameter("workAddress"));
				stu2.setEmpStatus(request.getParameter("empStatus"));
				stu2.setEmpInsurance(request.getParameter("empInsurance"));
				stu2.setEmpperiod(request.getParameter("empperiod"));
				stu2.setEmpRoute(request.getParameter("empRoute"));
				stu2.setRelation(request.getParameter("relation"));
				stu2.setPosition(request.getParameter("position"));
				stu2.setDecidedDate(request.getParameter("decidedDate"));
				
				// 1人分の就職データを更新
				boo = scl.updataEmpdata(stu2);
				
				// 更新後の就職データを取得
				dataArray = scl.getEmpData();
				
				// 更新後の就職データ情報をリクエストスコープに保存
				  request.setAttribute("dataArray", dataArray);
				
				// 更新が成功したら訓練生情報管理画面(stuManagement)へフォワード
				dispatcher = request.getRequestDispatcher("WEB-INF/jsp/stuManagement.jsp");
				dispatcher.forward(request, response);
				break;
			
		}
	
		

	}

}
