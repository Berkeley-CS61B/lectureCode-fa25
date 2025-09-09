package lec5_lists3;

// Camel is a placeholder for a type we'll pick later
public class SLList<Camel> {

    // because Node's dont use any of SLList's stuff (members!)
    private class Node {
        public Camel item;
        public Node next;

        public Node(Camel i, Node n) {
            item = i;
            next = n;
        }
    }

    // the first real value is sentinel.next.item
    // sentinel.item is not useful
    private Node sentinel;
    private int size;

    public SLList() {
        sentinel = new Node(null, null);
        size = 0;
    }

    public SLList(Camel x) {
        sentinel = new Node(null, null);
        sentinel.next = new Node(x, null);
        size = 1;
    }

    // adds x to the front of the list
    public void addFirst(Camel x) {
        sentinel.next = new Node(x, sentinel.next);
        size += 1;
    }

    public Camel getFirst() {
        return sentinel.next.item;
    }

    public void addLast(Camel x) {
        size += 1;
        Node p = sentinel;

        // the node with p.next == null is the last one
        while (p.next != null) {
            p = p.next;
        }

        // now p is the last node
        p.next = new Node(x, null);
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SLList<Integer> L = new SLList<>();
        L.addLast(10);
        L.addFirst(0);
        System.out.println(L.size());

        SLList<String> L2 = new SLList<>();
        L2.addLast("hi");
        L2.addLast("moo");
    }
}
