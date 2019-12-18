/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.bean;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class CalendarBean {
	Date date = new Date();
	SimpleDateFormat yearDateFormat = new SimpleDateFormat("yyyy");
	SimpleDateFormat monthDateFormat = new SimpleDateFormat("MM");
	SimpleDateFormat dayDateFormat = new SimpleDateFormat("dd");

	@Max(value = 2999, message = "*输入的年份不能大于2999")
	@Min(value = 1, message = "*输入的年份不能小于1")
	@NotNull(message = "年份不能为空")
	int year = Integer.parseInt(yearDateFormat.format(date));

	int month = Integer.parseInt(monthDateFormat.format(date));
	int day = Integer.parseInt(dayDateFormat.format(date));
	String calendar = null;

	public void setYear(int year) {
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getMonth() {
		return month;
	}

	public String getCalendar() {
		StringBuffer buffer = new StringBuffer();
		Calendar rili = Calendar.getInstance();
		rili.set(year, month - 1, 1); // 将日历翻到year年month月1日,注意0表示一月,
										// 依次类推,11表示12月。
		// 获取1日是星期几(get方法返回的值是1表示星期日,返回的值是7表示星期六):
		int 星期几 = rili.get(Calendar.DAY_OF_WEEK) - 1;
		int day = 0;
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			day = 31;
		}
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			day = 30;
		}
		if (month == 2) {
			if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
				day = 29;
			} else {
				day = 28;
			}
		}
		String a[] = new String[42];
		for (int i = 0; i < 星期几; i++) {
			a[i] = "**";
		}
		for (int i = 星期几, n = 1; i < 星期几 + day; i++) {
			a[i] = String.valueOf(n);
			n++;
		}
		for (int i = 星期几 + day/* , n = 1 */; i < 42; i++) {
			a[i] = "**";
		}
		// 用表格显示数组:
		buffer.append("<table border=1>");
		buffer.append("<tr>");
		String weekday[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		for (int k = 0; k < 7; k++) {
			buffer.append("<td>" + weekday[k] + "</td>");
		}
		buffer.append("</tr>");
		for (int k = 0; k < 42; k = k + 7) {
			buffer.append("<tr>");
			for (int j = k; j < Math.min(7 + k, 42); j++) {
				buffer.append("<td>" + a[j] + "</td>");
			}
			buffer.append("</tr>");
		}
		buffer.append("</table>");
		calendar = new String(buffer);
		return calendar;
	}
}
