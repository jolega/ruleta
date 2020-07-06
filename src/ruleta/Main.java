package ruleta;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int consecutive=0;
	static boolean close=true; 
	static ArrayList<Roulette> roulettes = new ArrayList<Roulette>();	
	public static void main(String[] args) {
		do{
		   load_menu();
		}while(close);	
	}
	public static void load_menu(){
		System.out.println("");
		System.out.println("Menu del juego la Ruleta");
		System.out.println("");
		System.out.println("1. Para realizar una apuesta");
		System.out.println("2. Para crear nuevas ruletas");
		System.out.println("3. Para consultar estado de ruletas");
		System.out.println("4. Para realizar sorteo");
		System.out.println("5. Cerrar programa");
		System.out.println("");
		System.out.print("Indique la operacion a realizar? : ");
		Scanner reader = new Scanner(System.in);
		int option = reader.nextInt();
		switch(option)
		{
		   case 1 :	
			  place_bets();
		      break; 		   
		   case 2 :
			   System.out.println("");
				System.out.print("Ingrese el numero de ruletas a crear? : ");
				reader = new Scanner(System.in);
				int quantity = reader.nextInt(); 
				roulette_creation(quantity);
				roulette_print();
		      break; 
		   case 3 :			
			   roulette_print();
			   break; 
		   case 4 :
			   break;
		   case 5 :
			   System.out.println("Su sesion fue cerrada correctamente");
			   close=false; 
			   break; 
		}
	}
	public static void roulette_creation(int quantity){		
	    for(int i=0;i<quantity;i++){
	    	consecutive++;
	    	roulettes.add(new Roulette(consecutive,"Abierta"));	
	    }	
	}
	public static void roulette_print(){
		System.out.println("");
		int size=roulettes.size();
	    for(int i=0;i<size;i++){
	    	System.out.println("Ruleta numero: "+ roulettes.get(i).id+" Estado: "+roulettes.get(i).state);
	    }
	 }
	public static void place_bets(){
		Bet bet_client;
		int id_users;
		int number;
		String color;
		int value;
		int id_Roulette=0;
		System.out.println("");
		System.out.println("Ingrese el codigo del usuario");
		Scanner reader = new Scanner (System.in); 
		id_users=reader.nextInt();
		System.out.println("Ingrese el numero a apostar entre el 0 y el 36");
		reader = new Scanner (System.in); 
		number=reader.nextInt();
		System.out.println("Ingrese el color Negro o Rojo");
		reader = new Scanner (System.in); 
		color= reader.nextLine ();
		System.out.println("Ingrese el monto a apostar");
		reader = new Scanner (System.in); 
		value=reader.nextInt();
		System.out.println("Ingrese el numero de la ruleta");
		reader = new Scanner (System.in); 
		id_Roulette=reader.nextInt();
		bet_client=new 
		roulettes.get(id_Roulette).new_Bets(bet_client);
		
	}
}
