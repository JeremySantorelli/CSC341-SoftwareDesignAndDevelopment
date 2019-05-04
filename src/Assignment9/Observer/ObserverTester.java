package Assignment9.Observer;

public class ObserverTester extends Observer {
    
    ObserverType o;
    
    public ObserverTester(MailSystem sys) {
        o = ObserverType.TES;
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
        System.out.println("New Message for Testers: \n" + m);
    }

    @Override
    public ObserverType getType() {
        return o;
    }        
}
