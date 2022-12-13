package model;

import dao.FileManagement;
import model.bean.StudentCsvBean;

public class StuCsvLogic {
	FileManagement fm = new FileManagement();
	StudentCsvBean scb = new StudentCsvBean();

	public StudentCsvBean[] csvReader() {
		StudentCsvBean[] dataArray = new StudentCsvBean[20];
		dataArray = fm.csvReader();
		return dataArray;
	}
	
}
