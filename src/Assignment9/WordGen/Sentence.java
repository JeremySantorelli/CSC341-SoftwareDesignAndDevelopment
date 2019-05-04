package Assignment9.WordGen;
//[0][n] = subject[], [1][n] = verb[], [2][n] = adverb[], [3][n] = object[]

class Sentence {

    String[][] incoming;


    String subject, verb, adverb, object;

    public Sentence(String[][] incoming) {
        this.incoming = incoming;
    }

    public void generateRandomSentance() {

        int subjectInt = (int) (Math.random() * incoming[0].length);
        int verbInt = (int) (Math.random() * incoming[1].length);
        int adverbInt = (int) (Math.random() * incoming[2].length);
        int objectInt = (int) (Math.random() * incoming[3].length);

        subject = getSubject(subjectInt);
        verb = getVerb(verbInt);
        adverb = getAdverb(adverbInt);
        object = getObject(objectInt);

    }

    public String getSubject(int randomIndex) {
        return incoming[0][randomIndex];
    }

    public String getVerb(int randomIndex) {
        return incoming[1][randomIndex];
    }

    public String getAdverb(int randomIndex) {
        return incoming[2][randomIndex];
    }

    public String getObject(int randomIndex) {
        return incoming[3][randomIndex];
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public void setAdverb(String adverb) {
        this.adverb = adverb;
    }

    public void setObject(String object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return subject + " " + verb + " " + adverb + " " + object + ".";
    }

}
