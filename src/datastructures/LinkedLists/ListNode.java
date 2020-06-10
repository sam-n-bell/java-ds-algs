package datastructures.LinkedLists;

public class ListNode {

    private int val;
    private ListNode next;

    public ListNode(int val){
        this.val = val;
    }

    public void setNext(ListNode next){
        this.next = next;
    }

    public void setNext(int val) {
        this.next = new ListNode(val);
    }

    public int getVal(){
        return this.val;
    }

    public ListNode getNext() {
        return this.next;
    }

}
