
public class Juego {
	public static void main(String[] args){
		int nC=0;
		
		Carta arreglo[] = new Carta[72];
		
		/*arreglo[0]= new Carta("Azul",1);*/
		/*Carta amarillo = new Carta("Amarillo",2);*/
		
		for(int i=0;i<9;i++){
			for(int j=1;j<=2;j++){
				arreglo[nC] = new Carta("Azul",i+1);
				System.out.println(arreglo[nC]);
				nC=nC+1;
			}
		}
		for(int i=0;i<9;i++){
			for(int j=1;j<=2;j++){
				arreglo[nC] = new Carta("Amarillo",i+1);
				System.out.println(arreglo[nC]);
				nC=nC+1;
			}
		}
		for(int i=0;i<9;i++){
			for(int j=1;j<=2;j++){
				arreglo[nC] = new Carta("Verde",i+1);
				System.out.println(arreglo[nC]);
				nC=nC+1;
			}
		}
		for(int i=0;i<9;i++){
			for(int j=1;j<=2;j++){
				arreglo[nC] = new Carta("Rojo",i+1);
				System.out.println(arreglo[nC]);
				nC=nC+1;
			}
		}
		
		
		CartaEspecial cartaE = new CartaEspecial("Negro");
		System.out.println(cartaE);
		

		
	}
}
