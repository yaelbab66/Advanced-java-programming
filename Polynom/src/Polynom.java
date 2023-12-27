import java.util.ArrayList;

public class Polynom {
	
	ArrayList<Organ> polynom = new ArrayList<Organ>(0);
	
	
	public Polynom(int[] power, double[] num){
		if(power.length != 0 && num.length != 0 && power.length != num.length){
			throw new IllegalArgumentException("Illegal Input, the arrays are in different size");
		}
		for(int i=0; i<num.length; i++){
			if(num[i] == 0){
				power[i] = -1;
			}
		}
		int max = 0;
		while(max != -1){
			
			max = max(power, num);
			if(max == -1)
				break;
			polynom.add(new Organ(power[max],num[max]));
			//System.out.println("max: " +max+", power: "+power[max] + ", num: "+num[max] );
			power[max] = -1;
			num[max] = -1;
		}
		
	}


	

	private int max(int[] power, double[] num) {
		
		int i;
		int max = -1;
		int place = -1;
		for(i=0; i < power.length; i++){
			//System.out.println("i: "+i+", power: "+power[i] + ", num: "+num[i] );
			
			
			if(power[i] == max && place != -1){
				num[place]+= num[i];
				power[i] = -1;
				num[i] = -1;
			}
			if(power[i] > max){
				place = i;
				max = power[i];
			}
		}
		return place;
	}


	public Polynom plus(Polynom p){
		
		int[] sumPower = new int[p.polynom.size()+this.polynom.size()];
		double[] sumNum = new double[p.polynom.size()+this.polynom.size()];
		int i;
		for(i = 0; i < p.polynom.size(); i ++){
			sumPower[i] = p.polynom.get(i).power;
			sumNum[i] = p.polynom.get(i).num;
		}
		for(int j = 0; j < polynom.size(); j ++){
			
			sumPower[i] = polynom.get(j).power;
			sumNum[i] = polynom.get(j).num;
			i++;
		}
		Polynom poynomSum = new Polynom(sumPower, sumNum);
		
		return poynomSum;
		
	}
	
	public Polynom minus(Polynom p){
		int i=0, j=0, k=0;
		int powerSub[] = new int[this.polynom.size() + p.polynom.size()];
		double numSub[] = new double[this.polynom.size() + p.polynom.size()];
		while(i< this.polynom.size() && j < p.polynom.size()){
			if(this.polynom.get(i).power > p.polynom.get(j).power){
				powerSub[k] = this.polynom.get(i).power;
				numSub[k] = this.polynom.get(i).num;
				k++;
				i++;
			}else{
			if(this.polynom.get(i).power < p.polynom.get(j).power){
				powerSub[k] = p.polynom.get(j).power;
				numSub[k] = -p.polynom.get(j).num;
				k++;
				j++;
			}else{
				powerSub[k] = this.polynom.get(i).power;
				numSub[k] = this.polynom.get(i).num - p.polynom.get(j).num;
				k++;
				j++;
				i++;
			}
			}
		}//end while
		while(i<this.polynom.size()){
			powerSub[k] = this.polynom.get(i).power;
			numSub[k] = this.polynom.get(i).num;
			k++;
			i++;
		}
		while(j<p.polynom.size()){
			powerSub[k] = p.polynom.get(j).power;
			numSub[k] = p.polynom.get(j).num;
			k++;
			j++;
		}
		Polynom polynomSub = new Polynom(powerSub, numSub);
		return polynomSub;
	}
	
	public Polynom derivative(Polynom p){
		int powerDerivative[] = new int[p.polynom.size()];
		double numDerivative[] = new double[p.polynom.size()];
		for(int i =0 ; i< p.polynom.size(); i++){
			powerDerivative[i] = p.polynom.get(i).power -1;
			numDerivative[i] = p.polynom.get(i).power * p.polynom.get(i).num;
			
		}
		Polynom derivative = new Polynom(powerDerivative,numDerivative);	
		return derivative;
	}

	
	public void print(){
		System.out.println("size: "+polynom.size());
		int i;
		for(i=0; i<polynom.size()-1;i++){
			
			System.out.print(this.polynom.get(i).num+"X^"+this.polynom.get(i).power+" + ");
		}
		if(this.polynom.get(i).power == 0){
			System.out.println(this.polynom.get(i).num);
		}
		else{
			System.out.println(this.polynom.get(i).num+"X^"+this.polynom.get(i).power);
		}
				
	}
}

