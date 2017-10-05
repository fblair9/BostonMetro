import java.util.List;
import java.util.Scanner;

public class UserApplication {

    private Scanner scanner;

    /**
     * Used to get the input of the source station or destination station.
     *
     * @param s when method gets called "s" will be a string "start" or "end" in order to show useful message without code repetition.
     * @return stationName - the name of the source or destination station
     */
    public String getStationName(String s){
        String stationName;
        scanner = new Scanner(System.in);
        System.out.println("Enter the station name where you " + s + " your journey.");
        System.out.print("-> ");
        stationName = scanner.nextLine();
        scanner.close();
        return stationName;
    }

    /**
     * Displays the route by printing each station name in the route list.
     *
     * @param route - list of strings containing station names in the route.
     */
    public void displayRoute(List<String> route){
        System.out.println("Your route is:");
        for (String s: route) {
            System.out.printf(s + "->");
        }
    }


}
