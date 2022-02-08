package ComponenteProcesor;

public class RegistruInt extends Registru{
	
	private Integer value;
	RegistruInt()
	{
		
		int v=(int)Math.random()*100;
		value=v;
	}
	
	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
}
