package Assignment1;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Jeremy Santorelli
 */
public class ListContainerToDo implements ListContainer {

    private final Map<Date, List<String>> toDoList;

    public ListContainerToDo() {

        this.toDoList = new TreeMap<>();
    }

    @Override
    public Map<Date, List<String>> getMessages() {
        return toDoList;
    }

    @Override
    public List<String> getMessagesByDate(String date) throws ParseException {
        date = date.trim();
        Date findDate;
        if (date.isEmpty()) {
            findDate = DateUtility.getDate();
        } else {
            findDate = DateUtility.formatDate(date);
        }
        return toDoList.get(findDate);
    }

    @Override
    public void setMessage(String message, String date) throws ParseException {
        date = date.trim();
        Date setDate;
        if (date == null || "".equals(date)) {
            setDate = DateUtility.getDate();
        } else {
            setDate = DateUtility.formatDate(date);
        }
        List<String> list = toDoList.get(setDate);
        if (list != null) {
            list = toDoList.get(setDate);
            list.add(message);
            this.toDoList.replace(setDate, list);
        } else {
            list = new ArrayList<>();
            list.add(message);
            this.toDoList.put(setDate, list);
        }
    }

    @Override
    public int getSize() {
        return toDoList.size();
    }

    @Override
    public String removeSingle(String seq) {

        String[] parts = seq.split(" ");
        int dateRef = Integer.parseInt(parts[0]);
        int itemRef = Character.getNumericValue(parts[1].toLowerCase().charAt(0));

        Iterator it = toDoList.entrySet().iterator();
        int count = 1;
        String removed = "";
        while (it.hasNext()) {
            if (count == dateRef) {
                Map.Entry pair = (Map.Entry) it.next();
                Date date = DateUtility.formatDate((Date) pair.getKey());
                List<String> entryList = (List<String>) pair.getValue();
                boolean found = false;
                for (int i = 0; i < entryList.size(); i++) {
                    int lower = Character.getNumericValue((char) ('a' + i));
                    if (lower == itemRef) {
                        removed = entryList.remove(i);
                        found = true;
                        break;
                    }
                    toDoList.replace(date, entryList);
                }
                if (found) {
                    break;
                }
            }
            count++;

        }

        if (!removed.isEmpty()) {
            removed += " << WAS REMOVED";
        }
        return removed;

    }

    @Override
    public String remove(String date) {

        Date rDate = DateUtility.formatDate(date);
        int initial = getSize();
        toDoList.remove(rDate);
        int newSize = initial - getSize();
        if (newSize > 0) {
            return "The list for " + date + " was Removed.";
        } else {
            return "The date " + date + " was not found. Nothing was removed.";
        }
    }

}
