package dataStructures;

import dataStructures.exceptions.NoSuchElementException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Sorted linked list Implementation
 * @author AED  Team
 * @version 1.0
 * Space Complexity: O(n) heritage n nodes
 * @param <E> Generic Element
 * 
 */
public class SortedLinkedList<E> extends LinkedList<E> implements SortedList<E> {

    /**
     * Comparator of elements.
     */
    private final Comparator<E> comparator;

    /**
     * Constructor of an empty sorted singly linked list.
     * head and tail are initialized as null.
     * currentSize is initialized as 0.
     * Time Complexity: O(1) at best and worst cases
     */
    public SortedLinkedList(Comparator<E> comparator) {
        super();
        this.comparator = comparator;
    }

    /**
     * Returns the first element of the list.
     * Time Complexity: O(1) at best and worst cases
     * @return first element in the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E getMin( ) {
        //TODO: Left as an exercise.
        if (isEmpty())
            throw new NoSuchElementException();
        return getFirstNode().getElement();
    }

    /**
     * Returns the last element of the list.
     * Time Complexity: O(1) at best and worst cases
     * @return last element in the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E getMax( ) {
        //TODO: Left as an exercise.
        if (isEmpty())
            throw new NoSuchElementException();
        return getLastNode().getElement();
    }

    /**
     * Returns the first occurrence of the element equals to the given element in the list.
     * Time Complexity: O(1) at best case (node is the first one) and O(n) at worst case
     * @return element in the list or null
     */
    @Override
    public E get(E element) {
        //TODO: Left as an exercise.
        pairNode<E> pair = searchNode(element);
        return pair == null ? null : pair.node().getElement();
    }

    /**
     * Returns true iff the element exists in the list.
     * Time Complexity: O(1) at best case (element is the first one) and O(n) at worst case
     * @param element to be found
     * @return true iff the element exists in the list.
     */
    public boolean contains(E element) {
        //TODO: Left as an exercise.
        return searchNode(element) != null;
    }

    /**
     * Inserts the specified element at the list, according to the comparator order.
     * If there is an equal element, the new element is inserted after it.
     * Time Complexity: O(1) at best case (adds in the first one) and O(n) at worst case
     * @param element to be inserted
     */
    public void add(E element) {
        //TODO: Left as an exercise.
        if (isEmpty() || comparator.compare(getLastNode().getElement(), element) <= 0)
            addLast(element);
        else if (comparator.compare(getFirstNode().getElement(), element) > 0)
            addFirst(element);
        else {
            LinkedNode<E> prev = getFirstNode();
            LinkedNode<E> node = prev.getNext();
            while (comparator.compare(node.getElement(), element) <= 0) {
                prev = node;
                node = node.getNext();
            }
            addBeforeNode(element, prev);
        }
        assert invariant();
        }

    /**
     * Inserts the element before node after.
     * Precondition: after is not the head of the list.
     * Time Complexity: O(1) at best and worst cases
     * @param element - Element to be inserted
     * @param before - Node to be previous to the new node
     */
    void addBeforeNode(E element, LinkedNode<E> before) {
        //TODO: Left as an exercise.
        addMiddleNode(new pairNode<>(before, before.getNext()),
                new SinglyListNode<>(element));
    }

    /**
     * Inserts the element at the first position in the list.
     * Time Complexity: O(1) at best and worst cases
     * @param element - Element to be inserted
     */
    void addFirst( E element ) {
        //TODO: Left as an exercise.
        addFirstNode(new SinglyListNode<>(element));
    }

    /**
     * Inserts the element at the last position in the list.
     * Time Complexity: O(1) at best and worst cases
     * @param element - Element to be inserted
     */
    void addLast( E element ) {
        //TODO: Left as an exercise.
        addLastNode(new SinglyListNode<>(element));
    }

    /**
     * Removes and returns the first occurrence of the element equals to the given element in the list.
     * Time Complexity: O(1) at best case (is the first one to remove) and O(n) at worst case
     * @return element removed from the list or null if !belongs
     */
    public E remove(E element) {
        //TODO: Left as an exercise.
        pairNode<E> pair = searchNode(element);
        if (pair == null)
            return null;
        E rem;
        if (pair.prev() == null)
            rem = removeFirstNode();
        else if (pair.node().getNext() == null)
            rem = removeLastNode(pair);
        else {
            rem = pair.node().getElement();
            removeMiddleNode(pair);
        }
        assert invariant();
        return rem;
    }

    /**
     * Adds an element to a SortedLinkedList.
     * Time Complexity: O(1) at best and worst cases
     * @param element
     */
    void addElem(E element) {
        //TODO: Left as an exercise.
        addLast(element);
    }

    /**
     * Checks the internal consistency of the list.
     * Time Complexity: O(1) at best case (empty list or a violation found in the fisrt node)
     * and O(n) at worst case
     * @return true if the list is consistent
     */
    private boolean invariant() {
        //TODO: Left as an exercise.
        if (currentSize == 0)
            return head == null && tail == null;
        if (head == null || tail == null || tail.getNext() != null)
            return false;
        int count = 1;
        LinkedNode<E> node = head;
        while (node.getNext() != null) {
            if (comparator.compare(node.getElement(), node.getNext().getElement()) > 0)
                return false;
            node = node.getNext();
            count++;
        }
        return node == tail && count == currentSize;
    }

    /**
     * Search for a specified node
     * Time Complexity: O(1) at best case (node is the first one) and O(n) at worst case
     * @param element
     * @return a pair of nodes if , nothing if not existent
     */
    private pairNode<E> searchNode(E element) {
        LinkedNode<E> prev = null;
        LinkedNode<E> node = getFirstNode();
        while (node != null) {
            int comp =  comparator.compare(node.getElement(), element);
            if (comp == 0)
                return new pairNode<>(prev, node);
            if (comp > 0)
                return null;
            prev = node;
            node = node.getNext();
        }
        return null;
    }

    /**
     * Time Complexity: O(1) at best and worst case (only writes once)
     * @throws IOException
     */
    void writeData(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject(); // write the normal attributes
    }

    /**
     * Time Complexity: O(1) at best and worst case (only reads once)
     * @throws IOException
     * @throws ClassNotFoundException
     */
    void readData(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject(); // read the normal attributes
    }
}
