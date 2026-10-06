package dataStructures;

import java.io.*;

/**
 * Linked List
 * Includes description of general methods to be implemented by linked lists.
 * @author AED  Team
 * @version 1.0
 * @param <E> Generic Element
 *
 */
abstract class LinkedList<E> implements Serializable {
    @Serial
    private static final long serialVersionUID = 0L;
    /**
     *  Node at the head of the list.
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
     */
    public LinkedList(){
        head=null;
        tail=null;
        currentSize=0;
    }
    /**
     * Returns true iff the list contains no elements.
     * @return true if the list is empty
     */
    public boolean isEmpty() {
	//TODO: Left as an exercise.
        return true;
    }
    /**
     * Returns the number of elements in the list.
     * @return number of elements in the list
     */
    public int size() {
	//TODO: Left as an exercise.
        return 0;
    }

    /**
     * Returns an iterator of the elements in the list (in a proper sequence).
     * @return Iterator of the elements in the list
     */
    public Iterator<E> iterator() {
        return new LinkedIterator<>(head);
    }

    /**
     * Insert a node on the head of list
     * @param newNode
     */
    void addFirstNode(LinkedNode<E> newNode){
        //TODO: Left as an exercise.
    }
    /**
     * Insert a node on the tail of list
     * @param newNode
     */
    void addLastNode(LinkedNode<E> newNode){
	//TODO: Left as an exercise.
    }
    /**
     * Record with two nodes (prev, node)
     * @param prev
     * @param node
     */
    record pairNode<E>(LinkedNode<E> prev, LinkedNode<E> node){}

    /**
     * Insert node (newNode) between pair.previous() and pair.node()
     * @pre: pair.previous()!=null && pair.node()!=null
     * @param newNode
     */
    void addMiddleNode(pairNode<E> pair,LinkedNode<E> newNode){
 	//TODO: Left as an exercise.
    }
    /**
     * Removes the first node in the list.
     * @pre: !isEmpty()
     * @return
     */
    E removeFirstNode(){
 	//TODO: Left as an exercise.
	return null;
    }

    /**
     * remove the last node (pair.node()) of the list
     * @return
     */
    E removeLastNode(pairNode<E> pair){
	//TODO: Left as an exercise.
        return null;
    }
    /**
     * remove the node pair.node()
     @pre: pair.previous()!=null && pair.node()!=null
     * @param pair
     */
    void removeMiddleNode(pairNode<E> pair) {
        //TODO: Left as an exercise.
    }

    /**
     *
     * @param element
     * @return pair with the previous node and the element node, Or null if no element
     */
    pairNode<E>  nodeOf(E element){
        //TODO: Left as an exercise.
        return null;
    }

    LinkedNode<E> getFirstNode(){
        //TODO: Left as an exercise.
        return null;
    }

    LinkedNode<E> getLastNode(){
        //TODO: Left as an exercise.
        return null;
    }
     // MANUAL SERIALIZATION
    @Serial
    private void writeObject(ObjectOutputStream oos) throws IOException {
        //TODO: Left as an exercise.
    }

    // MANUAL DESERIALIZATION
    @Serial
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        //TODO: Left as an exercise.
    }

    void writeData(ObjectOutputStream out) throws IOException{
    }

    void readData(ObjectInputStream in) throws IOException, ClassNotFoundException {
    }

    abstract void addElem(E element);
}
