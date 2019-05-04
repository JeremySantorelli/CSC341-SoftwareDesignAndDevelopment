package Assignment6;

/**
 * 
 * @author Jeremy Santorelli
 */
public class RaceLane implements Runnable {

    private final IRacer r;

    public RaceLane(IRacer r) {
        this.r = r;
    }

    @Override
    public void run() {
        r.run();
    }

}
