package aquarium.klass;

public class Fish extends Location implements Runnable {

    public int id;
    public int gender; // Jinsi 0 => urg`ochi 1 => erkak
    public int age; // yashash muddati

    public void setAge(int age) {
        this.age = age - 1;
    }

    public Fish(int id, int gender, int age) {
        super(id, gender, age);
        this.id = id;
        this.gender = gender;
        this.age = age;
    }

    public Fish(int id, int gender, int age, int x, int y) {
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.x = x;
        this.y = y;
    }

    public static int randomNumber(int max, int min) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    @Override
    public void run() {
        for (int i = 0; i < Aquarium.fishList.size(); i++) {
            Fish fish = Aquarium.fishList.get(i);
//            if (fish.moves == 0)
//                System.out.println(fish.id + "raqamli " + (fish.gender == 0 ? "urg`ochi" : "erkak") + " baliqning dastlabki joylashuvi, x: " + fish.x + ", y: " + fish.y);
            setNextLocation(fish);

            if (fish.age == 0) {
                Aquarium.fishList.remove(fish);
                System.out.println(fish.id + " - raqamli baliq halok bo`ldi!!!");
            } else {
                System.out.println(fish.id + " raqamli " + (fish.gender == 0 ? "urg`ochi" : "erkak") + " baliq, yashash muddati: " + fish.age + ", yangi joylashuvi x: " + fish.x + ", y: " + fish.y);
                fish.setAge(this.age - 1);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
