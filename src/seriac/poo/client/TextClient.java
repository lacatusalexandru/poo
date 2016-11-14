/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriac.poo.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author student
 */
public class TextClient {
    
    public static void main() throws IOException{
        String _userName = null ;
        String _localAddress = "127.0.0.1";
        int port = 9000;
        String line;
        
        BufferedReader name = new BufferedReader(new InputStreamReader(System.in));
        _userName = name.readLine();
        
        
        Socket _socket = new Socket(_localAddress, port); 
        ClientPeer _clientPeer = new ClientPeer(_userName, _socket);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        while((line = in.readLine()) != null){ 
            String _message = null;
            if(line.startsWith("/w")){ 
                String _receiverName = null;
                String[] lineSplit;
                lineSplit = line.split(" ");
                for (int i = 2; i < lineSplit.length; i ++){ 
                    _message = _message + " " +  lineSplit[i]; 
                }
                _receiverName = lineSplit[1]; 
                _clientPeer.sendMessage(line, _receiverName); 
            }
            else{
            _clientPeer.sendMessage(_message); 
            }
            if(line.startsWith("/q")){ 
                break; 
            }
        }
    }
}
