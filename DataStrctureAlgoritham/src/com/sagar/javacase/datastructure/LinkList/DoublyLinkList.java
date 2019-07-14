package com.sagar.javacase.datastructure.LinkList;

class DLLNode {

	int data;
	DLLNode next;
	DLLNode previous;

	public DLLNode(int data) {
		this.data = data;
		this.next = null;
		this.previous = null;
	}

}

class DLLNodeOperations {

	protected DLLNode root;
	protected DLLNode head;
	protected DLLNode tail;

	public DLLNodeOperations() {
		root = head = tail = null;
	}

	public void insert(int data) {

		DLLNode newNode = new DLLNode(data);

		if (root == null) {
			root = newNode;
			head = tail = root;
		} else {
			DLLNode temp = tail;
			tail = newNode;
			temp.next = tail;
			tail.previous = temp;
		}
	}
	
	public void insertAtHead(int data) {

		DLLNode newNode = new DLLNode(data);

		if (root == null) {
			root = newNode;
			head = tail = root;
		} else {
			DLLNode temp = head;
			head = root = newNode;
			temp.previous = head;
			head.next = temp;
			
		}
	}
	
	public void display() {
		DLLNode current = root;
		while(current != null) {
			System.out.print(current.data+" ");
			current = current.next;
		}
	}

}

public class DoublyLinkList {

	public static void main(String[] args) {
		
		DLLNodeOperations ops = new DLLNodeOperations();
		
		ops.insert(10);
		ops.insert(20);
		ops.insert(50);
		ops.insert(30);
		
		ops.display();
		
		ops.insertAtHead(40);
		ops.insertAtHead(60);
		
		System.out.println("");
		System.out.println("*******************");

		
		ops.display();
		

	}

}
