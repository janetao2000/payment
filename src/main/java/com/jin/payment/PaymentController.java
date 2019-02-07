package com.jin.payment;

import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jin.payment.dao.DbUtil;
import com.jin.payment.dao.PaymentObjectDao;

@RestController
public class PaymentController {

    @RequestMapping("/queryByDateRange")
    public List<PaymentObject> queryByDateRange(@RequestParam @DateTimeFormat(pattern="yyyyMMdd") Date begin,
    		@RequestParam @DateTimeFormat(pattern="yyyyMMdd") Date end) {
    	List<PaymentObject> results;
    	Connection conn = null;
		try {
			conn = DbUtil.getConnection();
			results = PaymentObjectDao.getInstance().queryByDateRange(conn, new java.sql.Date(begin.getTime()), new java.sql.Date(end.getTime()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				DbUtil.close(conn);
			}
		}
    	return results;
    }
	
}
