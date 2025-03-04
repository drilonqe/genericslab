package edu.grinnell.csc207.genericslab;

/**
 *
 * @author Drilon and Emily
 * @param <T>
 */
public class LinkedList<T> {

    public class Node<T> {

        public T value;
        public Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public Node<T> first;
    public int size;

    public LinkedList() {
        this.first = null;
        this.size = 0;
    }

    public void add(T value) {
        if (first == null) {
            first = new Node<>(value, null);

        } else {
            Node<T> cur = first;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node<>(value, null);

        }
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> cur = first;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }

    public int size() {
        return size;
    }

    public T remove(int index) {
        if (index < 0 || (index == 0 && first == null)) {
            throw new IndexOutOfBoundsException(index);
        } else if (index == 0) {
            T ret = first.value;
            first = first.next;
            return ret;
        } else {
            int origIndex = index;
            Node<T> cur = first;
            while (index > 1 && cur.next != null) {
                index -= 1;
                cur = cur.next;
            }
            if (cur.next == null) {
                throw new IndexOutOfBoundsException(origIndex);
            } else {
                T ret = cur.next.value;
                cur.next = cur.next.next;
                return ret;
            }
        }
    }

    /**
     * inserts sep in between each element of this list.
     */
    public void intersperse(T sep) {
        Node<T> cur = first;
        while (cur.next != null) {
            Node<T> newNode = new Node<>(sep, cur.next);
            cur.next = newNode;
            cur = newNode.next;
            size++;
        }
    }

    /**
     * This method cannot be implemented for a generic T because finding the
     * maximum requires comparing elements, which we cannot do with generics.
     *
     * returns the maximum element found in the list.
     *
     */
    public T maximum() {
        throw new UnsupportedOperationException();
    }

    /**
     * This method cannot be implemented for all generic types T because we
     * cannot compare generic T elements between each other.
     *
     * sorts this list using the insertion sort algorithm. Insertion sort
     * proceeds by looping over the elements of the array, maintaining the
     * following invariant:
     */
    public void insertionSort() {
        throw new UnsupportedOperationException();
    }

    /**
     * Implemented referring to the reading arrayToString func using
     * StringBuilder returns a string representation of the list in the form:
     * [x1, x2, ..., xk] where x1, x2, ..., xk are the elements of the list.
     *
     * @param <T>
     * @return List as a string
     */
    public String ToString() {
        StringBuilder buf = new StringBuilder();
        buf.append('[');
        Node<T> cur = first;
        while (cur != null) {
            buf.append(String.valueOf(cur.value));
            buf.append(", ");
            cur = cur.next;
        }
        buf.append(']');
        return buf.toString();
    }

}
