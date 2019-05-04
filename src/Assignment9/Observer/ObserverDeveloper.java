package Assignment9.Observer;

public class ObserverDeveloper extends Observer {
    
    ObserverType o;
    
    public ObserverDeveloper(MailSystem sys) {
        o = ObserverType.DEV;
        this.mailSYS = sys;
        this.mailSYS.attach(this);
    }

    @Override
    public void readInbox() {
        
        for(Mail m : mailSYS.getMail(o)){
        System.out.println(m + "\n");
        }
        
    }

    @Override
    public void newMessage(Mail m) {
        System.out.println("New Message for Developers: \n" + m);
    }

    @Override
    public ObserverType getType() {
        return o;
    }        
}
