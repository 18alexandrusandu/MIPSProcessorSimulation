import java.util.ArrayList;

import ComponenteProcesor.FunctionalUnit;
import ComponenteProcesor.Instruction;
import ComponenteProcesor.Registru;

public class DependentInstruction {
Instruction instruction;
String ypeOfHazard;
ArrayList<Registru> registerDependency;
ArrayList<FunctionalUnit> FunctionalUnitDependency;
}
