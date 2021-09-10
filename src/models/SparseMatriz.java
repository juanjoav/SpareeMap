package models;

import java.util.Comparator;

public class SparseMatriz<TR, TC, C> {

    private SortList<Cell<TR, TC, C>> cellList;
    private SimpleList<TC> columns;
    private SimpleList<TR> rows;

    public SparseMatriz() {
        this.cellList = new SortList<>();
        this.columns = new SimpleList<>();
        this.rows = new SimpleList<>();
    }

    public SimpleList<Cell<TR, TC, C>> getCellList() {
        return cellList;
    }

    /**
     * Este metodo agrega un elemento a la matriz
     * @param info el valor a agregar
     * @param row el valor de la fila
     * @param column el valor de la columna
     */
    public void add(C info, TR row, TC column) {
        columns.add(column);
        rows.add(row);
        cellList.add(new Cell<TR,TC,C>(row, column, info));
    }

    /**
     * Metodo de insertar un elemento al principio de la matrix
     * @param info el elemento de la celda
     * @param row el valor de la fila
     * @param column el valor de la columna
     */
    public void insert(C info, TR row, TC column) {
        columns.insert(column);
        rows.insert(row);
        cellList.insert(new Cell<TR,TC,C>(row, column, info));
    }

    /**
     * Metodo para remover un elemento
     * @param info el elemento a ver
     * @param comparator el comparador
     */
    public void remove(Cell<TR, TC, C> info, Comparator<Cell<TR, TC, C>> comparator ) {
        cellList.remove(info,  comparator);
    }
}
