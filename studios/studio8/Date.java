package studio8;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Date {
	
	final private int month, day, year;
	final private boolean holiday;
	
	public Date(int month, int day, int year, boolean holiday) {
		this.month = month;
		this.day = day;
		this.year = year;
		this.holiday = holiday;
	}
	
	public boolean isEarlierThan(Date other) {
		if (this.year > other.year) return false;
		else if (this.year < other.year) return true;
		else {
			if (this.month > other.month) return false;
			else if (this.month < other.month) return true;
			else {
				if (this.day >= other.day) return false;
				else return true;
			}
		}
	}
	
	public String toString() {
		if (this.holiday == true) return month + "/" + day + "/" + year + "(*)";
		else return month + "/" + day + "/" + year;
	}
	
	public int hashCode() {
		return (10000 * year) + (100 * month) + day;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	public static void main(String[] args) {
		Date test1 = new Date(1, 30, 2016, true);
		Date test2 = new Date(12, 10, 2018, false);
		Date test3 = new Date(1, 30, 2018, false);
		Date test4 = new Date(6, 17, 2014, false);
		Date test5 = new Date(8, 8, 1995, true);
		
		System.out.println(test1);
		System.out.println(test2);
		System.out.println(test3);
		System.out.println(test1.equals(test3));
		System.out.println();
		
		System.out.println(test1.isEarlierThan(test2));
		System.out.println(test3.isEarlierThan(test4));
		System.out.println();
		
		List<Date> list = new LinkedList<Date>();
		list.add(test1);
		list.add(test2);
		list.add(test3);
		list.add(test4);
		list.add(test5);
		list.add(test2);
		list.add(test1);
		
		System.out.println(list);
		System.out.println();
		
		Set<Date> set = new HashSet<Date>();
		set.add(test1);
		set.add(test2);
		set.add(test3);
		set.add(test4);
		set.add(test5);
		set.add(test2);
		set.add(test1);
		
		System.out.println(set);
	}

}
