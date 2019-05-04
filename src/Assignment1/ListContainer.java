package Assignment1;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jeremy Santorelli
 */
public interface ListContainer {

    Map<Date, List<String>> getMessages();

    public List<String> getMessagesByDate(String date) throws ParseException;

    int getSize();

    String remove(String date);

    public String removeSingle(String seq);

    void setMessage(String message, String date) throws ParseException;

}
