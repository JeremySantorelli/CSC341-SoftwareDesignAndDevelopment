package Assignment9.Observer;

public class ObserverLead extends Observer {
    
    ObserverType o;
    
    public ObserverLead(MailSystem sys) {
        o = ObserverType.LED;
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
        System.out.println("New Message for Team Leaders: \n" + m);
    }

    @Override
    public ObserverType getType() {
        return o;
    }        
}
