package Assignment1;

import Assignment1.AppView.AppView;
import Assignment1.AppView.AppViewConsole;
import Assignment1.AppView.AppViewGUI;
import Assignment1.AppView.MessageWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeremy Santorelli
 */
public final class AppControllerToDo implements AppController {

    private AppView view;
    private ListContainer list;
    private DataHandler handler;
    private String input, viewName;

    AppControllerToDo() throws ParseException {
        appInit();
    }

    @Override
    public void setView(String name) {
        this.viewName = name;
        if (viewName.equalsIgnoreCase("console")) {
            view = new AppViewConsole(list);
        } else if (viewName.equalsIgnoreCase("gui")) {
            view = new AppViewGUI(list);
        } else {
            view = null;
        }
        if (view != null) {

            view.display(MessageWriter.listAllMessages(list.getMessages()));
        } else {
            System.exit(1);
        }
    }

    @Override
    public void appInit() throws ParseException {
        list = new ListContainerToDo();
        handler = new DataHandlerFlatFile(list);
        handler.getData(Config.getFileName());
    }

    @Override
    public void run() throws ParseException {        
        do {
            input = view.getInput("Add (a) || Retrieve (r) a date || Show all (s) || Remove a single entry (e) || Delete (d) by Date || Save and quit (v)? ");
            if (input.equalsIgnoreCase("a")) {
                String date = view.getInput("Due Date? (set date as 'dd/MM/yyyy' or leave blank for today --> ");
                add(date);

                run();

            } else if (input.equalsIgnoreCase("r")) {
                input = view.getInput("Enter Date LIKE 'dd/MM/yyyy' --> or leave blank for today's list");
                view.display("\n" + view.getResult());
            } else if (input.equalsIgnoreCase("s")) {
                view.display(MessageWriter.listAllMessages(list.getMessages()));
            } else if (input.equalsIgnoreCase("d")) {
                input = view.getInput("Enter Date LIKE 'dd/MM/yyyy' --> or leave blank for today's list");
                view.display(list.remove(input));
            } else if (input.equalsIgnoreCase("e")) {
                input = view.getInput("Enter number letter sequence with space between");
                view.display(list.removeSingle(input));
            } else {
                quit();
                break;
            }
        } while (true);
    }

    private void add(String date) {
        try {

            String listItem = view.getInput("Enter to do list item --> ");
            list.setMessage(listItem, date);
            view.display("Current list size: " + list.getSize());
            again(date);
        } catch (ParseException ex) {
            Logger.getLogger(AppControllerToDo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void again(String date) throws ParseException {

        String again = view.getInput("add another? Y/N");
        if (again.equalsIgnoreCase("y")) {
            add(date);
        } else if (again.equalsIgnoreCase("q")) {
            quit();
        } else {
            run();
        }

    }

    private void quit() {
        handler.saveData(Config.getFileName());
        view.display(MessageWriter.listAllMessages(list.getMessages()));
    }
}
