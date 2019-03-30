
public class CartaEspecial extends Carta {
	public String toString(){
		String mensaje = "\n Soy una carta especial de color "+color;
		return mensaje;
	}
	
	public CartaEspecial(){
		
	}
	public CartaEspecial(String color){
		super.color=color;
	}
}
