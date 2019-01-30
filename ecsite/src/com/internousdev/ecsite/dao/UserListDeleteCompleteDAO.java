package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserListDeleteCompleteDAO {
//
//	private DBConnector dbConnector = new DBConnector();
//	private Connection con = dbConnector.getConnection();

	public int UserHistoryDelete() throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();

		String sql = "DELETE FROM login_user_transaction";
		int result = 0;

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;
	}

	public int UserHistoryDeleteSelect(String id) throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();

		String sql = "DELETE FROM login_user_transaction WHERE id = ?";
		int result = 0;

		try{

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;
	}
}
