public class Line implements Edge {
    private String label;
    private Node source;
    private Node destination;


    public Line(String label, Node source, Node destination){
        setLabel(label);
        setSource(source);
        setDestination(destination);
    }

    @Override
    public String getLabel() {

        return label;
    }
    @Override
    public void setLabel(String label) {

        this.label = label;
    }
    @Override
    public Node getSource() {

        return source;
    }
    @Override
    public void setSource(Node source) {

        this.source = source;
    }
    @Override
    public Node getDestination() {

        return destination;
    }
    @Override
    public void setDestination(Node destination) {

        this.destination = destination;
    }
}
