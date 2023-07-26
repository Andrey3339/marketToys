
public class Toy {
    private static int nextId = 1;
    private final int id;
    private String name;
    public Toy(String name) {
        this.name = name;
        id = nextId++;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
