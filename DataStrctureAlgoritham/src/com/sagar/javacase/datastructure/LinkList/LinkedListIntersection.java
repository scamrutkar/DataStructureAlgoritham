package com.sagar.javacase.datastructure.LinkList;

public class LinkedListIntersection {

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args){

        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(5);
        head1.next.next.next = new Node(10);

        Node head2 = new Node(30);
        head2.next = new Node(40);
        head2.next.next = new Node(50);
        head2.next.next.next = head1.next.next;

        System.out.println("First List is as follow: ");
        printList(head1);
        System.out.println("\nSecond List is as follow: ");
        printList(head2);
        System.out.println("\nIntersection point of two linked list is : "+findIntersectionPoint(head1, head2));

    }

    private static int findIntersectionPoint(Node head1, Node head2) {

        int h1Lenght = 0, h2Length = 0;

        Node tHead1 = head1, tHead2 = head2;

        while(tHead1 != null){
            tHead1 = tHead1.next;
            h1Lenght++;
        }

        while(tHead2 != null){
            tHead2 = tHead2.next;
            h2Length++;
        }

        int diff = Math.abs(h1Lenght -  h2Length);

        if(h1Lenght < h2Length) {
            Node temp = head2;
            head2 = head1;
            head1 = temp;
        }

        int count = 0;

        while(count++ < diff){
            head1 = head1.next;
        }

        while(head1 != null && head2 != null){
            if(head1 == head2)
                return head1.data;
            head1 = head1.next;
            head2 = head2.next;
        }

        return -1;
    }

    private static void printList(Node head) {
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }

}
