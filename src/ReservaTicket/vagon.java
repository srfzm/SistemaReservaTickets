package ReservaTicket;

public class vagon {

	public char[][] asientos;
	private int capacidad;
	private int capacidadTotal;
	
	vagon(int columnas){
		
		int tmpCol;
		
		if(columnas<2)
		{
			tmpCol=2;
		}
		else
		{
			tmpCol=columnas;
		}
		
		asientos = new char[4][tmpCol];
		
		for(int i=0; i<asientos.length;i++)
		{
			for(int j=0;j<asientos[i].length;j++)
			{
				asientos[i][j]='V';
			}
		}
		
		capacidad= 4*tmpCol;
		capacidadTotal=4*tmpCol;
	}
	
	public void mostrar()
	{
		System.out.println("Capacidad: "+capacidad+" de "+capacidadTotal+".");
		
		for(int i=0; i<asientos.length;i++)
		{
			for(int j=0;j<asientos[i].length;j++)
			{
				System.out.print(asientos[i][j] + " ");
			}
			
			System.out.println(" ");
		}
	}
	
	public void reservarPrimero()
	{
		
		if(capacidad==0)
		{
			System.out.println("Todos los asientos estan ocupados");
		}
		
		for(int i=0; i<asientos.length;i++)
		{
			for(int j=0;j<asientos[i].length;j++)
			{
				if(asientos[i][j]=='V')
				{
					asientos[i][j]='O';
					capacidad--;
					System.out.println("Asiemto: Fila "+(i+1)+" Columna "+(j+1)+" reservado.");
					return;
				}
			}
		}
	}
	
	public void reservarEspecifico(int fila, int columna)
	{
		if(capacidad==0)
		{
			System.out.println("Todos los asientos estan ocupados");
		}
		
		if(fila<asientos.length && columna < asientos[0].length && fila>=0 && columna>=0)
		{
			if(asientos[fila][columna]=='V')
			{
				asientos[fila][columna]= 'O';
				capacidad--;
				System.out.println("Asiemto: Fila "+(fila+1)+" Columna "+(columna+1)+" reservado.");
			}
			else
			{
				System.out.println("Asiemto: Fila "+(fila+1)+" Columna "+(columna+1)+" ya esta reservado.");
			}
		}
		else
		{
			System.out.println("Fila y/o columna incorrecta.");
		}
	}
}
