package model;

import java.util.ArrayList;
import java.util.List;

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
	
	// 就職データ取得（全員分）
		public List<StudentCsvBean> getEmpDataList() {
			List<StudentCsvBean> sEmpDataList = new ArrayList<>();
			sEmpDataList = dao.getEmpDataList();
			return sEmpDataList;
		}
	
	
}
