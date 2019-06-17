package org.sagar.javacase.datastructure.LinkList;

public class Node {
	
	Node next;
	int value;
	
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	Node(int value){
		this.next = null;
		this.value = value;
	}

}
