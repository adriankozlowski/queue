package pl.sda;

import java.util.Collection;
import java.util.Iterator;

public class Queue implements java.util.Queue {
    private Node head;
    private Node tail;
    private int size = 0;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        if (head == null) {
            head = new Node(o);
            tail = head;
        } else {
            Node node = new Node(o);
            tail.setNext(node);
            tail = node;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public boolean addAll(Collection c) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        System.gc();
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public boolean offer(Object o) {
        return add(o);
    }

    @Override
    public Object remove() {
        return null;
    }

    @Override
    public Object poll() {
        Node toReturn = head;
        if (head != null) {
            head = toReturn.getNext();
            size--;
        }
        return toReturn.getValue();
    }

    @Override
    public Object element() {
        if (head == null) {
            throw new NullPointerException();
        }
        return head;
    }

    @Override
    public Object peek() {
        return head;
    }
}
