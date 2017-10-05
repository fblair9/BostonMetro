
/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;

public class MultiGraph implements Graph{

    private List<Node> NodeNames;
    private List<ArrayList<Edge>> allConnections;

    public MultiGraph(){

        NodeNames = new ArrayList<Node>();
        allConnections = new ArrayList<ArrayList<Edge>>();
        allConnections.add(new ArrayList<Edge>());


    }


    @Override
    public List<Node> getNodes(){

        return NodeNames;
    }
    @Override
    public  List<ArrayList<Edge>> getAllConnections() {

        return allConnections;
    }

    @Override
    public void addEdge(int id, Edge edge ) {
        int position = id -1;
        if(position>= allConnections.size()){
            for(int i= allConnections.size(); i<id; i++){
                allConnections.add(new ArrayList<Edge>());
            }
        }
            allConnections.get(id - 1).add(edge);


    }

    @Override
    public Node findNode(String nodeName) {
        return null;
    }

    @Override
    public void addNode(Node node) {
        NodeNames.add(node);

    }
    @Override
    public List<Edge> bfs(Node source, Node destination) {

        return null;
    }
}
