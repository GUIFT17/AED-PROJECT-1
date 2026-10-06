package dataStructures;

import java.io.Serializable;

/**
 * Node Interface
 * @author AED  Team
 * @version 1.0
 * @param <E> Generic Element
 *
 */
public interface Node<E> extends Serializable {
    /**
     *
     * @return the element
     */
    E getElement();
}
