public class Jugador {
	public String nombre;
	public int numeroDeJugador;
	private int numeroDeCartas = 50;
	Carta mazo[] = new Carta[numeroDeCartas];
	
	public String toString(){ //ImprimirCartasJugador()
		String mensaje = "\nCartas de " + nombre + "\n";
		int contarCartas = 0;
		int inicio = 0;
		int fin = 9;
		boolean bandera = true;
		
		while(mazo[contarCartas] != null){ //cuenta las cartas que tiene el jugador
			contarCartas++;
		}
		 contarCartas--; //Para que empiece a contar desde 0
		
		 //while que termina caundo imprime todas las cartas del jugador
		while(bandera){
			for(int i = inicio; i <= fin && mazo[i] != null; i++){
				mensaje += " ________   ";
				if(i == contarCartas)
					bandera = false;
			}
			mensaje += "\n";
			
			for(int i = inicio; i <= fin && mazo[i] != null; i++){
				
				if(mazo[i].efecto != "CambioSentido")
					mensaje += "|        |  ";
				else
					mensaje += "|   ^    |  ";
				
				if(i == contarCartas)
					bandera = false;
				
			}
			mensaje += "\n";
			
			for(int i = inicio; i <= fin && mazo[i] != null; i++){
				if(mazo[i].efecto == "Normal")
					mensaje += "|   " + mazo[i].numero +"    |  ";
				if(mazo[i].efecto == "RobaDos")
					mensaje += "|   +2   |  ";
				if(mazo[i].efecto == "CambioSentido")
					mensaje += "|   ||   |  ";
				if(mazo[i].efecto == "PierdeTurno")
					mensaje += "|  (/0)  |  ";
				if(mazo[i].efecto == "C-CambioColor" || 
				   mazo[i].efecto == "C-CambioColor4")
					mensaje += "| Cambio |  ";
				
				if(i == contarCartas)
					bandera = false;
			}
			mensaje += "\n";
			
			for(int i = inicio; i <= fin && mazo[i] != null; i++){
				if(mazo[i].efecto == "Normal" ||
				   mazo[i].efecto == "RobaDos" ||
				   mazo[i].efecto == "PierdeTurno")
					mensaje += "|        |  ";
				if(mazo[i].efecto == "CambioSentido")
					mensaje += "|    v   |  ";
				if(mazo[i].efecto == "C-CambioColor" ||
				   mazo[i].efecto == "C-CambioColor4")
					mensaje += "| Color  |  ";
				
				if(i == contarCartas)
					bandera = false;
			}
			mensaje += "\n";
			
			//ARREGLAR PARA QUE LOS NOMBRES SE ESCRIBAN CENTRADOS
			for(int i = inicio; i <= fin && mazo[i] != null; i++){
				//Imprime el nombre del color
				if(mazo[i].efecto == "Normal" ||
					mazo[i].efecto == "CambioSentido" ||
					mazo[i].efecto == "RobaDos" ||
					mazo[i].efecto == "PierdeTurno"){
					String colorCarta = "";
					for(int j = mazo[i].color.length(); j < 8;j++)
						colorCarta+=" ";
					
					mensaje += "|" + mazo[i].color + colorCarta + "|  ";
				}
				
				if(mazo[i].efecto == "C-CambioColor")
					mensaje += "|        |  ";
				if(mazo[i].efecto == "C-CambioColor4")
					mensaje += "|   +4   |  ";
				
				if(i == contarCartas)
					break;
			}
			mensaje += "\n";
			
			for(int i = inicio; i <= fin && mazo[i] != null; i++){
				mensaje += "|________|  ";
			}
			mensaje += "\n";
			
			for(int i = inicio; i <= fin && mazo[i] != null; i++){
				if(i > 10)
					mensaje += "    " + (i+1) + "      ";
				else
					mensaje += "    " + (i+1) + "       ";
				
				if(i == contarCartas)
					bandera = false;
			}
			inicio += 10;
			fin += 10;
			mensaje += "\n";
		}
		
		
		return mensaje;
	}
	
	
	public Jugador(){
		
	}
	public Jugador(int numeroDeJugador, String nombre){
		this.numeroDeJugador = numeroDeJugador;
		this.nombre = nombre;	
	}
}
