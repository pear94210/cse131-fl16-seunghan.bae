package studio7;

public class Complex {
	
	private double real, imaginary;

	public Complex(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}
	
	/**
	 * 
	 * @return real part of complex
	 */
	public double getReal() {
		return this.real;
	}

	/**
	 * 
	 * @return imaginary part of complex
	 */
	public double getImaginary() {
		return this.imaginary;
	}
	
	/**
	 * 
	 * @param c (another complex)
	 * @return sum of complex and c
	 */
	public Complex sumComplex(Complex c) {
		double r = this.real + c.getReal();
		double i = this.imaginary + c.getImaginary();
		
		return new Complex(r, i);
	}
	
	/**
	 * 
	 * @param c (another complex)
	 * @return product of complex and c
	 */
	public Complex productComplex(Complex c) {
		double r = (this.real * c.getReal()) - (this.imaginary * c.getImaginary());
		double i = (this.real * c.getImaginary()) + (this.imaginary * c.getReal());
		
		return new Complex(r, i);
	}
	
}
