/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriac.poo.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author toader
 */
public class TextClient {
    
    public static void main() throws IOException{
        String _userName = new String();
        String _localAddress = "127.0.0.1";
        int port = 9000;
        String line;
        
        Socket _inputSocket = new Socket(_localAddress, port); // creeaza un socket la adresa 127.0.0.1 la portul 9000
        ClientPeer _clientPeer = new ClientPeer(_userName, _inputSocket);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // citire de la tastatura
        while((line = in.readLine()) != null){ // cat timp exista o linie cu text
            String _message = null;
            if(line.startsWith("/w")){ // cazul in care este private message
                String _receiverName = null;
                String[] lineSplit;
                lineSplit = line.split(" "); // imparte linia dupa spatii (" ") pentru a determina numele utilizatorului. Numele utilizatorului este mereu al doilea (0 primul 1 al doilea) element
                for (int i = 2; i < lineSplit.length; i ++){ // parcurge vectorul lineSplit de la al 2-lea element 
                    _message = _message + " " +  lineSplit[i]; // rescrierea liniei fara "/w" si numele recipientului
                }
                _receiverName = lineSplit[1]; // seteaza al doilea element sa fie numele
                _clientPeer.sendMessage(line, _receiverName); // trimite mesajul de tip privat
            }
            else{
            _clientPeer.sendMessage(in.readLine()); // altfel trimite mesajul cu tip public
            }
            if(line.startsWith("/q")){ // daca incepe cu "/q" 
                break; // iesi din while
            }
        }
    }
}
