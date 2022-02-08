package ComponenteProcesor;

public class InstructionR extends Instruction{
	Registru source1;
	Registru source2;
	public Registru getSource1() {
		return source1;
	}
	public void setSource1(Registru source1) {
		this.source1 = source1;
	}
	public Registru getSource2() {
		return source2;
	}
	public void setSource2(Registru source2) {
		this.source2 = source2;
		
	}
}

