package Assignment1;

import java.io.*;
import java.text.ParseException;
import java.util.*;
/**
 * 
 * @author Dr. Hu
 *
 * Modified to accept new parameters by Jeremy Santorelli
 */
public class DataHandlerFlatFile implements DataHandler {

    private final ListContainer list;

    public DataHandlerFlatFile(ListContainer list) {
        this.list = list;
    }

    @Override
    public void getData(String connStr) throws ParseException {
        String line = "";
        try {
            FileReader fileReader = new FileReader(connStr);
            try (BufferedReader bufferedReader = new BufferedReader(fileReader) //Wrap FileReader in BufferedReader.
                    ) {
                while ((line = bufferedReader.readLine()) != null) {
                    String[] parts = line.split(" : ");
                    String[] listParts = parts[1].split(", ");
                    for (int i = 0; i < listParts.length; i++) {
                        list.setMessage(listParts[i], parts[0].trim());
                    }

                }
            }
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
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

            Iterator it = list.getMessages().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                Date date = DateUtility.formatDate((Date) pair.getKey());
                List<String> entryList = (List<String>) pair.getValue();
                String messages =  DateUtility.formattedDateString(date) + " : ";
                for (int i = 0; i < entryList.size(); i++) {
                    if (i != 0) {
                        messages += ", ";
                    }
                    messages += entryList.get(i);
                }
                bufferedWriter.write(messages);
                bufferedWriter.write(System.getProperty("line.separator"));
            }
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file");
        }
    }

}
