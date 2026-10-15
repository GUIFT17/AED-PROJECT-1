import java.io.*;

import dataStructures.SortedLinkedList;
import dataStructures.SortedList;

/**
 * Persistent City Directory: manages a collection of cities (name, country, population),
 * identified by the pair (name, country), where the name is case-insensitive.
 *
 * The directory is kept in two sorted linked lists that share the same city objects:
 * one ordered by key (country, name), used to add, remove and search cities,
 * and one ordered by listing order (country, population, name), used to list the cities.
 * The directory is restored from a file when the application starts and saved when it ends.
 *
 * In the time complexity of the methods, n is the number of cities in the directory
 * and c is the number of commands read. The comparison of two strings is considered O(1).
 *
 * Space complexity: O(n) (two lists with n nodes each, which share the same n cities).
 */
public class Main {
    private static final String CITY_ADDED = "City successfully added.";
    private static final String CITY_ALR_EXISTS = "City already exists.";
    private static final String CITY_REMOVED = "City successfully removed.";
    private static final String CITY_NO_EXISTS = "City not found.";
    private static final String NO_CITIES_AVAILABLE = "No cities available.";
    private static final String CITY_SAVED = "City directory saved.";
    private static final String GOODBYE_MSG = "Goodbye.";

    private static final String FILE_NAME = "cityDirectory";
    private static final String DIR_RESTORED = "City directory restored successfully.";
    private static final String DIR_NOT_FOUND = "City directory not found.";
    private static final String DIR_CREATING = "Creating an empty city directory.";

    private static final String HELP = "HELP";
    private static final String ADDCITY = "ADDCITY";
    private static final String REMOVECITY = "REMOVECITY";
    private static final String POPULATION = "POPULATION";
    private static final String LISTCITIES = "LISTCITIES";
    private static final String QUIT = "QUIT";
    private static final String COMMAND_ERROR = "Unknown command. Type help to see available commands.\n";

    private static final int ANY_POPULATION = 0;

    private static BufferedReader in;
    private static SortedList<CityClass> citiesByKey;
    private static SortedList<CityClass> citiesByListing;


    /**
     * Loads the city directory from the file {@code FILE_NAME}.
     * If the file exists, both sorted lists (by key and by listing) are read from it,
     * in the same order in which {@code quitCommand} writes them.
     * Otherwise, two empty sorted lists are created, one ordered by {@code CityKeyComparator}
     * and the other by {@code CityListingComparator}
     *
     * Time complexity: best case O(1) (the file does not exist);
     * worst case O(n) (the file exists and the n cities are read).
     *
     * @throws IOException if an error occurs while reading the file
     * @throws ClassNotFoundException if the class of a serialized object cannot be found
     */
    @SuppressWarnings("unchecked")
    private static void loadDirectory() throws IOException, ClassNotFoundException {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                citiesByKey = (SortedList<CityClass>) ois.readObject();
                citiesByListing = (SortedList<CityClass>) ois.readObject();
            }
            System.out.println(DIR_RESTORED);
        } else {
            citiesByKey = new SortedLinkedList<>(new CityKeyComparator());
            citiesByListing = new SortedLinkedList<>(new CityListingComparator());
            System.out.println(DIR_NOT_FOUND);
            System.out.println(DIR_CREATING);
        }
    }

    /**
     * Starts the application: restores (or creates) the city directory and
     * processes the commands read from the standard input.
     *
     * Time complexity: best case O(1) (there is no file and the first command is {@code quit});
     * worst case O(c * n).
     *
     * @param args not used
     * @throws IOException if an error occurs while reading or writing
     * @throws ClassNotFoundException if the class of a serialized object cannot be found
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        in = new BufferedReader(new InputStreamReader(System.in));
        loadDirectory();
        command();
    }

    /**
     * Reads commands from the standard input, one per line, and executes the corresponding
     * handler until the {@code quit} command is entered.
     * Commands are case-insensitive and surrounding whitespace is ignored.
     * Unknown commands print an error message.
     * When {@code quit} is entered, the directory is saved and the input is closed.
     *
     * Time complexity: best case O(n) (the first command is {@code quit}, which saves the n cities);
     * worst case O(c * n) (each of the c commands costs O(n) in the worst case).
     *
     * @throws IOException if an error occurs while reading the input or saving the directory
     */
    private static void command() throws IOException {
        String command = in.readLine();
        while (!command.trim().equalsIgnoreCase(QUIT)) {
            switch (command.trim().toUpperCase()) {
                case HELP -> helpCommand();
                case ADDCITY -> addCityCommand();
                case REMOVECITY -> removeCityCommand();
                case POPULATION -> populationCommand();
                // case LISTCITIES -> listCitiesCommand();
                default -> System.out.print(COMMAND_ERROR);
            }
            command = in.readLine();
        }
        quitCommand();
        in.close();
    }

    /**
     * Handles the {@code help} command
     * Prints the list of all available commands with a brief description of each.
     *
     * Time complexity: O(1) (best and worst case).
     */
    private static void helpCommand() {
        System.out.println("addCity: Adds a new city to the directory.\n" +
                "removeCity: Removes an existing city from the directory.\n" +
                "population: Returns the number of inhabitants of a city.\n" +
                "listCities: Lists all cities currently stored in the directory.\n" +
                "help: Displays the list of available commands.\n" +
                "quit: Terminates the application."
        );
    }

    /*private static void listCitiesCommand() {
        if(!citiesByListing.isEmpty()){
            Iterator<CityClass> it = citiesByListing.iterator();
            while(it.hasNext()){
                CityClass ct = it.next();
                System.out.println(ct.getCountryName() + " - " + ct.getPopulation() + " - " + ct.getCityName());
                }
        }
        System.out.println(NO_CITIES_AVAILABLE);

    }*/

    private static void populationCommand() throws IOException {
        String cityName = in.readLine().trim();
        String countryName = in.readLine().trim();
        CityClass city = citiesByKey.get(new CityClass(cityName, countryName,ANY_POPULATION));
        if(city == null){
            System.out.println(CITY_NO_EXISTS);
        }
        else{System.out.println("Population: " + city.getPopulation());}
    }

    /**
     * Handles the {@code removeCity} command.
     * Reads the name of the city and the name of the country (one per line)
     * and removes the city from both lists, if it exists.
     *
     * Time complexity: best case O(1); worst case O(n), where n is the number of cities.
     *
     * @throws IOException if an error occurs while reading the input
     */
    private static void removeCityCommand() throws IOException {
        String cityName = in.readLine().trim();
        String countryName = in.readLine().trim();

        CityClass searchCity = new CityClass(cityName, countryName, 0);
        CityClass city = citiesByKey.get(searchCity);
        if (city == null) System.out.println(CITY_NO_EXISTS);
        else {
            citiesByKey.remove(city);
            citiesByListing.remove(city);
            System.out.println(CITY_REMOVED);
        }
    }

    /**
     * Handles the {@code addCity} command.
     * Reads three lines from the input: the city name, the country name and the population.
     * If a city with the same key (name and country) already exists in the directory,
     * an error message is printed and nothing is changed.
     * Otherwise, the city is inserted in both sorted lists and a confirmation is printed.
     *
     * Time complexity: best case O(1) (the city already exists and is the first one, or it is
     * inserted at the beginning or at the end of both lists); worst case O(n).
     *
     * @throws IOException if an error occurs while reading the input
     */
    private static void addCityCommand() throws IOException {
        String cityName = in.readLine().trim();
        String countryName = in.readLine().trim();
        long population = Long.parseLong(in.readLine().trim());

        CityClass city = new CityClass(cityName, countryName, population);
        if(citiesByKey.contains(city))
            System.out.println(CITY_ALR_EXISTS);
        else {
            citiesByKey.add(city);
            citiesByListing.add(city);
            System.out.println(CITY_ADDED);
        }
    }

    /**
     * Handles the {@code quit} command.
     * Saves the directory to the file {@code FILE_NAME}, replacing any previous content.
     * The two lists are written in a fixed order (by key, then by listing), which must match
     * the order in which {@code loadDirectory} reads them.
     * Prints a confirmation and a goodbye message.
     *
     * Time complexity: O(n) (best and worst case), since the n cities are written to the file.
     *
     * @throws IOException if an error occurs while writing the file
     */
    private static void quitCommand() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(citiesByKey);
            oos.writeObject(citiesByListing);
        }
        System.out.println(CITY_SAVED);
        System.out.println(GOODBYE_MSG);
    }
   }
