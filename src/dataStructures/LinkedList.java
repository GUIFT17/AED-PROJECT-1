package dataStructures;

import java.io.*;

/**
 * Linked List
 * Includes description of general methods to be implemented by linked lists.
 * @author AED  Team
 * @version 1.0
 * Space Complexity: O(n), n nodes, plus head, tail and currentSize
 * @param <E> Generic Element
 *
 */
abstract class LinkedList<E> implements Serializable {

    @Serial
    private static final long serialVersionUID = 0L;

    /**
     * Node at the head of the list.
     */
    transient LinkedNode<E> head;

    /**
     * Node at the tail of the list.
     */
    transient LinkedNode<E> tail;

    /**
     * Number of elements in the list.
     */
    transient int currentSize;

    /**
     * Constructor of an empty singly linked list.
     * head and tail are initialized as null.
     * currentSize is initialized as 0.
     * Time Complexity: O(1) at best and worst case
     */
    public LinkedList() {
        head = null;
        tail = null;
        currentSize = 0;
    }

    /**
     * Returns true iff the list contains no elements.
     * Time Complexity: O(1) at best and worst case
     * @return true if the list is empty
     */
    public boolean isEmpty() {
        //TODO: Left as an exercise.
        return currentSize == 0;
    }

    /**
     * Returns the number of elements in the list.
     * Time Complexity: O(1) at best and worst case
     * @return number of elements in the list
     */
    public int size() {
        //TODO: Left as an exercise.
        return currentSize;
    }

    /**
     * Returns an iterator of the elements in the list (in a proper sequence).
     * Time Complexity: O(1) at best and worst case
     * @return Iterator of the elements in the list
     */
    public Iterator<E> iterator() {
        return new LinkedIterator<>(head);
    }

    /**
     * Insert a node on the head of list
     * Time Complexity: O(1) at best and worst case
     * @param newNode
     */
    void addFirstNode(LinkedNode<E> newNode) {
        //TODO: Left as an exercise.
        newNode.setNext(head);
        head = newNode;
        if (tail == null)
            tail = newNode;
        currentSize++;
    }

    /**
     * Insert a node on the tail of list
     * Time Complexity: O(1) at best and worst case
     * @param newNode
     */
    void addLastNode(LinkedNode<E> newNode) {
        //TODO: Left as an exercise.
        newNode.setNext(null);
        if (head == null)
            head = newNode;
        else
            tail.setNext(newNode);
        tail = newNode;
        currentSize++;
    }

    /**
     * Record with two nodes (prev, node)
     *
     * @param prev
     * @param node
     */
    record pairNode<E>(LinkedNode<E> prev, LinkedNode<E> node) {
    }

    /**
     * Insert node (newNode) between pair.previous() and pair.node()
     * Time Complexity: O(1) at best and worst case
     * @param newNode
     * @pre: pair.previous()!=null && pair.node()!=null
     */
    void addMiddleNode(pairNode<E> pair, LinkedNode<E> newNode) {
        //TODO: Left as an exercise.
        newNode.setNext(pair.node());
        pair.prev().setNext(newNode);
        currentSize++;
    }

    /**
     * Removes the first node in the list.
     * Time Complexity: O(1) at best and worst case
     * @return
     * @pre: !isEmpty()
     */
    E removeFirstNode() {
        //TODO: Left as an exercise.
        E elem = head.getElement();
        head = head.getNext();
        if (head == null)
            tail = null;
        currentSize--;
        return elem;
    }

    /**
     * remove the last node (pair.node()) of the list
     * Time Complexity: O(1) at best and worst case
     * @return
     */
    E removeLastNode(pairNode<E> pair) {
        //TODO: Left as an exercise.
        E elem = pair.node().getElement();
        if (pair.prev() == null) {
            head = null;
            tail = null;
        } else {
            pair.prev().setNext(null);
            tail = pair.prev();
        }
        currentSize--;
        return elem;
    }

    /**
     * remove the node pair.node()
     * Time Complexity: O(1) at best and worst case
     * @param pair
     * @pre: pair.previous()!=null && pair.node()!=null
     */
    void removeMiddleNode(pairNode<E> pair) {
        //TODO: Left as an exercise.
        pair.prev().setNext(pair.node().getNext());
        currentSize--;
    }

    /**
     * Time Complexity: O(1) at best case (node is the first one) and O(n) at worst case
     * @param element
     * @return pair with the previous node and the element node, Or null if no element
     */
    pairNode<E> nodeOf(E element) {
        //TODO: Left as an exercise.
        LinkedNode<E> node = head;
        LinkedNode<E> prev = null;
        while (node != null) {
            if (node.getElement().equals(element))
                return new pairNode<>(prev, node);
            prev = node;
            node = node.getNext();
        }
        return null;
    }

    /**
     * Time Complexity: O(1) at best and worst case
     * @return first node
     */
    LinkedNode<E> getFirstNode() {
        //TODO: Left as an exercise.
        return head;
    }

    /**
     * Time Complexity: O(1) at best and worst case
     * @return last node
     */
    LinkedNode<E> getLastNode() {
        //TODO: Left as an exercise.
        return tail;
    }

    // MANUAL SERIALIZATION

    /**
     * Time Complexity: O(n) to best and worst cases, due the fact that he traverses
     * the nodes from the first to the last node (n times)
     * @param oos ObjectOutputStream object
     * @throws IOException if there is nothing to write on
     */
    @Serial
    private void writeObject(ObjectOutputStream oos) throws IOException {
        //TODO: Left as an exercise.
        writeData(oos);
        oos.writeInt(currentSize);
        LinkedNode<E> node = head;
        while (node != null) {
            oos.writeObject(node.getElement());
            node = node.getNext();
        }
    }

    /**
     * Time Complexity: O(n) to best and worst cases,
     * due the fact that he repeats the process (n times)
     * @param ois ObjectInputStream object
     * @throws IOException if there is nothing to read on
     * @throws ClassNotFoundException if no class was found
     */
    // MANUAL DESERIALIZATION
    @Serial
    @SuppressWarnings("unchecked")
    private void readObject (ObjectInputStream ois) throws IOException, ClassNotFoundException {
        //TODO: Left as an exercise.
        head = null;
        tail = null;
        currentSize = 0;
        readData(ois);
        int size = ois.readInt();
        for (int i = 0; i < size; i++) {
            addElem((E)ois.readObject());
        }
    }

    /**
     * Time Complexity: O(1) at best and worst case (only writes once)
     * @param out
     * @throws IOException
     */
    void writeData (ObjectOutputStream out) throws IOException {}

    /**
     * Time Complexity: O(1) at best and worst case (only reads once)
     * @param in
     * @throws IOException
     * @throws ClassNotFoundException
     */
    void readData (ObjectInputStream in) throws IOException, ClassNotFoundException {}

    abstract void addElem (E element);
}
