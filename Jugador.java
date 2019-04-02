public class Jugador {
	public int numeroDeJugador;
	private int numeroDeCartas = 50;
	Carta mazo[] = new Carta[numeroDeCartas];
	
	public String toString(){
		String mensaje = "Hola soyr el jugador numero "+numeroDeJugador;
		return mensaje;
	}
	
	
	public Jugador(){
		
	}
	public Jugador(int numeroDeJugador){
		this.numeroDeJugador = numeroDeJugador;
		//this.numeroDeCartas = numeroDeCartas;
		
	}
}