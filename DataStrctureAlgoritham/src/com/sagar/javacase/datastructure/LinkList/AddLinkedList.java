package com.sagar.javacase.datastructure.LinkList;

public class AddLinkedList {

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
        System.out.println("\n");
    }

    public static void main(String[] args) {

        AddLinkedList list1 = new AddLinkedList();
        list1.push(1);
        list1.push(7);
        list1.push(6);

        AddLinkedList list2 = new AddLinkedList();
        list2.push(1);
        list2.push(7);
        list2.push(4);

        list1.printList(list1.head);
        list1.printList(list2.head);
        System.out.println(16/10);
        System.out.println(16%10);
        AddLinkedList sumList = new AddLinkedList();
        Node node = addLinkedList(list1.head,list2.head,sumList);
        list1.printList(node);

    }

    private static Node reverse(Node curr){
        Node prev = null;
        Node next = null;
        while(curr != null ){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static Node addLinkedList(Node head1, Node head2, AddLinkedList sumList) {

        int remainder = 0;
        head1 = reverse(head1);
        head2 = reverse(head2);

        while(true){
            if(head1 == null && head2 == null)
                break;
            int number1 = 0;
            int number2 = 0;

            if(head1 != null){
                number1 = head1.data;
                head1 = head1.next;
            }

            if(head2 != null){
                number2 = head2.data;
                head2 = head2.next;
            }

            int sum = number1 + number2 + remainder;
            remainder = sum / 10;
            sumList.push(sum%10);
        }

        while(remainder > 0){
            sumList.push(remainder%10);
            remainder = remainder/10;
        }

        return reverse(sumList.head);

    }
}
