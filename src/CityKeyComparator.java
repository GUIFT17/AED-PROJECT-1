import dataStructures.Comparator;

import java.io.Serial;

/**
 * Compares cities by their identity:
 * country first (ascending order) and then city name, cities are equal iff they have the
 * same country name and the same city name
 * @author André Amante, Guilherme Teixeira
 */
public class CityKeyComparator implements Comparator<CityClass> {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Comparator by the order indicated above
     * @param c1 first city being compared
     * @param c2 second city being compared
     * @return a negative integer, zero or a positive integer as c1 is less than,
     * equal to or greater than c2, respectively
     */
    @Override
    public int compare(CityClass c1, CityClass c2) {
        int cmp = c1.getCountryName().compareTo(c2.getCountryName());
        if (cmp != 0) return cmp;
        return c1.getCityName().compareToIgnoreCase(c2.getCityName());
    }
}
