/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriac.poo.structs;

import java.io.Serializable;

/**
 *
 * @author rhobincu
 */
public class PrivateMessage extends Message implements Serializable {

    private final String mRecipient;
    
    public PrivateMessage(String recipient, String sender, String content) {
        super(sender, content);
        mRecipient = recipient;
    }
    
    public String toString() {
        return "(priv) " + super.toString();
    }
    
    public String getRecipient() {
        return mRecipient;
    }
}
