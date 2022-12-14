package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StuCsvLogic;
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
		
		//
		StuCsvLogic scl = new StuCsvLogic();
		StudentCsvBean[] dataArray = new StudentCsvBean[20];
		
		dataArray = scl.csvReader();
		
		Integer number = 0;
		  for(int n = 1; n < dataArray.length; n++) {
			  if(dataArray[n].getId() == null) {
				  continue;
			  }
			  number++;
		  }
		  // 
		  System.out.println(number);
		  
		  request.setAttribute("count", number);
		  request.setAttribute("dataArray", dataArray);

		// リクエストパラメータの取得
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");
			
			if(id != null) {
				// editSelectStu.jspへフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/editSelectStu.jsp");
				dispatcher.forward(request, response);
			}
		

		// stuManagement.jspへフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/stuManagement.jsp");
			dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StuCsvLogic scl = new StuCsvLogic();
		StudentCsvBean[] dataArray = new StudentCsvBean[20];
		StudentCsvBean stu = new StudentCsvBean();
		
		// CSVファイル読み込み
		dataArray = scl.csvReader();
		

		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String btn = request.getParameter("btn");
		
		System.out.println(btn);
		
		switch (btn) {
			case "update":
				
				break;
			
			case "edit":
				String id = request.getParameter("id");
				int no = Integer.parseInt(id);
				
				//
				System.out.println(id);
				// 選択した生徒をリクエストスコープに保存
				stu = dataArray[no];
				request.setAttribute("stu", stu);
								
				// stuManagement.jspへフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/editStuCsv.jsp");
				dispatcher.forward(request, response);
				break;
		}
		

	}

}
