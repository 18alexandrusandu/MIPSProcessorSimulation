package ComponenteProcesor;

public class Instruction {

	private Registru destination;
	private String step;
	private FunctionalUnit unitateCurenta;
	private Instruction instructionInUse;

	private String code;
	private String id;
	
	private String operation;
	
	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public  Registru getDestination() {
		return destination;
	}
	public void setDestination(Registru destination) {
		this.destination = destination;
	}
	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		this.step = step;
	}
	public FunctionalUnit getUnitateCurenta() {
		return unitateCurenta;
	}
	public void setUnitateCurenta( FunctionalUnit unitateCurenta) {
		this.unitateCurenta =unitateCurenta;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
