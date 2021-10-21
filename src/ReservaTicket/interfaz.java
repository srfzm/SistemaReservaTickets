package ReservaTicket;
import java.util.Scanner;

import java.net.URL;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class interfaz {
	
	public static Logger logger = LogManager.getLogger(interfaz.class);

	
	public void menu()
	{
		vagon vagonAct = new vagon(10);
		boolean salir=false;
		int opcion=0;
		Scanner in = new Scanner(System.in);
		
		logger.info("Iniciado el menú.");
		
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
					logger.info("Elegida la opción de reserva del primer asiento.");
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
					logger.info("Elegida una opción incorrecta.");
					System.out.println("Opcion incorrecta, intentelo de nuevo.");
					
			}
			
		}while(!salir);
		
		logger.info("Salida del menú.");
	}
	
	public void pedirAsiento(vagon vagonAct, Scanner in)
	{
		int fila, columna;
		
		System.out.println("Introduzca la fila.");
		fila = in.nextInt();
		System.out.println("Introduzca la columna.");
		columna = in.nextInt();
		logger.info("Intento de reserva en la posicion "+fila+" columna "+columna+".");
		vagonAct.reservarEspecifico(fila-1, columna-1);
		
	}
	
	public static void main (String [ ] args) {
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource("log4j.properties");
		PropertyConfigurator.configure(url);
		
		interfaz inter=new interfaz();
		inter.menu();
	}
}
