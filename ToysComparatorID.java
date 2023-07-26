import java.util.Comparator;

public class ToysComparatorID<T extends ToyLottery> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getId() - o2.getId();
    }
}
