package Assignmentt10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeremy Santorelli
 */
class FlatFileStorage implements Storage {

    static String storagePath;
    static FileWriter storage;
    long[] ret = new long[2];

    private FlatFileStorage() {

    }

    public static FlatFileStorage getInstance(String storagePath) {
        FlatFileStorage.storagePath = storagePath;
        FlatFileStorage f = new FlatFileStorage();
        try {
            FlatFileStorage.storage = new FileWriter(FlatFileStorage.storagePath);
        } catch (IOException ex) {
            Logger.getLogger(FlatFileStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }

    @Override
    public void save(String str, int alarmType) {
        String structuredText = "";
        if (alarmType == 0) {
            structuredText = "w:";
        } else {
            structuredText = "s:";
        }
        structuredText += str;

        BufferedWriter writer = new BufferedWriter(FlatFileStorage.storage);
        try {
            writer.write(structuredText);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(FlatFileStorage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public long[] getAll() {
        String line = null;
        try {            
            FileReader fileReader
                    = new FileReader(FlatFileStorage.storagePath);
            try ( 
                    BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                while ((line = bufferedReader.readLine()) != null) {
                    stringToLong(line);
                }             
            }
        } catch (FileNotFoundException ex) {
           
        } catch (IOException ex) {
            
        }

        return this.ret;
    }

    private void stringToLong(String line) {

        String[] lineParts = line.split(":");
        if (lineParts[0].equals("w")) {
            try {
                ret[0] = stringDateToMillis(lineParts[1]);
            } catch (ParseException ex) {
                Logger.getLogger(FlatFileStorage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public long stringDateToMillis(String alarmTime) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyyHHmm");
        Date d = formatter.parse(alarmTime);
        return d.getTime();
    }

}
