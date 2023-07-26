import java.util.Iterator;
import java.util.List;

public class ToyLotteryIterator<E> implements Iterator<E> {
    private List<E> toysLotteryList;
    private int index = 0;
    public ToyLotteryIterator(List<E> listToys) {
        this.toysLotteryList = listToys;
    }

    @Override
    public boolean hasNext() {
        return toysLotteryList.size() > index;
    }

    @Override
    public E next() {
        return toysLotteryList.get(index++);
    }
}
