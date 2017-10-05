import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, BadFileException  {
        String path = "bostonmetro.txt";
        Graph graph = new MultiGraph();
        MetroMapParser mapParser = new MetroMapParser(path,graph);
        BostonMetro metroSystem = new BostonMetro(mapParser.generateGraphFromFile());
/*
        //these are just for testing that the graph is created correctly
        System.out.println(metroSystem.getGraph().getAllConnections().size());
        System.out.println(metroSystem.getGraph().getNodes().size());
        System.out.println(metroSystem.getGraph().getAllConnections().get(0).size());
        System.out.println(metroSystem.getGraph().getAllConnections().get(1).size());
        ArrayList<Edge> temp = metroSystem.getGraph().getAllConnections().get(1);

        Edge edge = temp.get(1);
        System.out.println("Source : "+edge.getSource().getName()+" Destination: "+edge .getDestination().getName());
*/
    }

}
