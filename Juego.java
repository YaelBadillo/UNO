import java.util.Scanner;

public class Juego {
	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);      //Se declara el objeto Scanner
		
		Carta cartas[] = barajarCartas();             //Se declaran todas las cartas ya barajeadas
		int jugadores = numeroDeJugadores();           //Se declara el numero de jugadores
		boolean ganador = false;                       //El juego inicia sin ganador
		
		//int jugadores = numeroDeJugadores();           //Se declara el numero de jugadores
		Jugador jugador[] = mazoDeJugadores(jugadores, cartas); //Se declaran los jugadores
		Carta cartasVolteadas[] = cartasEnJuego(cartas);
		
		//Carta cartasVolteadas[] = turno(cartas, cartasVolteadas, jugador);
		//Imprime las cartas del mazo principal
		/*
		System.out.println("Cartas del mazo principal\n");
		for(int i = 0; i < cartas.length;i++)
			System.out.println(cartas[i]);
		
		//Imprime las cartas del jugador
		System.out.println("\nCartas del jugador\n");
		for(int i = 0; i < 7;i++)
			System.out.println(jugador[0].mazo[i]);
		
		System.out.println("\nPrimera Carta\n");
		System.out.println(cartasVolteadas[0]);
		System.out.println(cartas[93]);
		*/
		int cartaEntrada;
		int jugadorNumero=0;
		int nDeCartaVolteada=0;
		int nDeCartaRevuelta;
		//System.out.println(cartasVolteadas[0]);
		while(ganador==false){
			
			System.out.println(cartasVolteadas[nDeCartaVolteada]);//Imprime la carta en juego
			
			nDeCartaVolteada++;
			
			System.out.println("\nCartas del jugador " + jugadorNumero +"\n");
			
			for(int i = 0; jugador[jugadorNumero].mazo[i] != null; i++){//Imprime las cartas del jugador en turno
				System.out.println(jugador[jugadorNumero].mazo[i]);
			}
			
			System.out.println("Ingrese una carta ");//Pide una carta al jugador
			cartaEntrada=entrada.nextInt();
			
			//Si la carta no es la correcta, le vuelve a pedir otra al jugador
			while(jugador[jugadorNumero].mazo[cartaEntrada].color != cartasVolteadas[0].color 
					&& jugador[jugadorNumero].mazo[cartaEntrada].numero != cartasVolteadas[0].numero){
				System.out.println("No puedes poner esa carta, pon otra");
				cartaEntrada=entrada.nextInt();
			}
			
			//Agrega la carta que eligio el jugador, a el mazo cartasVolteadas		
			cartasVolteadas[nDeCartaVolteada]=jugador[jugadorNumero].mazo[cartaEntrada];
			//Elimina la carta que eligio el jugador, de su mano
			jugador[jugadorNumero].mazo[cartaEntrada] = null;
			
			//Recorre de posicion las cartas de la mano del jugador
			for(int i = cartaEntrada; true; i++){
				jugador[jugadorNumero].mazo[i] = jugador[jugadorNumero].mazo[i+1];
				if(jugador[jugadorNumero].mazo[i]==null)
					break;
			}
			
			//Efecto carta RobaDos
			if(cartasVolteadas[nDeCartaVolteada].efecto=="RobaDos"){
				
				if(jugadorNumero==0){
					
					for(int h = 0; h<2; h++){
						
						for(int i = 0; jugador[1].mazo[i] != null; i++ ){
							
							if(jugador[1].mazo[i+1] == null){
								
									for(int k = 107; cartas[k] == null || k>0; k--){
									
										if(cartas[k] != null){
											jugador[1].mazo[i+1] = cartas[k];
											cartas[k] = null;
											break;
										}
									}
									break;
							}		
						}
					}
				}
				if(jugadorNumero==0){
					
					for(int h = 0; h<2; h++){
						
						for(int i = 0; jugador[1].mazo[i] != null; i++ ){
							
							if(jugador[1].mazo[i+1] == null){
								
									for(int k = 107; cartas[k] == null || k>0; k--){
									
										if(cartas[k] != null){
											jugador[1].mazo[i+1] = cartas[k];
											cartas[k] = null;
											break;
										}
									}
									break;
							}		
						}
					}
				}
					
				System.out.println(jugador[1].mazo[8]+"Hola");
			}
			
			//Cambia el turno
			if(jugadorNumero==0){
				jugadorNumero=1;
			}else{
				jugadorNumero=0;
			}
					
		}
	}
	
	//Funcion que modela todas las cartas
	public static Carta[] declararCartas(){
		Carta cartas[] = new Carta[108];
		int numeroDeCarta = 0;
		
		//Genera cartas de colores del 1 al 9
		for(int i = 0; i < 2;i++)
			for(int numero = 1;numero <= 9; numero++){
				cartas[numeroDeCarta] = new Carta("Azul", numero, "Normal");
				numeroDeCarta++;
				cartas[numeroDeCarta] = new Carta("Verde", numero, "Normal");
				numeroDeCarta++;
				cartas[numeroDeCarta] = new Carta("Rojo", numero, "Normal");
				numeroDeCarta++;
				cartas[numeroDeCarta] = new Carta("Amarillo", numero, "Normal");
				numeroDeCarta++;
			}
		//Genera una carta con el nunmero 0 por cada color
		cartas[72] = new Carta("Azul", 0, "Normal");
		cartas[73] = new Carta("Verde", 0, "Normal");
		cartas[74] = new Carta("Rojo", 0, "Normal");
		cartas[75] = new Carta("Amarillo", 0, "Normal");
		
		//Genera 2 cartas RobaDos por cada color
		numeroDeCarta = 76;
		for(int i = 0; i < 2;i++){
			cartas[numeroDeCarta] = new Carta("Azul", 10, "RobaDos");
			numeroDeCarta++;
			cartas[numeroDeCarta] = new Carta("Verde", 10, "RobaDos");
			numeroDeCarta++;
			cartas[numeroDeCarta] = new Carta("Rojo", 10, "RobaDos");
			numeroDeCarta++;
			cartas[numeroDeCarta] = new Carta("Amarillo", 10, "RobaDos");
			numeroDeCarta++;
		}
		
		//Genera 2 cartas CambioSentido por cada color
		for(int i = 0; i < 2;i++){
			cartas[numeroDeCarta] = new Carta("Azul", 10, "CambioSentido");
			numeroDeCarta++;
			cartas[numeroDeCarta] = new Carta("Verde", 10, "CambioSentido");
			numeroDeCarta++;
			cartas[numeroDeCarta] = new Carta("Rojo", 10, "CambioSentido");
			numeroDeCarta++;
			cartas[numeroDeCarta] = new Carta("Amarillo", 10, "CambioSentido");
			numeroDeCarta++;
		}
		
		//Genera 2 cartas PierdeTurno por cada color
		for(int i = 0; i < 2;i++){
			cartas[numeroDeCarta] = new Carta("Azul", 10, "PierdeTurno");
			numeroDeCarta++;
			cartas[numeroDeCarta] = new Carta("Verde", 10, "PierdeTurno");
			numeroDeCarta++;
			cartas[numeroDeCarta] = new Carta("Rojo", 10, "PierdeTurno");
			numeroDeCarta++;
			cartas[numeroDeCarta] = new Carta("Amarillo", 10, "PierdeTurno");
			numeroDeCarta++;
		}
		
		//Genera 4 cartas C-CambioColor
		for(int i = 1; i <= 4; i++){
			cartas[numeroDeCarta] = new Carta("Todos", 10, "C-CambioColor");
			numeroDeCarta++;
		}
		
		//Genera 4 cartas C-CambioColor4
		for(int i = 1; i <= 4; i++){
			cartas[numeroDeCarta] = new Carta("Todos", 10, "C-CambioColor4");
			numeroDeCarta++;
		}
		
		
		return cartas;	//Regresa el arreglo cartas[]
	}
	
	//Funcion que limpia la consola
	public static void limpiarConsola(){
		for(int i = 0; i < 50; i++)
			System.out.println();
	}
	
	//Funcion para definir el numero de jugadores
	public static int numeroDeJugadores(){
		Scanner entrada = new Scanner(System.in);
		int jugadores = 0; 
		
		while(jugadores > 4 || jugadores < 2){
			System.out.println("Numero de jugadores: ");
			jugadores = entrada.nextInt();
			
			if(jugadores > 4 || jugadores < 2){
				limpiarConsola();
				System.out.println("ERROR: Numero de jugadores ivalido.\n"
						+ "Recuerde que solo puede haber de 2 a 4 jugadores.\n");
			}			
		}
		
		return jugadores;
	}
	
	//Funcion para barajar las cartas
	public static Carta[] barajarCartas(){
		Carta cartas[] = declararCartas();//Arreglo Cartas ordenadas
		Carta cartasRevueltas[] = new Carta[108];//Nuevo Arreglo Cartas barajeadas
		
		//Pasamos las cartas de un arreglo a otro de forma aleatoria
		for(int i = 0; i < cartas.length; i++){
			cartasRevueltas[i] = cartas[(int)(Math.random()*(cartas.length))];
			
			//Revision de que las cartas no sean repetidas
			for(int j = 0; i>0 && j < i; j++)
				
				//Sí una carta es repetida con la ultima, se le vuelve a asignar otra a esta
				if(cartasRevueltas[i] == cartasRevueltas[j])
					i--;
		}
		
		return cartasRevueltas;
	}
	
	
	//Funcion para asignar las primeras 7 cartas a cada jugador
	public static Jugador[] mazoDeJugadores(int NumeroJugadores, Carta MazoCartas[]){ //Se pasan las cartas y numero de jugador declararado en el main
		Carta cartas[] = MazoCartas;   //Se asisgnan las cartas del main a cartas

		int jugadores = NumeroJugadores; //Se asisgna el numero de jugadores del main a jugadores

		Jugador jugador[] = new Jugador[jugadores];//Instanciamos un arreglo de objetos del objeto Jugador, con el numero de jugadores

		for(int i = 0; i < jugadores; i++){//Declaramos el numero de jugadores del arreglo Jugador
			jugador[i] = new Jugador(i+1);
		}

		int cont=107;//Numero de objeto del arreglo cartas
		int cont2=0;//Numero de objeto del mazo, dentro del arreglo jugador
		//Asignacion de cartas del arreglo cartas al arreglo mazo, dentro de cada arreglo jugador
		for(int i = 0; i < 7; i++){
			jugador[0].mazo[cont2] = cartas[cont];//Jugador numero 1
			cartas[cont] = null;
			cont--;

			jugador[1].mazo[cont2] = cartas[cont];//jugador numero 2
			cartas[cont] = null;
			cont--;

			if(jugadores>2){//Asignacion de cartas al jugador 3(solo si son 3 o 4 jugadores)
				jugador[2].mazo[cont2] = cartas[cont];//jugador numero 3
				cartas[cont] = null;
				cont--;

				if(jugadores>3){//Asignacion de cartas al jugador 4(solo si son 4 jugadores)
					jugador[3].mazo[cont2] = cartas[cont];//Jugador numero 4
					cartas[cont] = null;
					cont--;
				}
			}
			cont2++;
		}

		return jugador;
	}
	
	//Funcion para poner la primera carta del arreglo cartas barajadas, al arreglo de cartas volteadas para empezar a jugar
	public static Carta[] cartasEnJuego(Carta mazoCartas[]) {
		Carta cartas[] = mazoCartas;//Arreglo de cartas barajadas
		
		Carta cartasVolteadas[] = new Carta[108];//Arreglo de cartas volteadas
		
		//Toma la ultima carta del arreglo de cartas barajadas para comenzar a jugar
		for(int i = 107; cartas[i] == null || i>=0; i--){
			
			if(cartas[i] != null){
				cartasVolteadas[0] = cartas[i];
				cartas[i] = null;
				break;
			}
		}
		
		return cartasVolteadas;
	}
	
}
