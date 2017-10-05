public interface Edge {

    public Node getSource();
    public Node getDestination();
    public String getLabel();
    public void setDestination(Node destination);
    public void setSource(Node source);
    public void setLabel(String label);
}
