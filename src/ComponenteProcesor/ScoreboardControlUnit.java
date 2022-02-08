package ComponenteProcesor;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Terminal.DispatcherInstruction;
import Terminal.ReaderInterface;

public class ScoreboardControlUnit implements Runnable{
private RegisterFile registers;
private ArrayList<InstructionStatus> instructions;
private ArrayList<InstructionStatus>   istoric;


private ArrayList<FunctionalUnit> functionalUnits;
private InstructionRegister insRegister;
private Integer ownClock;
private Integer OutsideClock;
private ReaderInterface readInterface;


public ReaderInterface getReadInterface() {
	return readInterface;
}
public void setReadInterface(ReaderInterface readInterface) {
	this.readInterface = readInterface;
}


boolean stoped;

public ScoreboardControlUnit()
{
	instructions=new ArrayList<InstructionStatus>();
	istoric=new ArrayList<InstructionStatus>();
	functionalUnits=new ArrayList<FunctionalUnit>();
	dI=new DispatcherInstruction();
	dI.setUnits(functionalUnits);
	registers=new  RegisterFile();
	insRegister=new  InstructionRegister();
	ownClock=0;
	OutsideClock=0;
	
}
void stop()
{
	stoped=true;
}


public Integer getOwnClock() {
	return ownClock;
}

public Integer getOutsideClock() {
	return OutsideClock;
}
public void setOutsideClock(Integer outsideClock) {
	OutsideClock = outsideClock;
}


DispatcherInstruction dI;


private Memory memory;

public RegisterFile getRegisters() {
	return registers;
}
public void setRegisters(RegisterFile registers) {
	this.registers = registers;
}
public ArrayList<InstructionStatus> getInstructions() {
	return instructions;
}



public void setInstructions(ArrayList<InstructionStatus> instructions) {
	this.instructions = instructions;

}

public void setInstructions(InstructionRegister iR) {
	this.instructions =new ArrayList<InstructionStatus>();
for(Instruction ins : iR.getInstructions())
{
	this.instructions.add(new InstructionStatus(ins));
}
}
public void addInstruction(Instruction ins)
{
	this.instructions.add(new InstructionStatus(ins));
	
}





public InstructionRegister getInsRegister() {
	return insRegister;
}
public void setInsRegister(InstructionRegister insRegister) {
	this.insRegister = insRegister;
}
public Memory getMemory() {
	return memory;
}
public void setMemory(Memory memory) {
	this.memory = memory;
}
public ArrayList<FunctionalUnit> getFunctionalUnits() {
	return functionalUnits;
}
public void setFunctionalUnits(ArrayList<FunctionalUnit> functionalUnits) {
	this.functionalUnits = functionalUnits;
}
private int previous;

public  synchronized void  run()
{     previous=-1;
	while(!stoped)
	{
		
	//	System.out.println("own:"+ownClock+ "  outside:" +OutsideClock+" previous:"+previous);
		int m=OutsideClock
		;ownClock=m;
		
		
		if(ownClock!=previous)
{
			
			//System.out.println("bazinka");
			previous=ownClock;
		
		
		
		System.out.println("own:"+ownClock+ "  outside:" +OutsideClock);
		
		
		
	int i=-1;
	
	//System.out.println("instructions:"+instructions);
  for(InstructionStatus  ins: instructions)
  {
	  
	  i++;

	  
	  if(ins.getStage()==Stage.PREINIT && i==getInsRegister().getPCPointer())
	  {
		  istoric.add(ins);
		  ins.setStage(Stage.INIT);
		  ins.setState(FunctionalState.FREE);
		  ins.setIsueStart(OutsideClock);
		  
	  }
	 
	 
	  if(ins.getState()!=FunctionalState.ENDED)
	  {
		   Instruction insInstruction= ins.getInstruction();
		  if(ins.getStage()==Stage.INIT)
		  {
			  System.out.println("INIT"+insInstruction.getCode());
			  boolean isNotHazard=true;
			  
		  
		     
		    
		     if(insInstruction instanceof InstructionJ)
		     {
		    	 
		    	 
		     }
		     if(insInstruction instanceof InstructionR)	 
		     {
		    	
		    	 
		    	 
		    		
		    	if(insInstruction.getDestination().getJob()==Job.WRITE)
		    	{  
		    		
		    		
		 
		    		isNotHazard=false;
		    		
		    	}
		    
		    		
		     }
		    	
		     if(insInstruction instanceof InstructionI)
			   {
		     
		     
		     
		         if(insInstruction.getDestination().getJob()==Job.WRITE)
		    	 	{
		    	 		 isNotHazard=false;
		    	
		    		
		    	 	}
		     
			   }
		     
		     if(!isNotHazard)
		     {
		    	 ins.setState(FunctionalState.STALLED);
		    	 for(InstructionStatus ins2: istoric)
		    	 {
		    		 
		    		 
		    	    if(ins2==ins)
		    		   break;
		    	    
		    	    
		    	    if(ins2.getState()!= FunctionalState.ENDED )
		    	    {
		    	    
		    	   Registru checkR= ins2.getInstruction().getDestination();
		    	    if(checkR==ins.getInstruction().getDestination())
		    		 ins.addHazardGetId(OutsideClock, "WAW", ins2.getInstruction());
		    	    }
		    	 
		    	 }
		    	 ins.addHazardGetId(OutsideClock, "WAW",null );
		     }
		     
		
		
	   if( isNotHazard) {
		        
				   FunctionalUnit fu=dI.dispatch(ins);
				   ins.getInstruction().setUnitateCurenta(fu);
				   
				    if(fu==null)
				    	 isNotHazard=false;
	
			      }
	         
	   
		     
		if(isNotHazard)   
		{      ins.setState(FunctionalState.BUSY);
			System.out.println("without hazards");
			ins.setReadOperandsStart(OutsideClock+1);
			
		  ins.setStage(Stage.READOPERANDS);  
		  
		  if(i==getInsRegister().getPCPointer() )
		  { getInsRegister().increaseCounter();
	        break;
			  
		  }
			  
		}
		else
			 ins.setState(FunctionalState.STALLED);
		     
		   }
		  else
		    if(ins.getStage()==Stage.READOPERANDS) {
		    	  System.out.println("reads operands: "+insInstruction.getCode());
		    	boolean isNotHazard=true;
		  
		    	  if(insInstruction instanceof InstructionR) {	 
		    	 
		    		  
		    	 if(((InstructionR)(insInstruction)).getSource1().getJob()==(Job.WRITE))
		    	 {  
		    		 System.out.println("i have an hazard1");
		    		 ins.setState(FunctionalState.STALLED);
		    		 ins.getInstruction().getUnitateCurenta().setRJ(false);
		    		
		    		 
		 
		    		 ins.addHazardGetId(OutsideClock, "RAW",((InstructionR)(insInstruction)).getSource1().getInstructionInUse() );
		    		 
		    		 
		    		 
		    		 isNotHazard=false;
		    	
		    		 
		    	 }
		       	 if(((InstructionR)(insInstruction)).getSource2().getJob()==(Job.WRITE))
		    	 {  
		    		 System.out.println("i have an hazard2");
		    		 ins.setState(FunctionalState.STALLED);
		    		 
		    		 isNotHazard=false;
		    		 ins.getInstruction().getUnitateCurenta().setRK(false);
		    		 
		    		 ins.addHazardGetId(OutsideClock, "RAW",((InstructionR)(insInstruction)).getSource2().getInstructionInUse() );
		    		 isNotHazard=false;
		    	 }
		    	 
		    	 
		    			 
		    	 
		    	  }
		    	  
				  if(insInstruction instanceof InstructionI)
				   {
						   if(((InstructionI)(insInstruction)).getSource1().getJob()==(Job.WRITE))
						 	 {  
							   System.out.println("i have an hazard 3");
							   ins.setState(FunctionalState.STALLED);
							   ins.getInstruction().getUnitateCurenta().setRJ(false);
							
					           ins.addHazardGetId(OutsideClock, "RAW",((InstructionI)(insInstruction)).getSource1().getInstructionInUse() );
							   
					           isNotHazard=false;
							   
						    }
							   
						    		 
						    		 
				}
				   
				 if(isNotHazard) {
					 System.out.println("go to execution no hazard");
					  ins.setState(FunctionalState.BUSY);
				      ins.setReadOperandsStop(OutsideClock);
					  ins.setStage(Stage.EXECUTION); 
					  ins.setExecutionStart(OutsideClock+1);
		     
				if(insInstruction instanceof InstructionJ)
				{
					
					InstructionJ inj=(InstructionJ)insInstruction;
			
				}
				  if(insInstruction instanceof InstructionR)
				  {
					  insInstruction.getDestination().setJob(Job.WRITE);
					  insInstruction.getDestination().setInstructionInUse(insInstruction);
					  ((InstructionR)(insInstruction)).getSource1().setJob(Job.READ);
					 // ((InstructionR)(insInstruction)).getSource1().setUnitInUse(insInstruction.getUnitateCurenta());
					  ((InstructionR)(insInstruction)).getSource2().setJob(Job.READ);
					 // ((InstructionR)(insInstruction)).getSource2().setUnitInUse(insInstruction.getUnitateCurenta()); 
					  
					  
				  }
				    	
				  if(insInstruction instanceof InstructionI)	
				  {
					  insInstruction.getDestination().setJob(Job.WRITE);
					  insInstruction.getDestination().setInstructionInUse(insInstruction);
					  ((InstructionI)(insInstruction)).getSource1().setJob(Job.READ);
					 
					 ((InstructionI)(insInstruction)).getSource1().setUnitInUse(insInstruction.getUnitateCurenta());
					  
					  
					  
				  }
				  
				  
				  FunctionalUnit fu2=ins.getInstruction().getUnitateCurenta();
				  if(fu2!=null)
				  {
					  System.out.println("set ready");
					  fu2.setRJ(true);
					  fu2.setRK(true);
					  fu2.setReadyAll(true);
				  }
				 
				  
		    }
		  
				 
				  
				  
				  
			
		   }
		    else
		    {
		    	if(ins.getStage()==Stage.EXECUTION)
		    	{
		    	   System.out.println("EXECUTION: "+insInstruction.getCode());
		    	}
		    	
		    	
		    	if(ins.getStage()==Stage.EXECUTION && (insInstruction.getUnitateCurenta().getState()==FunctionalState.ENDED || 
		    			insInstruction.getUnitateCurenta().getState()==FunctionalState.FREE))
		    			
		    		{
		    		ins.setExecutionStop(OutsideClock);
		    		ins.setStage(Stage.WRITERESULT);
		    		ins.setWriteResultStart(OutsideClock+1);
		    		 System.out.println("EXECUTION: "+insInstruction.getCode());
		    		}
		    	
			else
		    	if(ins.getStage()==Stage.WRITERESULT)
		    	{
		    		
		    		 System.out.println("Write Back Result: "+insInstruction.getCode());
		    		 
		    		boolean isNotHazard=true;
		    		FunctionalUnit unit=insInstruction.getUnitateCurenta();
		    		
		    		if( insInstruction.getDestination().getJob()==Job.READ)
			    	{
		    			
		    			System.out.println("hazard WAR");
			    	    ins.setState(FunctionalState.STALLED);
			    		isNotHazard=false;
			    		ins.addHazardGetId(OutsideClock, "WAR",null );
			    	 
			    	 
		    			 for(InstructionStatus ins2: istoric)
				    	 {
				    		
				    	    
				    	    if(ins2.getState()!= FunctionalState.ENDED )
				    	    {
				    	    	
				    	    	if(ins2.getInstruction() instanceof InstructionR)
				    	    	{
				    	         Registru checkR= ((InstructionR)(ins2).getInstruction()).getSource2();
				    	         Registru checkR2= ((InstructionR)(ins2).getInstruction()).getSource1();
				    	   
				    	    if(checkR==insInstruction.getDestination())
				    	       ins.addHazardGetId(OutsideClock, "WAR", ins2.getInstruction());
				    	    
				    	    if(checkR2==insInstruction.getDestination() )
					    	       ins.addHazardGetId(OutsideClock, "WAR", ins2.getInstruction());
					    	   
					    	   
					    	    if(checkR==insInstruction.getDestination())
					    	      ins.addHazardGetId(OutsideClock, "WAR", ins2.getInstruction());
				    	    	}
				    	    
				    	    	if(ins2.getInstruction() instanceof InstructionI)
				    	    	{
				    	       
				    	         Registru checkR2= ((InstructionI)(ins2).getInstruction()).getSource1();
				    	
				    	    
				    	    if(checkR2==insInstruction.getDestination())
					    	       ins.addHazardGetId(OutsideClock, "WAR", ins2.getInstruction());
					    	   
					    	   
					    	
				    	    	}
				    	    
				    	    	
				    	    	
				    	    
				    	    
				    	    }
				    	  }
				    	    
				    	    
				    	    
				    	    
				    	    
				    	 }
		    			
		    			
		    			
		    		if(isNotHazard)
		    		{ 
		    			ins.setWriteResultStop(OutsideClock);
		    			 insInstruction.getDestination().setInstructionInUse(null);
		    			 
		    			 ins.setStage(Stage.PREINIT);
		    			 ins.setState(FunctionalState.ENDED);
		    			 Registru registerDest=ins.getInstruction().getDestination();
		    			 
		    			 
                         {
                        	 
                        
		    			Pattern pattern=Pattern.compile("ST");
		    			
		    			Matcher matcher=pattern.matcher(ins.getInstruction().getOperation());
		    		 if(matcher.find())
		    		 {
		    			 Integer value=((IntegerUAL)unit).getResult();
		    			 
		    			 try {
							memory.write(((RegistruInt)(registerDest)).getValue(),value);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    			 memory.setState(FunctionalState.FREE);
		    			 readInterface.getResultArea().append("adress:"+value.toString()+"\n");
		    			 registerDest.setJob(Job.FREE);
		    		 }
		    		 else
		    		 {
		    		pattern=Pattern.compile("LD");
		    		matcher=pattern.matcher(ins.getInstruction().getOperation());
		    		 if(matcher.find())
		    		 {
		    			
		    			 registerDest.setJob(Job.FREE);
		    			 Integer value=null;
						try {
							value = memory.readInt(((IntegerUAL)unit).getResult());
							memory.setState(FunctionalState.FREE);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    			 
		    			   if(value!=null)
		    			   {
		    					 ((RegistruInt)(registerDest)).setValue(value);
				    			 readInterface.getResultArea().append(value.toString()+"\n");
		    			   }
		    
		    			 
		    			 
		    		 }else
		    		 { 
		    		  if(registerDest instanceof RegistruFloat)
		    		  {
		    			  Float result=((FloatUAL)unit).getResult();
		    			  ((RegistruFloat)registerDest).setValue(result);
		    			  registerDest.setJob(Job.FREE);
		    			  readInterface.getResultArea().append(result.toString()+"\n");
		    			  
		    		  }
		    			 
		    		  if(registerDest instanceof RegistruInt)
		    		  {
		    			  Integer result=((IntegerUAL)unit).getResult();
		    			  ((RegistruInt)registerDest).setValue( result);
		    			   registerDest.setJob(Job.FREE);
		    			   if(readInterface!=null)
		    			   {
		    				   readInterface.getResultArea().append(result.toString()+"\n");
		    			   }
		    		  }
		    		  
		    			  
		    		 }
		    		 
		    	
		
		    		}
		    		
		    		
		    	}
			
			
			
		  }
	   }
     }
	  }
	
  }
	for(FunctionalUnit unit : functionalUnits)
	{
		if(unit.getState()==FunctionalState.ENDED)
		{
			unit.setState(FunctionalState.FREE);
			
			Instruction ins= unit.getInstructionInUse();
		
	        System.out.println("I free instruction:"+ ins.getCode());
			     
			if(ins instanceof InstructionI)
			{
				
				  ((InstructionI)(ins)).getSource1().setJob(Job.FREE);
				  
				  ins.getDestination().setUnitInUse(null);
				  ((InstructionI)(ins)).getSource1().setUnitInUse(null);
				
			}
			
		    if(ins instanceof InstructionR)
		    {
		    	 
				  ((InstructionR)(ins)).getSource1().setJob(Job.FREE);
				  ((InstructionR)(ins)).getSource2().setJob(Job.FREE);
				  ins.getDestination().setUnitInUse(null);
				  ((InstructionR)(ins)).getSource2().setUnitInUse(null);
				  ((InstructionR)(ins)).getSource1().setUnitInUse(null);
				  
				  
				  
		    }
		    	
		    	
		    if(ins instanceof InstructionJ)	
		    {
		    	InstructionJ inj=(InstructionJ)ins;
				{
					
					
				
					
				}
				
		    }
		    unit.setInstructionInUse(null);
			
		}
		
		
		
		
		
		
		
		
		
		
		
	}


	
	
}


}
}

public boolean isStoped() {
	return stoped;
}
public void setStoped(boolean stoped) {
	this.stoped = stoped;
}
public DispatcherInstruction getdI() {
	return dI;
}
public void setdI(DispatcherInstruction dI) {
	this.dI = dI;
}
}










