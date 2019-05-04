package Assignment9.Observer;

import java.util.ArrayList;
import java.util.List;

public class MailSystem {

    private List<Observer> observers = new ArrayList<>();

    public List<Mail> getMail(ObserverType o) {

        return null;

    }

    public void sendMail(Mail m) {

        notifyAllObservers(m);
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    private void notifyAllObservers(Mail m) {
        boolean all = m.getO() == ObserverType.ALL;

        for (Observer observer : observers) {
            if (all) {
                observer.newMessage(m);
            } else if (observer.getType().equals(m.getO())) {
                observer.newMessage(m);
            }

        }

    }

}
