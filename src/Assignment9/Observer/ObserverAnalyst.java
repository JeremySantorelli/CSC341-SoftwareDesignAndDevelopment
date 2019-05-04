package Assignment9.Observer;

public class ObserverAnalyst extends Observer {
    
    ObserverType o;
    
    public ObserverAnalyst(MailSystem sys) {
        o = ObserverType.ANA;
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
        System.out.println("New Message for Analysts: \n" + m);
    }

    @Override
    public ObserverType getType() {
        return o;
    }        
}
