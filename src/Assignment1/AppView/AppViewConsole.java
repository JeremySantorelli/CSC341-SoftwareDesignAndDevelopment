package Assignment1.AppView;

import java.util.*;
import Assignment1.ListContainer;
import java.text.ParseException;

public class AppViewConsole implements AppView {

    private final Scanner sc;
    private String input;
    private final ListContainer list;

    public AppViewConsole(ListContainer b) {
        list = b;
        sc = new Scanner(System.in);

    }

    @Override
    public String getInput(String prompt) {
        System.out.println(prompt);
        input = sc.nextLine();
        return input;
    }

    @Override
    public String getResult() throws ParseException {
        return MessageWriter.listResult(input, list.getMessagesByDate(input));
    }

    @Override
    public void display(String msg) {
        System.out.println(MessageWriter.display(msg));
    }
}
