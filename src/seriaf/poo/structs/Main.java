/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriaf.poo.structs;

/**
 *
 * @author professor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Message m1 = new Message("John", "Hi!");
        Message m2 = new Message("Mary", "Hello!");
        Message m3 = new Message("John", "Bye!");
        Message m4 = new Message("Mary", "Awww...");
        
        System.out.print(m1.toString());
        System.out.print(m2);
        System.out.printf("%s", m3);
        System.out.println(m4);
    }
    
}
