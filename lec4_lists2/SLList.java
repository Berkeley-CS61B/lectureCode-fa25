package lec4_lists2;

public class SLList {

    // because IntNode's dont use any of SLList's stuff (members!)
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    // the first real value is sentinel.next.item
    // sentinel.item is not useful
    private IntNode sentinel;
    private int size;

    public SLList() {
        sentinel = new IntNode(47, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(47, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    // adds x to the front of the list
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public void addLast(int x) {
        size += 1;
        IntNode p = sentinel;

        // the node with p.next == null is the last one
        while (p.next != null) {
            p = p.next;
        }

        // now p is the last node
        p.next = new IntNode(x, null);
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SLList L = new SLList();
        L.addLast(10);
        L.addFirst(0);
        System.out.println(L.size());
    }
}
