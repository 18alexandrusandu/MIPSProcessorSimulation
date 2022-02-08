package ComponenteProcesor;

public class Memory extends FunctionalUnit{
	
	Integer[] data;
	Float[] data2;
	int size;
	Memory()
	{
		data=new Integer[1024];
		data2=new Float[1024];
		for(int i=0;i<1023;i++)
			{ data[i]=i;
			  data[i+1]=i;
			}
		size=1024;
	}
	
	
	
	void write(Integer Adress,Integer dataToWrite) throws InterruptedException
	{  if(Adress<size)
		data[Adress]=dataToWrite;
	    setState(FunctionalState.BUSY);
	    Thread.sleep(100);
		
	}
	void write(Integer Adress,Float dataToWrite) throws InterruptedException
	{  if(Adress<size)
		data2[Adress]=dataToWrite;
	    setState(FunctionalState.BUSY);
	    Thread.sleep(100);
	}
	
	
	Integer readInt(Integer Adress) throws InterruptedException
	{
		
		setState(FunctionalState.BUSY);
		  Thread.sleep(100);
		  
		if(Adress<size)
		return data[Adress];
	    else
		return null;	
	}
	
	Float readFloat(Integer Adress) throws InterruptedException
	{ 
		setState(FunctionalState.BUSY);
		  Thread.sleep(100);
		  
		if(Adress<size)
		return data2[Adress];
	    else
		return null;	
	}
	

}
