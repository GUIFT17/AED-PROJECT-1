package dataStructures;

/**
 * Node Interface
 * @author AED  Team
 * @version 1.0
 * @param <E> Generic element
 */

interface InfoNode<E> extends Node<E>{

    /**
     * Update the element
     * @param elem
     */
    void setElement(E elem);
}
