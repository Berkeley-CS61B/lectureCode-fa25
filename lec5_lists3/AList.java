package lec5_lists3;

// AList of integers
public class AList {
    public int size;
    public int[] contents;

    public AList() {
        size = 0;
        contents = new int[100];
    }

    // size: 3
    // contents: [6, 3, 9, -, -, -, -, ...]
    public void addLast(int x) {
        // I worked out a little example on paper
        // it felt right ot me that it should be
        // contents[size]
        contents[size] = x;
        size += 1;
    }

    // size: 3
    // contents: [6, 3, 9, -, -, -, -, ...]
    public int getLast() {
        return contents[size - 1];
    }

    public int size() {
        return size;
    }

    // size: 3
    // contents: [6, 3, 9, -, -, -, -, ...]
    public int get(int i) {
        if (i >= size) {
            throw new IndexOutOfBoundsException("You dummy too big of index.. mayb ei'm the dumy");
        }
        return contents[i];
    }

    // we're supposed to return the 9
    // size: 3
    // contents: [6, 3, 9, -, -, -, -, ...]
    public int removeLast() {
        int valueToReturn = getLast();
        // contents[size - 1] = 0; (purist or not, monk decisions)
        size = size - 1;
        return valueToReturn;
    }
}
