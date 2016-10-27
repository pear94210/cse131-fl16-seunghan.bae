package studio8;

import java.util.LinkedList;
import java.util.List;

public class Calendar {
	
	public static void main(String[] args) {
		List<Appointment> calendar = new LinkedList<Appointment>();
		
		Date date1 = new Date(1, 30, 2016, true);
		Date date2 = new Date(12, 10, 2018, false);
		Date date3 = new Date(1, 30, 2018, false);
		
		Time time1 = new Time(23, 30, true);
		Time time2 = new Time(17, 59, false);
		Time time3 = new Time(23, 30, false);
		
		Appointment test1 = new Appointment(date1, time1);
		Appointment test2 = new Appointment(date2, time2);
		Appointment test3 = new Appointment(date3, time3);
		
		calendar.add(test1);
		calendar.add(test2);
		calendar.add(test3);
		
		System.out.println(calendar);
	}

}
