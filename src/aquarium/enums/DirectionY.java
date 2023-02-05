package aquarium.enums;

import aquarium.klass.Aquarium;

public enum DirectionY {

    UP(1),
    NONE(0),
    DOWN(-1);

    public final int directionYInd;

    DirectionY(int Y) {
        directionYInd = Y;
    }

    public static int getRandomDirectionY(int Y) {
        if (Y != 0 && Y != Aquarium.aquariumSize - 1) {
            Y = Y + values()[(int) (Math.random() * (values().length))].directionYInd;
        } else if (Y >= Aquarium.aquariumSize - 1) {
            Y = Y + values()[(int) (Math.random() * (values().length - 1)) + 1].directionYInd;
        } else {
            Y = Y + values()[(int) (Math.random() * (values().length - 1))].directionYInd;
        }
        return (Y);
    }
}