package model;

import dao.StudentDAO;
import model.bean.StudentBean;

// 訓練生の情報に関する処理
public class StuInfoLogic {
	
	// 訓練生情報取得（1人分）
	public StudentBean execute(StudentBean stu) {
		StudentDAO dao = new StudentDAO();
		StudentBean stu1 = dao.findStudent(stu);
		return stu1;
	}
}
