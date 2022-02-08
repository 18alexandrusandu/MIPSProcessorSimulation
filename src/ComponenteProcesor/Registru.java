package ComponenteProcesor;

public class Registru {
	String name;
	FunctionalState busy;
	Job job;
	FunctionalUnit unitInUse;
	Instruction instructionInUse;
	
	
	public Instruction getInstructionInUse() {
		return instructionInUse;
	}
	public void setInstructionInUse(Instruction instructionInUse) {
		this.instructionInUse = instructionInUse;
	}
	
	
	
	public FunctionalUnit getUnitInUse() {
		return unitInUse;
	}
	public void setUnitInUse(FunctionalUnit unitInUse) {
		this.unitInUse = unitInUse;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public FunctionalState getBusy() {
		return busy;
	}
	public void setBusy(FunctionalState busy) {
		this.busy = busy;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}

	

}
