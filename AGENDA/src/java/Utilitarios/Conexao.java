
package Utilitarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection getConnection(){
	
	Connection con = null;
	  
	   try {
		  Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection("jdbc:mysql://localhost/agenda", "root", "");
		  System.out.println("Conectado");
		
	} catch (SQLException e) {
		System.out.println("Não conectado" + e.getMessage());
		
	} catch (ClassNotFoundException e) {
		System.out.println("Driver nao encontrado");
		e.printStackTrace();
	}
	   return con;
}

}