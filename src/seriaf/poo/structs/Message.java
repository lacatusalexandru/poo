/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriaf.poo.structs;

/**
 *
 * @author professor
 */
public class Message {
    private String mSender;
    private String mContent;

    public Message(String sender, String content) {
        mSender = sender;
        mContent = content;
    }
    
    @Override
    public String toString() {
        return mSender + ": " + mContent + "\n";
    }
}
