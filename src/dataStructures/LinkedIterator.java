package dataStructures;

import dataStructures.exceptions.NoSuchElementException;

/**
 * Implementation of an Iterator for Linked List
 * @author AED  Team
 * @version 1.0
 * Space Complexity: O(1) only saves two references
 * @param <E> Generic Element
 *
 */
class LinkedIterator<E>  implements Iterator<E> {

    /**
     * First node of the list.
     */
    private final LinkedNode<E> first;

    /**
     * Node with the next element in the iteration.
     */
    LinkedNode<E> nextToReturn;

    /**
     * SinglyIterator constructor
     * Time Complexity: O(1)
     * @param first - Node with the first element of the iteration
     */
    public LinkedIterator(LinkedNode<E> first) {
        this.first=first;
        nextToReturn=first;
    }

    /**TODO: Left as an exercise.
     *
     * Time Complexity: O(1)
     * @return true if it has next and false otherwise
     */
    @Override
    public boolean hasNext() {
        return nextToReturn != null;
    }

    /**
     * Time Complexity: O(1)
     * @return next element
     */
    @Override
    public E next() {
        if (nextToReturn == null)
            throw new NoSuchElementException();
        E elem =  nextToReturn.getElement();
        nextToReturn = nextToReturn.getNext();
        return elem;
    }

    /**
     * Rewind to the first element
     * Time Complexity: O(1)
     */
    @Override
    public void rewind() {
        nextToReturn=first;
    }
}
