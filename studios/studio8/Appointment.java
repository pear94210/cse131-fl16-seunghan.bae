package studio8;

public class Appointment {

	private Date date;
	private Time time;
	
	public Appointment(Date date, Time time) {
		this.date = date;
		this.time = time;
	}

	public int hashCode() {
		return (10000 * this.date.hashCode()) + this.time.hashCode();
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}
	
	public String toString() {
		return "Appointment [date=" + date + ", time=" + time + "]";
	}

	public static void main(String[] args) {
		Date date1 = new Date(1, 30, 2016, true);
		Date date2 = new Date(12, 10, 2018, false);
		Date date3 = new Date(1, 30, 2018, false);
		
		Time time1 = new Time(23, 30, true);
		Time time2 = new Time(17, 59, false);
		Time time3 = new Time(23, 30, false);
		
		Appointment test1 = new Appointment(date1, time1);
		Appointment test2 = new Appointment(date2, time2);
		Appointment test3 = new Appointment(date3, time3);
		
		System.out.println(test1);
		System.out.println(test2);
		System.out.println(test3);
	}
	
}
