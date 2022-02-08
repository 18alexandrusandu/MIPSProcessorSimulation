package ComponenteProcesor;

public class RegistruFloat extends Registru{
  private float value;
RegistruFloat()
{    float v=(float)Math.random()*100;
     
     value=v;
	
	
}
	public Float getValue() {
		return value;
	}

	public void setValue(Float d) {
		this.value = d;
	}
	
	public void setValue(double d) {
		this.value = (float)d;
	}
	
}
