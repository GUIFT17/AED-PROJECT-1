package dataStructures;

import dataStructures.exceptions.NoSuchElementException;

import java.io.Serializable;

    /**
     *  Sorted List (sequence) Abstract Data Type
     * Includes description of general methods to be implemented by sorted lists.
     * NOTE: all implementations of this interface must have
     * in the constructor a comparator for the generic type E
     * The ordering criteria must be consistent with the equality criteria.
     * @author AED  Team
     * @version 1.0
     * @param <E> Generic Element
     *
     */

    public interface SortedList<E> extends Serializable {

        /**
         * Returns true iff the list contains no elements.
         * @return true if the list is empty
         */
        boolean isEmpty( );

        /**
         * Returns the number of elements in the list.
         * @return number of elements in the list
         */
        int size( );

        /**
         *  Returns an iterator of the elements in the list (in natural order).
         * @return Iterator of the elements in the list
         */
        Iterator<E> iterator( );

        /**
         * Returns the first element of the list.
         * @return first element in the list
         * @throws NoSuchElementException - if size() == 0
         */
        E getMin( ) throws NoSuchElementException;

        /**
         * Returns the last element of the list.
         * @return last element in the list
         * @throws NoSuchElementException - if size() == 0
         */
        E getMax( ) throws NoSuchElementException;
        /**
         *
         * @param element to be found
         * @return true iff the element exists in the list.
         */
        boolean contains(E element );

        /**
         * Returns the first occurrence of the element equals to the given element in the list.
         * @param element to be got
         * @return element in the list or null
         */
        E get(E element );
        /**
         * Inserts the specified element at the list, according to the natural order.
         * If there is an equal element, the new element is inserted after it.
         * @param element to be inserted
         */
        void add( E element );

        /**
         * Removes and returns the first occurrence of the element equals to the given element in the list.
         * @param element to be removed
         * @return element removed from the list or null if !belongs
         */
        E remove(E element);

}
