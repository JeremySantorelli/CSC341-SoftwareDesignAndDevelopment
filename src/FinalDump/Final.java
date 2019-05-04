/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalDump;

import java.util.List;

/**
 *
 * @author jerem
 */
public class Final {
    
    private List<Mail> mails;
    
    public void handleMails(){
        for(int i = 0; i < mails.size(); i++){
            mails.get(i).processMail();
        }
        
    }

}
