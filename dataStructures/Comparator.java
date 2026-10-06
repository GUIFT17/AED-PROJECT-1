package dataStructures;

import java.io.Serializable;

/**
 *  Comparator interface
 * @author AED  Team
 * @version 1.0
 * @param <E> Generic Element
 *
 */
public interface Comparator<E> extends Serializable {
    /**
     * Compares its two arguments for order.
     * Returns a negative integer, zero, or a positive integer as the first argument
     * is less than, equal to, or greater than the second.
     * Must ensure that:
     * signum(compare(x, y)) == -signum(compare(y, x)) for all x and y.
     * relation is transitive: ((compare(x, y)>0) && (compare(y, z)>0)) implies compare(x, z)>0.
     * compare(x, y)==0 implies that signum(compare(x, z))==signum(compare(y, z)) for all z.
     * @param x
     * @param y
     * @return
     */
    int compare(E x, E y);
}
