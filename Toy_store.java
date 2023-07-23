import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Toy_store {
    private ArrayList<Toy> toys;
    private ArrayList<Toy> prizeToys;
    private String prizeFilePath;

    public Toy_store() {
        toys = new ArrayList<Toy>();
        prizeToys = new ArrayList<Toy>();
        prizeFilePath = "Prize_toys.txt";
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void changeToyFrequency(int toyId, double newFrequency) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setFrequency(newFrequency);
            }
        }
    }

    public void organizeRaffle() {
        prizeToys.clear();

        for (Toy toy : toys) {
            double random = Math.random() * 100;
            if (random < toy.getFrequency()) {
                prizeToys.add(toy);
            }
        }
    }
    public Toy getPrizeToy() {
        if (!prizeToys.isEmpty()) {
            Toy prizeToy = prizeToys.remove(0);
            prizeToy.setQuantity(prizeToy.getQuantity() - 1);

            try {
                FileWriter writer = new FileWriter(prizeFilePath, true);
                writer.write(prizeToy.getName() + "\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("Ошибка");
            }

            return prizeToy;
        } else {
            System.out.println("Игрушек больше нет");
            return null;
        }
    }
}