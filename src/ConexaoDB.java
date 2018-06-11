import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConexaoDB {    
    
    public ResultSet resultado;
    public PreparedStatement comando;
    public Connection con = null;
    public Statement stm = null;
    
    public ConexaoDB () {
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
        con = DriverManager.getConnection("jdbc:firebirdsql://127.0.0.1:3050/c:/"
         + "Users/Fabio/Desktop/Projeto1/IMOVEL.FDB?lc_ctype=WIN1253","SYSDBA","masterkey");
            stm= con.createStatement();

        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,e.getStackTrace(),
                "nÃ£o foi possivel conectar ao banco",JOptionPane.ERROR_MESSAGE);
        }
    }
}
