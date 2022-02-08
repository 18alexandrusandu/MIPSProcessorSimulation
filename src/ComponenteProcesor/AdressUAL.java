package ComponenteProcesor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdressUAL extends UAL{
	
	boolean zero;
	boolean cary;
	boolean overflow;
	static Integer index=0;
	InstructionRegister iR;
	AdressUAL()
	{
		super();
		index++;
		this.setName("Adress"+index);
		
		
	}
	
	public InstructionRegister getiR() {
		return iR;
	}
	public void setiR(InstructionRegister iR) {
		this.iR = iR;
	}
	public boolean isZero() {
		return zero;
	}
	public void setZero(boolean zero) {
		this.zero = zero;
	}
	public boolean isCary() {
		return cary;
	}
	public void setCary(boolean cary) {
		this.cary = cary;
	}
	public boolean isOverflow() {
		return overflow;
	}
	public void setOverflow(boolean overflow) {
		this.overflow = overflow;
	}
	
	void compareGrater(RegistruInt source1,RegistruInt source2,Integer adress)
	{
		 if(source1.getValue()>source2.getValue())
		 {
			 
			 iR.setPCPointer(iR.getPCPointer()+adress);
		 }
		
	}
	
	void compareEqual(RegistruInt source1,RegistruInt source2,Integer adress)
	{
		
		 if(source1.getValue()==source2.getValue())
		 {
			 
			 iR.setPCPointer(iR.getPCPointer()+adress);
			 setZero(true);
		 }
		
	}
	void compareLess(RegistruInt source1,RegistruInt source2,Integer adress)
	{
		
		
		 if(source1.getValue()>source2.getValue())
		 {
			 
			 iR.setPCPointer(iR.getPCPointer()+adress);
			 
			 
		 }
		
		
	}
	
	void jump(Integer location)
	{
		iR.setPCPointer((iR.getPCPointer()>>26)<<26 + location);
		
	}
	
	
	
	public void doOperation()
	{
		 System.out.println("operez");
		Pattern pattern=Pattern.compile("BZ");
		Matcher matcher=pattern.matcher(getOperation());
		 if(matcher.find())
		 {
			InstructionI ins=(InstructionI)(getInstructionInUse());
			compareEqual((RegistruInt)ins.getDestination(),(RegistruInt)ins.getSource1(),ins.getImedeate());
			 
		 }
		 pattern=Pattern.compile("BGTZ");
		 matcher=pattern.matcher(getOperation());
		 if(matcher.find())
		{
			 InstructionI ins=(InstructionI)(getInstructionInUse());
			compareGrater((RegistruInt)ins.getDestination(),(RegistruInt)ins.getSource1(),ins.getImedeate());
			 
	    }
		 pattern=Pattern.compile("BLTZ");
		 matcher=pattern.matcher(getOperation());
		 if(matcher.find())
		{  
			 InstructionI ins=(InstructionI)(getInstructionInUse());
			 compareLess((RegistruInt)ins.getDestination(),(RegistruInt)ins.getSource1(),ins.getImedeate());
	    }
		 pattern=Pattern.compile("JMP");
		 matcher=pattern.matcher(getOperation());
		 if(matcher.find())
		{
			 InstructionJ ins=(InstructionJ)(getInstructionInUse());
			jump(ins.getJumpLocation());
				 
	    }
}
	
	

}
