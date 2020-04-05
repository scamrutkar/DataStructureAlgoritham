package com.sagar.javacase.datastructure.LinkList;

public class SegregateEvenOdd {

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

    void printList(){
         Node temp = head;
         System.out.println("List is as follow: ");
         while(temp != null) {
             System.out.printf("%d ", temp.data);
             temp = temp.next;
         }
    }

    private void segregateEvenOdd() {

         Node curr = head;

         Node evenStart = null, evenEnd = null;
         Node oddStart = null, oddEnd = null;

         while(curr != null){
             int data = curr.data;

             if(data % 2 == 0){
                 if(evenStart == null){
                     evenStart = curr;
                     evenEnd = evenStart;
                 }else{
                     evenEnd.next = curr;
                     evenEnd = evenEnd.next;
                 }
             }
             else{
                 if(oddStart == null){
                     oddStart = curr;
                     oddEnd = oddStart;
                 }else{
                     oddEnd.next = curr;
                     oddEnd = oddEnd.next;
                 }
             }

             curr = curr.next;
         }

         if(evenStart == null && oddStart == null)
             return;

         evenEnd.next = oddStart;
         oddEnd.next = null;
         head = evenStart;

    }

    public static void main(String[] args) {

        SegregateEvenOdd evenOdd = new SegregateEvenOdd();
        evenOdd.push(17);
        evenOdd.push(15);
        evenOdd.push(8);
        evenOdd.push(12);
        evenOdd.push(10);
        evenOdd.push(15);
        evenOdd.push(14);
        evenOdd.push(1);
        evenOdd.push(7);
        evenOdd.push(6);

        evenOdd.printList();
        evenOdd.segregateEvenOdd();
        evenOdd.printList();

    }

}
