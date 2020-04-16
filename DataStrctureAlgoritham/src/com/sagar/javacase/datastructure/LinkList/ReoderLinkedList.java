package com.sagar.javacase.datastructure.LinkList;

public class ReoderLinkedList {

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

        ReoderLinkedList reorder = new ReoderLinkedList();
        reorder.push(8);
        reorder.push(12);
        reorder.push(10);
        reorder.push(15);
        reorder.push(14);
        //reorder.push(1);


        reorder.printList(reorder.head);
        Node node = reorder.reoderLinkedList(reorder.head);
        reorder.printList(node);


    }

    private Node reoderLinkedList(Node head) {

        if(head == null || head.next == null)
            return head;

        Node slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        Node node1 = head;
        Node node2 = slow.next;
        slow.next = null;
        
        node2 = reverse(node2);

        while(node1 != null && node2 != null){
                Node next1 = node1.next;
                Node next2 = node2.next;
                node1.next = node2;
                node2.next  = next1;
                node1 = next1;
                node2 = next2;
        }

        return head;

    }

    private Node reverse(Node node) {
        Node prev = null, curr = node, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }
}
