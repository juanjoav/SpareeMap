/*
 * Copyright (c) 6/9/2021.
 * Created by Juan Jose Ariza Velasco and Harrison Diaz
 * All rights reserved
 */

package models;

public class Cell <TR, TC, C> {

    protected  C info;
    protected TC column;
    protected TR row;

    public Cell(TR row, TC column, C info) {
        this.info = info;
        this.column = column;
        this.row = row;
    }

    public C getInfo() {
        return info;
    }

    public TC getColumn() {
        return column;
    }

    public TR getRow() {
        return row;
    }
}
