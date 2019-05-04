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

//An emample which would replace the getBuilder() Method
public class AttributeBuilder implements Attribute{
    String attribute;
    @Override
    public String getAttribute() {
        return this.attribute;
    }    
}
