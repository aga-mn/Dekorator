/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dekorator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author niewega_local
 */
public class Dekorator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
      InputStream inStream=null;
      OutputStream outStream=null;
      
   try{
       File afile = new File("c:\\input.html");
        File bfile = new File("c:\\output.html");

        inStream = new FileInputStream(afile);
        
        outStream = new CountDecorator(new ItalicsDecorator(new BoldDecorator(new FileOutputStream(bfile),"BeBe" ),"BeBe"),"BeBe");
       // outStream = new CountDecorator(new BoldDecorator(new ItalicsDecorator(new FileOutputStream(bfile),"BeBe" ),"BeBe"),"BeBe");
        //outStream =       new ItalicsDecorator(new BoldDecorator(new FileOutputStream(bfile),"BeBe" ),"BeBe");
       //outStream = new CountDecorator(new FileOutputStream(bfile),"BeBe" );
      //outStream = new ItalicsDecorator(new FileOutputStream(bfile),"BeBe" );
      //outStream = new BoldDecorator(new FileOutputStream(bfile),"BeBe" );
        
         int b;
         while ((b = inStream.read( ))  != -1) {
         outStream.write(b);  
         }
    }
   
   catch (IOException e) {System.out.println("Error message: " + e.getMessage());}

    finally {
         if (inStream != null) inStream.close();
         if (outStream != null) outStream.close();
     
   }

       
        //test write (byte[])

//        byte[] buf = new byte[10];
//          int len;
//          while ((len = inStream.read(buf)) !=-1){
//            outStream.write(buf);
//          }

//        
//        byte[] buffer = new byte[10];
//int len;
//while ((len = inStream.read(buffer)) != -1) {
//    outStream.write(buffer, 0, len);
//}
      }
 
}

        
    
