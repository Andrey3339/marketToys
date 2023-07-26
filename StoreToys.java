import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class StoreToys <E extends ToyLottery> implements Iterable<E>{
    private List<E> toysLotteryList;
    private List<Toy> tempList;
    private Deque<Toy> dequeToys;
    public StoreToys() {
        toysLotteryList = new ArrayList<>();
        dequeToys = new ArrayDeque<>();
        tempList = new ArrayList<>();
        try {
            new FileWriter("src/prizeToysList.txt", false).close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addToyLottery(E toyLottery) {

        toysLotteryList.add(toyLottery);
    }
    public boolean validFreq() {
        int allFreq = 0;
        for (int i = 0; i < toysLotteryList.size(); i++) {
            allFreq += toysLotteryList.get(i).getFreq();
        }
        return allFreq == 100;
    }

    public void printToysLotteryList() {
        for (int i = 0; i < toysLotteryList.size(); i++) {
            System.out.print(toysLotteryList.get(i).getToy() + " количество: " + toysLotteryList.get(i).getQuantity() + "\n");
        }
    }

    public void printDequeToys() {
        for (int i = 0; i < tempList.size(); i++) {
            System.out.print(tempList.get(i) + "\n");
        }
    }

    public void prizeToySelection(int minFreq) {
        int[] probabilityWinningArray = new int[toysLotteryList.size()];
        int temp = toysLotteryList.get(0).getFreq() / minFreq;
        probabilityWinningArray[0] = temp;
        for (int i = 1; i < toysLotteryList.size(); i++) {
            probabilityWinningArray[i] = (toysLotteryList.get(i).getFreq() / minFreq) + temp;
            temp += (toysLotteryList.get(i).getFreq() / minFreq);
        }
        Random rand = new Random();
        int randNumber = rand.nextInt(temp) + 1;
        int probabilityWinningArrayNumber = 0;
        for (int i = 0; i < probabilityWinningArray.length; i++) {
            if ( randNumber <= probabilityWinningArray[i]) {
                probabilityWinningArrayNumber = i;
                break;
            }
        }
        Toy toy = toysLotteryList.get(probabilityWinningArrayNumber).getToy();
        dequeToys.addLast(toy);
        tempList.add(toy);
        int currentQuantity = toysLotteryList.get(probabilityWinningArrayNumber).getQuantity();
        toysLotteryList.get(probabilityWinningArrayNumber).setQuantity(currentQuantity - 1);
        if (toysLotteryList.get(probabilityWinningArrayNumber).getQuantity() == 0) {
            toysLotteryList.remove(probabilityWinningArrayNumber);
        }
    }
    public void getPrizeToy() {
        if (!dequeToys.isEmpty()) {
            Toy toy = dequeToys.remove();
            tempList.remove(toy);
            try (FileWriter writer = new FileWriter("src/prizeToysList.txt", true)) {
                writer.write(toy.toString());
                writer.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int getMinFreq() {
        int minFreq = toysLotteryList.get(0).getFreq();
        for (int i = 1; i < toysLotteryList.size(); i++) {
            if (toysLotteryList.get(i).getFreq() < minFreq) {
                minFreq = toysLotteryList.get(i).getFreq();
            }
        }
        return minFreq;
    }

    public int getAllQuantity() {
        int allQuantity = 0;
        for (int i = 0; i < toysLotteryList.size(); i++) {
            allQuantity += toysLotteryList.get(i).getQuantity();
        }
        return allQuantity;
    }

    @Override
    public Iterator<E> iterator() {
        return new ToyLotteryIterator<>(toysLotteryList);
    }
}
