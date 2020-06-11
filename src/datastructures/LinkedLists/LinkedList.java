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

    public void appendNode(int val) {
        if (this.head == null) {
            this.head = new ListNode(val);
        } else {
            ListNode lastNode = this.getNodeAtIndex(this.length - 1);
            lastNode.setNext(new ListNode(val));
        }
        this.length++;
    }

    public void insertNodeAtIndex(int val, int index) {
        if (this.length -1 < index) {
            System.out.println("The list is not long enough to insert at index " + index + ". Only " + this.length + " nodes currently.");
        } else {
            /**
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
             **/
            ListNode newNode = new ListNode(val);

            ListNode previous = null;
            if (index > 0) {
                // can get previous node
                previous = this.getNodeAtIndex(index - 1);
            }
            ListNode next = null;
            if (index < this.length) {
                // can get next node (or null)
                next = this.getNodeAtIndex(index);
            }
            newNode.setNext(next);
            if (previous == null) {
                // index was 0
                this.head = newNode;
            } else {
                // index was end of the list or between 0 and last node
                previous.setNext(newNode);
            }
        }
    }

    public void removeNodeAtIndex(int index) {
        if (this.length -1 < index) {
            System.out.println("The list is not long enough to insert at index " + index + ". Only " + this.length + " nodes currently.");
        } else {
            /** old way of doing this
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
            **/

            // new way

            ListNode previous = null;
            if (index > 0) {
                // can get previous node
                previous = this.getNodeAtIndex(index - 1);
            }
            ListNode next = null;
            if (index < this.length) {
                // can get next node (or null)
                next = this.getNodeAtIndex(index + 1);
            }

            if (previous == null) {
                // index was 0
                this.head = next;
            } else {
                // index was end of the list or between 0 and last node
                previous.setNext(next);
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

    public ListNode getNodeAtIndex(int index) {
        if (index > this.length - 1) {
            throw new IndexOutOfBoundsException();
        }
        int count = 0;
        ListNode current = this.head;
        while (count < index) {
            current=current.getNext();
            count++;
        }
        return current;
    }

    public int getLength() {
        return this.length;
    }

    public void printLength() {
        System.out.println("The Linked List has " + this.length + " nodes.");
    }
}
