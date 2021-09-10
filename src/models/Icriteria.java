package models;

import java.util.Comparator;

public interface Icriteria<T> {
    public boolean isGood(T a);
    public T [] createList(int size);
    public T[] finder(T[] a);
    public boolean find(T o1);
}
