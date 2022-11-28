package model;

import java.util.ArrayList;
import java.util.List;

import dao.StudentDAO;
import model.bean.StudentBean;

// 訓練生の情報に関する処理
public class StuInfoLogic {
	
	// 訓練生情報取得（1人分）
	public StudentBean findAccount(StudentBean stu) {
		StudentDAO dao = new StudentDAO();
		StudentBean stu1 = dao.findStudent(stu);
		return stu1;
	}
	
	// 訓練生情報取得（全員）
	public List<StudentBean> findAccount() {
		List<StudentBean> stuList = new ArrayList<StudentBean>();
		StudentDAO dao = new StudentDAO();
		stuList = dao.findStudent();
		return stuList;
	}
}
