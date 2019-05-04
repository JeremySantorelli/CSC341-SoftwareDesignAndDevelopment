package Assignment1;

import java.text.ParseException;

/**
 * @author Whoever
 *
 */
interface DataHandler{
	void getData(String connectionStr) throws ParseException;
	void saveData(String connectionStr);
}



