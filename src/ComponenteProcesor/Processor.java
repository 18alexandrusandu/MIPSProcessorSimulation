package ComponenteProcesor;

import java.util.ArrayList;

import Terminal.DecodeInstruction;
import Terminal.DispatcherInstruction;

public class Processor {
	
	
private Memory memory;
private ArrayList<FunctionalUnit> units;
private  InstructionRegister iR;
private  DecodeInstruction di;
private DispatcherInstruction dispatcher;
private RegisterFile register;
private ScoreboardControlUnit scoreboard;
	
	

public Memory getMemory() {
	return memory;
}


public void setMemory(Memory memory) {
	this.memory = memory;
}


public ArrayList<FunctionalUnit> getUnits() {
	return units;
}


public void setUnits(ArrayList<FunctionalUnit> units) {
	this.units = units;
}


public InstructionRegister getiR() {
	return iR;
}


public void setiR(InstructionRegister iR) {
	this.iR = iR;
}


public DecodeInstruction getDi() {
	return di;
}


public void setDi(DecodeInstruction di) {
	this.di = di;
}


public DispatcherInstruction getDispatcher() {
	return dispatcher;
}


public void setDispatcher(DispatcherInstruction dispatcher) {
	this.dispatcher = dispatcher;
}


public RegisterFile getRegister() {
	return register;
}


public void setRegister(RegisterFile register) {
	this.register = register;
}


public ScoreboardControlUnit getScoreboard() {
	return scoreboard;
}


public void setScoreboard(ScoreboardControlUnit scoreboard) {
	this.scoreboard = scoreboard;
}


public Processor(int numberOfIntRegister,int numberofFloatRegister,int numberOfFLoatUnits,int numberOfIntUnits,int numberOfAdressUnits)
{
	memory=new 	Memory();
	iR=new InstructionRegister();
	di=new DecodeInstruction();
	dispatcher=new DispatcherInstruction();
	register=new RegisterFile();
	register.setSize(numberOfIntRegister, numberofFloatRegister);
	scoreboard=new ScoreboardControlUnit();
	scoreboard.setMemory(memory);
	scoreboard.setRegisters(register);
	scoreboard.setInstructions(iR);


    units=new ArrayList<FunctionalUnit>();
    
	for(int i=0;i<numberOfFLoatUnits;i++)
	{
		FloatUAL fu=new FloatUAL();
		units.add(fu);
	}
	for(int i=0;i<numberOfIntUnits;i++)
	{
		IntegerUAL fu=new IntegerUAL();
		units.add(fu);
	}
	
	for(int i=0;i<numberOfAdressUnits;i++)
	{
		AdressUAL fu=new AdressUAL();
		units.add(fu);
	}
	scoreboard.setFunctionalUnits(units);
	di.setScoreboard(scoreboard);
	dispatcher.setUnits(units);
	System.out.println("FUS:"+dispatcher.getUnits());
	scoreboard.setdI(dispatcher);

	
	;
}


public Processor() {
	memory=new 	Memory();
	iR=new InstructionRegister();
	di=new DecodeInstruction();
	dispatcher=new DispatcherInstruction();
	register=new RegisterFile();
	scoreboard=new ScoreboardControlUnit();
	
	// TODO Auto-generated constructor stub
}




	





}
