package aquarium.enums;

import aquarium.klass.Aquarium;

public enum DirectionX {


    RIGHT(1),
    NONE(0),
    LEFT(-1);

    public final int directionXInd;

    DirectionX(int X) {
        directionXInd = X;
    }

    public static int getRandomDirectionX(int x) {
        int X = x;

        if (X != 0 && X != Aquarium.aquariumSize - 1) {
            X = X + values()[(int) (Math.random() * (values().length))].directionXInd;

        } else if (x >= Aquarium.aquariumSize - 1) {
            X = X + values()[(int) (Math.random() * (values().length - 1)) + 1].directionXInd;
        } else {
            X = X + values()[(int) (Math.random() * (values().length - 1))].directionXInd;
        }
        return (X);
    }
}
