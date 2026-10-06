package dataStructures;
import dataStructures.exceptions.NoSuchElementException;


/**
 *  Doubly Linked List
 * @author AED  Team
 * @version 1.0
 * @param <E> Generic Element
 *
 */
public class DoublyLinkedList<E> extends SequenceLinkedList<E> implements TwoWayList<E> {

    /**
     * Constructor of an empty double linked list.
     * head and tail are initialized as null.
     * currentSize is initialized as 0.
     */
    public DoublyLinkedList( ) {
        super();
    }


    /**
     * Returns a two-way iterator of the elements in the list.
     *
     * @return Two-Way Iterator of the elements in the list
     */
    public TwoWayIterator<E> twoWayiterator() {
        return new TwoWayLinkedIterator<>(head, tail);
    }
    /**
     * Inserts the element at the first position in the list.
     * @param element - Element to be inserted
     */
    public void addFirst( E element ) {
        //TODO: Left as an exercise.
    }
    /**
     * Inserts the element at the last position in the list.
     * @param element - Element to be inserted
     */
    public void addLast( E element ) {
       //TODO: Left as an exercise.
    }
    /**
     * Inserts the specified element at the specified position in the list.
     * Pre-condition: position ranges from 1 to currentSize-1.
     * @param position - middle position for insertion of element
     * @param element - element to be inserted at middle position
     */
    void addMiddle( int position, E element ) {
        //TODO: Left as an exercise.
    }
    /**
     * Removes and returns the element at the first position in the list.
     * @return element removed from the first position of the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E removeFirst( ) {
       //TODO: Left as an exercise.
    }

    /**
     * Removes the node from the specified position of the list.
     * Pre-condition: the position is neither 0 nor the currentSize of the list.
     * @param position - position of node to be removed
     * @return element removed from the first position of the list
     */
    E removeMiddle( int position ) {
        //TODO: Left as an exercise.
    }

    pairNode<E> getNodes(int position){
        //TODO: Left as an exercise.
    }
}
