import dataStructures.Comparator;

import java.io.Serial;

/**
 * Compares cities by the order used to list them:
 * country first (ascending alphabetical order), then population (descending order)
 * and then city name (ascending alphabetical order)
 * @author André Amante, Guilherme Teixeira
 */
public class CityListingComparator implements Comparator<City> {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Comparator by the order indicated above
     * @param c1 first city being compared
     * @param c2 second city being compared
     * @return a negative integer, zero or a positive integer as c1 comes before,
     * is equivalent to or comes after c2 in the listing order, respectively
     */
    @Override
    public int compare(City c1, City c2) {
        int cmp = c1.getCountryName().compareTo(c2.getCountryName());
        if (cmp != 0) return cmp;
        cmp = Long.compare(c2.getPopulation(), c1.getPopulation());
        if (cmp != 0) return cmp;
        return c1.getCityName().compareTo(c2.getCityName());
    }
}
