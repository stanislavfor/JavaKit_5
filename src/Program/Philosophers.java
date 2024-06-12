package Program;



class Philosophers extends Thread {
    private final int id;
    private final Forks leftFork;
    private final Forks rightFork;
    private final int eatingNumber;
    public int index = 0;


    public Philosophers(int id, Forks leftFork, Forks rightFork, int eatingNumber) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.eatingNumber = eatingNumber;
    }

    private void think() {
        try {
            Thread.sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("С размышлениями 'Философ на стуле №" + (id + 1) + "'");
    }

    private void eat() {
        try {
            Thread.sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        if (index < 1) {System.out.println("С двумя вилками 'Философ на стуле №" + (id + 1) + "' *"); }
        else {System.out.println("С двумя вилками 'Философ на стуле №" + (id + 1) + "'");}
        index ++;
    }


    @Override
    public void run() {
        for (int i = 0; i < eatingNumber; i++) {
            think();
            leftFork.pickUp();
            rightFork.pickUp();
            eat();
            leftFork.putDown();
            rightFork.putDown();
        }
        System.out.println("[!] Смог поесть " + index + " раза 'Философ на стуле №" + (id + 1) + "'");
    }


}

