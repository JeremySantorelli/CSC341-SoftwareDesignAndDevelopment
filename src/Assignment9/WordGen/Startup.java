package Assignment9.WordGen;

public class Startup {

    public static void main(String[] args) {

        String[][] words = {
            {"they", "dan", "buildings"},//subject
            {"ran", "kicked", "blocked"},//verb
            {"quickly from", "powerfully through", ""},//adverb
            {"the cheetah", "the ball", "the sun"}//object

        };

        WordGenerator gen = new WordGenerator_RandomSentance();

        for (int i = 0; i < 20; i++) {
            System.out.println(gen.processRequest(words));
        }
    }
}
