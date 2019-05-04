/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jerem
 */
public class Test {
    
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        String strDate =  "Mon Apr 03 00:00:00 CDT 2000";
        
        
    }
    
        public Date getDate() {

        Date date = formatDate(new Date());

        if (date == null) {
            throw new NullPointerException("Date was returned null");
        }

        return date;
    }

    public Date formatDate(Date date) {
        try {
            return formatter.parse(formatter.format(date));
        } catch (ParseException ex) {
            Logger.getLogger(ListContainerToDo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
