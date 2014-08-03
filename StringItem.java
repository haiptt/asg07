public class StringItem implements Item{
	private String value;
	public StringItem(String value){
		this.value = value;
		}
	public StringItem(StringItem b){
		value = b.value;
		}
	public StringItem clone(){
		return new StringItem(this);
	}
	public String toString(){
		return ""+ value ;
	}
	public boolean equals(StringItem value){
		return(this == value);
		}
}