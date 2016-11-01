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
	public Matrix getSolution() {
		
		for(int i = 0; i < this.coeff.getNumCols(); i++){
			int n = i + 1;
			
			while (this.coeff.getValue(i, i) == 0) {
				this.constants.exchangeRows(i, n);
				this.coeff.exchangeRows(i, n);
				n++;
			}
			
			for(int j = i + 1; j < this.coeff.getNumRows(); j++){
				double ratio = -1.0 * this.coeff.getValue(i, i) / this.coeff.getValue(j, i);
				
				this.constants.scaleRow(j, ratio);
				this.coeff.scaleRow(j, ratio);
				
				this.constants.addRows(i, j);
				this.coeff.addRows(i, j);
			}
		}
		
		for(int i = this.coeff.getNumCols() - 1; i >= 0; i--){
			for(int j = i - 1; j >= 0; j--){
				double ratio = -1.0 * this.coeff.getValue(i, i) / this.coeff.getValue(j, i);
				
				this.constants.scaleRow(j, ratio);
				this.coeff.scaleRow(j, ratio);
				
				this.constants.addRows(i, j);
				this.coeff.addRows(i, j);
			}
		}
		
		for(int i = 0; i < this.coeff.getNumRows(); i++){
			this.constants.scaleRow(i, 1 / this.coeff.getValue(i, i));
			this.coeff.scaleRow(i, 1 / this.coeff.getValue(i, i));
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
