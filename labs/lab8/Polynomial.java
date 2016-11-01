package lab8;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Polynomial {

	final private LinkedList<Double> list;

	/**
	 * Constructs a Polynomial with no terms yet.
	 */
	public Polynomial() {
		//
		// Set the instance variable (list) to be a new linked list of Double type
		//
		this.list = new LinkedList<Double>();
	}
	
	/**
	 * toString	
	 */
	public String toString() {
		String s = "";
		for (int i = 0; i < this.list.size(); i++) {
			if (this.list.get(i) != 0) {
				if (i == 0) s = s + " " + this.list.get(i);
				else if (i == 1) s = s + " " + this.list.get(i) + "x";
				else s = s + " " + this.list.get(i) + "x^" + i;
			}
		}
		
		return s;
	}
	
	/**
	 * adds a term to the polynomial
	 * @param coeff (constant for the term)
	 * @return polynomial with the term added
	 */
	public Polynomial addTerm(double coeff) {
		this.list.add(coeff);
		
		return this;  // required by lab spec
	}
	
	/**
	 * evaluate polynomial at point x
	 * @param x
	 * @return the value of polynomial at point x
	 */
	public double evaluate(double x) {
		double ans = 0.0;
		
		for (int i = 0; i < this.list.size(); i++) {
			ans = ans + (this.list.get(i) * Math.pow(x, i));
		}
		
		return ans;
	}
	
	/**
	 * get a derivative
	 * @return derivative of polynomial
	 */
	public Polynomial derivative() {
		Polynomial d = new Polynomial();
		
		for (int i = 1; i < this.list.size(); i++) {
			d.addTerm(this.list.get(i) * i);
		}
		
		return d;
	}
	
	/**
	 * sums the polynomial with another
	 * @param another (polynomial)
	 * @return the sum of the two polynomials
	 */
	public Polynomial sum(Polynomial another) {
		Polynomial sum = new Polynomial();
		
		if (this.list.size() <= another.list.size()) {
			for (int i = 0; i < this.list.size(); i++) {
				sum.addTerm(this.list.get(i) + another.list.get(i));
			}
			
			for (int j = this.list.size(); j < another.list.size(); j++) {
				sum.addTerm(another.list.get(j));
			}
		}
		else {
			for (int i = 0; i < another.list.size(); i++) {
				sum.addTerm(this.list.get(i) + another.list.get(i));
			}
			
			for (int j = another.list.size(); j < this.list.size(); j++) {
				sum.addTerm(this.list.get(j));
			}
		}
		
		return sum;
	}

	/**
	 * This is the "equals" method that is called by
	 *    assertEquals(...) from your JUnit test code.
	 *    It must be prepared to compare this Polynomial
	 *    with any other kind of Object (obj).  Eclipse
	 *    automatically generated the code for this method,
	 *    after I told it to use the contained list as the basis
	 *    of equality testing.  I have annotated the code to show
	 *    what is going on.
	 */

	public boolean equals(Object obj) {
		// If the two objects are exactly the same object,
		//    we are required to return true.  The == operator
		//    tests whether they are exactly the same object.
		if (this == obj)
			return true;
		// "this" object cannot be null (or we would have
		//    experienced a null-pointer exception by now), but
		//    obj can be null.  We are required to say the two
		//    objects are not the same if obj is null.
		if (obj == null)
			return false;

		//  The two objects must be Polynomials (or better) to
		//     allow meaningful comparison.
		if (!(obj instanceof Polynomial))
			return false;

		// View the obj reference now as the Polynomial we know
		//   it to be.  This works even if obj is a BetterPolynomial.
		Polynomial other = (Polynomial) obj;

		//
		// If we get here, we have two Polynomial objects,
		//   this and other,
		//   and neither is null.  Eclipse generated code
		//   to make sure that the Polynomial's list references
		//   are non-null, but we can prove they are not null
		//   because the constructor sets them to some object.
		//   I cleaned up that code to make this read better.


		// A LinkedList object is programmed to compare itself
		//   against any other LinkedList object by checking
		//   that the elements in each list agree.

		return this.list.equals(other.list);
	}

}
