package Assignment9.Observer;

public class Mail {

    private final String from, to, subject, body;
    private final ObserverType o;

    public Mail(
            String from, String to, String subject,
            String body, ObserverType o
    ) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.o = o;
    }

    public ObserverType getO() {
        return o;
    }

    @Override
    public String toString() {

        return "FROM: " + from
                + "\nTO : " + to
                + "\nSUBJECT:\n " + subject
                + "\nBODY: \n" + body;
    }
}
