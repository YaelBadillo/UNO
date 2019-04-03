
public class Carta {
	public String color;
	public int numero;
	public String efecto;
	
	/*
	 Efectos
	 	* "Normal"         //Carta normal
	 	* "RobaDos"          //El siguiente jugador roba 2 cartas
	 	* "CambioSentido"  //Cambia el sentido de rotacion del juego
	 	* "PierdeTurno"    //El siguiente jugador pierde su turno
	 	* "C-CambioColor"  //Comodin El jugador puede cambiar el color
	 	* "C-CambioColor4" //Comodin El jugador puede cambiar el color y el siguiente roba 4
	 */
	
	public String toString(){
		String colorCarta = "";
		String efectoCarta = "";
		
		for(int i = color.length(); i < 8;i++)
			colorCarta+=" ";
		colorCarta = color + colorCarta + "|";
		
		if(efecto == "Normal")
			efectoCarta = "        |\n|   " + numero +"    |\n|        |\n" + "|" + colorCarta;
		if(efecto == "RobaDos")
			efectoCarta = "        |\n|   +2   |\n|        |\n" + "|" + colorCarta;
		if(efecto == "CambioSentido")
			efectoCarta = "   ^    |\n|   ||   |\n|    v   |\n" + "|" + colorCarta;
		if(efecto == "PierdeTurno")
			efectoCarta = "        |\n|  (/0)  |\n|        |\n" + "|" + colorCarta;
		if(efecto == "C-CambioColor")
			efectoCarta = "        |\n| Cambio |\n| Color  |\n|        |";
		if(efecto == "C-CambioColor4")
			efectoCarta = "        |\n| Cambio |\n| Color  |\n|   +4   |";
		
		String mensaje = " ________\n"
			           + "|" + efectoCarta + "\n"
			           + "|________|";
		return mensaje;
	}
	
	public Carta(){
		
	}
	public Carta(String color,int numero, String efecto){
		this.color = color;
		this.numero = numero;
		this.efecto = efecto;
	}
}
