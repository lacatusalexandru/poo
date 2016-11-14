package seriac.poo.server.config;

import seriac.poo.server.exceptions.MissingKeyException;
import seriac.poo.server.exceptions.UnknownKeyException;
import seriac.poo.server.exceptions.InvalidFormatException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ServerConfig {

    private int mTcpPort;
    private int mMaxClients;
    
    public ServerConfig(String filename) throws IOException, InvalidFormatException, UnknownKeyException, MissingKeyException{
        mTcpPort = mMaxClients = -1;
        
        FileInputStream fileInputStream = new FileInputStream(filename);
        Scanner scanner = new Scanner(fileInputStream);
        
        while(scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            if(line.startsWith("#") || line.isEmpty()) continue;
            
            if(!line.matches("[a-zA-Z_][a-zA-Z0-9_]*\\s*=\\s*[0-9]+")) {
                throw new InvalidFormatException("Linia " + line + " nu se potriveste cu formatul asteptat!");                
            }
            
            processLine(line);
        }
        
        if(mTcpPort < 0) {
            throw new MissingKeyException("TCP_PORT lipseste din fisierul de configurare.");
        }
        
        if(mMaxClients < 0) {
            throw new MissingKeyException("MAX_CLIENTS lipseste din fisierul de configurare.");
        }
    }
    
    public ServerConfig() throws IOException, InvalidFormatException, UnknownKeyException, MissingKeyException{
        this("server.conf");
    }

    private void processLine(String line) throws UnknownKeyException {
        String[] words = line.split("=");
        switch(words[0].trim()) {
            case "TCP_PORT": 
                mTcpPort = Integer.parseInt(words[1].trim());
                break;
            case "MAX_CLIENTS": 
                mMaxClients = Integer.parseInt(words[1].trim());
                break;
            default:  throw new UnknownKeyException("Cheie necunoscuta: " + words[0].trim());
        }
    }

    public int getTcpPort() {
        return mTcpPort;
    }

    public int getMaxClients() {
        return mMaxClients;
    }
}
