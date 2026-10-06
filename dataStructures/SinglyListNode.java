package dataStructures;
import java.io.Serial;
import java.io.Serializable;

/**
 * Singly List Node Implementation
 * @author AED  Team
 * @version 1.0
 * @param <E> Generic Element
 *
 */
class SinglyListNode<E> implements LinkedNode<E> {

    /**
     * Element stored in the node.
     */
    private E element;

    /**
     * (Pointer to) the next node.
     */
    private LinkedNode<E> next;

    /**
     *
     * @param theElement - The element to be contained in the node
     * @param theNext - the next node
     */
    public SinglyListNode( E theElement, SinglyListNode<E> theNext ) {
        element = theElement;
        next = theNext;
    }

    /**
     *
     * @param theElement to be contained in the node
     */
    public SinglyListNode( E theElement ) {
        this(theElement, null);
    }

    /**
     *
     * @return the element contained in the node
     */
    public E getElement( ) {
        return element;
    }

    /**
     *
     * @return the next node
     */
    public LinkedNode<E> getNext( ) {
        return next;
    }

    /**
     *
     * @param newElement - New element to replace the current element
     */
    public void setElement( E newElement ) {
        element = newElement;
    }

    /**
     *
     * @param newNext - node to replace the next node
     */
    public void setNext( LinkedNode<E> newNext ) {
        next = newNext;
    }
}
