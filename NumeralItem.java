public class NumeralItem implements Item{
	public int value;
	public NumeralItem(int value){
		this.value = value;
		}
	public NumeralItem(NumeralItem b){
		value = b.value;
		}
	public NumeralItem clone(){
		return new NumeralItem(this);
	}
	public String toString(){
		return  ""+ value ; 
	}
	
	public boolean equals(NumeralItem value){
		return(this == value);
		}
}