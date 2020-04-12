package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexaJdbc.SingleConnection;
import model.UserPosJava;

public class UserPosDao {
	
	private Connection connetion;   //variavel tipo Connection do pacote java SQl
	
	public  UserPosDao() {
		
		connetion = SingleConnection.getConnection();
		
	}
	public void Salvar(UserPosJava userPosJava) {//instaciar um objeto de modelo tipo UserposJava
		try {
		String sql = "insert into userposjava(nome,email)values(?,?)";
		PreparedStatement insert= connetion.prepareStatement(sql);   //prepara a conexão
		/*insert.setLong(1, 2);//prepara o "id
		insert.setString(2, "Benjamin");//prepara o nome
		insert.setString(3, "benjamin@gmail.com");//prepara o email
		insert.execute();//envia os dados para o banco*/
		
		//*******************************************************************************************
		//insert.setLong(1, userPosJava.getId() );//prepara o "id
		insert.setString(1, userPosJava.getNome());//prepara o nome
		insert.setString(2,userPosJava.getEmail());//prepara o email
		insert.execute();//envia os dados para o banco
		connetion.commit();//salva no banco
		
		
		}catch (Exception e) {
			e.printStackTrace();
			try {
				connetion.rollback();//se der erro reverte dentro do banco de dados
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
				
			}
		}
	}//fim do metodo salvar
	
	public List<UserPosJava> Mostrar() throws Exception {   // crio a lista, difino o tipo, nomeio a lisa
		
		List<UserPosJava> list = new ArrayList<UserPosJava>();
		
		String sql = "select * from userposjava";
		
		PreparedStatement select= connetion.prepareStatement(sql);  //prepara a conexão
		ResultSet resulatado = select.executeQuery(); //a variavel resulatado vai armazenar os dados pegos pelo select
		
		while (resulatado.next()) {//enquanto tiver dados no resultado faça
			UserPosJava userPosJava = new UserPosJava();  //instacio e cria objetos  Userposja para armazenar os dados até se false
			
			userPosJava.setId(resulatado.getLong("id"));;         //seta o id do objeto com o que vier do resultado
			userPosJava.setNome(resulatado.getString("nome"));    //seta o nome do objeto com o que vier do resultado 
			userPosJava.setEmail(resulatado.getString("email"));  //seta o email do objeto com o que vier do resultado
			
			list.add(userPosJava);                                //Adiciona a lista
			
		}
	
		return list;
	}//end mostrar
	
		public UserPosJava Pesquisar(Long id) throws Exception {   // crio a lista, difino o tipo, nomeio a lisa
		UserPosJava buscar = new UserPosJava();
		
		String sql = "select * from userposjava where id = "+id;
		
		PreparedStatement select= connetion.prepareStatement(sql);  //prepara a conexão
		ResultSet resulatado = select.executeQuery(); //a variavel resulatado vai armazenar os dados pegos pelo select
		
		while (resulatado.next()) {//enquanto tiver dados no resultado faça
			UserPosJava userPosJava = new UserPosJava();  //instacio e cria objetos  Userposja para armazenar os dados até se false
			
			buscar.setId(resulatado.getLong("id"));;         //seta o id do objeto com o que vier do resultado
			buscar.setNome(resulatado.getString("nome"));    //seta o nome do objeto com o que vier do resultado 
			buscar.setEmail(resulatado.getString("email"));  //seta o email do objeto com o que vier do resultado
			
			
			//buscar = userPosJava;
		}
	     
		return buscar;
		
	}//end pesquisar
		
	public void Atualizar(UserPosJava userPosJava) { // crio a lista, difino o tipo, nomeio a lisa

		try {
			String sql = "update userposjava set nome = ? where id = " + userPosJava.getId();
			PreparedStatement update = connetion.prepareStatement(sql); // prepara a conexão
			update.setString(1, userPosJava.getNome());
			
			
			update.execute();
			connetion.commit();

		} catch (Exception e) {
			try {
				e.printStackTrace();
				connetion.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

	}// end Atualizar
	
	
		
	public void Deletar(Long id) { // crio a lista, difino o tipo, nomeio a lisa
		try {
			String sql = "delete from userposjava where id = " + id; // comando para deletar do banco pelo Id
			PreparedStatement delete = connetion.prepareStatement(sql); // prepara a conexão

			delete.execute(); // executa o delete
			connetion.commit();//salva no BAnco

		} catch (Exception e) {
			try {
				e.printStackTrace();
				connetion.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

	}// end do Deletar
	
	/*public void SalvarTelefone(TefoneUser telefoneUser) {//instaciar um objeto de modelo tipo UserposJava
		try {
		String sql = "insert into tefoneuser(nome,tipo,usuariopessoa)values(?,?,?)";
		PreparedStatement insertTelefone= connetion.prepareStatement(sql);   //prepara a conexão
		insertTelefone.setString(1, telefoneUser.getNumero());//prepara o nome
		insertTelefone.setString(2,telefoneUser.getTipo());//prepara o email
		insertTelefone.setLong(3,telefoneUser.getUserPessoa());
		insertTelefone.execute();//envia os dados para o banco
		connetion.commit();//chama a conexão e salva no banco
		
		
		}catch (Exception e) {
			e.printStackTrace();
			try {
				connetion.rollback();//se der erro reverte dentro do banco de dados
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
				
			}
		}
	}//fim do metodo salvar*/
		
}
