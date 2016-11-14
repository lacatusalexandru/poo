/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriac.poo.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;
import seriac.poo.structs.Message;
import seriac.poo.structs.PrivateMessage;

/**
 *
 * @author toader
 */
public class ClientPeer implements Serializable {

    public final Socket inputSocket;
    public final String userName;
    public final String sender = null;
    
    public ClientPeer(String userName, Socket inputSocket){
        this.userName = userName; //username
        this.inputSocket = inputSocket; //socket
    }
    
    void sendMessage(String message) throws IOException, UnknownHostException {
        
        try{
        
        Message messageObj = new Message(sender, message); //instantiere obiect mesaj
        OutputStream _outputStream = inputSocket.getOutputStream(); // instantiere output stream. folosit pentru a trimite mesajul catre server
        InputStream _inputStream = inputSocket.getInputStream(); // instantiere input stream. folosit pentru a primi mesajul de la server. neutilizat inca
        
        _outputStream.write(messageObj.toString().getBytes()); // trimite textul din messageObj prin metoda toString
        
        inputSocket.close(); // inchide socket de retea
        
        } catch(IOException _ioe){
            return;
        }
        
 
    }
    
    void sendMessage(String message, String recipient) throws IOException{
        try{
        
        PrivateMessage privateMessageObj = new PrivateMessage(recipient,sender, message);
        OutputStream _outputStream = inputSocket.getOutputStream();
        InputStream _inputStream = inputSocket.getInputStream();
        
        _outputStream.write(privateMessageObj.toString().getBytes());
        
        inputSocket.close();
        
        } catch(IOException _ioe){
            return;
        }
    }
}