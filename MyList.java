import java.util.Stack;

public class MyList implements Item{
	Node start;
	Node end;

	
	public MyList(){
		start = null;
		end = null;
		}
	public MyList(MyList b){
		start = b.start;
		end = b.end;
		}
	public MyList clone() {
		MyList list = new MyList();
		list.appendList(this);
		return list;
	}
	public String toString(){
		if (isEmpty()) return "List is Empty";
		else{
			Node cur = start;
			String str = "";
			while(cur != null){
				String s = cur.data + "";
				cur = cur.next;
				if(cur != null) s += ", ";
				str +=s;
			}
			return "( " + str +" )" ; 
		}
		
	}
		
	public boolean isEmpty(){        
		return (start == null); 
		}
	public int length(){
		int leng = 0;
		Node cur = start;
		while(cur != null){
			cur = cur.next;
			leng ++;
			}
		return leng;
	}
	
	public void append(Item data){
		if( isEmpty()) 
			start = end = new Node(data);
		else
			end = end.next = new Node(data);
		}
		
	public void appendList(MyList list){
		Node cur = list.start;
		while(cur != null){
			this.append(cur.data.clone());
			cur = cur.next;
			}	
		}

	public boolean equals(MyList list){	
		Node cur1 = this.start;
		Node cur2 = list.start;
		 while (cur1 != null && cur2 != null){
				if(!cur1.data.equals(cur2.data)) return false;
				cur1 = cur1.next;
				cur2 = cur2.next;
				}
			if(cur1 != null || cur2 != null) return false;
			return true;
		}
	
	
	public Item find(Item value){
		Node cur = start;
		Item t = null;
		while(cur != null){
			if(cur.data == value) t = cur.data  ;
			cur = cur.next;		
			}
			 return t;
		}
		
	public MyList Invert() {
		Node cur = start;
		Stack<Node> stack = new Stack<Node>();
		MyList l = new MyList();
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		Node cur2 = null;
		while (!stack.isEmpty()) {
			cur2 = stack.pop();
			l.append(cur2.data);
		}
		return l;

	}
		
	public static void main(String [] avgs){
		MyList l = new MyList();
			l.append(new NumeralItem(1));
			l.append(new NumeralItem(2));
			System.out.println(l);		// (1, 2)
		MyList l2 = new MyList();
			l2.append(new StringItem("a"));
			l2.append(new StringItem("b"));
			System.out.println(l2);     // (a, b)
		l.append(l2);
		System.out.println(l);
			l.appendList(l2);
			System.out.println(l);    // (1, 2, (a, b), a, b)
		l2.append(new NumeralItem(5));
			System.out.println(l2);	 // (a, b, 5)
			System.out.println(l);			//(1, 2, (a, b), a, b)
			
		System.out.println("Is l empty ? -  " + l.isEmpty());
		System.out.println("Do dai cua danh sach la l: " + l.length());
		System.out.println(" l: "+ l);
		System.out.println("Do dai cua danh sach la l2: " + l2.length());
		System.out.println("l2: "+ l2);
		MyList l3 = new MyList(l2);
		System.out.println("New l3: "+ l3);
		System.out.println("l3 ? l2: "+ l3.equals(l2));
		System.out.println("l  ? l2: "+ l.equals(l2));
		System.out.printf("Danh sach sau khi dao nguoc: ");
		System.out.println(l.Invert());
		
		Item temp = new NumeralItem(1);
		System.out.println("Tim kiem l2 trong l: "+l.find(l2));
		System.out.println("Tim kiem 1: " +l.find(temp));
		
		
	
}
	
}
		
		