package datastructures.LinkedLists;

public class LinkedList {

    private ListNode head;
    private int length;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(int val) {
        this.head = new ListNode(val);
    }

    public void insertAtHead(int val) {
        ListNode oldHead = this.head;
        this.head = new ListNode(val);
        this.head.setNext(oldHead);
        this.length++;
    }

    public void insertAtHead(ListNode newNode) {
        ListNode oldHead = this.head;
        this.head = newNode;
        this.head.setNext(oldHead);
        this.length++;
    }

    public void appendNode(ListNode newNode) {
        ListNode current = this.head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
        this.length++;
    }

    public void appendNode(int val) {
        ListNode current = this.head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(val);
        this.length++;
    }

    public void insertNodeAtIndex(int val, int index) {
        if (this.length -1 < index) {
            System.out.println("The list is not long enough to insert at index " + index + ". Only " + this.length + " nodes currently.");
        } else {
            int count = 0;
            ListNode newNode = new ListNode(val);
            ListNode current = this.head;
            ListNode previous = null;
            while (current != null && count <= index) {
                if (count == index) {
                    previous.setNext(newNode);
                    newNode.setNext(current);
                } else {
                    previous = current;
                    current = current.getNext();
                }
                count++;
            }
        }
    }

    public void insertNodeAtIndex(ListNode newNode, int index) {
        if (this.length - 1 < index) {
            System.out.println("The list is not long enough to insert at index " + index + ". Only " + this.length + " nodes currently.");
        } else {
            int count = 0;
            ListNode current = this.head;
            ListNode previous = null;
            while (current != null && count <= index) {
                if (count == index) {
                    previous.setNext(newNode);
                    newNode.setNext(current);
                } else {
                    previous = current;
                    current = current.getNext();
                }
                count++;
            }
        }
    }

    public void removeNodeAtIndex(int index) {
        if (this.length -1 < index) {
            System.out.println("The list is not long enough to insert at index " + index + ". Only " + this.length + " nodes currently.");
        } else {
            int count = 0;
            ListNode current = this.head;
            ListNode previous = null;
            while (current != null && count <= index) {
                if (count == index) {
                    previous.setNext(current.getNext());
                } else {
                    previous = current;
                    current = current.getNext();
                }
                count++;
            }
        }
    }

    public void reverseList() {
        ListNode previous = null;
        ListNode current = this.head;
        // 2 -> 4 -> 10
        while (current != null) {
            ListNode nextNode = current.getNext(); // store 4
            current.setNext(previous); // store null
            previous = current; // store the 2 so 4 points to 2
            current = nextNode; // go to 4
        }
        this.head = previous;
    }

    public void printList() {
        ListNode current = this.head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.getVal());
            if (current.getNext() != null) {
                sb.append("->");
            }
            current = current.getNext();
        }
        System.out.println(sb.toString());
    }

    public int getLength() {
        return this.length;
    }

    public void printLength() {
        System.out.println("The Linked List has " + this.length + " nodes.");
    }
}
