package exercises8;

import java.util.HashSet;
import java.util.Set;

public class StockHolding implements Valuable{

	final private String name, owner;
	private int numShare, priceShare;
	
	public StockHolding(String name, String owner, int priceShare) {
		this.name = name;
		this.owner = owner;
		this.numShare = 0;
		this.priceShare = priceShare;
	}
	
	public int getNumShare() {
		return numShare;
	}

	public void setNumShare(int numShare) {
		this.numShare = numShare;
	}

	public int getPriceShare() {
		return priceShare;
	}

	public void setPriceShare(int priceShare) {
		this.priceShare = priceShare;
	}

	public String getName() {
		return name;
	}

	public String getOwner() {
		return owner;
	}
	
	public int getCurrentValue() {
		return (int)(this.getPriceShare() * this.getNumShare());
	}

	@Override
	public String toString() {
		return "StockHolding [name=" + name + ", owner=" + owner + ", numShare=" + numShare + ", priceShare="
				+ priceShare + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockHolding other = (StockHolding) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		
		Set<StockHolding> set = new HashSet<StockHolding>();
		
		StockHolding s1 = new StockHolding("IBM", "Ron", 10);
		s1.setNumShare(100);
		set.add(s1);
		s1.setNumShare(200);
		set.add(s1);
		System.out.println(set);
		
		StockHolding s2 = new StockHolding("IBM", "Jane", 3);
		set.add(s2);
		System.out.println(set);
		
	}

	@Override
	public int getLiquidValue() {
		return this.getCurrentValue();
	}
	
}
