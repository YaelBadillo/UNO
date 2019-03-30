
public class Carta {
	public String color;
	private int numero;
	
	public String toString(){
		String mensaje = " ______\n|" + numero + "     |\n|      |\n|(_._) |\n|  |   |\n|" + color + "|";
;
		return mensaje;
	}
	
	public Carta(){
		
	}
	public Carta(String color,int numero){
		this.color=color;
		this.numero=numero;
	}
}
