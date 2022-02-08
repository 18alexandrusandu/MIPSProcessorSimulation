package Simulare;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Menu extends JPanel{
	

	public JFrame getParentFrame() {
		return parentFrame;
	}


	public void setParentFrame(JFrame parentFrame) {
		this.parentFrame = parentFrame;
	}

	JPanel parent2;
	JFrame parentFrame;
	SimulationControl simulations;

	//public JPanel getParent() {
	//return parent;
	//}


public void setParent(JPanel parent) {
		this.parent2 = parent;
	}


	public SimulationControl getSimulations() {
		return simulations;
	}


	public void setSimulations(SimulationControl simulations) {
		this.simulations = simulations;
	}


	public JTextField getFieldForInput() {
		return fieldForInput;
	}


	
	public void setFieldForInput(JTextField fieldForInput) {
		this.fieldForInput = fieldForInput;
	}


	public JButton getSendChoice() {
		return sendChoice;
	}


	public void setSendChoice(JButton sendChoice) {
		this.sendChoice = sendChoice;
	}


	public Thread getSimulationsThread() {
		return simulationsThread;
	}


	public void setSimulationsThread(Thread simulationsThread) {
		this.simulationsThread = simulationsThread;
	}

	JTextField fieldForInput;
	JButton sendChoice;
	Thread simulationsThread;
	
	public  Menu()
	  {
		
		      setLayout(null);
		      fieldForInput =new JTextField();
		      sendChoice=new JButton();
		      simulations=new SimulationControl();
              JLabel l1=new  JLabel();
              JLabel l2=new  JLabel();
              JLabel l3=new  JLabel();
              JLabel l4=new  JLabel();
              JLabel l5=new  JLabel();
              JLabel l6=new  JLabel();
              JLabel l7=new  JLabel();
              JLabel l8=new  JLabel();
              
              l1.setText("Choose type of simulation:");
              l2.setText("Total instruction Flow simulation by pressing 1:");
              l3.setText("Scorebord simulation by pressing 2:");
              l4.setText("Particular instruction simulation by pressing 3:");
              l5.setText("Stop all simulations by pressing 4:");
              l6.setText("Start  simulation by pressing 5:");
              l7.setText("Pause  simulation by pressing 6:");
              l8.setText("Resume after Pause  simulation by pressing 7:");
              
              l1.setBounds(0,0,300,20);
              l2.setBounds(0,30,300,20);
              l3.setBounds(0,60,300,20);
              l4.setBounds(0,90,300,20);
              l5.setBounds(0,120,300,20);
              l6.setBounds(0,150,300,20);
              l7.setBounds(0,180,300,20);
              l8.setBounds(0,220,300,20);
              
		  fieldForInput.setBounds(0, 250,100,20);
		  sendChoice.setText("Send the choice");
		  sendChoice.setBounds( 0, 280, 100, 20);
		  
		  
		  
		  
		  sendChoice.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				System.out.println("on instructions: "+simulations.getProcessor().getScoreboard().getInstructions());
				int number=Integer.parseInt( fieldForInput.getText());
				if(number==1)
				{
					 simulations.startFlowSimulation();
				}
				if(number==2)
				{
					simulations.startScorebordSimulation();
					
				}
				if(number==3)
				{
					//JFrame Jf=new JFrame();
					JPanel jp=new InstructionChoice(simulations,simulations.getProcessor().getScoreboard().getInstructions());
					parent2.add(jp);
					parentFrame.repaint();
					//parentFrame.setVisible(false);
					parentFrame.setVisible(true);
					//Jf.setContentPane(jp);
					//Jf.setSize(500,500);
					
					
				}
		        if(number==4)	
		        {
		        	simulations.setStop(true);
		        	if(simulationsThread!=null)
		        	simulationsThread.stop();
		        	
		        }
		        if(number==5)		
		        {
		        	simulationsThread=new Thread(simulations);
		        	simulations.start2();
		        	simulationsThread.start();
			    }
		        
		        if(number==6)
		        {
		        	simulations.setPause(true);
		        }
		        else
		        if(number==7) 
		        { 
		        	simulations.setPause(false);
		        		  
		        } 
			   
			} 
			   
			   
		  }); 
	      add(l1);
	      add(l2);
	      add(l3);
	      add(l4);
	      add(l5);
	      add(l6);
	      add(l7);
	      add(l8);
		  add(fieldForInput);
		  add(sendChoice);
		  
	
		  
		  
	  
	  }
	
	
	

}
