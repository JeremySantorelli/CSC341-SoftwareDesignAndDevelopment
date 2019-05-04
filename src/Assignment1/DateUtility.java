package Assignment1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jerem
 */
public class DateUtility {

    private static final DateFormat FORMATTER = new SimpleDateFormat("dd/MM/yyyy");

    public static Date getDate() {

        Date date = formatDate(new Date());

        if (date == null) {
            throw new NullPointerException("Date was returned null");
        }

        return date;
    }

    public static Date formatDate(Date date) {
        try {
            return FORMATTER.parse(FORMATTER.format(date));
        } catch (ParseException ex) {
            Logger.getLogger(ListContainerToDo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Date formatDate(String date) {
        try {
            return FORMATTER.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(ListContainerToDo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String formattedDateString(Date date) {
        return FORMATTER.format(date);
    }

}
