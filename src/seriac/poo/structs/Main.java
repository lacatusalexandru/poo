/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriac.poo.structs;
import java.io.IOException;
import seriac.poo.server.config.ServerConfig;
import seriac.poo.server.exceptions.InvalidFormatException;
import seriac.poo.server.exceptions.MissingKeyException;
import seriac.poo.server.exceptions.UnknownKeyException;
import seriac.poo.server.config.*;

/**
 *
 * @author professor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, UnknownKeyException, InvalidFormatException, MissingKeyException {
        Message m1 = new Message("John", "Hi!");
        Message m2 = new Message("Mary", "Hello!");
        Message m3 = new Message("John", "Bye!");
        Message m4 = new Message("Mary", "Awww...");
        
        ServerConfig serverConfig = new ServerConfig();
        
        System.out.print(m1.toString());
        System.out.print(m2);
        System.out.printf("%s", m3);
        System.out.println(m4);
        System.out.print(serverConfig.getTcpPort());
        System.out.print(serverConfig.getMaxClients());
    }
    
}
