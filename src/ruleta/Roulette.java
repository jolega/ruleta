package ruleta;
import java.util.ArrayList;
public class Roulette {
	 int id;	
	 String state;
	 ArrayList<Bet> bets = new ArrayList<Bet>();
	 String winning_ballot="";
	 String winning_color="";
	 public Roulette(int id,String state){			 
		 this.id=id;
		 this.state=state;	 		 
	 }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String isState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public ArrayList<Bet> getBets() {
		return bets;
	}
	public void setBets(ArrayList<Bet> bets) {
		this.bets = bets;
	}	
	public void new_Bets(Bet place_bets) {
		bets.add(place_bets);	
	}
	public String getWinning_ballot() {
		return winning_ballot;
	}
	public void setWinning_ballot(String winning_ballot) {
		this.winning_ballot = winning_ballot;
	}
	public String getWinning_color() {
		return winning_color;
	}
	public void setWinning_color(String winning_color) {
		this.winning_color = winning_color;
	}
	public String getState() {
		return state;
	}
}