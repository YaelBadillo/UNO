import java.util.Scanner;
public class Juego {
	
	//Variables Globales
	public static Carta cartas[] = barajarCartas();  //Se declaran todas las cartas ya barajeadas
	public static int NumeroDeJugadores = 0;         //Inicializamos el numero de jugadores
	public static int NumeroDeJugador = 0;           //Inicializamos el numero de jugadore
	public static int cartaEntrada;                  //Creamos carta entrada
	
	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);      //Se declara el objeto Scanner
		boolean ganador = false;                       //El juego inicia sin ganador
		int cartaEntrada;
		//int NumeroDeJugador = 0;
		int nDeCartaVolteada = 0;
		int nDeCartaRevuelta;
		
		imprimirBienvenida();                          //Imprime la bienvenida
		NumeroDeJugadores = numeroDeJugadores();              //Se declara el numero de jugadores

		Jugador jugadores[] = crearJugadores(); //Se declaran los jugadores y se les da 7 cartas
		Carta cartasVolteadas[] = cartasEnJuego();
		
		limpiarConsola();
		while(ganador == false){
			for(NumeroDeJugador = 0; NumeroDeJugador < jugadores.length; NumeroDeJugador++){
				
				System.out.println("Carta en juego:");
				System.out.println(cartasVolteadas[nDeCartaVolteada]);//Imprime la carta en juego
				
				if(cartasVolteadas[nDeCartaVolteada].efecto == "Normal"){
					System.out.println("Turno de " + jugadores[NumeroDeJugador].nombre + "\nTus cartas: ");
					imprimirCartasJugador(NumeroDeJugador, jugadores);
					
					System.out.println("Ingrese una carta ");//Pide una carta al jugador
					cartaEntrada=entrada.nextInt() - 1;

					//Si la carta no es la correcta, le vuelve a pedir otra al jugador
					while(jugadores[NumeroDeJugador].mazo[cartaEntrada].color != cartasVolteadas[nDeCartaVolteada].color && 
						  jugadores[NumeroDeJugador].mazo[cartaEntrada].numero != cartasVolteadas[nDeCartaVolteada].numero){
						System.out.println("No puedes poner esa carta, pon otra");
						cartaEntrada=entrada.nextInt() - 1;
					}

					//Agrega la carta que eligio el jugador, a el mazo cartasVolteadas		
					cartasVolteadas[nDeCartaVolteada + 1]=jugadores[NumeroDeJugador].mazo[cartaEntrada];
					//Elimina la carta que eligio el jugador, de su mano
					jugadores[NumeroDeJugador].mazo[cartaEntrada] = null;

					//Recorre de posicion las cartas de la mano del jugador
					for(int i = cartaEntrada; true; i++){
						jugadores[NumeroDeJugador].mazo[i] = jugadores[NumeroDeJugador].mazo[i+1];
							if(jugadores[NumeroDeJugador].mazo[i] == null)
								break;
						}
					nDeCartaVolteada++;
					
					limpiarConsola();
					}
				if(cartasVolteadas[nDeCartaVolteada].efecto == "RobaDos"){
					for(int i = 0; i < 2; i++){
						System.out.print("RobaDos");
						ganador = true;
						}
					limpiarConsola();
					}
				if(cartasVolteadas[nDeCartaVolteada].efecto == "CambioSentido"){
					System.out.print("CambioSentido");
					ganador = true;
					limpiarConsola();
				}
				if(cartasVolteadas[nDeCartaVolteada].efecto == "PierdeTurno"){
					
					limpiarConsola();
					System.out.print(jugadores[NumeroDeJugador].nombre + "Pierde su turno");
					NumeroDeJugador++;
				}
				if(cartasVolteadas[nDeCartaVolteada].efecto == "C-CambioColor"){
					System.out.print("C-CambioColor");
					ganador = true;
				}
				if(cartasVolteadas[nDeCartaVolteada].efecto == "C-CambioColor4"){
					System.out.print("C-CambioColor4");
					ganador = true;
				}
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
		
	//Funcion para definir el numero de jugadores
	public static int numeroDeJugadores(){
		Scanner entrada = new Scanner(System.in);
		int jugadores = 0; 
		
		while(jugadores > 4 || jugadores < 2){
			System.out.println("Numero de jugadores: ");
			jugadores = entrada.nextInt();
			
			if(jugadores > 4 || jugadores < 2){
				System.out.println("\nERROR: Numero de jugadores ivalido.\n"
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

	//Funcion para crear los jugadores y asignar las primeras 7 cartas a cada jugador
	public static Jugador[] crearJugadores(){ //Se pasan las cartas y numero de jugador declararado en el main
		Scanner entrada = new Scanner(System.in);      //Se declara el objeto Scanner
		Jugador jugadores[] = new Jugador[NumeroDeJugadores];//Instanciamos un arreglo de objetos del objeto Jugador, con el numero de jugadores
		
		String nombre = "";
		int cont = 107;//Numero de objeto del arreglo cartas
		int cont2 = 0;//Numero de objeto del mazo, dentro del arreglo jugador
		
		//Declaramos el numero de jugadores del arreglo Jugador
		for(int i = 0; i < NumeroDeJugadores; i++){
			System.out.println("Nombre del jugador " + (i+1));
			nombre = entrada.nextLine();
			jugadores[i] = new Jugador(i+1 , nombre);
		}
		
		//Le damos cartas a cada jugador
		for(int i = 1; i <= 7; i++){
			for(int j = 0; j < jugadores.length; j++){
				jugadores[j].mazo[cont2] = cartas[cont];
				cartas[cont] = null;
				cont--;
			}
			cont2++;
		}

		return jugadores;
	}

	//Funcion para poner la primera carta del arreglo cartas barajadas, al arreglo de cartas volteadas para empezar a jugar
	public static Carta[] cartasEnJuego() {

		Carta cartasVolteadas[] = new Carta[108];//Arreglo de cartas volteadas
		int indice = IndiceUltimoElemento(cartas);
		
		cartasVolteadas[0] = cartas[indice];

		return cartasVolteadas;
	}

	//Da el indice donde se aloja el ultimo elemento
	public static int IndiceUltimoElemento(Carta arreglo[]){
		int indice = 0;
		
		for(int i = 107; arreglo[i] == null || i >= 0; i--){
			if(arreglo[i] != null){
				indice = i;
				break;
			}
		}
		
		return indice;
	}
	
	//Funcion que limpia la consola
	public static void limpiarConsola(){
		for(int i = 0; i < 50; i++)
			System.out.println();
	}
	
	//Imrime las cartas del jugador
	public static void imprimirCartasJugador(int jugadorNumero, Jugador jugadores[]){
		System.out.print("\nCartas de " + jugadores[jugadorNumero].nombre +"\n");

		int cont = 0;
		for(int i = 0; jugadores[jugadorNumero].mazo[i] != null; i++){//Imprime las cartas del jugador en turno
			cont++;
		}

		while(true){

			for(int j = 0; j < cont; j++){
				System.out.print(" ________   ");
				
				if(j == 9){
					break;
				}
			}
			
			System.out.println();
			
			for(int j = 0; j < cont; j++){
				
				if(jugadores[NumeroDeJugador].mazo[cartaEntrada].efecto != "CambioSentido")
				 	System.out.print("|        |  ");
					
				if(jugadores[NumeroDeJugador].mazo[cartaEntrada].efecto == "CambioSentido")
					System.out.print("|   ^    |  ");
					
				if(j == 9){
					break;
				}
				
				cartaEntrada++;
			}
			
			cartaEntrada = 0;
			System.out.println();
			
			for(int j = 0; j < cont; j++){
				
				if(jugadores[NumeroDeJugador].mazo[cartaEntrada].efecto == "Normal")
					System.out.print("|   "+jugadores[NumeroDeJugador].mazo[cartaEntrada].numero+"    |  ");
					
				if(jugadores[NumeroDeJugador].mazo[cartaEntrada].efecto == "RobaDos")
					System.out.print("|   +2   |  ");
					
				if(jugadores[NumeroDeJugador].mazo[cartaEntrada].efecto == "CambioSentido")
					System.out.print("|   ||   |  ");
					
				if(jugadores[NumeroDeJugador].mazo[cartaEntrada].efecto == "PierdeTurno")
					System.out.print("|  (/0)  |  ");
					
				if(jugadores[NumeroDeJugador].mazo[cartaEntrada].efecto == "C-CambioColor")
					System.out.print("| Cambio |  ");
					
				if(jugadores[NumeroDeJugador].mazo[cartaEntrada].efecto == "C-CambioColor4")
					System.out.print("| Cambio |  ");
					
				if(j == 9){
					break;
				}
				
				cartaEntrada++;
			}
			
			cartaEntrada = 0;
			System.out.println();
			
			for(int j = 0; j < cont; j++){
				
				if(jugadores[NumeroDeJugador].mazo[cartaEntrada].efecto == "Normal" 
						|| jugadores[NumeroDeJugador].mazo[cartaEntrada].efecto == "RobaDos" 
						|| jugadores[NumeroDeJugador].mazo[cartaEntrada].efecto == "PierdeTurno")
					System.out.print("|        |  ");
					
				if(jugadores[NumeroDeJugador].mazo[cartaEntrada].efecto == "CambioSentido")
					System.out.print("|    v   |  ");
					
				if(jugadores[NumeroDeJugador].mazo[cartaEntrada].efecto == "C-CambioColor")
					System.out.print("| Color  |  ");
					
				if(jugadores[NumeroDeJugador].mazo[cartaEntrada].efecto == "C-CambioColor4")
					System.out.print("| Color  |  ");
					
				if(j == 9){
					break;
				}
				
				cartaEntrada++;	
			}
			
			cartaEntrada = 0;
			System.out.println();
			
			
			for(int j = 0; j < cont; j++){
				
				if(jugadores[NumeroDeJugador].mazo[cartaEntrada].efecto == "Normal"){
					
					if(jugadores[NumeroDeJugador].mazo[cartaEntrada].color == "Azul"){
						System.out.print("|  "+"Azul"+"  |  ");
					}
					if(jugadores[NumeroDeJugador].mazo[cartaEntrada].color == "Amarillo"){
						System.out.print("|"+"Amarillo"+"|  ");
					}
					if(jugadores[NumeroDeJugador].mazo[cartaEntrada].color == "Verde"){
						System.out.print("| "+"Verde"+"  |  ");
					}
					if(jugadores[NumeroDeJugador].mazo[cartaEntrada].color == "Rojo"){
						System.out.print("|  "+"Rojo"+"  |  ");
					}
					
				}
				
				if(jugadores[NumeroDeJugador].mazo[cartaEntrada].efecto == "RobaDos"){
					
					if(jugadores[NumeroDeJugador].mazo[cartaEntrada].color == "Azul"){
						System.out.print("|  "+"Azul"+"  |  ");
					}
					if(jugadores[NumeroDeJugador].mazo[cartaEntrada].color == "Amarillo"){
						System.out.print("|"+"Amarillo"+"|  ");
					}
					if(jugadores[NumeroDeJugador].mazo[cartaEntrada].color == "Verde"){
						System.out.print("| "+"Verde"+"  |  ");
					}
					if(jugadores[NumeroDeJugador].mazo[cartaEntrada].color == "Rojo"){
						System.out.print("|  "+"Rojo"+"  |  ");
					}
					
				}
				
				if(jugadores[NumeroDeJugador].mazo[cartaEntrada].efecto == "CambioSentido"){
					
					if(jugadores[NumeroDeJugador].mazo[cartaEntrada].color == "Azul"){
						System.out.print("|  "+"Azul"+"  |  ");
					}
					if(jugadores[NumeroDeJugador].mazo[cartaEntrada].color == "Amarillo"){
						System.out.print("|"+"Amarillo"+"|  ");
					}
					if(jugadores[NumeroDeJugador].mazo[cartaEntrada].color == "Verde"){
						System.out.print("| "+"Verde"+"  |  ");
					}
					if(jugadores[NumeroDeJugador].mazo[cartaEntrada].color == "Rojo"){
						System.out.print("|  "+"Rojo"+"  |  ");
					}
					
				}
				
				if(jugadores[NumeroDeJugador].mazo[cartaEntrada].efecto == "PierdeTurno"){
					
					if(jugadores[NumeroDeJugador].mazo[cartaEntrada].color == "Azul"){
						System.out.print("|  "+"Azul"+"  |  ");
					}
					if(jugadores[NumeroDeJugador].mazo[cartaEntrada].color == "Amarillo"){
						System.out.print("|"+"Amarillo"+"|  ");
					}
					if(jugadores[NumeroDeJugador].mazo[cartaEntrada].color == "Verde"){
						System.out.print("| "+"Verde"+"  |  ");
					}
					if(jugadores[NumeroDeJugador].mazo[cartaEntrada].color == "Rojo"){
						System.out.print("|  "+"Rojo"+"  |  ");
					}
					
				}
				
				if(jugadores[NumeroDeJugador].mazo[cartaEntrada].efecto == "C-CambioColor"){
					System.out.print("|        |  ");
				}
				
				if(jugadores[NumeroDeJugador].mazo[cartaEntrada].efecto == "C-CambioColor4"){
					System.out.print("|   +4   |  ");
				}
			
				if(j == 9){
					break;
				}
				
				cartaEntrada++;
			}
			
			cartaEntrada = 0;
			System.out.println();
			
			for(int j = 0; j < cont; j++){
				System.out.print("|________|  ");
				
				if(j == 9){
					break;
				}
			}
			
			System.out.println();
			
			for(int j = 1; j <= cont; j++){
				
				if(j != 10){
					System.out.print("    "+j+"       ");
				}
				
				if(j == 10){
					System.out.print("    "+10+"      ");
				}
				
				if(j == 9){
					break;
				}	
			}
			
			System.out.println();
			
			cont = cont - 10;
			if(cont <= 0){
				break;
			}
		}

	}
	
	//Imprimir cartas del mazo principal
	public static void imprimirCartasPrincipales(){
		System.out.println("Cartas del mazo principal\n");
		for(int i = 0; i < cartas.length;i++)
			System.out.println(cartas[i]);
	}
	
	//Imprime la bienvenida
	public static void imprimirBienvenida(){
		System.out.print("Hola bienvenidos a:\n" +
						 "   __  ___   ______\n" +
						 "  / / / / | / / __ \n" +
				         " / / / /  |/ / / / /\n" +
						 "/ /_/ / /|  / /_/ /\n" +
				         "\\____/_/ |_/\\____/\n\n" +
						 "Por Yael y Erik\n\n");
	}
}
