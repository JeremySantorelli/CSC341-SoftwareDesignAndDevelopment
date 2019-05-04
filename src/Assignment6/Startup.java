package Assignment6;

/**
 * Starts Assignment 6
 *
 * @author Jeremy Santorelli
 */
public class Startup {

    public static void main(String[] args) {

        int finishlineDistance = 10;//Change this to account for variable distances

        IRacer[] racers = {
            new ConsoleRacer("Hare", 3, finishlineDistance),
            new ConsoleRacer("Tortise", 1, finishlineDistance),
            new ConsoleRacer("Horse", 2, finishlineDistance)
        };

        for (IRacer r : racers) {
            Thread lane = new Thread(new RaceLane(r));
            lane.start();
        }

    }

}
