package Week1Demo_AddressBook;

import java.util.*;

public class AddressBook implements IAddressBook {

    private final HashMap<String, String> addresses;

    public AddressBook() {
        addresses = new HashMap<>();
    }

    @Override
    public void add(String name, String address) {
        if (!contains(name)) {
            addresses.put(name.toLowerCase(), address);
        } else {
            addresses.put(name.toLowerCase(), address);
        }
    }

    @Override
    public int getSize() {
        return addresses.size();
    }

    @Override
    public void remove(String name) {
        addresses.remove(name.toLowerCase());
    }

    public Set<String> getKeyset() {
        return addresses.keySet();
    }

    @Override
    public boolean contains(String name) {
        Set<String> names = getKeyset();
        return names.contains(name.toLowerCase());
    }

    @Override
    public String getAddress(String name) {
        String toReturn = "";
        if (contains(name)) {
            toReturn = addresses.get(name);
        }
        return toReturn;
    }

    @Override
    public String toString() {
        String toReturn = "";
        for (Map.Entry<String, String> entry : addresses.entrySet()) {
            toReturn += entry.getKey() + " " + addresses.get(entry.getKey()) + "\n";
        }
        return toReturn;
    }
}
