package lec7_lists4.resizeExercise;

public class AList {
    private int size;
    private int[] items;

    public AList() {
        size = 0;
        items = new int[100];
    }

    // [3, 4, 2, 0, 0, 0, ....]
    //           ^ (size = 3)
    // size is the location of the next add
    // size - 1 location of the last item

    public void addLast(int x) {
        items[size] = x;
        size += 1;
    }

    public int getLast() {
        return items[size - 1];
    }

    public int get(int i) {
        return items[i];
    }

    public int removeLast() {
        int itemToReturn = getLast();
        size -= 1;
        return itemToReturn;
    }
}
