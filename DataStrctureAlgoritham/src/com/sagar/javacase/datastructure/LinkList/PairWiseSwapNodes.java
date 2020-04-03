package com.sagar.javacase.datastructure.LinkList;

public class PairWiseSwapNodes {

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
        root = pairWiseswapNodes(root);
        System.out.println("\nAfter swapping node list is as follow:");
        printList(root);
    }

    private static Node pairWiseswapNodes(Node root) {

        if(root == null || root.next == null)
            return root;

        Node head = root, returnNode = root.next,prev = null;
        while(head != null && head.next != null){
            Node node = head;
            head = head.next.next;
            swapNodes(node,node.next,prev);
            prev = node;
        }
        return returnNode;

    }

    private static void swapNodes(Node curr, Node next, Node prev) {

        if(curr != null && next != null){
            curr.next = next.next;
            next.next = curr;
            if(prev != null)
                prev.next = next;
        }

    }

    private static void printList(Node head) {
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
    
}
