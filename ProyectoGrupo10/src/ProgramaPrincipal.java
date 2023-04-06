import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ProgramaPrincipal {

	public static void main(String[] args) throws IOException {

		ArrayList<Partido> listaPartidos = new ArrayList<Partido>();

		String archivo = "Archivos\\Resultados.txt";

		for (String linea : Files.readAllLines(Paths.get(archivo))) {
			String lineas[] = linea.split(" ");

			Partido unPartido = new Partido();
			Equipo miEquipo1 = new Equipo();
			Equipo miEquipo2 = new Equipo();

			miEquipo1.setNombre(lineas[0]);
			miEquipo2.setNombre(lineas[3]);
			unPartido.setEquipo1(miEquipo1);
			unPartido.setEquipo2(miEquipo2);

			unPartido.setGolesEquipo1(Integer.parseInt(lineas[1]));
			unPartido.setGolesEquipo2(Integer.parseInt(lineas[2]));
			listaPartidos.add(unPartido);

		}
			for (int i=0; i<listaPartidos.size();i++) {		
				
				System.out.println(
						listaPartidos.get(i).getEquipo1().getNombre() + "  " + listaPartidos.get(i).getGolesEquipo1()
								+ "  " + listaPartidos.get(i).getGolesEquipo2() + "  "
								+ listaPartidos.get(i).getEquipo2().getNombre());
			
			}


		ArrayList<Pronostico> listaPronosticos = new ArrayList<Pronostico>();

		String archivoPronosticos = "Archivos\\pronosticos.txt"; {
			for (String lineaPronosticos : Files.readAllLines(Paths.get(archivoPronosticos))) {
				String lineasP[] = lineaPronosticos.split(" ");

				Pronostico unPronostico = new Pronostico();
				Equipo unEquipo1 = new Equipo();
				Equipo unEquipo2 = new Equipo();

				unEquipo1.setNombre(lineasP[0]);
				unEquipo2.setNombre(lineasP[4]);
				unPronostico.setEquipo1(unEquipo1);
				unPronostico.setEquipo2(unEquipo2);

				unPronostico.setGanaEquipo1(Integer.parseInt(lineasP[1]));
				unPronostico.setEmpate(Integer.parseInt(lineasP[2]));
				unPronostico.setGanaEquipo2(Integer.parseInt(lineasP[3]));
				listaPronosticos.add(unPronostico);
			}
			
		}
	
		int Puntaje = 0;
		
			for (int i=0; i<listaPronosticos.size(); i++) {
				
				System.out.println(
						listaPronosticos.get(i).getEquipo1().getNombre() + "  " 
								+ listaPronosticos.get(i).getGanaEquipo1()
								+ "  " + listaPronosticos.get(i).getEmpate() + "  "
								+ listaPronosticos.get(i).getGanaEquipo2()
								+ "  " + listaPronosticos.get(i).getEquipo2().getNombre());
			
				
			 if (listaPartidos.get(i).getGolesEquipo1() > listaPartidos.get(i).getGolesEquipo2() &&
					 listaPronosticos.get(i).getGanaEquipo1() == 1 )
			 { Puntaje++; 
			 JOptionPane.showMessageDialog(null, Puntaje);}
			  
			 if (listaPartidos.get(i).getGolesEquipo1() == listaPartidos.get(i).getGolesEquipo2() &&
					 listaPronosticos.get(i).getEmpate() == 1 )
						
			 { Puntaje++; 
			 JOptionPane.showMessageDialog(null,Puntaje);}
			 
			 if (listaPartidos.get(i).getGolesEquipo1() < listaPartidos.get(i).getGolesEquipo2() &&
					 listaPronosticos.get(i).getGanaEquipo2() == 1) 
			 { Puntaje++; 
			 JOptionPane.showMessageDialog(null,Puntaje );}
			 
		
				 
			}
			 	JOptionPane.showMessageDialog(null, "acumulaste " + Puntaje + " puntos!");
			
		

	}
}