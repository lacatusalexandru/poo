/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriac.poo.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;
import seriac.poo.structs.Message;
import seriac.poo.structs.PrivateMessage;

/**
 *
 * @author student
 */
public class ClientPeer implements Serializable {

    public final Socket socket;
    public final String userName;
    public final String sender = null;
    
    public ClientPeer(String userName, Socket inputSocket){
        this.userName = userName; 
        this.socket = inputSocket; 
    }
    
    
    void sendMessage(String message) throws IOException, UnknownHostException {
        
        try{
        
        Message messageObj = new Message(sender, message); 
        ObjectOutputStream _oOStream = new ObjectOutputStream(socket.getOutputStream());
        _oOStream.writeObject(messageObj); 
        socket.close(); 
        } catch(IOException _ioe){
            return;
        }
        
 
    }
    
    void sendMessage(String message, String recipient) throws IOException{
        try{
        
        PrivateMessage privateMessageObj = new PrivateMessage(recipient,sender, message);
        ObjectOutputStream _oOStream = new ObjectOutputStream(socket.getOutputStream());
        
        
        _oOStream.writeObject(privateMessageObj);
        _oOStream.close();
        
        } catch(IOException _ioe){
            System.out.println("test");
        }
    }
}