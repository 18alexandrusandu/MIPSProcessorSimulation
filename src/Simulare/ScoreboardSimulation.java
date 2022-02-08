package Simulare;

import java.awt.Color;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import ComponenteProcesor.FunctionalState;
import ComponenteProcesor.FunctionalUnit;
import ComponenteProcesor.Instruction;
import ComponenteProcesor.InstructionI;
import ComponenteProcesor.InstructionR;
import ComponenteProcesor.InstructionStatus;
import ComponenteProcesor.Job;
import ComponenteProcesor.Registru;
import ComponenteProcesor.ScoreboardControlUnit;
import ComponenteProcesor.Stage;
public class ScoreboardSimulation extends Simulation {
private ScoreboardControlUnit scoreboard;
private Graphics2D g2D;
private boolean Pause;
private boolean Start;
private boolean Stop;



public ScoreboardSimulation(ScoreboardControlUnit scoreboard) {
	super();
	
	this.scoreboard = scoreboard;

	

	this.currentTime =0;
}

public ScoreboardControlUnit getScoreboard() {
	return scoreboard;
}

public void setScoreboard(ScoreboardControlUnit scoreboard) {
	this.scoreboard = scoreboard;
}
private Integer currentTime;




public Integer getCurrentTime() {
		return currentTime;
	}


public FunctionalUnit findParentUnit(Registru r,Instruction ins)
{
	  

	
	for(InstructionStatus ins1 :scoreboard.getInstructions())
	{
		if(ins1.getInstruction()==ins)
			break;
		
		if(ins1.getInstruction()!=ins)
		{
			if(ins1.getInstruction().getDestination()==r)
			{
				
				if(ins1.getState()!=FunctionalState.ENDED && ins1.getStage()!=Stage.PREINIT)
				{
					return ins1.getInstruction().getUnitateCurenta();
				}
				
				
			}
			
		}
		
	}
	return null;
	
}










	public void setCurrentTime(Integer currentTime) {
		this.currentTime = currentTime;
	}
	public  void doGraphics(Graphics2D g2D)
	  {
		
		//System.out.println("scoreboard simulates: "+currentTime);
		
		  g2D.setPaint(Color.black);
		  g2D.setFont(new Font("Ink Free",Font.BOLD,15));
		  
		  
		  g2D.drawString("Instruction Status Register",0,0); 
		  g2D.drawString("Instruction ", 0,15); 
		  
		  g2D.drawString("Issue ",300,15);  
		  g2D.drawString("Read Operands ",500, 15); 
		  g2D.drawString("Execution complete", 700,15); 
		  g2D.drawString("Write Result",900, 15); 
		  
		  
	
		  
		       Integer y_offset=30;
		       Integer y_start=30;
		  for(InstructionStatus ins1 :scoreboard.getInstructions())
		  {
			  
			  g2D.drawString(ins1.getInstruction().getCode(),0,y_offset); 
			  
			  
			  
			  if(ins1.getIsueStart()>=0)
			  {
				    
				  g2D.drawString(ins1.getIsueStart().toString(),300,y_offset);  
				  
				  
			  }
			  if(ins1.getReadOperandsStart()>=0)
			  {
				  g2D.drawString(ins1.getReadOperandsStart().toString(),500,y_offset);  
				  
			  }
			  
			  if(ins1.getExecutionStop()>=0)
			  {
				  
				  g2D.drawString(ins1.getExecutionStop().toString(),700,y_offset);  
			  }
			  
			  
			  if(ins1.getWriteResultStop()>=0)
			  {
				  g2D.drawString(ins1.getWriteResultStart().toString(),900,y_offset);  
				  
			  }
			  
			  
			  y_offset+=20;
			  
		  }
		  
		  g2D.drawRect(0, 20, 1000,y_offset-y_start);
		  
		  y_offset+=30;
		  
		  
		  g2D.drawString("Function Units Status", 0,y_offset); 
		  y_offset+=25;
		  g2D.drawString("Name ", 0,y_offset); 
		  g2D.drawString("Busy ",100,y_offset);  
		  g2D.drawString("Op ",200,y_offset); 
		  g2D.drawString("dest",300,y_offset); 
		  g2D.drawString("S1",400,y_offset); 
		  g2D.drawString("S2", 500,y_offset); 
		  g2D.drawString("FU for j", 600,y_offset); 
		  g2D.drawString("FU for k", 700,y_offset); 
		  g2D.drawString("Rj", 800, y_offset); 
		  g2D.drawString("Rk", 900,y_offset); 
		  
		       y_offset+=25;
		 
		
		       
		       
		       
		  ArrayList<FunctionalUnit> fus=scoreboard.getFunctionalUnits();
		  g2D.drawRect(0, y_offset, 1000,20*fus.size());
		 // System.out.println(fus);
		 int yloc=y_offset+20;
		
		 for(FunctionalUnit fu: fus)
		 {
			
			 
			 g2D.drawString(fu.getName(), 0,yloc); 
			 
			 
			 if(fu.getState()==FunctionalState.BUSY)
			 g2D.drawString("Yes ",100,yloc);  
			 else
			  g2D.drawString("No ",100,yloc);  
					 
			 
			  if(fu.getInstructionInUse()!=null && fu.getInstructionInUse().getOperation()!=null)
			 g2D.drawString(fu.getInstructionInUse().getOperation(),200,yloc);	 
			  
			 
			  ArrayList<Registru> rfs=scoreboard.getRegisters().getRegistre();
			  Instruction ins=fu.getInstructionInUse();
			  
			  if( rfs!=null && ins!=null && ins.getDestination()!=null)
			 g2D.drawString("F"+String.valueOf(
					  rfs.indexOf(fu.getInstructionInUse().getDestination()))
					  ,300,yloc);	
			  
				 if(fu.isRJ())
					 g2D.drawString("Yes ",800,yloc);  
					 else
					  g2D.drawString("No ",800,yloc);  
			  
				 if(fu.isRJ())
					 g2D.drawString("Yes ",900,yloc);  
					 else
					  g2D.drawString("No ",900,yloc);  
			  
			  
			  
			  
			 
			  if(ins instanceof InstructionR)
			  {
				  InstructionR ins2=(InstructionR)ins;
	
				  
			  if( rfs!=null && ins!=null && ins2.getSource1()!=null)
			  {
				  g2D.drawString("F"+String.valueOf(
						  rfs.indexOf(ins2.getSource1()))
						  ,400,yloc);	
				  FunctionalUnit fu1=findParentUnit(ins2.getSource1(),ins2);
				  if(fu1!=null)
				  {
					  g2D.drawString(fu1.getName(),600,yloc);
				  }
				  
			  }
					
			  if( rfs!=null && fu.getInstructionInUse()!=null && ins2.getSource2()!=null)
			  {
				  g2D.drawString("F"+String.valueOf(
						  rfs.indexOf(ins2.getSource2()))
						  ,500,yloc);	
				  
				  FunctionalUnit fu1=findParentUnit(ins2.getSource1(),ins2);
				  if(fu1!=null)
				  {
					  g2D.drawString(fu1.getName(),700,yloc);
				  }
					  
				  
			  }
					
					 
			  }
			  
			  if(ins instanceof InstructionI)
			  {
				  
				  
				  
				  InstructionI ins2=(InstructionI)ins;
	
			  if( rfs!=null && ins!=null && ins2.getSource1()!=null)
					 g2D.drawString("F"+String.valueOf(
							  rfs.indexOf(ins2.getSource1()))
							  ,400,yloc);	
			  }
			  
			  
			  
			  
			  
			  
			
			  
			 
			  
			  
			 yloc+=20;
		 }
			  
		  
		   yloc+=50;
		   g2D.drawString("Clock  ", 0,  yloc); 
		   g2D.drawString(currentTime.toString(),50, yloc);
		   yloc+=20;
		   g2D.drawString("Register Result Status", 0, yloc);  
		
		  Integer sizeBox=scoreboard.getRegisters().getSize();
		  
		  yloc+=10;
		  
		  int registerRowIndex=0;
		  int registerColumnIndex=0;
		  
		  
		  for(int j=0;j<sizeBox;j++)
		  { 
		
			  g2D.drawString("F"+j, registerColumnIndex*55, yloc+60*registerRowIndex);
			  FunctionalUnit saveFu=null;
			  for(FunctionalUnit fu: fus)
			  {
				  if(fu.getInstructionInUse()!=null)
					  if(fu.getInstructionInUse().getDestination()!=null)
						  if(fu.getInstructionInUse().getDestination()==scoreboard.
						  getRegisters().getRegistre().get(j))
							  saveFu=fu;
							  
							  
							  
			  }
			  
		  if(saveFu!=null)
		  {
			  int yloc2=yloc+20;
			  g2D.drawString(saveFu.getName(),registerColumnIndex*55,yloc2+registerRowIndex*60); 
		  }
			
		  if(registerColumnIndex<17)
			  registerColumnIndex++;
		  else
		  {
			  registerRowIndex++;
			  registerColumnIndex=0;
			  
		  }
		  
		  
		  
		  }
		
		  
		  g2D.drawRect(0,yloc-10, 19*50+25,(registerRowIndex+1)*60);
		  
		  
		
		      
		 }
		  
  
	  
		  


		
		public Graphics2D getG2D() {
		return g2D;
	}






	public void setG2D(Graphics2D g2d) {
		g2D = g2d;
	}




		 
		public void paint(Graphics g) {
		  
		  Graphics2D g2D = (Graphics2D) g;
		  doGraphics(g2D);
		  //g2D.drawImage(image, 0, 0, null);
		 }

		
		
		

		
		
	}





