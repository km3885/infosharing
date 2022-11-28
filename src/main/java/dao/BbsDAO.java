package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.BbsBean;

public class BbsDAO {
	public List<BbsBean> findcomment() throws ClassNotFoundException {

        // name,commentを格納するリスト
        List<BbsBean> list = new ArrayList<>();

    	// データベース接続に使用する情報
    	String RDB_DRIVE = "com.mysql.cj.jdbc.Driver";
    	final String URL = "jdbc:mysql://localhost/sample";
    	final String USER = "root";
    	final String PASS = "";

        try {

        	Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASS);

            System.out.println("Connected....");

            try {
            	PreparedStatement pStmt = (PreparedStatement) con.createStatement();
                String sql = "select * from bbs";

                try {
                    // sqlを送信
                    ResultSet rs = pStmt.findAccountQuery(sql);

                    while (rs.next()) {
                        // DBから取り出したuser_name,comment timeをBbsBeanにset
                        BbsBean bo = new BbsBean();
                        bo.setUserName(rs.getString("user_name"));
                        bo.setComment(rs.getString("comment"));
                        bo.setTime(rs.getTimestamp("time"));

                        // リストに1個ずつ格納。末尾に要素が追加されていく。
                        list.add(bo);
                    }

                    rs.close();
                    pStmt.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // データベース接続の切断
                if (con != null) {
                    try {
                        con.close();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Failed.");
            return null;
        }
        return list;

    }
}
