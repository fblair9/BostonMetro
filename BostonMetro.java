import java.io.IOException;
import java.util.List;

public class BostonMetro {

    private Graph graph;
    private UserApplication ui;

    public BostonMetro(Graph graph) throws IOException, BadFileException {

        /*metroParser is created in main then creates the graph
        then main creates a new BostonMetro and passes the graph inside the constructor
         */
        setGraph(graph);
        ui = new UserApplication();


/*
        String sourceStation = ui.getStationName("start");
        String destStation = ui.getStationName("end");

        // below code isnt final but a suggestion for how we get data from BFS and display to user
        List<String> route;
        List<Edge> shortestPath;
        shortestPath = graph.bfs(getStationID(sourceStation), getStationID(destStation));
        route = pathToStrings(shortestPath);
        ui.displayRoute(route);*/

    }

    public void setGraph(Graph graph){

        this.graph = graph;
    }

    /**
     * Check the station exists
     * @param stationName
     * @return
     */
    public boolean stationExists(String stationName){

        return false; //needs implementation
    }

    /**
     * When the BFS returns the shortest route, will be a list of edges so convert to string
     * for user output.
     * @param routeIDs
     * @return
     */
 //   public List<String> pathToStrings(List<Edge> routeIDs){
      //  return null; //needs implementation
    //}





}
