package Week1Demo_AddressBook;

import java.io.*;
import java.util.*;

public class DataHandler implements IDataHandler {

    IAddressBook book;

    public DataHandler(IAddressBook book) {
        this.book = book;
    }

    @Override
    public void getData(String connStr) {
        String name = null, address = null;
        String line = "";
        try {
            FileReader fileReader = new FileReader(connStr);
            try (BufferedReader bufferedReader = new BufferedReader(fileReader) //Wrap FileReader in BufferedReader.
                    ) {
                while ((line = bufferedReader.readLine()) != null) {
                    String[] parts = line.split(":", 2);
                    if (parts.length >= 2) {
                        book.add(parts[0], parts[1]);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Error reading file");
        }
    }

    @Override
    public void saveData(String connStr) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        try {
            fileWriter = new FileWriter(connStr);
            bufferedWriter = new BufferedWriter(fileWriter);
            //Once writing objects are instantiated, the existing content of the file would be wiped out...
            Set<String> kset = ((AddressBook) book).getKeyset();
            Iterator<String> it = kset.iterator();
            while (it.hasNext()) {
                String name = it.next();
                String address = book.getAddress(name);
                bufferedWriter.write(name + ":" + address);
                bufferedWriter.write(System.getProperty("line.separator"));
            }
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file");
        }
    }

}
