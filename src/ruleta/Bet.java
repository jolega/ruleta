package ruleta;
public class Bet {
	int number;
	String color;
	int value;	
	int id_users;
	public Bet(int number,String color, int value,int id_users){
		this.number=number;
		this.color=color;
		this.value=value;	
		this.id_users=id_users;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}