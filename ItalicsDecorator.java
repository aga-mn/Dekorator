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
public class ItalicsDecorator extends Decorator{
    
    private final String word;
    private ArrayList<Byte> tempByte;
    private final byte[] wordToByte;
   // private int[] wordToInt;
    private int index=0;
    
    ItalicsDecorator(OutputStream os, String word) throws UnsupportedEncodingException
    {
        super(os);
        this.word=word;
    
  wordToByte = word.getBytes("UTF8");
  tempByte=new ArrayList<>();
    }
    
    
    @Override
    public void write(int b)  throws IOException
    {
        if((int)wordToByte[index]==b)
        { 
            if(index==wordToByte.length-1)
            {
                     byte[] om=("<b>").getBytes();
                     byte[]cm=("</b>").getBytes();
                  
                   super.write(om);
                   for(int i=0;i<tempByte.size();i++){super.write(tempByte.get(i));}
                   super.write(b);
                   super.write(cm);
             
                   tempByte.clear();
                   index=0;
            }
            
            else    {
                    index++;  
                    tempByte.add((byte)b);
                    }
        
        }
        else  super.write(b);
       
   }
    
      
    
    @Override
    public void write(byte[] b, int off, int len) throws IOException
    {
        super.write(b,off,len);
    
    }
    
    @Override
    public void write (byte[]b) throws IOException
    {
        super.write(b);
    }
    
    @Override
    public void close() throws IOException
    {
      
        super.close();}
    
}
