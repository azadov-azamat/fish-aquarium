package aquarium.klass;

import java.util.LinkedList;
import java.util.Scanner;

public class Aquarium {

    public static int aquariumSize = 0; // Aquarium hajmi
    public static int numberOfFishes = 1; // Aquariumdagi baliqlar soni

    public static final LinkedList<Fish> fishList = new LinkedList<Fish>();

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        System.out.print("Akvarium hajmini kiriting: ");
        aquariumSize = scn.nextInt();

        System.out.print("Baliqlar sonini kiriting: ");
        numberOfFishes = scn.nextInt();

        while (numberOfFishes >= Math.pow(aquariumSize, 2)) {
            System.out.print("Baliqlar sonini tekshirib qayta kiriting! baliqlar soni akvarium hajmidan kam bo`lishi kerak: ");
            numberOfFishes = scn.nextInt();
        }

        Thread[] threads = new Thread[numberOfFishes];

        for (int i = 0; i < numberOfFishes; i++) {
            Fish fish = new Fish(i, Fish.randomNumber(1, 0), Fish.randomNumber(5, 1));
            fishList.add(fish);
            threads[i] = new Thread(fish);
            threads[i].start();
        }

        try {
            for (int i = 0; i < numberOfFishes; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Baliqlarning yakuniy joylashuvi: ");
        for (Fish fish : fishList) {
            System.out.println(fish.id + " raqamli baliq; x: " + fish.x + ", y:" + fish.y);
        }
    }
}
