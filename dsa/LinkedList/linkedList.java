
// // public class linkedList {
// //     Node head;
// //     private int size;

// //     linkedList() {
// //         this.size = 0;
// //     }
// //     class Node {
// //         String data;
// //         Node next;

// //         Node(String data) {
// //             this.data = data;
// //             this.next = null;
// //             size++;
// //         }
// //     }

// //     // add-first, last

// //     public void addFirst(String data) {
// //         Node newNode = new Node(data);
// //         if (head == null) {
// //             head = newNode;
// //             return;
// //         }
// //         newNode.next = head;
// //         head = newNode;

// //     }

// //     public void addLast(String data) {
// //         Node newNode = new Node(data);
// //         if (head == null) {

// //             head = newNode;
// //             return;
// //         }
// //         Node currNode = head;
// //         while (currNode.next != null) {
// //             currNode = currNode.next;

// //         }
// //         currNode.next = newNode;

// //     }

// //     public void printList() {
// //         if (head == null) {
// //             System.out.println("list is empty");
// //             return;
// //         }
// //         Node currNode = head;
// //         while (currNode != null) {
// //             System.out.print(currNode.data + " -> ");
// //             currNode = currNode.next;
// //         }
// //         System.out.println("null");
// //     }

// //     public void deleteFirst() {
// //         if (head == null) {
// //             System.out.println("list is empty");
// //             return;
// //         }
// //         size--;
// //         head = head.next;
// //     }
    
// //     public void deleteLast() {
// //         if (head == null) {
// //             System.out.println("list is empty");
// //             return;
// //         }
// //         if (head.next == null) {
// //             head = null;
// //             return;
// //         }
// //         Node secondLast = head;
// //         Node lastNode = head.next;
// //         while (lastNode.next != null) {
// //             lastNode = lastNode.next;
// //             secondLast = secondLast.next;
// //         }
// //         secondLast.next = null;

// //     }

// //     public int getSize() {
// //         return size;
// //     }

// //     public static void main(String[] args) {
// //         linkedList list = new linkedList();
// //         list.addFirst("a");
// //         list.addFirst("is");
// //         // list.printList();
// //         list.addLast("list");
// //         // list.printList();
// //         list.addFirst("this");
// //         // list.printList();

// //         list.deleteFirst();
// //         // list.printList();
// //         list.deleteLast();
// //         list.printList();

// //         // System.out.println(list.getSize());
// //         list.addFirst("This"); 
// //         System.out.println(list.getSize());


// //     }
// // }

// // using java library

// import java.util.*;

// import org.w3c.dom.Node;

// public class linkedList {
//     Node head;
// //     Node next;
// //     public void reverseIterate() {
// //         if (head == null || head.next == null) {
// //             return;
            
// //         }
// //         Node head;
// //         Node prevNode = head;
// //     Node currNode = head.next;
// //     while (currNode != null) {
// //         Node nextNode = currNode.next;
// //         currNode.next = prevNode;

// //         // update
// //         prevNode = currNode;
// //         currNode = nextNode;
// //         head.next = null;
// //         head = prevNode;
        
// //     }
// // }

// public Node reverseRecursive(Node head) {
//     if (head == null || head.next == null) {
//         return head;
//     }
//     Node newHead = reverseRecursive(head.next);
//     head.next.next = head;
//     head.next = null;
//     return newHead;
// }
//     public static void main(String[] args) {
//         LinkedList<String> list = new LinkedList<>();
//         list.addFirst("a");
//         list.addFirst("is");
//         // System.out.println(list);
//         list.addFirst("This");
//         list.addLast("list");
//         System.out.println(list);
//         System.out.println(list.size());
//         for (int i = 0; i < list.size(); i++) {
//             System.out.print(list.get(i) + " -> ");
//         }
//         list.remove(3);
//         System.out.println(list);
//         // System.out.println();
//         // list.removeFirst();
//         // System.out.println(list);
//         // list.removeLast();
//         // System.out.println(list);
//         // reversing a linkedList
//         Collections.reverse(list);
//         System.out.println(list);

//     }

// }