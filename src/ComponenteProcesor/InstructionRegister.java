package ComponenteProcesor;

import java.util.ArrayList;

public class InstructionRegister {
	
	public InstructionRegister() {
		super();
		this.instructions =new ArrayList<Instruction>();
		PCPointer = 0;
	}
	
	public void increaseCounter()
	{
		PCPointer+=1;
	}

	
	public ArrayList<Instruction> getInstructions() {
		return instructions;
	}
	
	
	public void setInstruction(Integer index, Instruction instruction) {
		this.instructions.set(index, instruction);
		
		
	}
	
	
	public Instruction getInstruction(Integer index) {
		return instructions.get(index);
	}
	
	public boolean addInstruction(Instruction instruction) {
		return instructions.add(instruction);
	}
	
	
	
	
	
	public Integer getPCPointer() {
		return PCPointer;
	}
	public void setPCPointer(Integer pCPointer) {
		PCPointer = pCPointer;
	}







	ArrayList<Instruction> instructions;
	Integer PCPointer;
	

}
