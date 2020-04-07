package com.sagar.javacase.datastructure.LinkList;

public class ReverseLinkedListInSize {

    Node head;

    class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    void push(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void printList(Node head){
        Node temp = head;
        System.out.println("List is as follow: ");
        while(temp != null) {
            System.out.printf("%d ", temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        ReverseLinkedListInSize reverse = new ReverseLinkedListInSize();
        reverse.push(8);
        reverse.push(12);
        reverse.push(10);
        reverse.push(15);
        reverse.push(14);
        reverse.push(1);
        reverse.push(7);
        reverse.push(6);

        reverse.printList(reverse.head);
        Node node = reverse.reverseILinkedListInSize(reverse.head,3);
        reverse.printList(node);

    }

    private Node reverseILinkedListInSize(Node head, int k) {
        Node curr = head;
        Node prev = null;
        Node next = null;
        int count = 0;

        while(curr != null && count < k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if(next != null)
            head.next = reverseILinkedListInSize(next,k);

        return prev;

    }


}
