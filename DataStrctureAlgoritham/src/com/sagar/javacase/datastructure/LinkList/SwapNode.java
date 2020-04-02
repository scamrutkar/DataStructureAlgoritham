package com.sagar.javacase.datastructure.LinkList;

public class SwapNode {

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args){
        Node root = new Node(8);
        root.next = new Node(10);
        root.next.next = new Node(12);
        root.next.next.next = new Node(15);
        root.next.next.next.next = new Node(18);
        root.next.next.next.next.next = new Node(20);
        System.out.println("List is as follow: ");
        printList(root);
        root = swapNodes(root, 12, 18);
        System.out.println("\nAfter swapping node list is as follow:");
        printList(root);
    }

    private static void printList(Node head) {
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }

    private static Node swapNodes(Node head, int x, int y) {

        Node root = head;
        if(x == y)
            return head;
        Node a = null, b = null;
        while(head.next != null){
            if((head.next).data == x)
                a = head;
            else if ((head.next).data == y)
                b = head;
            head = head.next;

        }

        if(a != null && b!= null){
            Node temp = a.next;
            a.next = b.next;
            b.next = temp;
            temp = a.next.next;
            a.next.next = b.next.next;
            b.next.next = temp;
        }

        return root;
    }


}
