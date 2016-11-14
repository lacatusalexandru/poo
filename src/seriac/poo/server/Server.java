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
 * @author student
 */
public class Server {
    void main() throws IOException, UnknownKeyException, InvalidFormatException, MissingKeyException{
        ServerConfig serverConfig = new ServerConfig(); 
        ServerSocket _serverSocket = new ServerSocket(serverConfig.getTcpPort()); 
        Socket _socket = _serverSocket.accept(); 
        
        ServerPeer _serverPeerObj = new ServerPeer(_socket); 
        _serverPeerObj.run(); 
    }
}
