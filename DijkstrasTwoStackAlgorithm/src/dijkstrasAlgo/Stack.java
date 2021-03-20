package dijkstrasAlgo;

public class Stack<Item> {
	private Node<Item> top;
	private int length = 0;
	
	public void push(Item data) {
		Node<Item> node = new Node<Item>();
		node.data = data;
		
		node.next = top;
		top = node;
		this.length++;
	}
	
	public boolean isEmpty() {
		return this.length == 0;
	}
	
	public int size() {
		return this.length;
	}
	
	public Item pop() {
		if(isEmpty()) {
			throw new IndexOutOfBoundsException("The stack is empty!");
		}
		
		Item data = top.data;
		top = top.next;
		length--;
		return data;
	}
}
