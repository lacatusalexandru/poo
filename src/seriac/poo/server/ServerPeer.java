/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriac.poo.server;

import java.io.Serializable;
import java.net.Socket;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import seriac.poo.structs.Message;

/**
 *
 * @author toader
 */
public class ServerPeer implements Serializable {
    Socket inputSocket = null;
    
    public ServerPeer(Socket inputSocket){
        this.inputSocket = inputSocket;
    }
    
    void run() throws IOException{
        try{
            Message message = new Message();
            InputStream _inputStream = inputSocket.getInputStream();
        
        int _char;
        while((_char = _inputStream.read()) != -1){
            System.out.print((char)_char);
        }            
        } catch (EOFException _eofE){
            System.out.println("Connection interrupted");
        }
    }
}
