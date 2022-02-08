package ComponenteProcesor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FunctionalUnit  implements Runnable{
	 public FunctionalUnit() {
	    this.curentClock=0;
		this.state =FunctionalState.FREE;
		 instructionInUse=null;
		 String name="Functional Unit";
	    this.clocksPerInstruction=0;
		this.currentClocksFromInstruction=0;
		this.curentClock=0;
		this.SimulationClock=0;
	    this.mainThread=null;
	    RJ=false;
	    RK=false;
	}
	
	 
	 public boolean isRJ() {
		return RJ;
	}
	public void setRJ(boolean rJ) {
		RJ = rJ;
	}
	public boolean isRK() {
		return RK;
	}
	public void setRK(boolean rK) {
		RK = rK;
	}
	public void setCurentClock(Integer curentClock) {
		this.curentClock = curentClock;
	}


	public String operation;
	 
	 
	 
public void setOperation()
{  
	
}
public String getOperation()
{  
	return null;
}


//overwritten in child objects
public void doOperation()
{
	
	//instructionInUse.getDestination()
	
}

public void setExternalClock(Integer time)
{
	SimulationClock=time;
	
}

public boolean isReadyAll() {
	return ReadyAll;
}






public void setReadyAll(boolean readyAll) {
	ReadyAll = readyAll;
}

private boolean ReadyAll,RJ,RK;
private boolean startVar;



int previous=-1;
public void run()
{
	
	while(startVar){
	////if(curentClock!=SimulationClock)
   //System.out.println("current: "+curentClock+" external clock:"+SimulationClock);
		curentClock=SimulationClock;
	if( previous!=curentClock)
	{ previous=curentClock;
	  System.out.println("current_clock:"+curentClock);
	if(ReadyAll)
	{
	 System.out.println("pot opera :"+this);
	 System.out.println("done :"+currentClocksFromInstruction+"/"+clocksPerInstruction);
	 
	if(currentClocksFromInstruction < clocksPerInstruction)
	{
		
		
		if(currentClocksFromInstruction==1 )
		{
			doOperation();
		}
		
		
		currentClocksFromInstruction+=1;
	}
	else
	{
		state=FunctionalState.ENDED;
		ReadyAll=false;
		RJ=false;
		RK=false;
		System.out.println("ended FOR"+this.getOperation());
		
		
	}
	}
	int m=SimulationClock;
	curentClock=m;
	}

	}
	
	
	
}
public void start()
{

	startVar=true;
	
	
	
	
}



	public Integer getCurentClock() {
	return curentClock;
}












public Integer getSimulationClock() {
	return SimulationClock;
}






public void setSimulationClock(Integer simulationClock) {
	SimulationClock = simulationClock;
}






public Thread getMainThread() {
	return mainThread;
}






public void setMainThread(Thread mainThread) {
	this.mainThread = mainThread;
}






public void setClocksPerInstruction(Integer clocksPerInstruction) {
	this.clocksPerInstruction = clocksPerInstruction;
}






public void setCurrentClocksFromInstruction(Integer currentClocksFromInstruction) {
	this.currentClocksFromInstruction = currentClocksFromInstruction;
}



	private FunctionalState state;
	private Instruction instructionInUse;
	private String name;
	private  Integer clocksPerInstruction;
	private  Integer currentClocksFromInstruction;
	private  Integer curentClock;
	private  Integer SimulationClock;
    private  Thread  mainThread;
    
    
    
    
    
    
	
	public int getClocksPerInstruction() {
		return clocksPerInstruction;
	}


	public void setClocksPerInstruction(int clocksPerInstruction) {
		this.clocksPerInstruction = clocksPerInstruction;
	}


	public int getCurrentClocksFromInstruction() {
		return currentClocksFromInstruction;
	}


	public void setCurrentClocksFromInstruction(int currentClocksFromInstruction) {
		this.currentClocksFromInstruction = currentClocksFromInstruction;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public FunctionalUnit copy() {
		// TODO Auto-generated method stub
		 FunctionalUnit nFu=new  FunctionalUnit();
		 nFu.setInstructionInUse(instructionInUse);
		 nFu.setState(state);
		 return nFu;
	}
	public FunctionalState getState() {
		return state;
	}
	public void setState(FunctionalState state) {
		this.state = state;
	}
	public Instruction getInstructionInUse() {
		return instructionInUse;
	}
	public void setInstructionInUse(Instruction instructionInUse) {
		this.instructionInUse = instructionInUse;
	}
	
}
