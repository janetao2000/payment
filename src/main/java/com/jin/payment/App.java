package com.jin.payment;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App 
{
	public static List<PaymentObject> generatePayments(int n){
		List<PaymentObject> results = new ArrayList<>();
		Date begin = new Date(0);
		Calendar cal = Calendar.getInstance();
		for (int i = 0; i<n; i++) {
			cal.setTime(begin);
			double rand = Math.random() * 50 * n;
			cal.add(Calendar.DATE, (int) rand);
			PaymentObject po = new PaymentObject(i, rand, new Date(cal.getTime().getTime()));
			results.add(po);
		}
		return results;
	}
	
	
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
