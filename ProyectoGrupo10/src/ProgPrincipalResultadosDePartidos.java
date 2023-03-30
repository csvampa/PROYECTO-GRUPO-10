import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ProgPrincipalResultadosDePartidos {

    public static void main(String[] args) throws IOException {

        ArrayList<Partido> listaPartidos = new ArrayList<Partido>();

        Partido unPartido;

        Equipo unEquipo1;
        Equipo unEquipo2;

        String archivo = "archivos\\Resultados.txt";
        for (String linea : Files.readAllLines(Paths.get(archivo))) {
            String lineas[] = linea.split("\t");

            unPartido = new Partido();
            unEquipo1 = new Equipo();
            unEquipo2 = new Equipo();

            unEquipo1.setNombre(lineas[0]);
            unEquipo2.setNombre(lineas[3]);

            unPartido.setEquipo1(unEquipo1);
            unPartido.setEquipo2(unEquipo2);
            unPartido.setGolesEquipo1(Integer.parseInt(lineas[1]));
            unPartido.setGolesEquipo2(Integer.parseInt(lineas[2]));
            listaPartidos.add(unPartido);
        }
        for (int i = 0; i < listaPartidos.size(); i++) {
            JOptionPane.showMessageDialog(null, listaPartidos.get(i).getEquipo1().getNombre() + "  "
                    + listaPartidos.get(i).getGolesEquipo1() + " " + listaPartidos.get(i).getGolesEquipo2() + " "
                    + listaPartidos.get(i).getEquipo2().getNombre());
           
            }
        }
    }

