import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ProgPrincipalPronosticos {

	public static void main(String[] args) throws IOException{
		
		
		String archivoPronosticos = "archivos\\pronosticos.txt";
		ArrayList<Pronostico> listaPronosticos = new ArrayList<Pronostico>();
		for (String linea : Files.readAllLines(Paths.get(archivoPronosticos))) {
		    String[] lineas = linea.split("\t");

		    Pronostico unPronostico = new Pronostico();
		    Equipo unEquipo1 = new Equipo();
		    Equipo unEquipo2 = new Equipo();

		    unEquipo1.setNombre(lineas[0]);
		    unPronostico.setEquipo1(unEquipo1);
		    unEquipo2.setNombre(lineas[4]);
		    unPronostico.setEquipo2(unEquipo2);

		    if (lineas[1].equals("X")) {
		        unPronostico.setResultado("X");
		    } else if (lineas[2].equals("X")) {
		        unPronostico.setResultado("X");
		    } else {
		        unPronostico.setResultado(lineas[3]);
		    }

		    listaPronosticos.add(unPronostico);
		}

		
	
	}
	}



