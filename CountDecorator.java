/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dekorator;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 *
 * @author molda-ni
 */
public class CountDecorator extends Decorator{
    
        private int count=0;
        private final String word;
        private final byte[] wordToByte;
        private ArrayList<Byte> tempByte;
        private int index=0;
       //private StringBuilder tmpword = new StringBuilder();
      
       CountDecorator(OutputStream os, String inword) throws UnsupportedEncodingException
    {
        super(os);
        this.word=inword;
        wordToByte = word.getBytes("UTF8");
        tempByte=new ArrayList<>();
    }
 
       @Override
       public void write(int b) throws IOException{
     
           if((int)wordToByte[index]==b)
        { 
            if(index==wordToByte.length-1)
            {       
                 for(int i=0;i<tempByte.size();i++){super.write(tempByte.get(i));}
                 super.write(b);
                   tempByte.clear();
                   index=0;
                   count++;
            }
            
            else    {
                    index++;  
                    tempByte.add((byte)b);
                    }
        
        }
        else  super.write(b);
           

       }
       
       @Override
       public void write(byte[]b) throws IOException{
       
        super.write(b);  
      
       }
       
       
       
       @Override
       public void write(byte[] b, int off, int len) throws IOException
       {
       
      super.write(b, off, len);
       }
       
        @Override
       public void close () throws IOException
       {
       super.close();
       System.out.println("Słowo "+word+ " wystąpiło "+ this.count+" razy");
       }
}
