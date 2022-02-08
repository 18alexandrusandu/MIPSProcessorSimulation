package ComponenteProcesor;

import java.util.ArrayList;

public class InstructionJ extends Instruction{
public Integer getJumpLocation() {
		return jumpLocation;
	}
	public void setJumpLocation(Integer jumpLocation) {
		this.jumpLocation = jumpLocation;
	}
	public String getTypeofJump() {
		return typeofJump;
	}
	public void setTypeofJump(String typeofJump) {
		this.typeofJump = typeofJump;
	}
	public ArrayList<RegistruInt> getRegistersForComparison() {
		return registersForComparison;
	}
	public void setRegistersForComparison(ArrayList<RegistruInt> registersForComparison) {
		this.registersForComparison = registersForComparison;
		
	}
Integer jumpLocation;
String typeofJump;
ArrayList<RegistruInt> registersForComparison;
}
