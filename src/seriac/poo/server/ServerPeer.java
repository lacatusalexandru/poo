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
import java.io.ObjectInputStream;
import seriac.poo.structs.Message;

/**
 *
 * @author student
 */
public class ServerPeer implements Serializable {
    Socket socket = null;
    
    public ServerPeer(Socket socket){
        this.socket = socket;
    }
    
    void run() throws IOException{
        try{
            Message message = new Message();
            ObjectInputStream _oIStream = new ObjectInputStream(socket.getInputStream());
        
        int _char;
        while((_char = _oIStream.read()) != -1){
            System.out.print((char)_char);
        }            
        } catch (EOFException _eofE){
            System.out.println("Connection interrupted");
        }
    }
}
