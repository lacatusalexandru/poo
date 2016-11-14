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
        ServerConfig serverConfig = new ServerConfig();

        System.out.println("server port " +serverConfig.getTcpPort());
        System.out.println("server clients " + serverConfig.getMaxClients());
    }
    
}
