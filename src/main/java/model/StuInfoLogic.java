package model;

import java.util.ArrayList;
import java.util.List;

import dao.StudentDAO;
import model.bean.StudentBean;

// 訓練生の情報に関する処理
public class StuInfoLogic {
	StudentDAO dao = new StudentDAO();
	boolean boo;
	
	// 訓練生情報取得（1人分）
	public StudentBean findAccount(StudentBean stu) {
		StudentBean stu1 = dao.findStudent(stu);
		return stu1;
	}
	
	// 訓練生情報取得（全員）
	public List<StudentBean> findAccount() {
		List<StudentBean> stuList = new ArrayList<StudentBean>();
		stuList = dao.findStudent();
		return stuList;
	}
	
	// 訓練生情報更新
	public boolean updateStudent(StudentBean stu) {
		boo = dao.updateStudent(stu);
		return boo;
	}

	public boolean insertStudent(StudentBean stu) {
		boo = dao.insertStudent(stu);
		return boo;
	}
}
