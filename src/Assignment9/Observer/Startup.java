package Assignment9.Observer;

public class Startup {

    public static void main(String[] args) {
        MailSystem sys = new MailSystem();

        new ObserverDeveloper(sys);
        new ObserverAnalyst(sys);
        new ObserverLead(sys);
        new ObserverTester(sys);

        String[] names = {
            "Developers", "Analysts",
            "Leads", "Testers",
            "All"};
        
        ObserverType[] type = {
            ObserverType.DEV, ObserverType.ANA,
            ObserverType.LED, ObserverType.TES,
            ObserverType.ALL
        };

        //Send some emails
        for (int n = 0; n < names.length; n++) {
            System.out.println((n + 1) + " EMAIL\n\n");
            sys.sendMail(
                    new Mail(
                            "me",
                            "you",
                            "ATTN: " + names[n],
                            "hello you,\n we will be doing testing tomorrow."
                                    + "\n Thanks,\n me\n\n",
                            type[n])
            );
        }
    }
}
