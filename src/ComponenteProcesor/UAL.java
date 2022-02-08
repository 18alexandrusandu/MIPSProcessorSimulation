package ComponenteProcesor;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UAL extends FunctionalUnit{
 public boolean isBusy() {
		return busy;
	}
	public void setBusy(boolean busy) {
		this.busy = busy;
	}
	public String getOperation() {
		return operation;
	}
	
	
	public void setOperation()
	{   setCurrentClocksFromInstruction(1);
		String operation=getInstructionInUse().getOperation();
		this.operation=operation;
		System.out.println("operation:"+operation);

		Pattern pattern=Pattern.compile("ADD");
		Matcher matcher=pattern.matcher(operation);
		 if(matcher.find())
		 {
			 this.setClocksPerInstruction(2);
		
		 }
		
		pattern=Pattern.compile("SUB");
	    matcher=pattern.matcher(operation);
		 if(matcher.find())
		 {
			 this.setClocksPerInstruction(2);
	
		 }
	    
	    pattern=Pattern.compile("MULTI");
	    matcher=pattern.matcher(operation);
		 if(matcher.find())
		 {
			 this.setClocksPerInstruction(10);
		
		 }
	    
		 
	    pattern=Pattern.compile("DIV");
	    matcher=pattern.matcher(operation);
	    if(matcher.find())
		 {
	   	 this.setClocksPerInstruction(20);
			
		 }
	   
		 
	    
	    pattern=Pattern.compile("AND");
	    matcher=pattern.matcher(operation);
	    if(matcher.find())
		 {
	   	 this.setClocksPerInstruction(2);
		 }
	   
	    
	    
	    pattern=Pattern.compile("OR");
	    matcher=pattern.matcher(operation);
	    if(matcher.find())
		 {
	   	 this.setClocksPerInstruction(2);
		
		 }
	   
	    
	    pattern=Pattern.compile("XOR");
	    matcher=pattern.matcher(operation);
	    if(matcher.find())
		 {
	    	
	   	 this.setClocksPerInstruction(2);
		 }
	   
	    
	    pattern=Pattern.compile("ADDI");
	    matcher=pattern.matcher(operation);
	    if(matcher.find())
		 {
	   	 this.setClocksPerInstruction(2);
		 }
	   
	    
	    
		 pattern=Pattern.compile("SUBI");
	     matcher=pattern.matcher(operation);
	     if(matcher.find())
	 	 {
	    	 this.setClocksPerInstruction(2);
	 	 }
	    
		
		
		pattern=Pattern.compile("MULI");
	    matcher=pattern.matcher(operation);
	    if(matcher.find())
	 	 {
	   	 this.setClocksPerInstruction(10);
	 	 }
	    
	    
	    pattern=Pattern.compile("DIVI");
	    matcher=pattern.matcher(operation);
	    if(matcher.find())
	 	 {
	   	 this.setClocksPerInstruction(20);
	 	 }
	    
	    
		 
	    pattern=Pattern.compile("FADD");
	    matcher=pattern.matcher(operation);
	    if(matcher.find())
	 	 {
	   	 this.setClocksPerInstruction(3);
	 	 }
	    
	    
		 
	    pattern=Pattern.compile("FSUB");
	    matcher=pattern.matcher(operation);
	    if(matcher.find())
		 {
	   	 this.setClocksPerInstruction(3);
		 }
	    

	    pattern=Pattern.compile("FMUL");
	    matcher=pattern.matcher(operation);
	    if(matcher.find())
	  	 {
	   	 this.setClocksPerInstruction(10);
	  	 }
	     
	    
	    pattern=Pattern.compile("FDIV");
	    matcher=pattern.matcher(operation);
	    if(matcher.find())
	  	 {
	   	 this.setClocksPerInstruction(15);
	  	 }
	     

		 
	  
	    pattern=Pattern.compile("FSQRT");
	    matcher=pattern.matcher(operation);
	    if(matcher.find())
	  	 {
	   	 this.setClocksPerInstruction(40);
	  	 }
	     
	    
	    pattern=Pattern.compile("FABS");
	    matcher=pattern.matcher(operation);
	    if(matcher.find())
	  	 {
	   	 this.setClocksPerInstruction(3);
	  	 }
	     
	    
	    
	    
	    
	    pattern=Pattern.compile("SL");
	    matcher=pattern.matcher(operation);
	    if(matcher.find())
	  	 {
	   	 this.setClocksPerInstruction(2);
	  	 }
	     
	    
	    
	    pattern=Pattern.compile("SR");
	    matcher=pattern.matcher(operation);
	    if(matcher.find())
	  	 {
	   	 this.setClocksPerInstruction(2);
	  	 }
	     
	    
	    
	    
	    
	    pattern=Pattern.compile("LD");
	    matcher=pattern.matcher(operation);
	    if(matcher.find())
	  	 {
	   	 this.setClocksPerInstruction(2);
	  	 }
	     
	    
	    pattern=Pattern.compile("ST");
	    matcher=pattern.matcher(operation);
	    if(matcher.find())
	  	 {
	   	 this.setClocksPerInstruction(2);
	  	 }
	     
	    
	    
	    
	    pattern=Pattern.compile("JMP");
	    matcher=pattern.matcher(operation);
	    if(matcher.find())
		 {
	   	 this.setClocksPerInstruction(2);
		 }
	   
	    pattern=Pattern.compile("BZ");
	    matcher=pattern.matcher(operation);
	    if(matcher.find())
	  	 {
	   	 this.setClocksPerInstruction(2);
	  	 }
	     
	    
	    pattern=Pattern.compile("BGTZ");
	    matcher=pattern.matcher(operation);
	    if(matcher.find())
	  	 {
	   	 this.setClocksPerInstruction(2);
	  	 }
	     
	    pattern=Pattern.compile("BLTZ");
	    matcher=pattern.matcher(operation);
	    if(matcher.find())
	  	 {
	   	 this.setClocksPerInstruction(2);
	  	 }
	     

		
	}
	
	
	
	
	
	
	
	
	
	
	
	public Registru getDestination() {
		return destination;
	}
	public void setDestination(Registru destination) {
		this.destination = destination;
	}
	public ArrayList<Registru> getSources() {
		return sources;
	}
	public void setSources(ArrayList<Registru> sources) {
		this.sources = sources;
	}
	public ArrayList<Integer> getFlags() {
		return Flags;
	}
	public void setFlags(ArrayList<Integer> flags) {
		Flags = flags;
	}
	public Integer getNumberOfCycles() {
		return numberOfCycles;
	}
	public void setNumberOfCycles(Integer numberOfCycles) {
		this.numberOfCycles = numberOfCycles;
	}
	public Thread getMainThread() {
		return mainThread;
	}
	public void setMainThread(Thread mainThread) {
		this.mainThread = mainThread;
	}
	public Instruction getInstruction() {
		return instruction;
	}
	public void setInstruction(Instruction instruction) {
		this.instruction = instruction;
	}
private	boolean busy;
 private	String operation;
 private	Registru destination;
 private  	ArrayList<Registru> sources;
 private 	ArrayList<Integer> Flags;
 private    Integer numberOfCycles;
 private    Thread mainThread;
 private    Instruction instruction;

}
