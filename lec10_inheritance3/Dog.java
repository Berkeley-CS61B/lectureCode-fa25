package lec10_inheritance3;

import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    public String name;
    public int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    public static class NameComparator implements Comparator<Dog> {
        @Override
        public int compare(Dog a, Dog b) {
            return a.name.compareTo(b.name);
        }
    }

    @Override
    public int compareTo(Dog other) {
        return size - other.size;
    }

    public static NameComparator NAME_COMPARATOR = new NameComparator();
}