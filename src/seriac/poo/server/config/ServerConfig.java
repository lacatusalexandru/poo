/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriac.poo.server.config;
 
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import seriac.poo.server.exceptions.InvalidFormatException;
import seriac.poo.server.exceptions.MissingKeyException;
import seriac.poo.server.exceptions.UnknownKeyException;
 
/**
 *
 * @author student
 */
public class ServerConfig {
    String nameFile;
    BufferedReader br = null;
    int[] value;
    String[] property;
    int i = 0;
   
    int TCP_CHECK = 0;
    int MAX_CHECK = 0;
    int TCP_PORT = 0;
    int MAX_CLIENTS = 0;
   
    public ServerConfig(String nameFile) throws IOException, InvalidFormatException, UnknownKeyException, MissingKeyException{
        this.nameFile = nameFile;
        FileReader input = new FileReader(nameFile);
        BufferedReader bufr = new BufferedReader(input);
       
        while(bufr.ready() == true){
            String[] splitValue;
            String str = bufr.readLine();
            str = str.trim();
            if(str.startsWith("#")) continue;
           
            if (str.indexOf("=") == -1){
                throw new InvalidFormatException();
            }
           
            splitValue = str.split("=");
            value[i] = Integer.parseInt(splitValue[2]);
            property[i] = splitValue[1];
           
            if(property[i] == "TCP_PORT"){
                TCP_CHECK = 1;
                TCP_PORT = Integer.parseInt(property[i]);
            }
            else if(property[i] == "MAX_CLIENTS"){
                MAX_CHECK = 1;
                MAX_CLIENTS = Integer.parseInt(property[i]);
            }
            else{
                throw new UnknownKeyException();}
            i++;
           
        }
        if(MAX_CHECK != 1 || TCP_CHECK != 1)
            throw new MissingKeyException();
    }
   
    public ServerConfig() throws UnknownKeyException, InvalidFormatException, IOException, MissingKeyException{
        this.nameFile = "server.conf";
        FileReader input = new FileReader(nameFile);
        BufferedReader bufr = new BufferedReader(input);
       
        while(bufr.ready() == true){
    String[] splitValue;
            String str = bufr.readLine();
            str = str.trim();
            if(str.startsWith("#")) continue;
           
            if (str.indexOf("=") == -1){
                throw new InvalidFormatException();
            }
           
            splitValue = str.split("=");
            value[i] = Integer.parseInt(splitValue[1]);
            property[i] = splitValue[0];
           
            if(property[i] == "TCP_PORT"){
                TCP_CHECK = 1;
                TCP_PORT = Integer.parseInt(property[i]);
            }
            else if(property[i] == "MAX_CLIENTS"){
                MAX_CHECK = 1;
                MAX_CLIENTS = Integer.parseInt(property[i]);
            }
            else{
                throw new UnknownKeyException();}
           
            i++;
           
        }
        if(MAX_CHECK != 1 || TCP_CHECK != 1)
            throw new MissingKeyException();
    }
   
    public int getTcpPort(){
        return TCP_PORT;
    }
   
    public int getMaxClients(){
        return MAX_CLIENTS;
    }
}
