package org.sagar.javacase.datastructure.stack;

import java.util.LinkedList;

class stack{
	
	LinkedList<Integer> queue = new  LinkedList<Integer>();
	
	void push(int element) {
		
		int size = queue.size();
		queue.add(element);
		
		for(int i=0;i<size;i++) {
			int x = queue.remove();
			queue.add(x);
		}
		System.out.println(queue.toString());
	}
	
	int pop() {
		
		if(queue.isEmpty()) {
			System.out.println("No element present");
			return -1;
		}
		
		return queue.remove();
	}
	
	int top() {
		
		if(queue.isEmpty()) {
			System.out.println("No element present");
			return -1;
		}
		
		return queue.peek();
		
	}
	
	boolean isEmpty() {
		return queue.isEmpty();
	}
	
}

public class StackUsingQueue {

	public static void main(String[] args) {
		stack s = new stack(); 
        s.push(10); 
        s.push(20); 
        System.out.println("Top element :" + s.top()); 
        s.pop(); 
        s.push(30); 
        s.pop(); 
        System.out.println("Top element :" + s.top()); 

	}

}
