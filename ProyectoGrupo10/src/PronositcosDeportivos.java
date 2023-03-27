import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PronositcosDeportivos {

	public static void main(String[] args) throws IOException{
		
		
		//ArrayList<Pronostico> listaPronosticos=new ArrayList<Pronostico>();
		
		ArrayList<Equipo> listaEquipos=new ArrayList<Equipo>();
		
		Partido unPartido=new Partido();
		
		Equipo miEquipo1=new Equipo();
		
		unPartido.equipo1 = miEquipo1;
		
		miEquipo1.setNombre("Argentina");
		miEquipo1.setDescripcion("el mejor");	
		listaEquipos.add(miEquipo1);
		
		Equipo miEquipo2=new Equipo ();
		
		unPartido.equipo2 = miEquipo2;
		
		miEquipo2.setNombre("Francia");
		miEquipo2.setDescripcion("segundo");
		listaEquipos.add(miEquipo2);
		
		
			JOptionPane.showMessageDialog(null, unPartido.equipo1.getNombre());
		
		ArrayList<Partido> listaPartidos=new ArrayList<Partido>();
		String archivo = "Archivos\\Resultados.txt";
		for (String linea : Files.readAllLines(Paths.get(archivo))) {
			String lineas[] = linea.split(" ");
			
			unPartido=new Partido();
			miEquipo1=new Equipo();
			miEquipo2=new Equipo();
			
				miEquipo1.setNombre(lineas[0]);
				miEquipo2.setNombre(lineas[3]);
			unPartido.equipo1=miEquipo1;
			unPartido.equipo2=miEquipo2;
			unPartido.setGolesEquipo1(Integer.parseInt(lineas[1]));
			unPartido.setGolesEquipo2(Integer.parseInt(lineas[2]));
			listaPartidos.add(unPartido);
			
			
		for (int i=0; i<listaPartidos.size(); i++) {	
			
			JOptionPane.showMessageDialog(null,listaPartidos.get(i).equipo1.getNombre()+"  "+listaPartidos.get(i).unPartido.getGolesEquipo1()+"  "+listaPartidos.get(i).golesEquipo2)+"  "listaPartidos.get(i).equipo2.getNombre();
		}
		
	
	}
	}
}


