package com.sagar.javacase.datastructure.LinkList;

public class Pallindrome {
	
	public boolean isPallindrome(Node root, int size) {
		
		Node current = root; Node prev = null;
		
		int reverseFromPos = 0, count = 0;
		
		if(size % 2 != 0) 
			reverseFromPos = size/2 + 1;
		else
			reverseFromPos = size/2;
			
		System.out.println(reverseFromPos);
		
		while(count != reverseFromPos) {
			prev = current;
			current = current.next;
			count++;
		}
		
		Node next = current.next;
		
		while(current.next != null) {
			
			current.next = prev;
			prev = current;
			current = next;
			next = next.next;
			
		}
		
		current.next = prev;
		
		Node start = root;
		
		count = 0;
		
		boolean flag = true;
		
		while( count != reverseFromPos ) {
			count++;
			if(current.value == start.value) {
				System.out.println("Current Val And Last Val "+current.value+" "+start.value);
				current = current.next;
				start = start.next;
				continue;
			}
			else {
				flag = false;
				break;	
			}
			
		}
		
		return flag;
		
	}
	
	public static void main(String[] args) {
		
		Operations op = new Operations();
		
		op.insertAtStart(1);
		op.insertAtEnd(2);
		op.insertAtEnd(3);
		op.insertAtEnd(2);
		op.insertAtEnd(1);
		
		//op.display();
		
		Pallindrome pll = new Pallindrome();
		
		boolean flag = pll.isPallindrome(op.start,op.size);
		System.out.println("isPallindrome = "+flag);
		
	}

}
