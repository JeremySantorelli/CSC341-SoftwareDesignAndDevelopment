package Assignment1;

import java.text.ParseException;

/**
 * @author Dr.
 *
 */
interface AppController{
	void appInit() throws ParseException;
	void setView(String viewName);
	void run() throws ParseException;
}







