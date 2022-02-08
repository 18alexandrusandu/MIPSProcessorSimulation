package ComponenteProcesor;

import java.util.ArrayList;

public class InstructionStatus {
private Instruction instruction;
private Stage stage;
public Stage getStage() {
	return stage;
}
public void setStage(Stage stage) {
	this.stage = stage;
}


private ArrayList<Hazard> hazards;


   
public InstructionStatus(Instruction instruction) {
	hazards=new ArrayList<Hazard>();
	this.instruction=instruction;
	state=FunctionalState.BUSY;
	stage=Stage.PREINIT;
	state=FunctionalState.FREE;
	isueStart=-1;
	isueStop=-1;
	readOperandsStart=-1;
	readOperandsStop=-1;
	executionStart=-1;
	executionStop=-1;
	WriteResultStart=-1;
	WriteResultStop=-1;

	

}
public int addHazardGetId(int clockStart,String type,InstructionStatus instruction2,FunctionalUnit fu)
{
	 Hazard hazard=new Hazard();
	   hazard.setClocKTimeHazardHappend(clockStart);
	   hazard.setTypeHazard(type);
	   hazard.setInstruction1(instruction);
	   hazard.setInstruction2(instruction2.getInstruction());
	   hazard.setEnded(false);
	   hazard.setUnitForStructuralHazard(fu);
	   hazard.setIdHazard(hazards.size()+1);
	   
	   
	   
	hazards.add(hazard);
	 instruction2.addHazardGetIdHelper(clockStart, type, this, fu);
	
	
	
	return hazards.size();
	
}


public int addHazardGetIdHelper(int clockStart,String type,InstructionStatus instruction2,FunctionalUnit fu)
{
	 Hazard hazard=new Hazard();
	   hazard.setClocKTimeHazardHappend(clockStart);
	   hazard.setTypeHazard(type);
	   hazard.setInstruction1(instruction);
	   hazard.setInstruction2(instruction2.getInstruction());
	   hazard.setEnded(false);
	   hazard.setUnitForStructuralHazard(fu);
	   hazard.setIdHazard(hazards.size()+1);
	   
	   
	   
	hazards.add(hazard);
	
	
	
	
	return hazards.size();
	
}

public int addHazardGetId2(int clockStart,String type,Instruction instruction2,FunctionalUnit fu)
{
	 Hazard hazard=new Hazard();
	   hazard.setClocKTimeHazardHappend(clockStart);
	   hazard.setTypeHazard(type);
	   hazard.setInstruction1(instruction);
	   hazard.setInstruction2(instruction2);
	   hazard.setEnded(false);
	   hazard.setUnitForStructuralHazard(fu);
	   hazard.setIdHazard(hazards.size()+1);
	   
	   
	   
	hazards.add(hazard);
	 
	
	
	return hazards.size();
	
}







void endHazardById(int id,int clockEnd)
{
	
	hazards.get(id).setClockTimeHazardEnded(clockEnd);
	hazards.get(id).setEnded(true);
}




public ArrayList<Hazard> getHazards() {
	return hazards;
}
public void setHazards(ArrayList<Hazard> hazards) {
	this.hazards = hazards;
}
int addHazardGetId(int clockStart,String type,Instruction instruction2)
{
	   Hazard hazard=new Hazard();
	   hazard.setClocKTimeHazardHappend(clockStart);
	   hazard.setTypeHazard(type);
	   hazard.setInstruction1(instruction);
	   hazard.setInstruction2(instruction2);
	   hazard.setEnded(false);
	   
	hazards.add(hazard);
	
	return 0;
}




public Instruction getInstruction() {
	return instruction;
}
public void setInstruction(Instruction instruction) {
	this.instruction = instruction;
}
public Integer getIsueStart() {
	return isueStart;
}
public void setIsueStart(Integer isueStart) {
	this.isueStart = isueStart;
}
public Integer getIsueStop() {
	return isueStop;
}
public void setIsueStop(Integer isueStop) {
	this.isueStop = isueStop;
}
public Integer getReadOperandsStart() {
	return readOperandsStart;
}
public void setReadOperandsStart(Integer readOperandsStart) {
	this.readOperandsStart = readOperandsStart;
}
public Integer getReadOperandsStop() {
	return readOperandsStop;
}
public void setReadOperandsStop(Integer readOperandsStop) {
	this.readOperandsStop = readOperandsStop;
}
public Integer getExecutionStart() {
	return executionStart;
}
public void setExecutionStart(Integer executionStart) {
	this.executionStart = executionStart;
}
public Integer getExecutionStop() {
	return executionStop;
}
public void setExecutionStop(Integer executionStop) {
	this.executionStop = executionStop;
}
public Integer getWriteResultStart() {
	return WriteResultStart;
}
public void setWriteResultStart(Integer writeResultStart) {
	WriteResultStart = writeResultStart;
}
public Integer getWriteResultStop() {
	return WriteResultStop;
}
public void setWriteResultStop(Integer writeResuktStop) {
	WriteResultStop = writeResuktStop;
}


public FunctionalState getState() {
	return state;
}
public void setState(FunctionalState state) {
	this.state = state;
}


private FunctionalState state;
private Integer isueStart;
private Integer isueStop;
private Integer readOperandsStart;
private Integer readOperandsStop;
private Integer executionStart;
private Integer executionStop;
private Integer WriteResultStart;
private Integer WriteResultStop;


InstructionStatus()
{
	

}


}
