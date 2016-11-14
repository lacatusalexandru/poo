/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriac.poo.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import seriac.poo.server.config.ServerConfig;
import seriac.poo.server.exceptions.InvalidFormatException;
import seriac.poo.server.exceptions.MissingKeyException;
import seriac.poo.server.exceptions.UnknownKeyException;

/**
 *
 * @author toader
 */
public class Server {
    void main() throws IOException, UnknownKeyException, InvalidFormatException, MissingKeyException{
        ServerConfig serverConfig = new ServerConfig(); // creeaza obiect de tip ServerConfig
        
        ServerSocket _serverSocket = new ServerSocket(serverConfig.getTcpPort()); // foloseste metoda getTcpPort() al obiectului _serverConfig pentru a deschide un socket de server (ServerSocket)
        Socket _inputSocket = _serverSocket.accept(); // deschide un socket normal ce accepta conexiuni de la _serverSocket
       
        
        ServerPeer _serverPeerObj = new ServerPeer(_inputSocket); // creeaza obiect de tip ServerPeer si il instantiaza cu socketul de mai sus 
        
        _serverPeerObj.run(); // apeleaza metoda run() din ServerPeer. ruleaza pana la EOFException
    
    }
}
