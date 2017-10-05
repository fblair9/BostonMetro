public class Station implements Node {

    private String name;
    private int id;

    public Station(int id,String name){
        setID(id);
        setName(name);
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void setID(int x) {
        this.id = x;
    }
}
