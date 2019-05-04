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
public class Bank {

    public void processCheck(Check theCheck, String acctNum) {
        Account acct = new Account(acctNum);
        double amount = theCheck.getAmount();
        double balance = acct.getBalance();
        if (balance >= amount) {
            acct.addDebitTranaction(theCheck.getCheckNum(), amount);
            acct.storePhotoOfCheck(theCheck);

        } else {
            acct.addInsufficientFundFee();
            acct.noteReturnedCheck(theCheck);
            informCustomer(acct.getCustomerInfo());
        }
        fileCheck(theCheck);
    }

    private void fileCheck(Check theCheck) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void informCustomer(String customerInfo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
