package Simulare;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SetupFrame extends JPanel{

	private JFrame jframe;
	private JButton submit;
	private JTextField numberIntReg;
	private JTextField numberFloatReg;
	private JTextField numberIntUnits;
	private JTextField numberFloatUnits;
	private JTextField numberAdressUnits;
	
	public JFrame getJframe() {
		
		return jframe;
	}
	public void setJframe(JFrame jframe) {
		this.jframe = jframe;
	}
	public JButton getSubmit() {
		return submit;
	}
	public void setSubmit(JButton submit) {
		this.submit = submit;
	}
	public JTextField getNumberIntReg() {
		return numberIntReg;
	}
	public void setNumberIntReg(JTextField numberIntReg) {
		this.numberIntReg = numberIntReg;
	}
	public JTextField getNumberFloatReg() {
		return numberFloatReg;
	}
	public void setNumberFloatReg(JTextField numberFloatReg) {
		this.numberFloatReg = numberFloatReg;
	}
	public JTextField getNumberIntUnits() {
		return numberIntUnits;
	}
	public void setNumberIntUnits(JTextField numberIntUnits) {
		this.numberIntUnits = numberIntUnits;
	}
	public JTextField getNumberFloatUnits() {
		return numberFloatUnits;
	}
	public void setNumberFloatUnits(JTextField numberFloatUnits) {
		this.numberFloatUnits = numberFloatUnits;
	}
	public boolean isSubmited() {
		return submited;
	}
	public void setSubmited(boolean submited) {
		this.submited = submited;
	}
	boolean submited;
	public SetupFrame()
	{    setLayout(null);
		submited=false;
		 JLabel l1=new JLabel();
		 l1.setText("number of integer registers");
		 l1.setBounds(27, 29, 155, 20);
		 JLabel l2=new JLabel();
		 l2.setText("number of float registers");
		 l2.setBounds(27, 70, 155, 20);
		 JLabel l3=new JLabel();
		 l3.setText("number of integer functional units");
		 l3.setBounds(27, 110, 155, 20);
		 JLabel l4=new JLabel();
		 l4.setText("number of float functoional units");
		 l4.setBounds(27, 150, 155, 20);
		 JLabel l5=new JLabel();
		 l5.setText("number of adress functoional units");
		 l5.setBounds(27, 190, 155, 20);
		 
	    numberIntReg=new  JTextField();
		numberIntReg.setBounds(27, 49, 155, 20);
		
		
		numberFloatReg=new  JTextField();
		numberFloatReg.setBounds(27, 90, 155, 20);
		
		
		numberIntUnits=new  JTextField();
		
		numberIntUnits.setBounds(27, 130, 155, 20);
		
		numberFloatUnits=new  JTextField();
		numberFloatUnits.setBounds(27,170 , 155, 20);
		
		numberAdressUnits=new JTextField();
		numberAdressUnits.setBounds(27,210 , 155, 20);
		submit=new JButton();
		submit.setText("submit");
		submit.setBounds(27,250 , 155, 20);
		
		submit.addActionListener(new ActionListener(){

			@Override
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				submited=true;
				jframe.setVisible(false);
			}
			
			
		});
	add(l1);
	add(l2);	
	add(l3);	
	add(l4);
	add(l5);
	add( numberFloatUnits);
	add( numberIntUnits);
	add( numberFloatReg);
	add( numberIntReg);
	add( numberAdressUnits);
	add( submit);
	}
	public JTextField getNumberAdressUnits() {
		return numberAdressUnits;
	}
	public void setNumberAdressUnits(JTextField numberAdressUnits) {
		this.numberAdressUnits = numberAdressUnits;
	}
	

	
	
	
	
	
	
	
	
	
	//jframe.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
}
