package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.StudentCsvBean;

public class EmploymentDataDAO {
	// データベース接続に使用する情報
		private static String RDB_DRIVE = "com.mysql.cj.jdbc.Driver";
		private final static String URL = "jdbc:mysql://localhost/sample";
		private final static String USER = "root";
		private final String PASS = "";
		
	// 就職データ情報取得
	public StudentCsvBean[] getEmpData() {
		StudentCsvBean[] sEmpData = new StudentCsvBean[20];
		Connection con = null;
		
		try {
			// Class.forName()メソッドにJDBCドライバ名を与えJDBCドライバをロード
			Class.forName(RDB_DRIVE);
	
			// 接続先の情報。引数:「JDMC接続先情報」,「ユーザー名」,「パスワード」
			con = DriverManager.getConnection(URL, USER, PASS);
			
			// SELECT文を準備
			String sql = "SELECT * FROM employmentdata";
			PreparedStatement pStmt = con.prepareStatement(sql);
			
			// SELECT文を実行し、結果票を取得
			ResultSet rs = pStmt.executeQuery();
			
			// 結果表からデータを取得しリストに格納
			while (rs.next()) {
				int i = 0;
				// 結果票からデータを取得
				String id = rs.getString("id");
				String category = rs.getString("category");
				String name = rs.getString("name");
				String jurisdiction = rs.getString("newGrad");
				String newGrad = rs.getString("id");
				String apply = rs.getString("apply");
				String jobCard = rs.getString("jobCard");
				String pref = rs.getString("pref");
				String coName = rs.getString("coName");
				String internship = rs.getString("internship");
				String workAddress = rs.getString("workAddress");
				String empStatus = rs.getString("empStatus");
				String empInsurance = rs.getString("empInsurance");
				String empperiod = rs.getString("empperiod");
				String empRoute = rs.getString("empRoute");
				String relation = rs.getString("relation");
				String position = rs.getString("position");
				String decidedDate = rs.getString("decidedDate");
				// 結果表からのデータをもとに、1人分の就職データを持つインスタンスを生成して、配列に追加
				StudentCsvBean stu = new StudentCsvBean(id, category, name, jurisdiction, newGrad, apply, jobCard, pref,  coName, internship, workAddress, empStatus, empInsurance, empperiod, empRoute, relation, position, decidedDate);
				sEmpData[i++] = stu;
			}
			// forName()で例外発生
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("no1");

			// getConnection()で例外発生
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("no2");

		} finally {
			try {
				if (con != null) {
					// データベースを切断
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sEmpData;
	}
}
