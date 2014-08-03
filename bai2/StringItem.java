
public class StringItem implements Item {
	private String value;
	
	public StringItem(String value){
		this.value = value;
	}

	public Item clone(){
		return new StringItem(value);
	}
	
	
	public String toString(){
	  return value ;
	}

	@Override
	public boolean equals(Item item) {
		if (item == null)
			return false;
		if (!(item instanceof StringItem))
			return false;			
		return value.equals(((StringItem)item).value);
	}
}
