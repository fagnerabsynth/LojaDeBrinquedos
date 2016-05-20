package Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionFactory {
	public static Connection getConnection() {             
        try {             
        	
            Class.forName("com.mysql.jdbc.Driver");
            
            //configura os parametros de conexao
            return DriverManager.getConnection ("jdbc:mysql://localhost:3306/projetoalmir", "projetoalmir", "123456");
            
           //Processa e retorna a conexão 
        } catch(ClassNotFoundException  | SQLException e) {             
            return null;
        }             
    }
}
