package org.sagar.javacase.datastructure.LinkList;

public class ReverseLinkList {
	
	public void reverse(Node root) {
		
		Node current = root;
		Node prev = null;
		Node next = current.next;
		
		while(current.next != null) {
			
			current.next = prev;
			prev = current;
			current = next;
			next = next.next;
			
		}
		
		current.next = prev;
		
		while(current != null ) {
			System.out.println("Node : "+current.value);
			current = current.next;
		}
		
	}
	
	public static void main(String[] args) {
		
		Operations op = new Operations();
		
		op.insertAtStart(4);
		op.insertAtStart(5);
		op.insertAtEnd(6);
		op.insertAtPos(7, 2);
		
		
		op.display();
		
		ReverseLinkList rll = new ReverseLinkList();
		rll.reverse(op.start);
		
		
	}

}
