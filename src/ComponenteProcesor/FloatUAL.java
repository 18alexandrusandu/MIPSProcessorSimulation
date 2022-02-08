package ComponenteProcesor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FloatUAL extends UAL{

	 static Integer index=0;
	Float result;
	
	
	
	FloatUAL()
	{
		super();
		index++;
		this.setName("Float"+index);
		
		
	}
	

	void fadd (RegistruFloat destination ,RegistruFloat source1,RegistruFloat source2)
	{
		result=(source1.getValue()+source2.getValue());
		
	}
	
	
	void fsub (RegistruFloat destination ,RegistruFloat source1,RegistruFloat source2)
	{
		result=(source1.getValue()-source2.getValue());
		
	}
	
	void fdiv (RegistruFloat destination ,RegistruFloat source1,RegistruFloat source2)
	{
		result=(source1.getValue()/source2.getValue());
		
	}
	
	void fmul (RegistruFloat destination ,RegistruFloat source1,RegistruFloat source2)
	{
		result=(source1.getValue()*source2.getValue());
		
	}
	
	void fabs (RegistruFloat destination ,RegistruFloat source1)
	{
		result=(Math.abs(source1.getValue()));
		
	}
	void fsqrt (RegistruFloat destination ,RegistruFloat source1)
	{
		result=(float)(Math.sqrt(source1.getValue()));
		
	}
	
	
	
	public Float getResult() {
		return result;
	}


	public void setResult(Float result) {
		this.result = result;
	}


	public void doOperation()
	{
		 System.out.println("operez"+this);
		Pattern pattern=Pattern.compile("FADD");
		Matcher matcher=pattern.matcher(getOperation());
		 if(matcher.find())
		 {
			InstructionR ins=(InstructionR)(getInstructionInUse());
			fadd((RegistruFloat)ins.getDestination(),(RegistruFloat)ins.getSource1(),(RegistruFloat)ins.getSource2());
			 
		 }
		 pattern=Pattern.compile("FSUB");
		 matcher=pattern.matcher(getOperation());
		 if(matcher.find())
		{
			 InstructionR ins=(InstructionR)(getInstructionInUse());
				fsub((RegistruFloat)ins.getDestination(),(RegistruFloat)ins.getSource1(),(RegistruFloat)ins.getSource2());
			 
	    }
		 pattern=Pattern.compile("FDIV");
		 matcher=pattern.matcher(getOperation());
		 if(matcher.find())
		{  
			 InstructionR ins=(InstructionR)(getInstructionInUse());
			 fdiv((RegistruFloat)ins.getDestination(),(RegistruFloat)ins.getSource1(),(RegistruFloat)ins.getSource2());
	    }
		 pattern=Pattern.compile("FMUL");
		 matcher=pattern.matcher(getOperation());
		 if(matcher.find())
		{
			 InstructionR ins=(InstructionR)(getInstructionInUse());
			fmul((RegistruFloat)ins.getDestination(),(RegistruFloat)ins.getSource1(),(RegistruFloat)ins.getSource2());
				 
	    }
		 pattern=Pattern.compile("FABS");
		 matcher=pattern.matcher(getOperation());
		 if(matcher.find())
		{
			 InstructionI ins=(InstructionI)(getInstructionInUse());
			 fabs((RegistruFloat)ins.getDestination(),(RegistruFloat)ins.getSource1());
	    }
		 
		 pattern=Pattern.compile("FSQRT");
		 matcher=pattern.matcher(getOperation());
		 if(matcher.find())
		{
			 InstructionI ins=(InstructionI)(getInstructionInUse()); 
			 fsqrt((RegistruFloat)ins.getDestination(),(RegistruFloat)ins.getSource1());
	    }
		 
		 
		 
	}
	
	
	
	
	
	
	
	
	
	
}
