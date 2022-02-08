package Terminal;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ComponenteProcesor.AdressUAL;
import ComponenteProcesor.FloatUAL;
import ComponenteProcesor.FunctionalState;
import ComponenteProcesor.FunctionalUnit;
import ComponenteProcesor.Instruction;
import ComponenteProcesor.InstructionI;
import ComponenteProcesor.InstructionJ;
import ComponenteProcesor.InstructionR;
import ComponenteProcesor.InstructionStatus;
import ComponenteProcesor.IntegerUAL;

public class DispatcherInstruction {
	private ArrayList<FunctionalUnit> units;
	
	
	
	public ArrayList<FunctionalUnit> getUnits() {
		return units;
	}



	public void setUnits(ArrayList<FunctionalUnit> units) {
		this.units = units;
	}



	public FunctionalUnit dispatch(InstructionStatus insStatus)
	{
		Instruction ins=insStatus.getInstruction();
	 boolean freeUnit=false;
	 
	 String[] Patterns= {
		       "^#file","^ADD","^SUB","^MUL","^DIV",
		       "^AND","^OR","^XOR",
		       "^ADDI","^SUBI ","^MULI","^DIVI",
		       "^FADD ","^FSUB","^FMUL","^FDIV ",
		       "^FSQRT","^FABS ",
		       "^SL","^SR ","^LD","^ST","^JMP","^BZ","^BGTZ",
		       "^BLTZ"};
	 
	      
	   int tipIns=-1;
	 for(int i=1;i<=25;i++)
	 {
	    String pat=Patterns[i];
	    Pattern pattern=Pattern.compile(pat);
		Matcher matcher=pattern.matcher(ins.getCode());
		 if(matcher.find())
		 {
			 if(i<11 || (i>17 && i<22))
			 {
				 tipIns=1;
			 }
			 else
				 if(i<=17)
				 {
					 tipIns=2;
				 }
				 else
				 {
					 tipIns=3;
					 
				 }
					 
					 
		 }
		
		 
	 }
	 System.out.println("Dispatcher "+ins.getCode() +" tip:"+tipIns);
	 
  int i=0;
	 
	    for(FunctionalUnit unit: units )
	    {   
	    	System.out.println("unit exists "+i+" unit:"+unit+" "+unit.getState());
	    	i++;
	        
	    	{
	    		System.out.println(i+" fu:"+unit+" tip cautat:"+tipIns);
	    		i++;
	    		boolean rightType=false;
	    		
	    		if(tipIns==1)
	    			if(unit instanceof IntegerUAL)
	    				rightType=true;
	    		
	    	    if(tipIns==2)
	    	    	if(unit instanceof FloatUAL)
	    	    		rightType=true;
	    	    	
	    	 	if(tipIns==3)
	    	 		if(unit instanceof AdressUAL)
	    	 			rightType=true;
	    	 		
	    	
	    	 	
	    		if(rightType)
	    			if(unit.getState()==FunctionalState.FREE)
	    		{
	    			
	    		System.out.println("se intampla asta");
	    		unit.setInstructionInUse(ins);
		    	ins.setUnitateCurenta(unit);
	    		unit.setState(FunctionalState.BUSY);
	    		unit.setOperation();
	    		  return unit;
	    		
	    		}
	    			
	       }
	    	
	    }
	 
		
			
			insStatus.addHazardGetId2(units.get(0).getCurentClock(),"STRUCTURAL HAZARD FOR FU ",null, null);
	
	
	   return null;
	 
		
	}
	
	
	
}
