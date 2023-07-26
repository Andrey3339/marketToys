public class ToyLottery {
    private static int nextId = 1;
    private final int id;
    private Toy toy;
    private int freq;
    private int quantity;
    public ToyLottery(Toy toy, int quantity, int freq) {
        this.toy = toy;
        this.quantity = quantity;
        this.freq = freq;
        id = nextId++;
    }
    public int getId() {
        return id;
    }
    public int getFreq() {
        return freq;
    }
    public void setFreq(int freq) {
        this.freq = freq;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Toy getToy() {
        return this.toy;
    }
    @Override
    public String toString() {
        return "ToyLottery{" +
                "id=" + id +
                ", toy=" + toy +
                ", freq=" + freq +
                ", quantity=" + quantity +
                '}';
    }
}
