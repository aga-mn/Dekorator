/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dekorator;

import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author molda-ni
 */
public class Decorator extends OutputStream {

    private OutputStream os;
    Decorator(OutputStream os){this.os=os;
    if(os==null){throw new IllegalArgumentException();}
    }

    @Override
    public void write(int i) throws IOException 
    {
    os.write(i);
    }
    
    @Override
    
     public void write(byte[]b) throws IOException 
     {
      os.write(b);
     }
    
     @Override
    
     public void write(byte[] b, int off, int len) throws IOException 
     {
      os.write(b,off,len);
     }
     
     @Override
     public void close() throws IOException 
     {
     os.close();
     }
     
     @Override
     public void flush() throws IOException
     {
     os.flush();
     }
    
}
