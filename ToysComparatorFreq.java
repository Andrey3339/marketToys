import java.util.Comparator;

public class ToysComparatorFreq<T extends ToyLottery> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {

        return o2.getFreq() - o1.getFreq();
    }
}
