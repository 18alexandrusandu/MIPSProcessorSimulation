package ComponenteProcesor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntegerUAL extends UAL{

	int index=0;
	Integer result;
	IntegerUAL()
	{   
		  super();
		  index++;
		  this.setName("Integers"+index);
		
		
	}
	void add (RegistruInt destination ,RegistruInt source1,RegistruInt source2)
	{  
		result=(source1.getValue()+source2.getValue());
		
		
	}
	
	
	void sub (RegistruInt destination, RegistruInt source1,RegistruInt source2)
	{
		result=(source1.getValue()-source2.getValue());
		
	}
	
	void div (RegistruInt destination ,RegistruInt source1,RegistruInt source2)
	{  if(source2.getValue()!=0)
	   result=(source1.getValue()/source2.getValue());
	   result=0;
	}
	
	void mul (RegistruInt destination ,RegistruInt source1,RegistruInt source2)
	{
		result=(source1.getValue()*source2.getValue());
		
	}
	void and(RegistruInt destination ,RegistruInt source1,RegistruInt source2)
	{
		result=(source1.getValue()&source2.getValue());
	}
	void  or(RegistruInt destination ,RegistruInt source1,RegistruInt source2)
	{
		result=(source1.getValue()|source2.getValue());
	}

	void  xor(RegistruInt destination ,RegistruInt source1,RegistruInt source2)
	{
	    result=(source1.getValue()^source2.getValue());
	}

	
	
	void addi (RegistruInt destination ,RegistruInt source1,Integer source2)
	{
		result=(source1.getValue()+source2);
		
	}
	
	
	void subi (RegistruInt destination ,RegistruInt source1,Integer source2)
	{
		result=(source1.getValue()-source2);
		
	}

	void divi (RegistruInt  destination ,RegistruInt source1,Integer source2)
	{  	if(source2!=0)
		 result=source1.getValue()/source2;
	     result=0;
		
	}
	
	void muli (RegistruInt destination ,RegistruInt source1,Integer source2)
	{
		result=(source1.getValue()*source2);
		
	}
	void SR (RegistruInt destination ,RegistruInt source1,Integer source2)
	{
		result=(source1.getValue()>>source2);
		
	}
	void SL (RegistruInt destination ,RegistruInt source1,Integer source2)
	{
		result=(source1.getValue()<<source2);
		
	}
	void Load (RegistruInt destination ,RegistruInt source1,Integer source2)
	{
		result=(source1.getValue()+source2);
		
	}
	void Store (RegistruInt destination ,RegistruInt source1,Integer source2)
	{
		result=(source1.getValue()+source2);
		
	}
	public void doOperation()
	{
		 System.out.println("operez"+this);
		Pattern pattern=Pattern.compile("ADD");
		Matcher matcher=pattern.matcher(getOperation());
		 if(matcher.find())
		 {
			InstructionR ins=(InstructionR)(getInstructionInUse());
			add((RegistruInt)ins.getDestination(),(RegistruInt)ins.getSource1(),(RegistruInt)ins.getSource2());
			 
		 }
		 pattern=Pattern.compile("SUB");
		 matcher=pattern.matcher(getOperation());
		 if(matcher.find())
		{
			 InstructionR ins=(InstructionR)(getInstructionInUse());
				sub((RegistruInt)ins.getDestination(),(RegistruInt)ins.getSource1(),(RegistruInt)ins.getSource2());
			 
	    }
		 pattern=Pattern.compile("DIV");
		 matcher=pattern.matcher(getOperation());
		 if(matcher.find())
		{  
			 InstructionR ins=(InstructionR)(getInstructionInUse());
			 div((RegistruInt)ins.getDestination(),(RegistruInt)ins.getSource1(),(RegistruInt)ins.getSource2());
	    }
		 pattern=Pattern.compile("MUL");
		 matcher=pattern.matcher(getOperation());
		 if(matcher.find())
		{
			 InstructionR ins=(InstructionR)(getInstructionInUse());
			mul((RegistruInt)ins.getDestination(),(RegistruInt)ins.getSource1(),(RegistruInt)ins.getSource2());
				 
	    }
		 
		 
		 pattern=Pattern.compile("AND");
		 matcher=pattern.matcher(getOperation());
		 if(matcher.find())
		{
			 InstructionR ins=(InstructionR)(getInstructionInUse());
			and((RegistruInt)ins.getDestination(),(RegistruInt)ins.getSource1(),(RegistruInt)ins.getSource2());
				 
	    }
		 pattern=Pattern.compile("OR");
		 matcher=pattern.matcher(getOperation());
		 if(matcher.find())
		{
			 InstructionR ins=(InstructionR)(getInstructionInUse());
			or((RegistruInt)ins.getDestination(),(RegistruInt)ins.getSource1(),(RegistruInt)ins.getSource2());
				 
	    }
		 
		 pattern=Pattern.compile("XOR");
		 matcher=pattern.matcher(getOperation());
		 if(matcher.find())
		{
			 InstructionR ins=(InstructionR)(getInstructionInUse());
			xor((RegistruInt)ins.getDestination(),(RegistruInt)ins.getSource1(),(RegistruInt)ins.getSource2());
				 
	    }
		 
		
		 
		 
		 pattern=Pattern.compile("ADDI");
		 matcher=pattern.matcher(getOperation());
		 if(matcher.find())
		{
			 InstructionI ins=(InstructionI)(getInstructionInUse());
			 addi((RegistruInt)ins.getDestination(),(RegistruInt)ins.getSource1(),ins.getImedeate());
	    }
		 
		 pattern=Pattern.compile("SUBI");
		 matcher=pattern.matcher(getOperation());
		 if(matcher.find())
		{
			 InstructionI ins=(InstructionI)(getInstructionInUse()); 
			 subi((RegistruInt)ins.getDestination(),(RegistruInt)ins.getSource1(),ins.getImedeate());
	    }
		 pattern=Pattern.compile("DIVI");
		 matcher=pattern.matcher(getOperation());
		 if(matcher.find())
		{
			 InstructionI ins=(InstructionI)(getInstructionInUse()); 
			 divi((RegistruInt)ins.getDestination(),(RegistruInt)ins.getSource1(),ins.getImedeate());
	    }
		 pattern=Pattern.compile("MULI");
		 matcher=pattern.matcher(getOperation());
		 if(matcher.find())
		{
			 InstructionI ins=(InstructionI)(getInstructionInUse()); 
			 divi((RegistruInt)ins.getDestination(),(RegistruInt)ins.getSource1(),ins.getImedeate());
	    }
		 
		 
		 pattern=Pattern.compile("SL");
		 matcher=pattern.matcher(getOperation());
		 if(matcher.find())
		{
			 InstructionI ins=(InstructionI)(getInstructionInUse()); 
			 SL((RegistruInt)ins.getDestination(),(RegistruInt)ins.getSource1(),ins.getImedeate());
	    }
		 
		 
		 pattern=Pattern.compile("SR");
		 matcher=pattern.matcher(getOperation());
		 if(matcher.find())
		{
			 InstructionI ins=(InstructionI)(getInstructionInUse()); 
			 SR((RegistruInt)ins.getDestination(),(RegistruInt)ins.getSource1(),ins.getImedeate());
	    }
		 
		 pattern=Pattern.compile("LD");
		 matcher=pattern.matcher(getOperation());
		 if(matcher.find())
		{
			 InstructionI ins=(InstructionI)(getInstructionInUse()); 
			 addi((RegistruInt)ins.getDestination(),(RegistruInt)ins.getSource1(),ins.getImedeate());
	    }
		 pattern=Pattern.compile("ST");
		 matcher=pattern.matcher(getOperation());
		 if(matcher.find())
		{
			 InstructionI ins=(InstructionI)(getInstructionInUse()); 
			 addi((RegistruInt)ins.getDestination(),(RegistruInt)ins.getSource1(),ins.getImedeate());
	    }
		 
		 
	}
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	
	
	
	
	
	
}
