package com.sagar.javacase.datastructure.LinkList;

public class Operations {
	
	protected Node start;
	protected Node end;
	int size;
	
	Operations(){
		start = null;
		end = null;
		size = 0;
	}
	
	public void insertAtStart(int val) {
		
		Node newNode = new Node(val);
		
		if(start == null) {
			start = newNode;
			end = start;
		}else {
			newNode.setNext(start);
			start = newNode;
		}
		
		size++;
	}
	
	public void insertAtEnd(int val) {
		
		Node newNode = new Node(val);
				
		if(start == null) {
			start = newNode;
			end = start;
		}
		else {
			end.setNext(newNode);
			end = newNode;
		}
		
		size++;
		
	}
	
	public void insertAtPos(int val, int pos) {
		
		if(size > pos) {
			Node newNode = new Node(val);

			if (start == null) {
				start = newNode;
				end = start;
			} else {
				Node currentNode = start;
				int count = 0;
				while(count != pos) {
					currentNode = currentNode.next;
					count++;
				}
				
				Node nextNode = currentNode.getNext();
				currentNode.setNext(newNode);
				newNode.setNext(nextNode);

			}
			size++;
		}
	}
	
	public void display() {
		
		Node currentNode = start;
		
		int count = size;
		
		while(count > 0 ) {
			System.out.println("Node : "+currentNode.value);
			count--;
			currentNode = currentNode.next;
		}
		
	}
	
	public static void main(String[] args) {
		
		Operations op = new Operations();
		
		op.insertAtStart(4);
		op.insertAtStart(5);
		op.insertAtEnd(6);
		op.insertAtPos(7, 2);
		
		
		op.display();
		
	}
	
}
