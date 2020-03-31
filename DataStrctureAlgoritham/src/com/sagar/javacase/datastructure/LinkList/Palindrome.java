package com.sagar.javacase.datastructure.LinkList;

public class Palindrome {

	static void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	static boolean isPalindrome(Node root) {
		if (root == null || root.next == null)
			return true;
		Node head = root, slow = root, fast = root;
		Node prev_slow = slow;
		while (fast != null && fast.next != null) {
			prev_slow = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast != null)
			slow = slow.next;
		prev_slow.next = null;

		printList(head);

		Node prev = null;
		Node curr = slow;
		Node next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		printList(prev);

		while (head != null || prev != null) {
			System.out.println("Head Data: " + head.value + " End Value: " + prev.value);
			if (head.value == prev.value) {

				head = head.next;
				prev = prev.next;
			} else
				return false;
		}

		if (head == null && prev == null)
			return true;

		return false;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(2);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(1);

		System.out.println("Is Palindrome: " + Palindrome.isPalindrome(head));
	}
}
