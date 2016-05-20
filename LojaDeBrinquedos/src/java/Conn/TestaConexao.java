package Conn;
import Models.BrinquedoMOD;
import java.sql.SQLException;
import java.util.ArrayList;


public class TestaConexao {
	 public static void main(String[] args) throws SQLException{
     
             BrinquedoMOD c = new BrinquedoMOD();
             c.categoria="teste";
             c.descricao="teste2";
             c.detalhe="teste3";
             c.imagem="teste4";
             c.marca="teste5";
             c.preco=15.50;
             
             Database b = new Database();
             
             b.insert(c);
             ArrayList<BrinquedoMOD> d = b.select();
             ArrayList<BrinquedoMOD> i = d ;
             
	    }
}
