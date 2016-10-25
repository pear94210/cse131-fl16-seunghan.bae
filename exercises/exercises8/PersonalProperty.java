package exercises8;

public class PersonalProperty implements Valuable{

	final private int initialValue, yearsOld;

	public PersonalProperty(int initialValue, int yearsOld) {
		this.initialValue = initialValue;
		this.yearsOld = yearsOld;
	}

	public int getInitialValue() {
		return initialValue;
	}

	public int getYearsOld() {
		return yearsOld;
	}
	
	public int depreciatedValue() {
		return (int)(this.initialValue * Math.pow(0.8, this.yearsOld));
	}

	@Override
	public String toString() {
		return "PersonalProperty [initialValue=" + initialValue + ", yearsOld=" + yearsOld + "]";
	}
	
	public int getLiquidValue() {
		return this.depreciatedValue();
	}
			
}
