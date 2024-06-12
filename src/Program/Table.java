package Program;




public class Table {

    private static int id_index = 1;

    public static void main(String[] args) {

        int philosophersNumber = 5;
        int eatingNumber = 3;

        Forks[] forks = new Forks[philosophersNumber];
        Philosophers[] philosophers = new Philosophers[philosophersNumber];

        for (int i = 0; i < philosophersNumber; i++) {
            forks[i] = new Forks();
        }

        for (int i = 0; i < philosophersNumber; i++) {
            Forks leftFork = forks[i];
            Forks rightFork = forks[(i + 1) % philosophersNumber];
            philosophers[i] = new Philosophers(i, leftFork, rightFork, eatingNumber);
            philosophers[i].start();
        }

        for (Philosophers philosopher : philosophers) {
            try {
                philosopher.join();
                id_index = id_index + 1;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (id_index == 5) {System.out.println("Все Философы поели");}
         }
    }


}