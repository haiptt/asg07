
public class MyList implements Item {
	private Node start;
	private Node end;
	private int size;
	
	public MyList() {
		start = null;
		end = null;
		size = 0;
	}

	public void append(Item data) {
		size++;
		if (start == null) {
			Node node = new Node(data, null);
			start = node;
			end = node;
		} else {
			Node node = new Node(data, null);
			end.next = node;
			end = node;
		}
	}

	public void appendList(MyList l) {
		//size += l.length();
		Node cur = l.start;
		while (cur != null) {
			append(cur.data);
			cur = cur.next;
		}
	}

	public Item clone() {
		MyList list = new MyList();
		list.appendList(this);
		return list;
	}

	public String toString() {
		String result = "(";
		Node cur = this.start;
		boolean first = true;
		while (cur != null) {
			if (first) {
				result += cur.data.toString();
				first = false;
			} else
				result += ", " + cur.data.toString();
			cur = cur.next;
		}
		result += ")";
		return result;
	}
	
	public int length(){
		return size;
	}
	
	public boolean equals(Item item){
		if (item == null)
			return false;
		if (!(item instanceof MyList))
			return false;		
		MyList list = (MyList)item;
		
		Node n1 = this.start;
		Node n2 = list.start;
		
		if (length() != list.length())
			return false;
		
		while ((n1 != null) && (n2 != null)){
			//System.out.println(n1 +  "  ????==????  " + n2);
			if (!n1.data.equals(n2.data))
				return false;
			n1 = n1.next;
			n2 = n2.next;
		}
		return true;
	}
	
	public Item find(Item item){
		Node cur = this.start;
		while (cur != null){
			//System.out.println(n1 +  "  ????==????  " + n2);
			if (!cur.data.equals(item))
				return cur.data;
		}
		return null;
	}
	
	private void addInvert(Node head){
		if (head != null){
			addInvert(head.next);
			append(head.data);
		}
	}
	
	public void invert(){
		Node head = start;
		start = end = null;
		size = 0;
		addInvert(head);
	}
	
	public static void main(String args[]) {
		System.out.println("result:   -=====");
		MyList l = new MyList();
		l.append(new NumeralItem(1));
		l.append(new NumeralItem(2));
		System.out.println(l); // (1, 2)
		MyList l2 = new MyList();
		l2.append(new StringItem("a"));
		l2.append(new StringItem("b"));

		System.out.println(l2.toString()); // (a, b)
		l.append(l2);
		System.out.println(l + " with length = " + l.length()); // (1, 2, (a, b))
		l.appendList(l2);
		System.out.println(l + " with length = " + l.length()); // (1, 2, (a, b), a, b)
		MyList newList = (MyList)l.clone();
		System.out.println(newList); // (1, 2, (a, b), a, b)
		System.out.println(newList.length() + " lll " + l.length()); 
		System.out.println(newList.equals(l));
		newList.invert();
		System.out.println(newList);
	}
}
