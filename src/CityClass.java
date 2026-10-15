import java.io.Serial;
import java.io.Serializable;

/**
 * A city identified by its name and country.
 * The name keeps the capitalization with which it was added.
 * @author André Amante 70945, Guilherme Teixeira 67917
 * Space Complexity: O(1) per city.
 */
public class CityClass implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final String cityName;
    private final String countryName;
    private final long population;

    /**
     * Constructor of a city.
     * @param cityName the name of the city with original capitalization
     * @param countryName the name of the country
     * @param population the number of inhabitants
     * Time Complexity: O(1) at best and worst scenario
     */
    public CityClass(String cityName, String countryName, long population) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.population = population;
    }

    /**
     * Getter for the city name.
     * @return the name of the city with original capitalization
     * Time Complexity: O(1) at best and worst scenario
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Getter for the country name.
     * @return the name of the country.
     * Time Complexity: O(1) at best and worst scenario
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Getter for the inhabitants.
     * @return the number of inhabitants
     * Time Complexity: O(1) at best and worst scenario
     */
    public long getPopulation() {
        return population;
    }
}
