/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servergrafico;
import java.io.IOException;
import java.net.ServerSocket;
/**
 *
 * @author Luca
 */
public class ServerGrafico {

    
    public static void main(String[] args) throws IOException {
         
        ServerSocket ss = new ServerSocket(6666);    
        
        while (true) {
            new MyThread(ss.accept()).start();
            System.out.println("Connesso");
        }
    }
    
}
