package ComponenteProcesor;

public class Hazard {

	private int IdHazard;
	private String typeHazard;
	private Instruction instruction1;
	private Instruction instruction2;
	private FunctionalUnit unitForStructuralHazard;
	private boolean ended;
	
	
	public int getIdHazard() {
		return IdHazard;
	}
	public void setIdHazard(int idHazard) {
		IdHazard = idHazard;
	}
	public FunctionalUnit getUnitForStructuralHazard() {
		return unitForStructuralHazard;
	}
	public void setUnitForStructuralHazard(FunctionalUnit unitForStructuralHazard) {
		this.unitForStructuralHazard = unitForStructuralHazard;
	}
	public boolean isEnded() {
		return ended;
	}
	public void setEnded(boolean ended) {
		this.ended = ended;
	}


	private int clocKTimeHazardHappend;
	private int clockTimeHazardEnded;
	
	public String getTypeHazard() {
		return typeHazard;
	}
	public void setTypeHazard(String typeHazard) {
		this.typeHazard = typeHazard;
	}
	public Instruction getInstruction1() {
		return instruction1;
	}
	public void setInstruction1(Instruction instruction1) {
		this.instruction1 = instruction1;
	}
	public Instruction getInstruction2() {
		return instruction2;
	}
	public void setInstruction2(Instruction instruction2) {
		this.instruction2 = instruction2;
	}
	public int getClocKTimeHazardHappend() {
		return clocKTimeHazardHappend;
	}
	public void setClocKTimeHazardHappend(int clocKTimeHazardHappend) {
		this.clocKTimeHazardHappend = clocKTimeHazardHappend;
	}
	public int getClockTimeHazardEnded() {
		return clockTimeHazardEnded;
	}
	public void setClockTimeHazardEnded(int clockTimeHazardEnded) {
		this.clockTimeHazardEnded = clockTimeHazardEnded;
	}
	
	
	int duration()
	{
		return clockTimeHazardEnded-clocKTimeHazardHappend+1;
	}
	
	
}
