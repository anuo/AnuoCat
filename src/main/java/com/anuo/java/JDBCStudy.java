package com.anuo.java;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCStudy {
	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		CallableStatement cs = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "testdb", "qaz00");
			st = conn.createStatement();
			// 查询
			rs = st.executeQuery("select * from userlogin");
			while (rs.next()) {
				System.out.println(rs.getString("username"));
				System.out.println(rs.getString("password"));
			}
			// PreparedStatement
			PreparedStatement ps = conn
					.prepareStatement("insert into userlogin values(?,?,?)");
			ps.setInt(1, 1);
			ps.setString(2, "eclipse");
			ps.setString(3, "123");
			ps.execute();
			// Pro
			cs = conn.prepareCall("{ call CalName(?) }");
			cs.setInt(1, 0);
			cs.execute();
			// Transaction
			conn.setAutoCommit(false);
			// st=conn.createStatement();
			// googlecode
			st.addBatch("insert into userlogin values('4','tOne','tOneP')");
			st.addBatch("insert into userlogin values('5','tTwo','tTwoP')");
			st.executeBatch();
			conn.commit();
			// eclipsecode
			conn.setAutoCommit(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				if (conn != null) {
					conn.rollback();
					conn.setAutoCommit(true);
				}
			} catch (SQLException el) {
				el.printStackTrace();
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (st != null) {
					st.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (cs != null) {
					cs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
}
