package com.jin.payment;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.jin.payment.dao.DbUtil;
import com.jin.payment.dao.PaymentObjectDao;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

		PaymentObjectDao dao = PaymentObjectDao.getInstance();
	   
	   @Test
	   public void testInsert1000PaymentObjects() throws SQLException {
		   Connection conn = DbUtil.getConnection();
		   dao.createTable(conn);
		   List<PaymentObject> payments = App.generatePayments(1000);
		   dao.batchSave(conn, payments);
		   DbUtil.close(conn);
	   }
	   
	   @Test
	   public void testQueryByDateRange() throws SQLException {
		   Connection conn = DbUtil.getConnection();
		   Date begin = new Date(0);
		   Date end = new Date(1990,1,1);
		   
		   List<PaymentObject> results = PaymentObjectDao.getInstance().queryByDateRange(conn, begin, end);
		   System.out.println("" + results.size() + " records are returned.");
		   DbUtil.close(conn);
	   }
	   
	   @Test
	   public void testSort1() {
		   List<PaymentObject> payments = App.generatePayments(10000);
		   long start = System.currentTimeMillis();
		   Comparable[] array = SortUtil.toArray(payments);
		   MergeSort.sort(array);
		   long elapsed = System.currentTimeMillis() - start;
		   System.out.println("Merge sort takes " + elapsed + " milliseconds");
		   assertTrue(SortUtil.isSorted(array));
	   }	

	   @Test
	   public void testSort2() {
		   List<PaymentObject> payments = App.generatePayments(10000);
		   long start = System.currentTimeMillis();
		   Comparable[] array = SortUtil.toArray(payments);
		   QuickSort.sort(array);
		   long elapsed = System.currentTimeMillis() - start;
		   System.out.println("Quick sort takes " + elapsed + " milliseconds");
		   assertTrue(SortUtil.isSorted(array));
	   }	
}
