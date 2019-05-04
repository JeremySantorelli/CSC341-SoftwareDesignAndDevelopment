/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalDump;

/**
 *
 * @author jerem
 */
public class Guitar {
    
    Attribute[] attributes;
    //Other code ommitted as it is unrelated to question
    public boolean allAttributesPopulated(){
        
        for(Attribute a : attributes){
            if(a.equals("")){
                return false;
            }
        }
        return true;
        
    }

}
