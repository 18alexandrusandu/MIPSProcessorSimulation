package Simulare;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ComponenteProcesor.Instruction;
import ComponenteProcesor.InstructionRegister;
import ComponenteProcesor.InstructionStatus;

public class InstructionChoice extends JPanel{
	
	ArrayList<InstructionStatus> iR;
	JTextField fieldForInput;
	JButton sendChoice;
    SimulationControl simControl;
	Integer y=0;
	
	InstructionChoice( SimulationControl simControl,ArrayList<InstructionStatus> iR )
	{    setLayout(null);
		this.simControl=simControl;
		this.iR=iR;
		fieldForInput =new JTextField();
		sendChoice=new JButton();
		  fieldForInput.setBounds( 0, y+60, 100, 30);
		  sendChoice.setText("Send the choice");
		  sendChoice.setBounds(0, y+100, 100, 30);
		  
		  sendChoice.addActionListener(new ActionListener()
				  {
			@Override
			
			public void actionPerformed(ActionEvent e) {
				Integer index=0;
				try {
					
				
				index=Integer.parseInt(fieldForInput.getText());
				}catch(Exception e1)
				{
				
				}
				
				;
				simControl.startInstructionSimulation(iR.get(index));			  
				  }}
			);
		  
		  
		 
		 add(fieldForInput);
		 add(sendChoice);
		
		 
	}
       
	
	
	public  void doGraphics(Graphics2D g2D)
	  {
         
		  g2D.setPaint(Color.black);
		  g2D.setFont(new Font("Ink Free",Font.BOLD,20));
		  int id=0;
		  y=30;
		  g2D.drawString("Choose an Instruction by typing the id:",0,30); 
		  for(InstructionStatus ins : iR)
		  {
			  
			  g2D.drawString("Instruction "+id+ ": "+ ins.getInstruction().getCode(),0,y+30);
			  y+=20;
			  id++;
			  
		  }
		  
		  
		  
		  
		  g2D.drawString("add instruction here",0,y+30);
		  fieldForInput.setBounds( 0, y+60, 40, 30);
		  sendChoice.setBounds(0, y+100, 100, 30);
		
	  }
	
	
	
	
	public void paint(Graphics g) {
	    	super.paint(g);
		  
		  Graphics2D g2D = (Graphics2D) g;
		  doGraphics(g2D);
	
	

		 }

}
