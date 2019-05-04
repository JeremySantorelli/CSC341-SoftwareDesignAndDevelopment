package Assignment9.Observer;
//developers, business analysts, team leads, and testers

public abstract class Observer {

    protected MailSystem mailSYS;

    public abstract void readInbox();

    public abstract void newMessage(Mail m);

    public abstract ObserverType getType();
}
