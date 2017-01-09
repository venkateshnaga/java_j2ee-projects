package com.employee.servlet;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class Date 
{

	public static void main(String[] args) 
	{
		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(1993, Month.JANUARY, 1);
		 
		Period period = Period.between(birthday, today);
		 
		//Now access the values as below
		System.out.println(period.getDays());
		System.out.println(period.getMonths());
		System.out.println(period.getYears());
	}
}
