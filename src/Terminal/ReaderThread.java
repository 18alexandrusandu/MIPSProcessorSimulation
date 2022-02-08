package Terminal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ComponenteProcesor.InstructionRegister;
import ComponenteProcesor.RegisterFile;

public class ReaderThread extends Thread{
private Reader reader;
private  DecodeInstruction dI;
private InstructionRegister iR;
private RegisterFile rf;
private ReaderInterface readInterface;


public RegisterFile getRf() {
	return rf;
}

public void setRf(RegisterFile rf) {
	this.rf = rf;
}

public ReaderThread()
{
	iR=new InstructionRegister();
	readInterface=new ReaderInterface();

	
}

public Reader getReader() {
	return reader;
}

public void setReader(Reader reader) {
	this.reader = reader;
}

public DecodeInstruction getdI() {
	return dI;
}

public void setdI(DecodeInstruction dI) {
	this.dI = dI;
}

public InstructionRegister getiR() {
	return iR;
}

public void setiR(InstructionRegister iR) {
	this.iR = iR;
}

public void run()
{
	// JFrame jF=new JFrame();

	
	readInterface.getAddButton().addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String text=readInterface.getTextArea().getText();
			System.out.println("text from text area:"+text);
			reader.reading_from_terminal(text , dI, iR, rf);
			readInterface.getTextArea().setText("");
			
			
			
		}
		
		});
	//readInterface.setPreferredSize(600);
	
	//jF.setContentPane(readInterface);
	//jF.setSize(600,600);
	//jF.setVisible(true);
	
	
	
}

public ReaderInterface getReadInterface() {
	return readInterface;
}

public void setReadInterface(ReaderInterface readInterface) {
	this.readInterface = readInterface;
}
}
