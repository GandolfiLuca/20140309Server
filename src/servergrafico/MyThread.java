/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servergrafico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luca
 */
public class MyThread extends Thread {
     private Socket s;

    public MyThread(Socket s) {
        this.s = s;
    }

    public void run() {    
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
           
            boolean maiusc = false;
                while(true) {
                    String str = in.readLine();
                    switch(str){
                        case "fine":                            
                            out.println("Connessione chiusa");
                            break;
                        case "on" :
                            String sx = in.readLine();
                           // maiusc = true;
                            out.println(sx.toUpperCase());
                            break;
                        case "off":
                            String sx1 = in.readLine();
                            //maiusc = false;  
                            out.println(sx1);
                            break;
                        default :
                            String sx2 = in.readLine();
                             //if(maiusc==true){                      
                               // out.println(str.toUpperCase());
                           // }else
                                out.println(sx2);
                            
                            break;
                    }
    
           
            }     
        }catch (IOException ex) {
             Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
         }

    }
}

