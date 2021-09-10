/*
 * Copyright (c) 6/9/2021.
 * Created by Juan Jose Ariza Velasco and Harrison Diaz
 * All rights reserved
 */

package models;

import java.util.Comparator;

/**
 * Esta clase permite modificar una lista enlazada
 * @param <T>
 */
public class SortList<T> extends SimpleList<T>{

    private Comparator<T> comparator;

    public SortList() {
        super();
    }

    public SortList(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void remove(T info, Comparator<T> tComparator) {
        super.remove(info, tComparator);
    }
}
