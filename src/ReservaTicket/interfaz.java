package ReservaTicket;
import java.util.Scanner;

public class interfaz {

	
	public void menu()
	{
		vagon vagonAct = new vagon(10);
		boolean salir=false;
		int opcion=0;
		Scanner in = new Scanner(System.in);
		
		do
		{
			System.out.println("Opciones disponibles:");
			System.out.println("1. Reservar primer asiento disponible.");
			System.out.println("2. Reservar asiento especifico.");
			System.out.println("3. Salir.");
			opcion = in.nextInt();
			
			switch(opcion)
			{
				case 1:
					vagonAct.reservarPrimero();
					vagonAct.mostrar();
					break;
				case 2:
					pedirAsiento(vagonAct, in);
					vagonAct.mostrar();
					break;
				case 3:
					salir=true;
					break;
				default :
					System.out.println("Opcion incorrecta, intentelo de nuevo.");
					
			}
			
		}while(!salir);
	}
	
	public void pedirAsiento(vagon vagonAct, Scanner in)
	{
		int fila, columna;
		
		System.out.println("Introduzca la fila.");
		fila = in.nextInt();
		System.out.println("Introduzca la columna.");
		columna = in.nextInt();
		vagonAct.reservarEspecifico(fila-1, columna-1);
		
	}
	
	public static void main (String [ ] args) {
		
		interfaz inter=new interfaz();
		inter.menu();
	}
}
