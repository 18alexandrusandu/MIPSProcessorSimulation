package Simulare;

import java.util.ArrayList;

import javax.swing.JFrame;

import ComponenteProcesor.FunctionalState;
import ComponenteProcesor.FunctionalUnit;
import ComponenteProcesor.InstructionStatus;
import ComponenteProcesor.Job;
import ComponenteProcesor.Processor;
import ComponenteProcesor.Registru;
import ComponenteProcesor.Stage;

public class SimulationControl implements Runnable{
	
	private ArrayList<ScoreboardSimulation> scoreboardsSimulations;
	private ArrayList<InstructionSimulation> instructionSimulations;
	private Integer currentTime;
	private ArrayList<Thread> threads;
	private ArrayList<JFrame> simulationWindows;
	ArrayList<FlowSimulation> flowSimulations;
	private Processor processor;
	private Integer delay=1000;
	private boolean start,stop,pause;
	
	

	
	public ArrayList<ScoreboardSimulation> getScoreboardsSimulations() {
		return scoreboardsSimulations;
	}
	public void setScoreboardsSimulations(ArrayList<ScoreboardSimulation> scoreboardsSimulations) {
		this.scoreboardsSimulations = scoreboardsSimulations;
	}
	public ArrayList<InstructionSimulation> getInstructionSimulations() {
		return instructionSimulations;
	}
	public void setInstructionSimulations(ArrayList<InstructionSimulation> instructionSimulations) {
		this.instructionSimulations = instructionSimulations;
	}
	public ArrayList<FlowSimulation> getFlowSimulations() {
		return flowSimulations;
	}

	
	
	
	
	public SimulationControl() {
		
		
		this.scoreboardsSimulations =new  ArrayList<ScoreboardSimulation>();
		this.instructionSimulations = new ArrayList<InstructionSimulation>();
		this.flowSimulations = new ArrayList<FlowSimulation>();
		this.simulationWindows=new ArrayList<JFrame>();
		stop=false;
	}
	

	void startScorebordSimulation()
	{
		
		JFrame scorebordWindow=new JFrame();
		ScoreboardSimulation ss=new ScoreboardSimulation(processor.getScoreboard());
		this.scoreboardsSimulations.add(ss);
		scorebordWindow.setContentPane(ss);
		simulationWindows.add(scorebordWindow);
		scorebordWindow.setSize(1000,800);		
		scorebordWindow.setVisible(true);
		
	}
	
	void startInstructionSimulation(InstructionStatus ins)
	{
		
		
		System.out.println("instruction status:"+ins);
		System.out.println("instruction status:"+ins.getInstruction());
		JFrame InstructionWindow=new JFrame();
		InstructionSimulation Is=new InstructionSimulation(ins);
		this.instructionSimulations.add(Is);
		
		InstructionWindow.setContentPane(Is);
		simulationWindows.add(InstructionWindow);
		
		InstructionWindow.setSize(800,800);	
		InstructionWindow.setVisible(true);
		
	}
	
	void startFlowSimulation()
	{
		
		JFrame FlowWindow=new JFrame();
		FlowSimulation Fs=new FlowSimulation(processor.getUnits().size(),processor.getUnits());
		Fs.setMem(processor.getMemory());
		this.flowSimulations.add(Fs);
		
		FlowWindow.setContentPane(Fs);
		simulationWindows.add(FlowWindow);
		
		FlowWindow.setSize(800,800);
		FlowWindow.setVisible(true);
	}
	
	public Integer getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(Integer currentTime) {
		this.currentTime = currentTime;
	}
	public ArrayList<Thread> getThreads() {
		return threads;
	}
	public void setThreads(ArrayList<Thread> threads) {
		this.threads = threads;
	}
	public ArrayList<JFrame> getSimulationWindows() {
		return simulationWindows;
	}
	public void setSimulationWindows(ArrayList<JFrame> simulationWindows) {
		this.simulationWindows = simulationWindows;
	}
	public Processor getProcessor() {
		return processor;
	}
	public void setProcessor(Processor processor) {
		this.processor = processor;
	}
	public boolean isStart() {
		return start;
	}
	public void setStart(boolean start) {
		this.start = start;
	}
	public boolean isStop() {
		return stop;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	public boolean isPause() {
		return pause;
	}
	public void setPause(boolean pause) {
		this.pause = pause;
	}
	public void setFlowSimulations(ArrayList<FlowSimulation> flowSimulations) {
		this.flowSimulations = flowSimulations;
	}
	void start2()
	{
		 
		   
		  
		  
		stop=false;
		start=true;
		
	}
	
	void initControl()
	{
		
		 threads=new ArrayList<Thread>();
		 
		 
		  threads.add(new Thread(processor.getScoreboard()));

		  
		 for(FunctionalUnit funit:processor.getUnits())
		 {
			 
			 
			 funit.setState(FunctionalState.FREE);
			 Thread forfu=new Thread(funit);
		     funit.setMainThread(forfu);
			 threads.add(forfu);
			 
		 }
		 processor.getiR().setPCPointer(0);
	
		 
		for(InstructionStatus iStatus: processor.getScoreboard().getInstructions())
		{
			iStatus.setState(FunctionalState.FREE);
			iStatus.setStage(Stage.PREINIT);
			
		}
		 
		for(Registru reg: processor.getRegister().getRegistre())
		{
			reg.setJob(Job.FREE);
			
		}
		 
		
		
	}
	
	
	@SuppressWarnings("deprecation")
	public void run()
	{
		
		while(!stop)
		{
			
		
		if(start==true)
		{ 
		
			initControl();
	
			for(FunctionalUnit fu :processor.getUnits())
			{
				
				fu.start();
				
			}
		
			for(Thread t:threads)
				t.start();
			
		  currentTime=0;
		  start=false;
		  stop=false;
		}
		
		while(!stop && !pause)
		{
			
			if(start==true)
			{ 
		
				initControl();
				for(Thread t:threads)
					t.start();
				
			  currentTime=0;
			  start=false;
			  stop=false;
			}
			
			
			currentTime++;
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			processor.getScoreboard().setOutsideClock(currentTime);
			
		System.out.println("current time: "+currentTime);
			
			
			for(FunctionalUnit fu :processor.getUnits())
			{
				
				fu.setExternalClock(currentTime);
				
			}
			
			
			for(JFrame Jf: simulationWindows)
			  Jf.repaint();
			
			
			
			
			
			for(InstructionSimulation Is: instructionSimulations)
			{
				Is.setCurrentTime(currentTime);
			    Is.repaint();
				
			}

			for(ScoreboardSimulation ss:  scoreboardsSimulations)
			{
				//System.out.println("enters in simulation");
				ss.setCurrentTime(currentTime);
				ss.repaint();
			}
			
			for(FlowSimulation fs:  flowSimulations)
			{
				fs.setCurrentTime(currentTime);
				fs.repaint();
			}
		
		}
		if(stop || pause)
		for(Thread thrd:threads)
		{
			 thrd.stop();
		}
		
		
		}
		
	}
	public Integer getDelay() {
		return delay;
	}
	public void setDelay(Integer delay) {
		this.delay = delay;
	}
	
	
	
	
	

}
