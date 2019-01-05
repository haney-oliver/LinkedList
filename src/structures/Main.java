package structures;

public class Main {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>("0");
		list.addLast("1");
		list.addLast("2");
		list.addLast("3");
		list.addLast("4");
		
		System.out.print(list.size() + "  ");
		System.out.println(list);
		
		list.insertBefore("2.5", "3");
		
		System.out.print(list.size() + "  ");
		System.out.println(list);
		
		list.remove("2.5");
		
		System.out.print(list.size() + "  ");
		System.out.println(list);
		
		list.addFirst("-1");
		
		System.out.print(list.size() + "  ");
		System.out.println(list);
	}
}
