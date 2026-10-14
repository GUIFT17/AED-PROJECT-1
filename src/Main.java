import java.io.*;

import dataStructures.SortedLinkedList;
import dataStructures.SortedList;

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

    private static BufferedReader in;
    private static SortedList<CityClass> citiesByKey;
    private static SortedList<CityClass> citiesByListing;


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

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        in = new BufferedReader(new InputStreamReader(System.in));
        loadDirectory();
        command();
    }

    private static void command() throws IOException {
        String command = in.readLine();
        while (!command.equalsIgnoreCase(QUIT)) {
            switch (command.toUpperCase()) {
                case HELP -> helpCommand();
                case ADDCITY -> addCityCommand();
                case REMOVECITY -> removeCityCommand();
                case POPULATION -> populationCommand();
                case LISTCITIES -> listCitiesCommand();
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

    private static void listCitiesCommand() {
    }

    private static void populationCommand() {
    }

    private static void removeCityCommand() {
    }

    private static void addCityCommand() throws IOException {
        String cityName = in.readLine();
        String countryName = in.readLine();
        long population = Long.parseLong(in.readLine());

        CityClass city = new CityClass(cityName, countryName, population);
        if(citiesByKey.contains(city))
            System.out.println(CITY_ALR_EXISTS);
        else {
            citiesByKey.add(city);
            citiesByListing.add(city);
            System.out.println(CITY_ADDED);
        }
    }

    private static void quitCommand() {
    }
   }
