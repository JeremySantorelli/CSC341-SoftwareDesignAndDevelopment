package Assignment1.AppView;

import Assignment1.DateUtility;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jeremy Santorelli
 */
public class MessageWriter {

    public static String listResult(String input, List<String> list) {
        String ret = input + "\n\n";
        if (input.isEmpty()) {
            ret = DateUtility.formattedDateString(DateUtility.getDate()) + "\n\n";
        }

        ret = list.stream().map((l) -> l + "\n").reduce(ret, String::concat);
        return ret;
    }

    public static String listAllMessages(Map<Date, List<String>> list) {
        String ret = "CURRENT TO DO LIST " + System.lineSeparator() + System.lineSeparator();

        Iterator it = list.entrySet().iterator();
        int count = 0;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            Date date = DateUtility.formatDate((Date) pair.getKey());
            List<String> entryList = (List<String>) pair.getValue();
            String messages = System.lineSeparator() + ++count + ". "
                    + DateUtility.formattedDateString(date)
                    + System.lineSeparator() + System.lineSeparator();
            for (int i = 0; i < entryList.size(); i++) {
                char lower = (char) ('a' + i);
                messages += lower + ". " + entryList.get(i) + System.lineSeparator();
            }
            ret += messages + System.lineSeparator();

        }
        return ret;
    }

    public static String display(String msg) {
        return "\n" + msg;
    }
}
