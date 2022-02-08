package Terminal;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import ComponenteProcesor.Instruction;
import ComponenteProcesor.InstructionRegister;

public class ReaderInterface extends JPanel{
    JTextArea textArea;
    JTextArea resultArea;
    JButton addButton;
    JTable instructionsTable;
    JLabel label1;
    JLabel label2;
    ArrayList<JLabel> labels;
    
    InstructionRegister insReg;
    Integer InstructionsYOffset; 
    
	public JLabel getLabel1() {
		return label1;
	}


	public void setLabel1(JLabel label1) {
		this.label1 = label1;
	}


	public Integer getInstructionsYOffset() {
		return InstructionsYOffset;
	}


	public void setInstructionsYOffset(Integer instructionsYOffset) {
		InstructionsYOffset = instructionsYOffset;
	}


	public ReaderInterface()
	{
		setLayout(null);
		label1=new JLabel();
		label1.setText("Please introduce your instructions in the text box");
		label2=new JLabel();
		label2.setText("Results");
		textArea=new JTextArea();
		
		
		
	    resultArea=new JTextArea();
		instructionsTable=new JTable();
		
		
		addButton=new JButton("Send Data");
		
		instructionsTable=new JTable();
		
		
		
		label1.setBounds(0,5,500,20);
		textArea.setBounds(0,30,300,100);
		textArea.setEditable(true);		
		JScrollPane scrollPane = new JScrollPane(textArea); 
		scrollPane.setBounds(0,30,300,100);
		
		
		
		addButton.setBounds(0,150,200,30);
		label2.setBounds(0,190,500,20);
		resultArea.setBounds(0,230,200,200);
		
	    add(scrollPane);
	//	add(textArea);
		add(label1);
		add(addButton);
		add(label2);
		add(resultArea);
		
		InstructionsYOffset =400;
		
		
		
	}


	public JTextArea getResultArea() {
		return resultArea;
	}


	public void setResultArea(JTextArea resultArea) {
		this.resultArea = resultArea;
	}


	public JLabel getLabel2() {
		return label2;
	}


	public void setLabel2(JLabel label2) {
		this.label2 = label2;
	}


	public ArrayList<JLabel> getLabels() {
		return labels;
	}


	public void setLabels(ArrayList<JLabel> labels) {
		this.labels = labels;
	}


	public JTextArea getTextArea() {
		return textArea;
	}


	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}


	public JButton getAddButton() {
		return addButton;
	}


	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}


	public JTable getInstructionsTable() {
		return instructionsTable;
	}


	public void setInstructionsTable(JTable instructionsTable) {
		this.instructionsTable = instructionsTable;
	}


	public InstructionRegister getInsReg() {
		return insReg;
	}


	public void setInsReg(InstructionRegister insReg) {
		this.insReg = insReg;
	}
	
	
}
