import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

        // создаем несколько игрушек
        Toy t1 = new Toy("constructor");
        Toy t2 = new Toy("doll");
        Toy t3 = new Toy("gnome");
        Toy t4 = new Toy("puzzle");
        Toy t5 = new Toy("ball");

        // создаем несколько экземпляров класса игрушек для розыгрыша
        // вероятность выбора каждой игрушки должна быть кратна самой маленькой вероятности выбора игрушки
        ToyLottery tl1 = new ToyLottery(t1, 2, 30);
        ToyLottery tl2 = new ToyLottery(t2, 3, 10);
        ToyLottery tl3 = new ToyLottery(t3, 5, 20);
        ToyLottery tl4 = new ToyLottery(t4, 4, 5);
        ToyLottery tl5 = new ToyLottery(t5, 1, 35);

        // создаем магазин игрушек, где будет розыгрыш
        StoreToys<ToyLottery> storeToys = new StoreToys<>();

        storeToys.addToyLottery(tl1);
        storeToys.addToyLottery(tl2);
        storeToys.addToyLottery(tl3);
        storeToys.addToyLottery(tl4);
        storeToys.addToyLottery(tl5);

        // меняем частоту появления игрушки в розыгрыше
        tl1.setFreq(25);
        tl2.setFreq(15);

        // проверяем правильность заданных вероятностей - сумма должна быть равна 100
        System.out.println("Сумма вероятностей равна 100% - " + storeToys.validFreq());

        // сумма всех игрушек в розыгрыше
        System.out.println("Сумма всех игрушек в розыгрыше: " + storeToys.getAllQuantity());

        // меняем количество игрушек puzzle в розыгрыше
        tl4.setQuantity(2);

        // сумма всех игрушек в розыгрыше после изменения количества puzzle
        System.out.println("Сумма всех игрушек в розыгрыше сейчас: " + storeToys.getAllQuantity());

        // список всех игрушек в розыгрыше
        System.out.println("Список игрушек в розыгрыше: ");
        storeToys.printToysLotteryList();

        // получаем минимальную вероятность выбора какой то игрушки
        int minFreq = storeToys.getMinFreq();

        // проводим 10 розыгрышей игрушек
        for (int i = 0; i < 10; i++) {
            storeToys.prizeToySelection(minFreq);
        }

        // выводим список розыгранных игрушек
        System.out.println("Список розыгранных игрушек: ");
        storeToys.printDequeToys();

        // получаем 5 игрушек из розыгранного списка и записываем их в файл
        for (int i = 0; i < 5; i++) {
            storeToys.getPrizeToy();
        }

        // выводим список оставшихся розыгранных игрушек
        System.out.println("Список оставшихся розыгранных игрушек: ");
        storeToys.printDequeToys();

        // выводим список оставшихся в розыгрыше игрушек
        System.out.println("Спиок оставшихся в розыгрыше игрушек: ");
        storeToys.printToysLotteryList();

    }
}