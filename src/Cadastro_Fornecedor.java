
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Cadastro_Fornecedor {

	private int id;
	private String nome;
	private String morada;
	private String fone;
	private String e_mail;
	
	public Cadastro_Fornecedor() {
		// TODO Auto-generated constructor stub
	}

	public Cadastro_Fornecedor(int id, String nome, String fone) {
		this.id = id;
		this.nome = nome;
		this.fone = fone;
	}
	
	public void Listar (JTable grid) {
		FornecedorSQL objSQL = new FornecedorSQL();
		objSQL.Listar(grid);
	}
	
        public void carregaOBJ(JTable grd) {
        this.id  = Integer.parseInt(grd.getValueAt(
                                       grd.getSelectedRow(), 
                                       grd.getColumnModel().getColumnIndex("Código") 
                                    ).toString());
        
        this.nome = grd.getValueAt(grd.getSelectedRow(), 
                               grd.getColumnModel().getColumnIndex("Nome")
                               ).toString();
        this.morada = grd.getValueAt(grd.getSelectedRow(), 
                                 grd.getColumnModel().getColumnIndex("Morada")
                                 ).toString();
        this.fone  = grd.getValueAt(
                                       grd.getSelectedRow(), 
                                       grd.getColumnModel().getColumnIndex("Telefone") 
                                    ).toString();
        
        this.e_mail = grd.getValueAt(grd.getSelectedRow(), 
                                 grd.getColumnModel().getColumnIndex("E-mail")
                                 ).toString();      
    }
        
        public void gravar () {
        FornecedorSQL objSQL = new FornecedorSQL();
        objSQL.gravar(this);
    }
    
        public boolean excluir(){
            if (this.id == 0) {
            JOptionPane.showMessageDialog(null,"Código não é válido para exclusão!!!");
            return (false);
        }
        
        if (JOptionPane.showConfirmDialog(null,"Tem certeza que deseja excluir o Fornecedor?", "Exclusão de FORNECEDOR?" , 0) == 0 ) {
          FornecedorSQL objSQL = new FornecedorSQL();
          objSQL.excluir(this);
          return (true);
          
        } else {
          return (false);
            }
        }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMorada() {
		return morada;
	}
	public void setMorada(String morada) {
		this.morada = morada;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	
}
