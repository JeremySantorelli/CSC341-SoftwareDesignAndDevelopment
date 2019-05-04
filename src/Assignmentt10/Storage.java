package Assignmentt10;

/**
 *
 * @author Jeremy Santorelli
 */
public interface Storage {

    long[] getAll();

    void save(String str, int alarmType);

}