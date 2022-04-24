package Person;

public class Phone {

	private int areaCode;
	private float number;
	
	public Phone(int areaCode, float number) {
		super();
		this.areaCode = areaCode;
		this.number = number;
	}
	
	public int getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}
	public float getNumber() {
		return number;
	}
	public void setNumber(float number) {
		this.number = number;
	}
}
