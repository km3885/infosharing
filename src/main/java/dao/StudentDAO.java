package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.StudentBean;

public class StudentDAO {

	// データベース接続に使用する情報
	private static String RDB_DRIVE = "com.mysql.cj.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost/sample";
	private final static String USER = "root";
	private final String PASS = "";

	// 訓練生情報取得(1人)
	public StudentBean findStudent(StudentBean stu) {
		StudentBean stu1 = null;
		// SELECT文を準備
		String sql = "SELECT * FROM students WHERE id = ?";

		// データベースへ接続
		try (
				Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pStmt = con.prepareStatement(sql);) {
			Class.forName(RDB_DRIVE);
			System.out.println("no1");
			pStmt.setInt(1, stu.getId());

			// SELECT文を実行し、結果票を取得
			ResultSet rs = pStmt.executeQuery();

			// 一致したstudentが存在した場合
			// そのユーザを表すStudentBeanインスタンスを生成
			if (rs.next()) {
				// 結果票からデータを取得
				int id = rs.getInt("id");
				String no = rs.getString("no");
				String name = rs.getString("name");
				String state = rs.getString("state");
				String coName = rs.getString("co_name");
				stu1 = new StudentBean(id, no, name, state, coName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			System.out.println("JDBCデータベース接続エラー:" + e);
		}
		// 見つかったユーザまたはnullを返す
		return stu1;
	}
	
	// 訓練生情報取得(全員分)
	public List<StudentBean> findStudent() {
		List<StudentBean> stuList = new ArrayList<StudentBean>();

		Connection con = null;

		try {
			// Class.forName()メソッドにJDBCドライバ名を与えJDBCドライバをロード
			Class.forName(RDB_DRIVE);

			// 接続先の情報。引数:「JDMC接続先情報」,「ユーザー名」,「パスワード」
			con = DriverManager.getConnection(URL, USER, PASS);

			System.out.println("接続成功");

			// SELECT文を準備
			String sql = "SELECT * FROM students";
			PreparedStatement pStmt = con.prepareStatement(sql);

			// SELECT文を実行し、結果票を取得
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				// 結果票からデータを取得
				int id = rs.getInt("id");
				String no = rs.getString("no");
				String name = rs.getString("name");
				String state = rs.getString("state");
				String coName = rs.getString("co_name");
				StudentBean stu = new StudentBean(id, no, name, state, coName);
				stuList.add(stu);
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
		return stuList;
	}
	
	// 訓練生情報更新
	public boolean updateStudent(StudentBean stu) {
		boolean boo = false;
		Connection con = null;
		
		try {
			// Class.forName()メソッドにJDBCドライバ名を与えJDBCドライバをロード
			Class.forName(RDB_DRIVE);

			// 接続先の情報。引数:「JDMC接続先情報」,「ユーザー名」,「パスワード」
			con = DriverManager.getConnection(URL, USER, PASS);

			System.out.println("接続成功");

			// UPDATE文を準備
			String sql = "UPDATE students SET name = ?, state = ?, co_name = ? WHERE id = ?";
			PreparedStatement pStmt = con.prepareStatement(sql);
			
			pStmt.setString(1, stu.getName());
			pStmt.setString(2, stu.getstate());
			pStmt.setString(3, stu.getCoName());
			
			pStmt.setInt(4, stu.getId());

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
		return boo;
	}
	
}
