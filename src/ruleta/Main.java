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
				System.out.println("");
				System.out.println("ruletas a crear con exito");
		      break; 
		   case 3 :			
			   roulette_print();
			   break; 
		   case 4 :
			    int size=roulettes.size();
			    if(size==0){
			    	System.out.println("No existen Ruletas creadas para sortear");
			    	break;
			    }
			   roulette_play();
			   roulette_print();
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
	    	System.out.println("Ruleta numero: "+ roulettes.get(i).id+" Estado: "+roulettes.get(i).state+" balota ganadora: "+roulettes.get(i).winning_ballot+" color Ganador :"+roulettes.get(i).winning_color);
	    }
	    if(size==0){
	    	System.out.println("No existen Ruletas creadas para mostrar");
	    }
	 }
	public static int number_bet(Scanner reader, int number){
		do{
		System.out.print("Ingrese el numero a apostar entre el 0 y el 36 : ");
		reader = new Scanner (System.in);
		number=reader.nextInt();
		}while(!(number>=0 && number <=36));
		return number;
	}
	public static String color_bet(Scanner reader, String color){	
		do{
			System.out.print("Ingrese el color negro o rojo :");
			reader = new Scanner (System.in); 
			color= reader.nextLine ();		
		}while(!(color.equals("negro") || color.equals("rojo")));
		return color;
	}
	public static int cash_bet(Scanner reader, int value){
		do{
			System.out.print("Ingrese el monto a apostar (máximo 10.000 dólares) :");
			reader = new Scanner (System.in); 
			value=reader.nextInt();	
		}while(!(value>=1 && value <=10000));
		return value;
	}
	public static int roulette_bet(Scanner reader,int id_Roulette){
		do{
		System.out.print("Ingrese el numero de la ruleta :");
		reader = new Scanner (System.in); 
		id_Roulette=reader.nextInt();
		}while(roulette_validator(id_Roulette));
		return id_Roulette;
	}
	public static boolean roulette_validator(int id_Roulette){
		int size=roulettes.size();
	    for(int i=0;i<size;i++){
	        if(roulettes.get(i).id==id_Roulette && roulettes.get(i).state.equals("Abierta")){
	        	System.out.println("Ruleta donde se realiza la apuesta numero: "+ roulettes.get(i).id+" Estado: "+roulettes.get(i).state);
	        	return false;
	        }	    	
	    }
	    System.out.print("Ingrese el numero de la ruleta existente o abierta :");
		return true;
	}	
	public static void place_bets(){
		Bet bet_client;
		int id_users;
		int number=-1;
		String color="";
		int value=-1;
		int id_Roulette=0;
	if(roulettes.size()<=0){
			System.out.println("");
			System.out.println("No existen ruletas creadas, Para poder realizar la apuesta");
	}
	else{
			System.out.println("");
			System.out.print("Ingrese el codigo del usuario: ");
			Scanner reader = new Scanner (System.in); 
			id_users=reader.nextInt();
			number=number_bet(reader, number);	
			color=color_bet(reader, color);
			value=cash_bet(reader,value);			
			bet_client=new Bet(number,color,value,id_users);
			id_Roulette=roulette_bet(reader,id_Roulette);
			roulettes.get(id_Roulette-1).new_Bets(bet_client);
			System.out.println("");
			System.out.println("Apuesta realizada con exito");
		}
	}
	public static void  print_bets(int id_Roulette){
		
		ArrayList<Bet> bets = new ArrayList<Bet>();
		bets=roulettes.get(id_Roulette-1).getBets();
		
		System.out.println("");
		int size=bets.size();
	    for(int i=0;i<size;i++){
	    	System.out.println("Usuario: "+bets.get(i).id_users+" Numero jugado: "+bets.get(i).number+" Color Jugado "+bets.get(i).getColor()+" Valor Apostado "+bets.get(i).value);
	    }
	    if(size==0){
	    	System.out.println("No existen apuestas creadas para mostrar");
	    }
	}
	public static void  roulette_play(){
		int id_Roulette=0;
		Scanner reader=new Scanner (System.in);;
		id_Roulette=roulette_bet(reader,id_Roulette);
		if(!(roulette_validator(id_Roulette))){			
			int ballot=(int) Math.floor(Math.random()*37);
			int value_color=(int) Math.floor(Math.random()*2);
			String color=""; 
			if(value_color==0){color="negro";}
			else if(value_color==1){color="rojo";}
			System.out.println("");
			roulettes.get(id_Roulette-1).setState("Cerrada");
			roulettes.get(id_Roulette-1).setWinning_ballot(ballot+"");
			roulettes.get(id_Roulette-1).setWinning_color(color);
			System.out.println("Sorteo realizado con exito numero de la ruleta "+id_Roulette+" balota: "+ballot+" color: "+color);	
			print_bets(id_Roulette);
		};
	}
}