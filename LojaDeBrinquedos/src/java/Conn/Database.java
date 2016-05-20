package Conn;

import Models.BrinquedoMOD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fagner
 */
public class Database extends ConnectionFactory {

    private Connection mysql;
    private Statement conexao;

//protege contra injeção de sql
    private String mysql_real_escape_string(String str) {

        String dados = null;
        if (str != null && str.length() > 0) {
            str = str.replace("\\", "\\\\");
            str = str.replace("'", "\\'");
            str = str.replace("\0", "\\0");
            str = str.replace("\n", "\\n");
            str = str.replace("\r", "\\r");
            str = str.replace("\"", "\\\"");
            str = str.replace("\\x1a", "\\Z");
            dados = str;
        }
        return dados;
    }

    public Database() {
        mysql = getConnection();

        try {
            conexao = mysql.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //fecha a conexao
    public void fechaConexao() {
        try {
            mysql.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //pega todos os brinquedos inseridos no banco
    public ArrayList<BrinquedoMOD> select() {

        ArrayList<BrinquedoMOD> b = new ArrayList<>();

        String query = "select * from brinquedos order by codigo desc";

        ResultSet resultado;
        try {
            resultado = conexao.executeQuery(query);
            while (resultado.next()) {
                b.add((BrinquedoMOD) resultado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return b;
    }

    ///Faz a pesquisa pelo string digitado... para a lista de pesquisa... pesquisando em 3 campos descricao,categoria ou preco
    public ArrayList<BrinquedoMOD> select(String tudo) {

        ArrayList<BrinquedoMOD> b = new ArrayList<>();

        tudo = mysql_real_escape_string(tudo);

        String query = "select * from brinquedos where descricao = '%" + tudo + "%' or categoria = '%" + tudo + "%' or preco = '%" + tudo + "%' order by codigo desc";

        ResultSet resultado;
        try {
            resultado = conexao.executeQuery(query);
            while (resultado.next()) {
                b.add((BrinquedoMOD) resultado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return b;
    }

    ///Faz a pesquisa pelo código id...um numero inteiro... para edição do arquivo
    public BrinquedoMOD select(int i) {

        BrinquedoMOD b = new BrinquedoMOD();

        String query = "select * from brinquedos where codigo = '" + i + "'";

        ResultSet resultado;
        try {
            resultado = conexao.executeQuery(query);
            while (resultado.next()) {
                b = ((BrinquedoMOD) resultado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return b;
    }

    //para atualizar basta passar a classe brinquedo atualizada...
    public boolean update(BrinquedoMOD b) {
        String query = "update brinquedos set "
                + "categoria = '" + mysql_real_escape_string(b.categoria) + "',"
                + "descricao = '" + mysql_real_escape_string(b.descricao) + "',"
                + "detalhe = '" + mysql_real_escape_string(b.detalhe) + "',"
                + "marca = '" + mysql_real_escape_string(b.marca) + "',"
                + "preco = '" + b.preco + "',"
                + "  where codigo =codigo '" + b.codigo + "'";

        boolean retorno = false;
        try {
            conexao.executeQuery(query);
            retorno = true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    //para inserir basta passar a classe brinquedo...
    public boolean insert(BrinquedoMOD b) {
        String query = "insert into brinquedos (categoria,descricao,detalhe,marca,preco) values ("
                + "'" + mysql_real_escape_string(b.categoria) + "',"
                + "'" + mysql_real_escape_string(b.descricao) + "',"
                + "'" + mysql_real_escape_string(b.detalhe) + "',"
                + "'" + mysql_real_escape_string(b.marca) + "',"
                + "'" + b.preco + "')";

        boolean retorno = false;
        try {
            conexao.executeQuery(query);
            retorno = true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    //para deletar basta passar a classe brinquedo...
    public boolean delete(BrinquedoMOD b) {
        String query = "delete from brinquedos"
                + "  where codigo =codigo '" + b.codigo + "'";
        boolean retorno = false;
        try {
            conexao.executeQuery(query);
            retorno = true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

}
