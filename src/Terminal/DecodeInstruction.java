package Terminal;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import ComponenteProcesor.*;


public class DecodeInstruction {
	
ScoreboardControlUnit scoreboard;	
	
	
	
	
	
public ScoreboardControlUnit getScoreboard() {
	return scoreboard;
}





public void setScoreboard(ScoreboardControlUnit scoreboard) {
	this.scoreboard = scoreboard;
}





public void decodeLine(String line,InstructionRegister iR,RegisterFile rf,Reader r)
{
	
	 line=line.toUpperCase();
	 String[] Patterns= {
       "^#file","^ADD ","^SUB ","^MULTI","^DIV",
       "^AND ","^OR ","^XOR ",
       "^ADDI","^SUBI ","^MULI","^DIVI",
       "^FADD ","^FSUB","^FMUL","^FDIV ",
       "^FSQRT","^FABS ",
       "^SL","^SR ","^LD","^ST","^JMP","^BZ","^BGTZ",
       "^BLTZ"};
	 
  
	boolean found=false;
	for (int i=0;i<Patterns.length;i++)
	{
    String pat=Patterns[i];
    
    Pattern pattern=Pattern.compile(pat);
	Matcher matcher=pattern.matcher(line);
	
    if(matcher.find())
    {    found=true;
    	
    	if(i==0)
    	{
    		
				
			String path=line.substring(6);
    		r.readFromFile(pat, this, iR, rf);
    		
    	}
    	else
         if(i>0 && i<8)
         {
            System.out.println(line + "0 matches with: "+Patterns[i]);
         	InstructionR ins=new InstructionR();
         	ins.setCode(line);
         	ins.setOperation(pat.substring(1));
         	 String pat2="\\d+";
         	 Pattern pattern2=Pattern.compile(pat2);
         	 Matcher  matcher2=pattern2.matcher(line);
         	 int j=0;
            while(matcher2.find())
         	{
            	
            	int index=Integer.parseInt(matcher2.group());
         		j++;
         		
         		if(j==1)
         		ins.setDestination(rf.getRegistre().get(index));
         		
         	    if(j==2)
         	   	ins.setSource1(rf.getRegistre().get(index));
         	    if(j==3)
         	   	ins.setSource2(rf.getRegistre().get(index));
         	}
         	
            iR.getInstructions().add(ins);
            scoreboard.addInstruction(ins);
         	
         }
         else
    	 if(i>=8 && i<12)
    	 { 
            System.out.println(line + "1 matches with: "+Patterns[i]);
          	InstructionI ins=new InstructionI();
          	ins.setCode(line);
        	ins.setOperation(pat.substring(1));
       	 String pat2="\\d+";
     	 Pattern pattern2=Pattern.compile(pat2);
     	 Matcher  matcher2=pattern2.matcher(line);
     	 int j=0;
     	while(matcher2.find())
     	{
     		j++;
     		int index=Integer.parseInt(matcher2.group());
     	   	if(j==1)
     	   	 ins.setDestination(rf.getRegistre().get(index));
            if(j==2)
            	 ins.setSource1(rf.getRegistre().get(index));    	    	
            if(j==3)	 
            	ins.setImedeate(index);
     		
     		
     		
     		
     	}
     	 iR.getInstructions().add(ins);
     	 scoreboard.addInstruction(ins);
         }
    	 else
    	if(i>=12 && i<=15)
    	{
    		 System.out.println(line + " 2 matches with : "+Patterns[i]);
          	 InstructionR ins=new InstructionR();
          	 ins.setCode(line);
         	 ins.setOperation(pat.substring(1));
          	 String pat2="\\d+";
         	 Pattern pattern2=Pattern.compile(pat2);
         	 Matcher  matcher2=pattern2.matcher(line);
         	int j=0;
         	while(matcher2.find())
         	{
         		
         		int index=Integer.parseInt(matcher2.group());
         		
         		j++;
         		if(j==1)
                ins.setDestination(rf.getFloatRegister(index));
             		
             	if(j==2)
             	ins.setSource1(rf.getFloatRegister(index));
             	if(j==3)
             	ins.setSource2(rf.getFloatRegister(index));
         		
         		
         	}
         	 iR.getInstructions().add(ins);
         	 scoreboard.addInstruction(ins);
    	}
    	else
    	if(i>=16 && i<=17)
    	{
    		 System.out.println(line + " 3 matches with: "+Patterns[i]);
          	 InstructionI ins=new InstructionI();
         	 ins.setOperation(pat.substring(1));
          	 ins.setCode(line);
        	 String pat2="\\d+";
         	 Pattern pattern2=Pattern.compile(pat2);
         	 Matcher  matcher2=pattern2.matcher(line);
         	 int j=0;
         	while(matcher2.find())
         	{
         		int index=Integer.parseInt(matcher2.group());
         		 j++;
           		
         	   	if(j==1)
         	   	 ins.setDestination(rf.getFloatRegister(index));
                if(j==2)
                	 ins.setSource1(rf.getFloatRegister(index));    	    	
                if(j==3)	 
                	ins.setImedeate(index);
         		
         		
         	}
         	 iR.getInstructions().add(ins);
         	 scoreboard.addInstruction(ins);
    	}
    	else
    	if(i>=18 && i<=19)
    	{
    		 System.out.println(line + " 4 matches with: "+Patterns[i]);
          	 InstructionI ins=new InstructionI();
          	 ins.setCode(line);
         	 ins.setOperation(pat.substring(1));
        	 String pat2="\\d+";
         	 Pattern pattern2=Pattern.compile(pat2);
         	 Matcher  matcher2=pattern2.matcher(line);
         	 int j=0;
         	while(matcher2.find())
         	{
         		
         		int index=Integer.parseInt(matcher2.group());
        		 j++;
        		
        		 
        	   	   	if(j==1)
                	   	 ins.setDestination(rf.getRegistre().get(index));
         	   	   	
                       if(j==2)
                       	 ins.setSource1(rf.getRegistre().get(index));    	    	
                       if(j==3)	 
                       	ins.setImedeate(index);
                		
         	}
         	iR.getInstructions().add(ins);
         	
         	scoreboard.addInstruction(ins);
    	}
    	else
    	if( (i>=20 && i<=21 ))
    	
    	{
    		 System.out.println(line + " 5 matches with: "+Patterns[i]);
          	 InstructionI ins=new InstructionI();
          	 ins.setCode(line);
         	 ins.setOperation(pat.substring(1));
         	 
        	 String pat2="\\d+";
        	 
         	 Pattern pattern2=Pattern.compile(pat2);
         	 Matcher  matcher2=pattern2.matcher(line);
         	 
         	 System.out.println("it gets here");
         	 int j=0;
         	while(matcher2.find())
         	{   System.out.println("it enters here");
         	    String str=matcher2.group();
         	    System.out.println("string: "+str);
         	
         		int index=Integer.parseInt(str);
         		 System.out.println("number:"+index);
         		 
         		 
        		 j++;
        	  	if(j==1)
        	  	{
        	  		System.out.println("register file:"+rf);
        	  		System.out.println("register array: "+rf.getRegistre());
        	  		System.out.println("register: "+rf.getIntegerRegister(index));
        	  		 ins.setDestination(rf.getIntegerRegister(index));
        	  	}
               	
                 if(j==3)
                 {
                	 ins.setSource1(rf.getIntegerRegister(index));    
                 }
                 	    	
                 if(j==2)	 
                 {
                	  ins.setImedeate(index);
                 }
                
                		
         		
         	}
         	 System.out.println("finished that");
         	
         	iR.getInstructions().add(ins);
         	scoreboard.addInstruction(ins);
    	}
    	else
    	if(i==22)
    	{
    		 System.out.println(line + " 6 matches with: "+Patterns[i]);
          	 InstructionJ ins=new InstructionJ();
          	 ins.setCode(line);
         	 ins.setOperation(pat.substring(1));
        	 String pat2="\\d+";
         	 Pattern pattern2=Pattern.compile(pat2);
         	 Matcher  matcher2=pattern2.matcher(line);
         	int j=0;
         	if(matcher2.find())
         	{
         		int index=Integer.parseInt(matcher2.group());
        		
        		  	if(j==1)
        		  	{
        		  		if(i==22)
        		  		 ins.setJumpLocation(index);
        		  	}
        	
         	}
         	iR.getInstructions().add(ins);
         	scoreboard.addInstruction(ins);
    	}
    	else
    	{
    		
    		 System.out.println(line + " 7 matches with: "+Patterns[i]);
          	 InstructionI ins=new InstructionI();
          	 ins.setCode(line);
         	 ins.setOperation(pat.substring(1));
         	 
        	 String pat2="\\d+";
        	 
         	 Pattern pattern2=Pattern.compile(pat2);
         	 Matcher  matcher2=pattern2.matcher(line);
         	 
         	 System.out.println("it gets here");
         	 int j=0;
         	while(matcher2.find())
         	{   System.out.println("it enters here");
         	    String str=matcher2.group();
         	    System.out.println("string: "+str);
         	
         		int index=Integer.parseInt(str);
         		 System.out.println("number:"+index);
         		 
         		 
        		 j++;
        	  	if(j==1)
        	  	{
        	  		System.out.println("register file:"+rf);
        	  		System.out.println("register array: "+rf.getRegistre());
        	  		System.out.println("register: "+rf.getIntegerRegister(index));
        	  		 ins.setDestination(rf.getIntegerRegister(index));
        	  	}
               	
                 if(j==2)
                 {
                	 ins.setSource1(rf.getIntegerRegister(index));      
                 }
                 	    	
                 if(j==3)	 
                 {
                	  ins.setImedeate(index);
                 }
                
                		
         		
         	}
         	 System.out.println("finished that");
         	
         	iR.getInstructions().add(ins);
         	scoreboard.addInstruction(ins);
    		
    		
    	}
    	
    }
   
	
	}
	
    if(!found)
	System.out.println("does not match any instruction");
    
}
	
	
	
}
