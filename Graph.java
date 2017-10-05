import java.util.ArrayList;
import java.util.List;

public interface Graph {
    public void addEdge(int id, Edge edge);
    public void addNode(Node node);
    public List<Edge> bfs(Node source, Node destination);
    public List<Node> getNodes();
    public List<ArrayList<Edge>> getAllConnections();
    public Node findNode(String nodeName);
}
