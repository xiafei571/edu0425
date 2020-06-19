package edu0425.spring.demo;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		// Date 类
		Date date = new Date();
		DateFormat df = DateFormat.getInstance();
		System.out.println(df.format(date));

		// Calendar类
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);

		int year = c.get(Calendar.YEAR);
		System.out.println(year);

		// *月份从0开始的
		int month = c.get(Calendar.MONTH);
		System.out.println(month);

		// 某一年的二月有多少天
		System.out.println("2019:" + getDaysofFeb(2019));
		System.out.println("2020:" + getDaysofFeb(2020));

		System.out.println("SAT:" + c.get(Calendar.DAY_OF_WEEK));
		c.add(Calendar.DAY_OF_MONTH, 1);
		System.out.println("SUN:" + c.get(Calendar.DAY_OF_WEEK));
		// SUN:1 , SAT:7
		// (c.Month == 4 || c.Month == 9) && c.DAY_OF_MONTH == 1
		// c.DAY_OF_WEEK == 1 || c.DAY_OF_WEEK == 7
		// c.add(Calendar.DAY_OF_Year, 1);

		System.out.println(getFinshDate(300));
	}

	private static int getDaysofFeb(int year) {
		Calendar c = Calendar.getInstance();
		// 设置成3月1日(月份从0开始的)
		c.set(year, 2, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		return c.get(Calendar.DAY_OF_MONTH);
	}

	private static String getFinshDate(int days) {
		// 每周末休息，五一、十一各休一天，计算哪天完成
		Calendar c = Calendar.getInstance();
		int i = 0;
		while (i < days) {
			c.add(Calendar.DAY_OF_YEAR, 1);
			
			if(c.get(Calendar.DAY_OF_WEEK)==1) {// sun
				continue;
			}else if(c.get(Calendar.DAY_OF_WEEK)==7) {// sat
				continue;
			}else if(c.get(Calendar.DAY_OF_MONTH)==1) {//5-1 or 10-1
				if(c.get(Calendar.MONTH)==4||c.get(Calendar.MONTH)==9) {
					continue;
				}else{
					i++;
				}
			}else {
				i++;
			}
		}

		Date date = c.getTime();
		return date.toString();
	}

}
