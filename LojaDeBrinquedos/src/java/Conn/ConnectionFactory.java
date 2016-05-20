package Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static String bancodedados, usuario, senha, host;

    public static Connection getConnection() {
       
        
        //registra o usuário e a senha e a base de dados
        bancodedados = "projetoalmir";
        usuario = "projetoalmir";
        senha = "123456";
        host = "localhost";
        
        try {

            Class.forName("com.mysql.jdbc.Driver");

            //configura os parametros de conexao
            return DriverManager.getConnection("jdbc:mysql://"+host+":3306/" + bancodedados, usuario, senha);

            //Processa e retorna a conexão 
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }
}
