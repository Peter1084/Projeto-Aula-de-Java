package peter.j.cadastrousuario.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Peterson
 */
public class Conexao {
    
    private static Connection conn;

    private Conexao() throws SQLException {
     if (Conexao.conn==null) {
         Conexao.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cad_usuario?zeroDateTimeBehavior=convertToNull","root", "");
     }  
    }
    
    public static Connection getInstance() throws SQLException {
        new Conexao();
        return Conexao.conn;
    }
    
    
}
