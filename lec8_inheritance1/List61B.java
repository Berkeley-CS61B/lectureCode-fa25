package lec8_inheritance1;

// An interface is like a class, except it can't be
// instantiated and (mostly) does not have its own logic.
public interface List61B<T> {
    // no constructor, you can't make List61B directly!!
    // it's an interface! not a class!!
    /** Inserts item into given position.*/
    public void insert(T x, int position);

    /** Inserts an item at the front. */
    public void addFirst(T x);

    /** Inserts X into the back of the list. */
    public void addLast(T x);

    /** Gets an item from the front. */
    public T getFirst();

    /** Returns the item from the back of the list. */
    public T getLast();

    /** Gets the ith item in the list (0 is the front). */
    public T get(int i);

    /** Returns the number of items in the list. */
    public int size();

    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast();

    public default void print() {
        System.out.print("[");
        for (int i = 0; i < size(); i += 1) {
            System.out.print(get(i) + ", ");
        }
        System.out.println("]");
    }
}