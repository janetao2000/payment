package com.jin.payment.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jin.payment.PaymentObject;

public class PaymentObjectDao {
	private static PaymentObjectDao _instance = new PaymentObjectDao();
	private PaymentObjectDao() {}
	public static PaymentObjectDao getInstance() {
		return _instance;
	}
	
	public void createTable(Connection conn) throws SQLException {
		// Creating a statement.
		Statement stmt = conn.createStatement();

		// Executing a statement and receiving Resultset.
		String sql = "CREATE TABLE payment_object (payment_number INTEGER not NULL, amount double, date datetime)";
		stmt.executeUpdate(sql);
	}
	
	public void batchSave(Connection conn, List<PaymentObject> payments) throws SQLException {
		String sql = "INSERT INTO payment_object VALUES (?,?,?)";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);

		for (PaymentObject po: payments) {
			preparedStatement.setInt(1, po.getPaymentNumber());
			preparedStatement.setDouble(2, po.getAmount());
			preparedStatement.setDate(3, po.getDate());
			preparedStatement.addBatch();			
		}
		preparedStatement.executeBatch();
		
	}
	
	public List<PaymentObject> queryByDateRange(Connection conn, Date begin, Date end) throws SQLException{
		String sql = "select * from payment_object where date between ? and ?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setDate(1, begin);
		preparedStatement.setDate(2, end);
		ResultSet rs = preparedStatement.executeQuery();
		List<PaymentObject> results = new ArrayList<>();
		while (rs.next()) {
			results.add(new PaymentObject(rs.getInt(1), rs.getDouble(2), rs.getDate(3)));
		}
		return results;
	}
}
