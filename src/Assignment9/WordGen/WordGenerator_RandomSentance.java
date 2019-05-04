package Assignment9.WordGen;

public class WordGenerator_RandomSentance extends WordGenerator {

    Sentence s;

    @Override
    Sentence processRequest(String[][] arr) {
        if (s == null) {
            s = new Sentence(arr);
        }

        s.generateRandomSentance();

        return s;

    }

}
