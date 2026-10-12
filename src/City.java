import java.io.Serial;
import java.io.Serializable;

/**
 * A city identified by its name and country.
 * The name keeps the capitalization with which it was added.
 * @author André Amante, Guilherme Teixeira
 */
public class City implements Serializable {
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
     */
    public City(String cityName, String countryName, long population) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.population = population;
    }

    /**
     * Getter for the city name.
     * @return the name of the city with original capitalization
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Getter for the country name.
     * @return the name of the country.
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Getter for the inhabitants.
     * @return the number of inhabitants
     */
    public long getPopulation() {
        return population;
    }
}
