package dataStructures;

import dataStructures.exceptions.NoSuchElementException;

/**
 * Implementation of Two Way Iterator for DLList 
 * @author AED  Team
 * @version 1.0
 * @param <E> Generic Element
 * 
 */
class TwoWayLinkedIterator<E> extends LinkedIterator<E>
        implements TwoWayIterator<E> {
    /**
     * Node with the last element in the iteration.
     */
    private final LinkedNode<E> lastNode;
    /**
     * Node with the previous element in the iteration.
     */
    private LinkedNode<E> prevToReturn;

    /**
     * DoublyLLIterator constructor
     *
     * @param first - Node with the first element of the iteration
     * @param last  - Node with the last element of the iteration
     */
    public TwoWayLinkedIterator(LinkedNode<E> first, LinkedNode<E> last) {
        super(first);
        prevToReturn=null;
        lastNode=last;
    }

    //TODO: Left as an exercise.
    

}
