package dataStructures;

/**
 * Predicate.
 * @author AED  Team
 * @version 1.0
 * @param <E> Generic Element
 *
 */
public interface Predicate<E> {
    /**
     *  Filter that an element needs to check
     * @param elem
     * @return
     */
    boolean check(E elem);
}
