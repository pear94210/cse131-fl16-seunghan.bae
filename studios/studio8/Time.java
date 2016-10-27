package studio8;

public class Time {
	
	final private int hour, minute;
	final private boolean twelveHour;
		
	public Time(int hour, int minute, boolean twelveHour) {
		this.hour = hour;
		this.minute = minute;
		this.twelveHour = twelveHour;
	}
	
	public boolean isEarlierThan(Time other) {
		if (this.hour > other.hour) return false;
		else if (this.hour < other.hour) return true;
		else {
			if (this.minute >= other.minute) return false;
			else return true;
		}
	}
	
	public String toString() {
		if (this.twelveHour == true) {
			if (this.hour > 12) return (hour - 12) + ":" + minute + "PM";
			else return hour + ":" + minute + "AM";
		}
		else return hour + ":" + minute;
	}
	
	public int hashCode() {
		return (100 * hour) + minute;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (hour != other.hour)
			return false;
		if (minute != other.minute)
			return false;
		return true;
	}

	public static void main(String[] args) {
		Time test1 = new Time(23, 30, true);
		Time test2 = new Time(17, 59, false);
		Time test3 = new Time(23, 30, false);
		
		System.out.println(test1);
		System.out.println(test2);
		System.out.println(test3);
		System.out.println(test1.equals(test3));
		System.out.println();
		
		System.out.println(test2.isEarlierThan(test1));
		System.out.println(test3.isEarlierThan(test1));
		System.out.println();
	}

}
