package dataStructures;

import dataStructures.exceptions.*;

/**
 *  Sequence Linked List
 * @author AED  Team
 * @version 1.0
 * @param <E> Generic Element
 *
 */
abstract class SequenceLinkedList<E> extends LinkedList<E> implements List<E>{
       /**
     * Constructor of an empty singly linked list.
     * head and tail are initialized as null.
     * currentSize is initialized as 0.
     */
    public SequenceLinkedList(){
        super();
    }
    /**
     * Returns the first element of the list.
     *
     * @return first element in the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E getFirst() {
        if ( this.isEmpty() )
            throw new NoSuchElementException();
        return head.getElement();
    }
    /**
     * Returns the last element of the list.
     *
     * @return last element in the list
     * @throws NoSuchElementException - if size() == 0
     */

    public E getLast() {
        if ( this.isEmpty() )
            throw new NoSuchElementException();
        return tail.getElement();
    }
    /**
     * Returns the element at the specified position in the list.
     * Range of valid positions: 0, ..., size()-1.
     * If the specified position is 0, it corresponds to getFirst.
     * If the specified position is size()-1, get corresponds to getLast.
     *
     * @param position - position of the element to be returned
     * @return element at position
     * @throws InvalidPositionException if position is not valid in the list
     */

    public E get(int position) {
        if ( position < 0 || position >= currentSize )
            throw new InvalidPositionException();
        if (position == 0)
            return getFirst();
        if (position == currentSize-1)
            return getLast();
        return getNode(position).getElement();
    }

    /**
     * Return the node in the given position
     * @param position
     * @return
     */
    LinkedNode<E> getNode(int position) {
        LinkedNode<E> node = head;
        for ( int i = 0; i < position; i++)
            node = node.getNext();
        return node;
    }
    /**
     * Returns the position of the specified element in the list
     * if the list contains the element.
     * Otherwise, returns -1.
     *
     * @param element - element to be searched in the list
     * @return position of the element in the list (or -1)
     */
    public int indexOf(E element) {
        //TODO: Left as an exercise.
        return 0;
    }

    /**
     * Inserts the specified element at the first position in the list.
     *
     * @param element to be inserted
     */
    public abstract void addFirst(E element);

    /**
     * Inserts the specified element at the last position in the list.
     *
     * @param element to be inserted
     */
    public abstract void addLast(E element) ;

     /**
     * Inserts the specified element at the specified position in the list.
     * Range of valid positions: 0, ..., size().
     * If the specified position is 0, add corresponds to addFirst.
     * If the specified position is size(), add corresponds to addLast.
     *
     * @param position - position where to insert the element
     * @param element  - element to be inserted
     * @throws InvalidPositionException - if position is not valid in the list
     */

    public void add(int position, E element) {
        if ( position < 0 || position > currentSize )
            throw new InvalidPositionException();
        if ( position == 0 )
            addFirst(element);
        else if ( position == currentSize )
            addLast(element);
        else
            addMiddle(position, element);
    }
    /**
     *
     * @param position
     * @param element
     */
    abstract void addMiddle(int position, E element);


    /**
     * Returns the previous node, and the node on this position
     * @param position
     * @pre position > 0 && position < size()
     * @return
     */
    pairNode<E> getNodes(int position){
        LinkedNode<E> prevNode = this.getNode(position - 1);
        return new pairNode<>(prevNode,prevNode.getNext());
    }
    /**
     * Removes and returns the element at the first position in the list.
     *
     * @return element removed from the first position of the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        return super.removeFirstNode();
    }

    /**
     * Removes and returns the element at the last position in the list.
     *
     * @return element removed from the last position of the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        if ( size() == 1 )
            return removeFirst();
        pairNode<E> pair= this.getNodes(size() - 1);
        return super.removeLastNode(pair);
    }
    /**
     * Removes and returns the element at the specified position in the list.
     * Range of valid positions: 0, ..., size()-1.
     * If the specified position is 0, remove corresponds to removeFirst.
     * If the specified position is size()-1, remove corresponds to removeLast.
     *
     * @param position - position of the element to be removed
     * @return element removed at position
     * @throws InvalidPositionException - if position is not valid in the list
     */
    @Override
    public E remove(int position) {
        if ( position < 0 || position >= currentSize )
            throw new InvalidPositionException();
        if ( position == 0 )
            return removeFirst();
        if ( position == currentSize - 1 )
            return removeLast();
        return removeMiddle(position);
    }
    /**
     * Remove in the middle of the list
     */
    E removeMiddle(int position) {
        return removeMiddleNode(position).node().getElement();
    }
    /**
     * Return the previous and the node in the given position
     */
    pairNode<E> removeMiddleNode(int position) {
        pairNode<E> pair=getNodes(position);
        super.removeMiddleNode(pair);
        return pair;
    }

    void addElem(E element){
        //TODO: Left as an exercise.
    }
}
