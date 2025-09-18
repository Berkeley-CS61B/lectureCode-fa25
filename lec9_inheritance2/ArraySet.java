package lec9_inheritance2;

import java.util.Iterator;

public class ArraySet<T> implements Iterable<T> {
    private T[] items;
    private int size; // the next item to be added will be at position size

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for (int i = 0; i < size; i += 1) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map.
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("can't add null");
        }
        if (contains(x)) {
            return;
        }
        items[size] = x;
        size += 1;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    // how does a wizard know where it is?

    private class WizardIterator implements Iterator<T> {
        private int wizPos;

        public WizardIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < size();
        }

        @Override
        public T next() {
            T thingToReturn = items[wizPos];
            wizPos += 1;
            return thingToReturn;
        }
    }

    // we need to return some sort of object that has a
    // hasNext function and a next function
    public Iterator<T> iterator() {
        return new WizardIterator();
    }

    @Override
    public String toString() {
        StringBuilder stuff = new StringBuilder("{");
        for (T x : this) {
            stuff.append(x).append(", ");
        }
        stuff.append("}");
        return stuff.toString();
    }

    public boolean equals(Object o) {
        if (this == o) { return true; }
        // check if o is an ArraySet
        // and if it is start comparing the things in that array set
        if (o instanceof ArraySet uddaArraySet) {
            if (size != uddaArraySet.size) {
                return false;
            }
            for (T x : this) {
                if (!uddaArraySet.contains(x)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);

        /* won't work yet: */
        for (int i : aset) {
            System.out.println(i);
        }

        // JAVA COuld have been designed such that if an
        // iterator method exists, then : aset works fine
        // because ti would realize "hey this method exists"
        // but that's not how type checking works in Java
        //
         // Type checking in Java is very formal, and we
        // have to explicitly state hypernym/hyponym relationships
        // using implements (and later extends)
        System.out.println(aset);

    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}
