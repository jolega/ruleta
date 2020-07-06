package ruleta;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int consecutive=0;
	static ArrayList<Roulette> roulettes = new ArrayList<Roulette>();	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ingrese el numero de ruletas a crear");
		Scanner reader = new Scanner(System.in);
		int quantity = reader.nextInt(); 
		roulette_creation(quantity);
		roulette_print();
	}	
	public static void roulette_creation(int quantity){		
	    for(int i=0;i<quantity;i++){
	    	consecutive++;
	    	roulettes.add(new Roulette(consecutive,"Abierta"));	
	    }	
	}
	public static void roulette_print(){		
		int size=roulettes.size();
	    for(int i=0;i<size;i++){
	    	System.out.println("Ruleta numero: "+ roulettes.get(i).id+" Estado: "+roulettes.get(i).state);
	    }
	 }
}
