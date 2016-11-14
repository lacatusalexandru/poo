/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriac.poo.structs;

import java.io.Serializable;

/**
 *
 * @author professor
 */
public class Message implements Serializable {
    private String mSender;
    private String mContent;

    public Message(String sender, String content) {
        mSender = sender;
        mContent = content;
    }

    public Message() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        return mSender + ": " + mContent + "\n";
    }
}
