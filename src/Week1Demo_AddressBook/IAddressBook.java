package Week1Demo_AddressBook;

/**
 * @author Whoever
 *
 */
public interface IAddressBook {

    void add(String name, String address);

    int getSize();

    void remove(String name);

    boolean contains(String name);

    String getAddress(String name);
}
