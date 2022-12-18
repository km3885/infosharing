package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StuEmpLogic;
import model.bean.StudentCsvBean;

/**
 * Servlet implementation class FileManagement
 */
@WebServlet("/FileMgmtServlet")
public class FileMgmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileMgmtServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 宣言・初期化
		List<StudentCsvBean> sEmpDataList = new ArrayList<>();
		StuEmpLogic scl = new StuEmpLogic();
		String value = null;
		int stuId;
		
		// ヘッダ情報リスト
		List<String> headerList = new ArrayList<String>(Arrays.asList("入力", "科名", "氏名", "管轄", "新卒", "適用", "ジョブカード", "希望地", "就職先", "実習先", "勤務地住所", "雇用形態", "雇用保険", "雇用期間", "就職経路", "関連", "職種","内定日"));
		// 就職データ情報取得
		sEmpDataList = scl.getEmpDataList();
		// 就職データ情報リスト
		
		
//		for (int i = 0; i < dataArray.length && dataArray[i].getId() == 0; i++) {
//			List<String>  = new ArrayList<>();
//		}
//		
	
		
		String filename = "sample.csv";
        response.setHeader("Content-Type", "text/csv; charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=\""+filename+"\"");
        
    	
    	
    	
        PrintWriter out = response.getWriter();
        out.write(0xFEFF);
//        out.println(headerList);
        
        for(String header: headerList) {
    		out.print(header);
    		out.print(",");
    	}
        out.print("\n");
    	
        for(StudentCsvBean sEmpData: sEmpDataList) {
    		out.print(sEmpData.getId() + ",");
    		out.print(sEmpData.getCategory() + ",");
    		out.print(sEmpData.getName() + ",");
    		out.print(sEmpData.getJurisdiction() + ",");
    		out.print(sEmpData.getNewGrad() + ",");
    		out.print(sEmpData.getApply() + ",");
    		out.print(sEmpData.getJobCard() + ",");
    		out.print(sEmpData.getPref() + ",");
    		out.print(sEmpData.getCoName() + ",");
    		out.print(sEmpData.getInternship() + ",");
    		out.print(sEmpData.getWorkAddress() + ",");
    		out.print(sEmpData.getEmpStatus() + ",");
    		out.print(sEmpData.getEmpInsurance() + ",");
    		out.print(sEmpData.getEmpperiod() + ",");
    		out.print(sEmpData.getEmpRoute() + ",");
    		out.print(sEmpData.getRelation() + ",");
    		out.print(sEmpData.getPosition() + ",");
    		out.println(sEmpData.getDecidedDate());
    	}
        out.print("\n");

    	out.print("exit");
    	out.flush();
        
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
