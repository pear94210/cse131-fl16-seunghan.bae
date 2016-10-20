package matrix;

public class Gaussian {
	
	Matrix coeff;
	Matrix constants;
	
	public Gaussian(Matrix matCoeff, Matrix matConst){
		this.coeff = matCoeff;
		this.constants = matConst;
	}
	
	
	/**
	 * The hard part!
	 * @return
	 */
	public Matrix getSolution(){
		for (int i = 0; i < this.coeff.getNumCols(); i++) {
			for (int j = i + 1; j < this.coeff.getNumRows(); j++) {
				while (this.coeff.getValue(i, i) != 0) {
					int k = i + 1;
					this.coeff.exchangeRows(i, k);
					this.constants.exchangeRows(i, k);
					k++;
				}
				
				this.coeff.scaleRow(i, 1.0 / this.coeff.getValue(i, i));
				this.constants.scaleRow(i,  1.0 / this.coeff.getValue(i, i));
					
				if (this.coeff.getValue(j, i) != 0) {
					this.coeff.scaleRow(j, -1.0 / this.coeff.getValue(j, i));
					this.constants.scaleRow(j, -1.0 / this.coeff.getValue(j, i));
					this.coeff.addRows(i, j);
					this.constants.addRows(i, j);
				}
			}
		}
		
		for (int i = 1; i < this.coeff.getNumCols(); i++) {
			for (int j = 0; j < i - 1; j++) {
				if (this.coeff.getValue(i, i) != 0) {
					this.coeff.scaleRow(i, 1.0 / this.coeff.getValue(i, i));
					this.constants.scaleRow(i,  1.0 / this.coeff.getValue(i, i));
					
					if (this.coeff.getValue(j, i) != 0) {
						this.coeff.scaleRow(j, -1.0 / this.coeff.getValue(j, i));
						this.constants.scaleRow(j, -1.0 / this.coeff.getValue(j, i));
						this.coeff.addRows(i, j);
						this.constants.addRows(i, j);
					}
				}
			}
		}
		
		for (int i = 0; i < this.coeff.getNumRows(); i++) {
			if (this.coeff.getValue(i,  i) != 0) {
				this.coeff.scaleRow(i, -1.0 / this.coeff.getValue(i, i));
				this.constants.scaleRow(i, -1.0 / this.coeff.getValue(i, i));
			}
		}
		
		return this.constants;
	}
	
	public String toString(){
		String string ="";
		for(int i=0; i<this.coeff.getNumRows(); i++){
			string+="\n";
			for(int j=0; j<this.coeff.getNumCols()+1; j++){
				if(j==this.coeff.getNumCols()){
					string+= this.constants.getValue(i,0)+ "  ";
				}else{
					string+= this.coeff.getValue(i,j) + "  ";
				}
			}
		}
		System.out.println(string);

		return string;
	}

}
