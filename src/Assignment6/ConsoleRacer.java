package Assignment6;

import java.util.concurrent.TimeUnit;

/**
 * An implementation of th IRacer interface.
 *
 * NOTE: The racers didn't really need their own implementation in my opinion,
 * so I made this generic implementation to instantiate in a customizable way
 * that described the movement of each animal or racer.
 *
 * @author Jeremy Santorelli
 */
public class ConsoleRacer implements IRacer {

    private boolean isWinner;
    private int distanceTraveled;
    private long start;
    private final String name;
    private int frameNumber;
    private long interval;
    private final long startTimeFrames;
    private final int speed;
    private final int finishlineDistance;

    public ConsoleRacer(String name, int speed, int f) {
        isWinner = false;
        distanceTraveled = 0;
        start = 0;
        frameNumber = 0;
        this.speed = speed;
        this.finishlineDistance = f;
        this.name = name;
        this.startTimeFrames = System.nanoTime();
    }

    @Override
    public void run() {

        while (isWinner == false) {

            while (distanceTraveled < finishlineDistance) {
                speedController();
                fpsController();
            }
            isWinner = true;

        }
        System.out.println(progress());
        System.out.println(name + " is the Winner!");
        //Race Over
        System.exit(0);
    }

    @Override
    public String progress() {

        String progressOut = "";
        for (int i = 0; i < distanceTraveled; i++) {
            progressOut += "-";
        }

        progressOut += name;

        return progressOut;
    }

    public boolean isWinner() {
        return isWinner;
    }

    /**
     * this controller manages the number of outputs sent per second.
     */
    private void fpsController() {
        long end = System.nanoTime();
        interval = TimeUnit.SECONDS.convert(end - startTimeFrames, TimeUnit.NANOSECONDS);
        if (interval > frameNumber) {
            frameNumber++;
            System.out.println(progress());

        }

    }

    public String speedController() {
        long end = System.nanoTime();
        long inter = TimeUnit.SECONDS.convert(end - start, TimeUnit.NANOSECONDS);

        // I did this in such a way that the larger the speed 
        //the longer the break between each summation. That way you achieve the
        //effect of breaking without having to build a massive set of
        //instructions to do the same thing.
        if (inter >= speed) {
            start = end;
            distanceTraveled += speed;
        }
        return progress();
    }

}
