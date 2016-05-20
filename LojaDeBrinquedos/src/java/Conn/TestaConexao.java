package Conn;
import Models.BrinquedoMOD;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class TestaConexao {
	 public static void main(String[] args) throws SQLException{
     
             BrinquedoMOD i = new BrinquedoMOD();
             i.codigo = 1;
             Database b = new Database();
              b.delete(i);
        
             
	    }
}
