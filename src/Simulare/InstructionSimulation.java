package Simulare;
import java.awt.*;

import javax.swing.*;

import ComponenteProcesor.Hazard;
import ComponenteProcesor.InstructionStatus;
public class InstructionSimulation extends JPanel {

	public boolean isPause() {
		return Pause;
	}
	public void setPause(boolean pause) {
		Pause = pause;
	}
	
	
	

	public boolean isStart() {
		return Start;
	}
	public void setStart(boolean start) {
		Start = start;
	}
	public boolean isStop() {
		return Stop;
	}
	public void setStop(boolean stop) {
		Stop = stop;
	}
	public InstructionStatus getInstructionStatus() {
		return instructionStatus;
	}
	public void setInstructionStatus(InstructionStatus instructionStatus) {
		this.instructionStatus = instructionStatus;
	}
	
	public  InstructionSimulation()
	 {
		 
		 
	 }
	
	public  InstructionSimulation(InstructionStatus ins)
	 {
		 
		instructionStatus=ins;
	 }

	
	private boolean Pause;
	private boolean Start;
	private boolean Stop;
    private InstructionStatus instructionStatus;
    private int clockCycle;
    private int ended;
    JButton RedoSimulation;
    
   
    public  void doGraphics(Graphics2D g2D) {
      g2D.setPaint(Color.black);
	  g2D.setFont(new Font("Ink Free",Font.BOLD,20));
		  
  	  g2D.drawString("Instruction id:"+instructionStatus.getInstruction().getId(),0,0); 
  	  g2D.drawString("Instruction code:"+instructionStatus.getInstruction().getCode(),0,30); 
  	  g2D.drawString("Instruction operation:"+instructionStatus.getInstruction().getOperation(),0,60); 
  	  g2D.drawString("Instruction state: "+instructionStatus.getState(),0,90);
	  g2D.drawString("Instruction stage: "+instructionStatus.getStage(),0,120);
	  g2D.drawString("clock tick: "+clockCycle,0,140); 
	  
	  
	  if(instructionStatus.getWriteResultStop()>0)
	  g2D.drawString("End clock: "+instructionStatus.getWriteResultStop(),0,160); 
	  
	  int ypos=200;
    	g2D.drawString("Here are the hazards",0,180); 
    	
    	
    	
    	
  	
  	  for(Hazard hazard :instructionStatus.getHazards() )
     {
    	g2D.drawString("Type hazard:"+hazard.getTypeHazard(),0,ypos);
    	ypos+=30;
    	if(hazard.getInstruction2()!=null)
    	{ g2D.drawString("Instruction in hazard:"+hazard.getInstruction2().getCode(),0,ypos);
    	  ypos+=30;
    	}
    	g2D.drawString("Start time:"+hazard.getClocKTimeHazardHappend(),0,ypos);
    	ypos+=30;
    	if(hazard.isEnded())
    	{g2D.drawString("End time:"+hazard.getClockTimeHazardEnded(),0,ypos);
    	ypos+=30;
    	}
    	ypos+=40;
    	
     }
  	  
  	  
  	  
  	  
  	  
    }
	public void paint(Graphics g) {
		  
		  Graphics2D g2D = (Graphics2D) g;
		  doGraphics(g2D);
		
		  
		  
		  
		 }
	public void setCurrentTime(Integer currentTime) {
		// TODO Auto-generated method stub
		clockCycle=currentTime;
		repaint();
		
	}
	
}










