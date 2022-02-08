package Simulare;
import java.awt.*;
import java.util.ArrayList;

import ComponenteProcesor.*;

import javax.swing.*;
public class FlowSimulation extends Simulation implements Runnable{
	private Graphics2D g2D;
	private Integer numberOfFunctionalUnits;
	private ArrayList<FunctionalUnit> Units;
	private Memory mem;
	public Memory getMem() {
		return mem;
	}







	public void setMem(Memory mem) {
		this.mem = mem;
	}







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

	private Integer currentTime;
	
	private boolean Pause;
	private boolean Start;
	private boolean Stop;

	

  public Integer getCurrentTime() {
		return currentTime;
		
	}

  





	public void setCurrentTime(Integer currentTime) {
		this.currentTime = currentTime;
		repaint();
		
	}






public  void doGraphics(Graphics2D g2D)
  {
		/*
		 * g2D.setPaint(Color.blue); g2D.setStroke(new BasicStroke(5)); g2D.drawLine(0,
		 * 0, 500, 500);
		 *
		 */
	 //g2D.clearRect(0, 0, getParent().getWidth(), getParent().getHeight());
	
	  
	  g2D.setPaint(Color.green);
	  
	  g2D.drawRect(0, 0, 100, 200);
	  
	  g2D.fillRect(0, 0, 100, 200);
	  
	  g2D.drawRect(110, 0+(currentTime*10)%200, 10, 10);
	  g2D.fillRect(110, 0+(currentTime*10)%200, 10, 10);
	  
	  
	  
	  
	  if(mem.getState()==FunctionalState.FREE)
	  g2D.setPaint(Color.yellow);
	  else
	  g2D.setPaint(Color.red);  
	  
	  g2D.drawRect(0, 250, 100, 200);
	  g2D.fillRect(0, 250, 100, 200);
	  
	  
	  currentTime+=1;
	  

	  g2D.setPaint(Color.blue);
	  int yRect=0;
	  for(int i=0;i<numberOfFunctionalUnits;i++)
	  {  
		  if(Units!= null && Units.get(i)!=null)
		  if(Units.get(i).getState()==FunctionalState.FREE)
		  g2D.setPaint(Color.green);
		  else
	      g2D.setPaint(Color.red); 
		  
		  
		 g2D.drawRect(300, yRect, 200, 75);
	     g2D.fillRect(300, yRect, 200, 75);
	    g2D.setPaint(Color.BLACK);
	   
	    
		g2D.setFont(new Font("Ink Free",Font.BOLD,18));
		 if(Units!= null && Units.get(i)!=null && Units.get(i).getInstructionInUse()!=null)
				 if( Units.get(i).getInstructionInUse().getCode()!=null)
		g2D.drawString(Units.get(i).getInstructionInUse().getCode(), 370, yRect+60); 
		 
		 if(Units!= null && Units.get(i)!=null && Units.get(i).getName()!=null)
		 g2D.drawString(Units.get(i).getName(), 370, yRect+20);
	     
	     yRect=yRect+90;
	  }  
	  
	  
	  
	     g2D.setPaint(Color.BLACK);
		 g2D.setFont(new Font("Ink Free",Font.BOLD,30));
		  g2D.drawString("Cycle: "+currentTime.toString(), 150, 40);  
	
	  
	  
	  g2D.setPaint(Color.BLACK);
	  g2D.setFont(new Font("Ink Free",Font.BOLD,30));
	  g2D.drawString("MI", 40, 100);  
	  
	  
	  
	  g2D.setPaint(Color.BLACK);
	  g2D.setFont(new Font("Ink Free",Font.BOLD,30));
	  g2D.drawString("Memory ", 0, 350);  
	  g2D.drawString("Unit ", 0, 385); 
	  
	  g2D.setPaint(Color.black);
	  g2D.setBackground(Color.black);
	      
	 }
	  
	  
	  


	
	public Graphics2D getG2D() {
	return g2D;
}






public void setG2D(Graphics2D g2d) {
	g2D = g2d;
}






public Integer getNumberOfFunctionalUnits() {
	return numberOfFunctionalUnits;
}






public void setNumberOfFunctionalUnits(Integer numberOfFunctionalUnits) {
	this.numberOfFunctionalUnits = numberOfFunctionalUnits;
}






public ArrayList<FunctionalUnit> getUnits() {
	return Units;
}

public FunctionalUnit getUnit(Integer index) {
	return Units.get(index);
}


public FunctionalUnit setUnit(Integer index,FunctionalUnit fu) {
	return Units.set(index,fu);
}




public void setUnits(ArrayList<FunctionalUnit> units) {
	Units = units;
}






	public FlowSimulation(Integer numberOfFunctionalUnits, ArrayList<FunctionalUnit> Units){
	//image = new ImageIcon("sky.png").getImage();
		this.Units=new ArrayList<FunctionalUnit>();
		for(FunctionalUnit unit: Units)
			this.Units.add(unit);
	 	this.currentTime=0;
			
		
	  this.numberOfFunctionalUnits=numberOfFunctionalUnits;
	 }
	 
	public void paint(Graphics g) {
	  
	  Graphics2D g2D = (Graphics2D) g;
	  doGraphics(g2D);
	  //g2D.drawImage(image, 0, 0, null);
	 }
	
public	void run()
{
		
		
}
	
	
	

}
