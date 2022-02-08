package ComponenteProcesor;

import java.util.ArrayList;

public class RegisterFile {
private ArrayList<Registru> registre;


public ArrayList<Registru> getRegistre() {
	return registre;
}

public void setRegistre(ArrayList<Registru> registre) {
	this.registre = registre;
}


public RegistruInt  getIntegerRegister(Integer index)
{
	return (RegistruInt)registre.get(index);
	
}
public RegistruFloat getFloatRegister(Integer index)
{
	return (RegistruFloat)registre.get(index+sizeInt);
	
}





public Integer  getSize()
{
	return registre.size();
	
	
}

Integer sizeInt,sizeFloat;



public void setSize(int size1,int size2) {
	registre=new ArrayList<Registru>();
	for(int i=0;i<size1;i++)
	{
		registre.add(new RegistruInt());
	}
	sizeInt=size1;
	sizeFloat=size2;
	for(int i=0;i<size2;i++)
	{
		registre.add(new RegistruFloat());
	}
	
	
}
public void setSize(int size) {
	registre=new ArrayList<Registru>();
	for(int i=0;i<size;i++)
	{
		registre.add(new RegistruInt());
	}
	sizeInt=size;
	sizeFloat=0;
	
	
}

public Integer getSizeInt() {
	return sizeInt;
}

public void setSizeInt(Integer sizeInt) {
	this.sizeInt = sizeInt;
}

public Integer getSizeFloat() {
	return sizeFloat;
}

public void setSizeFloat(Integer sizeFloat) {
	this.sizeFloat = sizeFloat;
}


}
