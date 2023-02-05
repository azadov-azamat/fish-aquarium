package aquarium.klass;

import aquarium.enums.DirectionX;
import aquarium.enums.DirectionY;

import static aquarium.klass.Aquarium.aquariumSize;
import static aquarium.klass.Fish.randomNumber;

public class Location {

    public int x; // koordinata obsissiyasi
    public int y; // koordinata ordinatasi

    public Location() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    public Location(int id, int gender, int age) {
        setRandomLocation(aquariumSize, new Fish(id, gender, age, 0, 0));
        synchronized (Aquarium.fishList) {
            Aquarium.fishList.add(new Fish(id, gender, age, this.x, this.y));
        }
    }

    public void setRandomLocation(int Size, Fish currentFish) {

        int location_exist_ind = 0;

        while (location_exist_ind == 0) {

            this.x = (int) (Math.random() * Size);

            this.y = (int) (Math.random() * Size);

            currentFish.setX(this.x);
            currentFish.setY(this.y);

            location_exist_ind = checkLocation(currentFish);
        }
    }

    public void setNextLocation(Fish currentFish) {

        int XLocation = 0;
        int YLocation = 0;

        int location_exist_ind = 0;

        while (location_exist_ind == 0) {

            XLocation = DirectionX.getRandomDirectionX(currentFish.x);

            YLocation = DirectionY.getRandomDirectionY(currentFish.y);

            currentFish.setX(XLocation);
            currentFish.setY(YLocation);

            location_exist_ind = checkLocation(currentFish);

        }
        this.setX(XLocation);
        this.setY(YLocation);

    }

    public int checkLocation(Fish currentFish) {
        int temp_ind = 0;
        synchronized (Aquarium.fishList) {
            if (Aquarium.fishList.size() != 0)
                for (Fish fish : Aquarium.fishList) {
                    if (currentFish.x == fish.x && currentFish.y == fish.y && currentFish.gender != fish.gender) { // baliqlarning x va y koordinatalari mos va jinslari har xil bo`lganda yangi baliqlar yasaladi
                        System.out.println(currentFish.id + " chi baliq bilan " + fish.id + " chi baliq uchrashdilar!");

                        int children = randomNumber(10, 5);

                        for (int i = 0; i <= children; i++) {
                            Aquarium.fishList.add(new Fish(Aquarium.numberOfFishes + i, randomNumber(1, 0), randomNumber(5, 1), (int) (Math.random() * aquariumSize), (int) (Math.random() * aquariumSize)));
                        }

                        Aquarium.numberOfFishes += children;

                        System.out.println(currentFish.id + " chi baliq bilan " + fish.id + " chi baliqlardan " + children + " ta yangi baliqlar hosil bo`ldi");
                        System.out.println("Hozirda jami baliqlar soni: " + Aquarium.numberOfFishes + " ta");

                        int count = 0;

                        for (Fish fishCount : Aquarium.fishList) {
                            if (fishCount.gender == 1) count++;
                        }

                        System.out.println(count + " ta erkak va " + ((Aquarium.fishList.size() - 1) - count) + " ta urg`ochi baliqlar mavjud");

                        temp_ind = 0;

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        break;
                    } else temp_ind = 1;
                }
            else temp_ind = 1;
        }
        return temp_ind;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}