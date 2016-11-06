package lab7;

public class Course {
	
	private String name;
	private int credits, numSeats;
	private Student[] roster;
	
	public Course(String name, int credits, int numSeats) {
		this.name = name;
		this.credits = credits;
		this.numSeats = numSeats;
		this.roster = new Student[numSeats];
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCredits() {
		return this.credits;
	}
	
	public int getRemainingSeats() {
		return this.numSeats;
	}
	
	public boolean addStudent(Student a) {
		if (getRemainingSeats() <= 0) return false;
		else {
			int already = this.roster.length;
			
			for (int i = 0; i < this.roster.length; i++) {
				if (this.roster[i] == a) already--;
			}
			
			if (already != this.roster.length) return false;
			else {
				this.roster[this.roster.length - getRemainingSeats()] = a;
				this.numSeats--;
				return true;
			}
		}
	}
	
	public double averageGPA() {
		double totalGPA = 0.0;
		
		for (int i = 0; i < this.roster.length - getRemainingSeats(); i++) {
			totalGPA = totalGPA + this.roster[i].getGPA();
		}
		
		return totalGPA / (this.roster.length - getRemainingSeats());
	}
	
	public String toString() {
		return getName() + " " + getCredits();
	}
	
}
