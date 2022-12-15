package model;

import dao.EmploymentDataDAO;
import model.bean.StudentCsvBean;

public class StuEmpLogic {
	EmploymentDataDAO dao = new EmploymentDataDAO();
	StudentCsvBean scb = new StudentCsvBean();
	boolean boo;
	
	// 就職データ取得（全員分）
	public StudentCsvBean[] getEmpData() {
		StudentCsvBean[] dataArray = new StudentCsvBean[20];
		dataArray = dao.getEmpData();
		return dataArray;
	}

	// 就職データ更新（1人分）
	public boolean updataEmpdata(StudentCsvBean stu2) {
		boo = dao.updataEmpdata(stu2);
		return boo;
	}
	
	
	
}
