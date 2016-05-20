package Conn;
import Models.BrinquedoMOD;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class TestaConexao {
	 public static void main(String[] args) throws SQLException{
     
             Database b = new Database();
             ArrayList<BrinquedoMOD> c = b.select();
             ArrayList<BrinquedoMOD> i = c ;
             
	    }
}
