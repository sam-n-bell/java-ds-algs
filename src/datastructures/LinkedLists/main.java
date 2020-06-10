package datastructures.LinkedLists;

public class main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertAtHead(5);
        linkedList.insertAtHead(10);
        linkedList.insertAtHead(15);
        linkedList.printList();
        linkedList.reverseList();
        linkedList.appendNode(20);
        linkedList.printList();
        linkedList.insertNodeAtIndex(13, 2);
        linkedList.printList();
        linkedList.removeNodeAtIndex(2);
        linkedList.printList();
    }
}
