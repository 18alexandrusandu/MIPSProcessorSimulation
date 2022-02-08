package Terminal;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;

import ComponenteProcesor.Instruction;
import ComponenteProcesor.InstructionRegister;
import ComponenteProcesor.RegisterFile;

public class Reader {
	
	public  void readFromFile(String filePath,DecodeInstruction dI,InstructionRegister rI,RegisterFile rf)
	{
		
		File f=new File(filePath);
		try {
			Scanner scanner=new Scanner(f);
			
			while(scanner.hasNextLine())
			{
				
				String line=scanner.nextLine();
				//System.out.println(line);
			    dI.decodeLine(line,rI, rf, this);
				
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	

	public void reading_from_terminal(DecodeInstruction dI,InstructionRegister iR,RegisterFile rf)
	{
		System.out.println("Citire din consola");
    try
    {
         BufferedReader fromConsole = 
        new BufferedReader(new InputStreamReader(System.in));
      String message;

      while (true) 
      {
        message = fromConsole.readLine();
        if(message!=null)
        	{System.out.println("citit "+message);
        	  dI.decodeLine(message, iR,rf,this);
        	}
        	
    } 
    }
    catch (Exception ex) 
    {
      System.out.println
        ("Unexpected error while reading from console!");
    }
    
	}
	public void reading_from_terminal(String text,DecodeInstruction dI,InstructionRegister iR,RegisterFile rf)
	{
		System.out.println("Citire din interfata terminal");
    try
    {
    	
         InputStream inputStream = new ByteArrayInputStream(text.getBytes(Charset.forName("UTF-8")));
         BufferedReader fromTerminal = 
        new BufferedReader(new InputStreamReader(inputStream));
      String message;
        message=fromTerminal.readLine();
      while (message!=null) 
      {
       
        if(message!=null)
        	{System.out.println("citit "+message);
        	  dI.decodeLine(message, iR,rf,this);
        	}
          message = fromTerminal.readLine();
        	
     } 
    }
    catch (Exception ex) 
    {
      System.out.println
        ("Unexpected error while reading from console!");
    }
    
	}
    
	
	
	
	
	
    
}
