package Proyecto_MySQL.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *
 * @author Your name
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
    	Connection conectar = null;
    	String sURL = "jdbc:mysql://localhost:3306/trabajo_integrador";
    	
   //importamos el conector que descargamos en mysql. descargamos el odd
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	
   //se conecta al servidor de mysql
    	try {
    		conectar = DriverManager.getConnection(sURL,"root","esteroplito");
    	JOptionPane.showMessageDialog(null,"Conexión Existosa");
    	} catch (SQLException ex) {
    		
    	JOptionPane.showMessageDialog(null,"Conexión Fallida");	
    	}
    
    	Statement s=null;
    //nos conectamos a una instancia
    	try {
    		s = conectar.createStatement();
    	} 	catch (SQLException ex) {
    		JOptionPane.showMessageDialog(null,"Conexión Fallida");	
    	}
    	
    	
    	ResultSet rs=null;
    //hacemos consulta para recuperar valores de la tabla y lo guardamos en la variable rs
    	try {
    		rs = s.executeQuery("SELECT * FROM trabajo_integrador.resultados as resultados inner join trabajo_integrador.equipo as equipo2 on resultados.cod_equipo1=equipo2.cod_equipo inner join trabajo_integrador.equipo as equipo3 on (resultados.cod_equipo2=equipo3.cod_equipo);");
  
    	} catch (SQLException ex) {
    		JOptionPane.showMessageDialog(null,"Consulta Fallida");
    	}
    	
    	Partido rr = null; 
    	
    	ArrayList<Partido> arrayPartidos = new ArrayList<Partido>();
    	
    	Equipo equipo1;
    	Equipo equipo2;
    	
    	try {
    		while (rs.next())
    		{ rr=new Partido ();
    		equipo1=new Equipo();
    		equipo2=new Equipo();
    	
    		equipo1.setNombre(rs.getString(7));
    		equipo2.setNombre(rs.getString(10));
    		
    		rr.setEquipo1(equipo1);
    		rr.setEquipo2(equipo2);
    		
    		rr.setGolesEquipo1(rs.getInt(3));
    		rr.setGolesEquipo2(rs.getInt(4));
    		arrayPartidos.add(rr);
    		
    	  	System.out.println(rs.getString(7)+"  "+rs.getInt(3)+"  "+rs.getInt(4)+"  "+rs.getString(10));
    		}
    	} catch (SQLException ex) {}
 //
    	Pronostico r = null; 
    	
    	try {
    		rs = s.executeQuery("SELECT * FROM trabajo_integrador.pronosticos as pronosticos inner join trabajo_integrador.equipo as equipo2 on pronosticos.cod_equipo1=equipo2.cod_equipo inner join trabajo_integrador.equipo as equipo3 on (pronosticos.cod_equipo2=equipo3.cod_equipo);");
  
    	} catch (SQLException ex) {
    		JOptionPane.showMessageDialog(null,"Consulta Fallida");
    	}
    	
    	
    	ArrayList<Pronostico> arrayPronosticos = new ArrayList<Pronostico>();
    	
    	
    	try {
    		while (rs.next())
    		{ r=new Pronostico();
    		equipo1=new Equipo();
    		equipo2=new Equipo();
    	
    		equipo1.setNombre(rs.getString(8));
    		equipo2.setNombre(rs.getString(11));
    		
    		r.setEquipo1(equipo1);
    		r.setEquipo2(equipo2);
    		
    		r.setGanaEquipo1(rs.getInt(3));
    		r.setEmpate(rs.getInt(4));
    		r.setGanaEquipo2(rs.getInt(5));
    		arrayPronosticos.add(r);
    		
    	  	System.out.println(rs.getString(8)+"  "+rs.getInt(3)+"  "+rs.getInt(4)+"  "+rs.getInt(5)+"  "+rs.getString(11));
    		}
    	} catch (SQLException ex) {}
    	
    	int Puntaje = 0;
		
		for (int i=0; i<arrayPronosticos.size(); i++) {
			
			System.out.println(
					arrayPronosticos.get(i).getEquipo1().getNombre() + "  " 
							+ arrayPronosticos.get(i).getGanaEquipo1()
							+ "  " + arrayPronosticos.get(i).getEmpate() + "  "
							+ arrayPronosticos.get(i).getGanaEquipo2()
							+ "  " + arrayPronosticos.get(i).getEquipo2().getNombre());
		
			
		 if (arrayPartidos.get(i).getGolesEquipo1() > arrayPartidos.get(i).getGolesEquipo2() &&
				 arrayPronosticos.get(i).getGanaEquipo1() == 1 )
		 { Puntaje++; 
		 JOptionPane.showMessageDialog(null, Puntaje);}
		  
		 if (arrayPartidos.get(i).getGolesEquipo1() == arrayPartidos.get(i).getGolesEquipo2() &&
				 arrayPronosticos.get(i).getEmpate() == 1 )
					
		 { Puntaje++; 
		 JOptionPane.showMessageDialog(null,Puntaje);}
		 
		 if (arrayPartidos.get(i).getGolesEquipo1() < arrayPartidos.get(i).getGolesEquipo2() &&
				 arrayPronosticos.get(i).getGanaEquipo2() == 1) 
		 { Puntaje++; 
		 JOptionPane.showMessageDialog(null,Puntaje );}
		 
			 
		}
		 	JOptionPane.showMessageDialog(null, "acumulaste " + Puntaje + " puntos!");
    	
    	
  

    }
}