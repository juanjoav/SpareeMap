package models;

public class Node<T> {

    protected T info;
    protected Node<T> next;

    public Node(T info) {
        this.info = info;
        next = null;
    }

    public Node(T info, Node<T> next) {
        this.info = info;
        this.next = next;
    }

    public T getInfo() {
        return this.info;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
