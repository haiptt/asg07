

public class NumeralItem implements Item {
	private int value;
	
	public NumeralItem (int value){
		this.value = value;
	}
	
	public Item clone(){
		return new NumeralItem(value);
	}
	public String toString(){
		return ""+value;
	}

	@Override
	public boolean equals(Item item) {
		if (item == null)
			return false;
		if (!(item instanceof NumeralItem))
			return false;			
		return value == ((NumeralItem)item).value;
	}
}
