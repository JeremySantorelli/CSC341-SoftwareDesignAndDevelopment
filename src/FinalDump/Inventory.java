/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalDump;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author jerem
 */
public class Inventory {

    private List<Guitar> guitars;

    public List<Guitar> search(Guitar target) {
        List<Guitar> toReturn = new ArrayList<>();
        Iterator<Guitar> it = guitars.iterator();
        while (it.hasNext()) {
            Guitar guitar = it.next();
            if (!guitar.allAttributesPopulated() && !guitar.equals(target)) {
                toReturn.add(guitar);
            }

        }
        return toReturn;
    }

}


