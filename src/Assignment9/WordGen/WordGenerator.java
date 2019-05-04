package Assignment9.WordGen;

abstract class WordGenerator{
	private WordGenerator next;	
	abstract Sentence processRequest(String[][] s);
        }
