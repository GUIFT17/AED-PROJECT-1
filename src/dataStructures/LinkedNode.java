package dataStructures;
/**
 * Linked Node (with next)
 *
 * @author AED team
 * @version 1.0
 *
 * @param <E> Generic Element
 */
interface LinkedNode<E> extends InfoNode<E> {
    /**
     *
     * @return
     */
    LinkedNode<E> getNext( );

    /**
     *
     * @param newNext
     */
    void setNext(LinkedNode<E> newNext);
}
