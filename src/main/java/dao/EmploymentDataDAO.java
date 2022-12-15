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
			int i = 0;
			while (rs.next()) {
				// 結果票からデータを取得
				String id = rs.getString("id");
				String category = rs.getString("category");
				String name = rs.getString("name");
				String jurisdiction = rs.getString("jurisdiction");
				String newGrad = rs.getString("newGrad");
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
				System.out.println(stu.getId());
				System.out.println(i);
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

	// 就職データ更新（1人分）
	public boolean updataEmpdata(StudentCsvBean stu2) {
		boolean boo = false;
		Connection con = null;
		
		try {
			// Class.forName()メソッドにJDBCドライバ名を与えJDBCドライバをロード
			Class.forName(RDB_DRIVE);

			// 接続先の情報。引数:「JDMC接続先情報」,「ユーザー名」,「パスワード」
			con = DriverManager.getConnection(URL, USER, PASS);

			System.out.println("接続成功");

			// UPDATE文を準備
			String sql = "UPDATE employmentdata SET id=?, category=?, name=?, jurisdiction=?, newGrad=?, apply=?, jobCard=?, pref=?, coName=?, internship=?, workAddress=?, empStatus=?, empInsurance=?, empperiod=?, empRoute=?, relation=?, position=?, decidedDate=? WHERE id = ?";
			PreparedStatement pStmt = con.prepareStatement(sql);
			
			// sql分に値をセット
			pStmt.setString(1, stu2.getId());
			pStmt.setString(2, stu2.getCategory());
			pStmt.setString(3, stu2.getName());
			pStmt.setString(4, stu2.getJurisdiction());
			pStmt.setString(5, stu2.getNewGrad());
			pStmt.setString(6, stu2.getApply());
			pStmt.setString(7, stu2.getJobCard());
			pStmt.setString(8, stu2.getPref());
			pStmt.setString(9, stu2.getCoName());
			pStmt.setString(10, stu2.getInternship());
			pStmt.setString(11, stu2.getWorkAddress());
			pStmt.setString(12, stu2.getEmpStatus());
			pStmt.setString(13, stu2.getEmpInsurance());
			pStmt.setString(14, stu2.getEmpperiod());
			pStmt.setString(15, stu2.getEmpRoute());
			pStmt.setString(16, stu2.getRelation());
			pStmt.setString(17, stu2.getPosition());
			pStmt.setString(18, stu2.getDecidedDate());
			pStmt.setString(19, stu2.getId());

			// UPDATE文を実行し、結果票を取得
			int result = pStmt.executeUpdate();
			//
			System.out.print(result);
			
			if(result == 1) {
				boo = true;
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
		System.out.println(boo);
		return boo;
	}
}
