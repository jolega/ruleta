package ruleta;

import java.util.ArrayList;

public class Roulette {
	 int id;	
	 boolean state;
	 ArrayList<Bet> bets = new ArrayList<Bet>();
	 public Roulette(int id,boolean state){			 
		 this.id=id;
		 this.state=state;	 		 
	 }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public ArrayList<Bet> getBets() {
		return bets;
	}
	public void setBets(ArrayList<Bet> bets) {
		this.bets = bets;
	}		 	 
}
