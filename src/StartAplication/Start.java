package StartAplication;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ComponenteProcesor.Processor;
import Simulare.Menu;
import Simulare.SetupFrame;
import Simulare.SimulationControl;
import Terminal.Reader;
import Terminal.ReaderThread;
public class Start {

	
	public static void main(String[] args) {

		
		Processor processor;
		JFrame setupF=new JFrame();
		SetupFrame setupFrame=new SetupFrame();
		setupF.setContentPane(setupFrame);
		setupF.setSize(400,400);
	
		
		
		/*
		setupFrame.setJframe(setupF);
		setupF.setVisible(true);
		
		int x=0;
		
		while(!setupFrame.isSubmited())
		{
			if(x==0)
			System.out.println("wait for setup...");
			x++;
		}
		
			System.out.println("submitted");
			
			
			
			Integer nfr=Math.max(10,Integer.parseInt(setupFrame.getNumberFloatReg().getText()));
		    Integer nir=Math.max(10,Integer.parseInt(setupFrame.getNumberIntReg().getText()));
		    Integer niu=Math.max(1,Integer.parseInt( setupFrame.getNumberIntUnits().getText()));
		    Integer nfu=Math.max(1,Integer.parseInt(setupFrame.getNumberFloatUnits().getText()));
		    Integer nau=Math.max(1,Integer.parseInt(setupFrame.getNumberAdressUnits().getText())); 
			 */
		
		Integer nfr=32;
	    Integer nir=32;
	    Integer niu=2;
	    Integer nfu=1;
	    Integer nau=1;
		
	
		processor=new Processor(nir,nfr,nfu,niu,nau);
		System.out.println(processor);
		
		ReaderThread  rdt=new 	ReaderThread();
		rdt.setReader(new Reader());
		rdt.setdI(processor.getDi());
		rdt.setRf(processor.getRegister());
		rdt.setiR(processor.getiR());
		
		processor.getScoreboard().setReadInterface(rdt.getReadInterface());
		
		
	
		SimulationControl simulationControl=new SimulationControl();
		simulationControl.setCurrentTime(0);
		simulationControl.setDelay(2000);
		simulationControl.setProcessor(processor);
		

		Menu menu=new Menu();
	    menu.setSimulations(simulationControl);
	 
	    
		JFrame mergedFrame= new JFrame();
		
		  final JPanel p = new JPanel();
          p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
          p.add(menu);
          p.add(rdt.getReadInterface());
          menu.setParent(p);
          menu.setParentFrame(mergedFrame);
          
          mergedFrame.setContentPane(p);
          mergedFrame.setSize(1500,600);
          mergedFrame.setVisible(true);
		   rdt.start();

		// TODO Auto-generated method stub

	}

}
