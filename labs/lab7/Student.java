package lab7;

public class Student {

	private String firstName, lastName;
	private int studentID, credits;
	private double gpa;
	
	public Student(String firstName, String lastName, int studentID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentID = studentID;
		this.credits = 0;
		this.gpa = 0.0;
	}

	public String getName() {
		return this.firstName + " " + this.lastName;
	}

	public int getStudentID() {
		return studentID;
	}

	public int getCredits() {
		return credits;
	}

	public double getGPA() {
		return gpa;
	}
	
	public String getClassStanding() {
		if (this.credits < 30) return "Freshman";
		else if (this.credits < 60) return "Sophomore";
		else if (this.credits < 90) return "Junior";
		else return "Senior";
	}
	
	public double submitGrade(double g, int c) {
		double qScore = g * c;
		double totalScore = (this.gpa * this.credits) + qScore;
		
		this.credits = this.credits + c;
		this.gpa = Math.round(1000.0 * totalScore / this.credits) / 1000.0;
		
		return this.gpa;
	}
	
	public Student createLegacy(Student a) {
		Student legacy = new Student(getName(), a.getName(), getStudentID() + a.getStudentID());
		legacy.gpa = (getGPA() + a.getGPA()) / 2;
		
		legacy.credits = Math.max(getCredits(), a.getCredits());
		
		return legacy;
	}
	
	public String toString() {
		return getName() + " " + getStudentID();
	}
	
}
