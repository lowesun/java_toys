public class Toy_raffle {
    
    public static void main(String[] args) {
        Toy_store store = new Toy_store();

        Toy toy1 = new Toy(1, "Плюшевая акула", 100, 70);
        Toy toy2 = new Toy(2, "Фигурка Гарри Поттера", 50, 50);
        Toy toy3 = new Toy(3, "Игрушечная гоночная машина", 20, 30);
        Toy toy4 = new Toy(4, "Монополия", 10, 10);


        store.addToy(toy1);
        store.addToy(toy2);
        store.addToy(toy3);
        store.addToy(toy4);
 


        store.changeToyFrequency(1, 30);

        store.organizeRaffle();

        Toy prizeToy = store.getPrizeToy();
        if (prizeToy != null) {
            System.out.println("Вы выиграли: " + prizeToy.getName());
        }
    }
}