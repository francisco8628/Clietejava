package ClasseTestes;

import java.util.List;

import org.junit.Test;

import conexaJdbc.SingleConnection;
import dao.UserPosDao;
import model.UserPosJava;


public class testeJdbcnovo {
	
	@Test
	public void InitBanco() {
		
		SingleConnection.getConnection();
	}
	
	@Test
	public  void InsereBanco() {     //insere os dados do cliente no banco
		
		UserPosDao userPosDao = new UserPosDao();
		UserPosJava userPosJava = new UserPosJava();//objeto de modelo
		
		//userPosDao.savar(userPosJava);//passar o objeto com dados estaticos
		
		//userPosJava.setId(5L);  
		userPosJava.setNome("carro");
		userPosJava.setEmail("mel@gamail.com");
        
		userPosDao.Salvar(userPosJava);//passar o objeto modelo como parametro para  Dao
	}//fim do inserir cliente
	
	@Test
	public void InitListarClientes() {//metodo de teste listar do banco (mostra todo o conteudo do banco)

		UserPosDao dao = new UserPosDao();

		try {
			List<UserPosJava> list = dao.Mostrar();
			
			for (UserPosJava userPosJava : list) {
				System.out.println(userPosJava.getId());
				System.out.println(userPosJava.getNome());
				System.out.println(userPosJava.getEmail());
				System.out.println("--------------------------------");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	} //fim listar
	
	@Test
	public void PesquisaCliente() {// metodo buscar cliente pelo ID

		UserPosDao dao = new UserPosDao();   //instacia Dao

		try {
			
			UserPosJava busca = dao.Pesquisar(17L);
			
			System.out.println(busca.getId());
			System.out.println(busca.getNome());
			System.out.println(busca.getEmail());
			System.out.println("--------------------------------");
			
				
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		
		
		
	} // fim Buscar
	
	@Test
	public void AtualizarClinteNome() {// metodo de teste listar do banco (mostra todo o conteudo do banco)
		try {

			UserPosDao dao = new UserPosDao();

			UserPosJava objetoBanco = dao.Pesquisar(17L);

			objetoBanco.setNome("Benja");
			objetoBanco.setEmail("cigano@gmail.com");

			dao.Atualizar(objetoBanco);

		} catch (Exception e) {
			e.printStackTrace();
		}

	} // fim atualizar
	
	@Test
	public void Deletar() {// metodo de teste listar do banco (mostra todo o conteudo do banco)
        try {
			UserPosDao dao = new UserPosDao();
			dao.Deletar(23L);
				
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	
	
	}
}
