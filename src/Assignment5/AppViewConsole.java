package Assignment5;

import Assignment2.*;
import Assignment1.AppView.*;
import java.util.*;
import java.text.ParseException;

public class AppViewConsole implements AppView {

    private final Scanner sc;
    private String input;
    MessageWriter w;

    public AppViewConsole(MessageWriter w) {
        sc = new Scanner(System.in);
        this.w = w;

    }

    @Override
    public String getInput(String prompt) {
        System.out.println(prompt);
        input = sc.nextLine();
        return input;
    }

    @Override
    public String getResult() throws ParseException {
        return input;
    }

    @Override
    public void display(String msg) {
        System.out.println(w.display(msg));
    }
}
