
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FornecedorSQL extends ConexaoDB{
    
   public void gravar(Cadastro_Fornecedor obj) {
           try {
            PreparedStatement comando;
             
            if (obj.getId()== 0) {
                comando = con.prepareStatement(
                        
                       "INSERT INTO FORNECEDORES  (nome,            " +
                       "                           telefone,        " +
                       "                           morada,          " +
                       "                           email)           " +
                       "       VALUES (?,?,?,?)                   "
                    );
            } else {
                comando = con.prepareStatement(
                        " UPDATE FORNECEDORES SET             " +
                        "        nome                   = ?,  " +
                        "        telefone               = ?,  " +
                        "        morada                 = ?,  " +
                        "        email                  = ?   " +
                        "       WHERE CODIGO_FORNECEDOR = ?  "
                );
                comando.setInt(5, obj.getId());
                
            }
            comando.setString(1, obj.getNome());
            comando.setString(2, obj.getFone());
            comando.setString(3, obj.getMorada());
            comando.setString(4, obj.getE_mail());
            comando.execute();
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Erro:" + e);
        }
        
     }
   
 
    
    public void Listar(JTable grid) {
       DefaultTableModel jTabela = (DefaultTableModel)grid.getModel();

       String sql = "";
       try {
            while (jTabela.getRowCount() > 0) {
             jTabela.removeRow(0);
            }
            sql = sql
                    + "SELECT  *                                       "
                    + "  FROM FORNECEDORES order by codigo_fornecedor  ";
            
            this.resultado = this.stm.executeQuery(sql);
            while (resultado.next()) {

                jTabela.addRow(new Object[]{resultado.getObject("CODIGO_FORNECEDOR").toString(),
                                            resultado.getObject("NOME").toString(),
                                            resultado.getObject("MORADA").toString(),
                                            resultado.getObject("TELEFONE").toString(),
                                            resultado.getObject("EMAIL").toString()
                                           }                   
                              );
            }
          stm.close();              
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e);
        }
    }
    
    public void excluir(Cadastro_Fornecedor obj){
        try {
            PreparedStatement comando;
             
            comando = con.prepareStatement(
                       "DELETE FROM FORNECEDORES WHERE CODIGO_FORNECEDOR = ? ");
            
            comando.setInt(1, obj.getId());

            comando.execute();
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Erro:" + e);
        }    
        
    }

}
