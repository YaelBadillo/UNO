public class Jugador {
	public String nombre;
	public int numeroDeJugador;
	private int numeroDeCartas = 50;
	Carta mazo[] = new Carta[numeroDeCartas];
	
	public String toString(){
		String mensaje = "Hola soy el jugador numero " + numeroDeJugador;
		return mensaje;
	}
	
	
	public Jugador(){
		
	}
	public Jugador(int numeroDeJugador, String nombre){
		this.numeroDeJugador = numeroDeJugador;
		this.nombre = nombre;	
	}
}
