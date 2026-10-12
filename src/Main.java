import java.util.*;


public class Main {
    private static final String CITY_ADDED = "City successfully added.";
    private static final String CITY_ALR_EXISTS = "City already exists.";
    private static final String CITY_REMOVED = "City successfully removed.";
    private static final String CITY_NO_EXISTS = "City not found.";
    private static final String NO_CITIES_AVAILABLE = "No cities available.";
    private static final String CITY_SAVED = "City directory saved.";
    private static final String GOODBYE_MSG = "Goodbye.";

    private static final String HELP = "HELP";
    private static final String ADDCITY = "ADDCITY";
    private static final String REMOVECITY = "REMOVECITY";
    private static final String POPULATION = "POPULATION";
    private static final String LISTCITIES = "LISTCITIES";
    private static final String QUIT = "QUIT";
    private static final String COMMAND_ERROR = "Unknown command. Type help to see available commands.\n";

    private static void main (String[] args) {
        command();
    }

    private static void command(){
        Scanner in = new Scanner(System.in);
        String command = in.next();
        while (!command.equalsIgnoreCase(QUIT)) {
            switch (command.toUpperCase()) {
                case HELP -> helpCommand();
                case ADDCITY -> addCityCommand();
                case REMOVECITY -> removeCityCommand();
                case POPULATION -> populationCommand();
                case LISTCITIES -> listCitiesCommand();
                default -> System.out.print(COMMAND_ERROR);
            }
            command = in.next();
        }
        quitCommand();
        in.close();
    }


    /**
     * Handles the {@code help} command
     * Prints the list of all available commands with a brief description of each.
     */
    private static void helpCommand() {
        System.out.println("addCity: Adds a new city to the directory.ê\n" +
                "removeCity: Removes an existing city from the directory.ê\n" +
                "population: Returns the number of inhabitants of a city.ê\n" +
                "listCities: Lists all cities currently stored in the directory.ê\n" +
                "help: Displays the list of available commands.ê\n" +
                "quit: Terminates the application.ê"
        );
    }

    private static void listCitiesCommand() {
    }

    private static void populationCommand() {
    }

    private static void removeCityCommand() {
    }

    private static void addCityCommand() {
    }

    private static void quitCommand() {

    }


   }