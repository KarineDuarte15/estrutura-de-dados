package Basededados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class bancoconexao {
	private Connection connection= null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	
	public void conectar() {
		 String servidor = "jdbc:mysql://localhost:3306/cadastro?useSSL=false";
		 String usuario = "BancodeDados";
		 String senha = "Banco123";
		 String driver = "com.mysql.cj.jdbc.Driver";
		 try {
			 Class.forName(driver);
			 this.connection = DriverManager.getConnection(servidor,usuario,senha);
			 this.statement = this.connection.createStatement();
    } catch(Exception e){
		 System.out.println("erro:"+ e.getMessage());}
		 
		 
 }
	public boolean estaConectado() {
		if(this.connection != null) {
			   return true;
		}else {
		    	return false;
		    }
}public void listarContatos() {
	try {
	String query = "select * from cadastro_completo order by nome";
	this.resultSet = this.statement.executeQuery(query);
	while(this.resultSet.next()) {
    System.out.println("ID: "+this.resultSet.getString("id")+
    		"Nome: "+ this.resultSet.getString("nome")+
    		"cpf:"+ this.resultSet.getString("cpf")+
    		"nascimento: "+ this.resultSet.getString("nascimento")+
    		"email: "+ this.resultSet.getString("email")+
    		"telefone: "+ this.resultSet.getString("telefone"));
    
	}
	}
catch(Exception e) {
	System.out.println("Erro:" + e.getMessage());
}
	}

public void inserircontato(String nome,String cpf,String nascimento,String email,String telefone) {
	 try { 
		 String query = "insert into cadastro_completo(nome,cpf,rg,nascimento,email,telefone) values "+
	 "('"+nome+"','"+cpf+"','"+nascimento+"','"+email+"', '"+telefone+"')";
		 System.out.println("contato inserido com sucesso!");
				 this.statement.executeUpdate(query);
	 }catch(Exception e) {
		System.out.println("Erro:" + e.getMessage()); 
		}
	 }
public void apagarcontato(String id) {
	 try { 
		 String query = "Delete  from cadastro_completo where id = "+id+"; ";
				 this.statement.executeUpdate(query);
				 System.out.println("Contato editado!");
	 }catch(Exception e) {
		System.out.println("Erro:" + e.getMessage()); 
	 }
}


public void desconectar() {
	try {
		this.connection.close();
	}catch(Exception e) {
		System.out.println("Erro"+ e.getMessage());
	}
	}


}

