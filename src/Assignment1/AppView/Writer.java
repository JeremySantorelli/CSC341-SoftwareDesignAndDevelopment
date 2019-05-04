package Assignment1.AppView;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jeremy Santorelli
 */
public interface Writer {
    public String listResult(String input, List<String> list);
    public String listAllMessages(Map<Date, List<String>> list);
    public String display(String msg);
}
