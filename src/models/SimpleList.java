package models;

import java.util.Comparator;
import java.util.LinkedList;

public class SimpleList<T> {

    private Node<T> head;
    private Node<T> current;

    public SimpleList() {
        this.head = null;
        this.current = head;
    }

    public SimpleList(T info) {
        this.head = new Node(info);
        this.current = head;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public Node<T> getCurrent() {
        return current;
    }

    /**
     * Determina si la lista contiene elementos
     * complejidad : 0(1) constante
     * para todos los casos son constantes
     * @return True si esta vacia False si contiene elementos
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Este metodo adiciona un elemento a la lista
     * @param info el elemento a adicionar
     */
    public void add (T info) {
        if (this.head==null) {
            this.head = new Node<>(info);
        } else {
            Node<T> aux = this.head;
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = new Node<>(info);
        }
    }

    /**
     * Este metodo permite saber si el elemento buscado de encuentra disponible
     * @param info la info a buscar que puede ser de tipo T
     * @param tComparator el criterio por el cual se realizan las comparaciones
     * @return True si lo encuentra o False si no
     */
    public boolean isAvailable(T info, Comparator<T> tComparator){
        if (this.head != null) {
            Node<T> aux = this.head;
            while(aux != null ){
                if(tComparator.compare(info, aux.info) == 0) {
                    return true;
                }
                aux = aux.next;
            }
        }
        return false;
    }

    /**
     * Este metodo permite eliminar un elemento de la lista
     * @param info
     * @param tComparator
     */
    public void remove(T info, Comparator<T> tComparator) {
        if (isAvailable(info, tComparator)) {
            Node<T> aux = this.head;
            Node<T> auxNext = this.head.next;
            System.out.println("--->" + aux.getInfo());
            while(aux != null && auxNext != null ){
                if(tComparator.compare(info, aux.info) == 0) {
                    aux.info = auxNext.info;
                    info = auxNext.info;
                }
                aux = aux.next;
                auxNext = aux.next;
            }
            aux.info = null;
        }
    }

    /**
     * Este metodo permite eliminar un elemento de la lista
     * @param info el objeto que se desea eliminar
     * @return True si elimino el objeto y False si no lo elimino
     */
    public boolean delete(T info){
        //boolean status = false;
//        if (head != null) {
//            Node<T> aux = this.head;
//            if (info != aux.getInfo()) {
//                while (aux.getNext() != null){
//                    if(info != aux.next.info){
//                        aux = aux.next;
//                        //status = true;
//                    } else {
//                        aux.next = aux.next.getNext();
//                    }
//                }
//                //status = true;
//            } else {
//                this.head = aux.next;
//            }
//        }
//        return false;
        //public boolean remove(T data) {
            if (!isEmpty()) {
                if (this.head.info.equals(info)) {
                    this.head = this.head.next;
                    return true;
                } else {
                    Node<T> actual = this.getHead();
                    while (actual.next != null) {
                        if (actual.next.info.equals(info)) {
                            actual.next = actual.next.next;
                            return true;
                        }
                        actual = actual.next;
                    }
                }
            }

            return false;
      //  }
    }

    /**
     * Este metodo inserta un elemento al comienzo de la lista
     * @param info el info que se va ha agregar al comienzo de la lista este es de tipo T
     */
    public void insert(T info) {
//        Node newNode = new Node(info);
//        newNode.next = head;
//        head = newNode;
        this.head = new Node<>(info, this.head);
    }

    public boolean search(T info){
        if(head == null) {
            return false;
        }

        Node current = head;
        while(current != null) {
            if(current.info == info) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void sortList(Comparator<T> tComparator) {
        Node current = null;
        Node index = null;
        T temp;
        if(getHead() == null) {
            return;
        }
        else {
            for(current = getHead(); current.next != null; current = current.next) {
                for(index = current.next; index != null; index = index.next) {
                    if (tComparator.compare((T)current.info, (T)index.getInfo()) > 0) {
                        temp = (T)current.info;
                        current.info = index.info;
                        index.info = temp;
                    }
                }
            }
        }
    }

    public SimpleList<T> find(Icriteria<T> iCriteria){
        SimpleList<T> auxSimple = new SimpleList<>();
        Node<T> aux = this.head;
        if (this.head != null) {
            while (aux!=null){
                if(iCriteria.find(aux.info)){
                    auxSimple.add(aux.info);
                }
                aux = aux.next;
            }
        }
        return auxSimple;
    }

    public SimpleList<T> findCriter(Icriteria<T> iCriteria, Comparator<T> comparator){
        SimpleList<T> auxSimple = new SimpleList<>();
        SimpleList<T> result = new SimpleList<>();
        //SimpleList<T> icretiraSimple= new SimpleList<>();
        Node<T> aux = this.head;
        if (this.head != null) {
            auxSimple = find(iCriteria);
            auxSimple.sortList(comparator);
        }
        return result;
    }

}
