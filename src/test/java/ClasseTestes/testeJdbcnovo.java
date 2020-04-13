package ClasseTestes;

import java.util.List;

import org.junit.Test;

import conexaJdbc.SingleConnection;
import dao.UserPosDao;
import model.BeanUserFone;
import model.TefoneUser;
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
		userPosJava.setNome("mãe ");
		userPosJava.setEmail("maria@gamail.com");
        
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
	public void DeletarCLiente() {// metodo de teste listar do banco (mostra todo o conteudo do banco)
        try {
			UserPosDao dao = new UserPosDao();
			dao.Deletar(23L);  //recebe o id do cliente para deletar
				
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	
	
	} //fim deletar cliente
	
	
	@Test
	public void CadastrarTelefone() {
		
		
			TefoneUser telefone = new TefoneUser();
			UserPosDao dao = new UserPosDao();
			
		    telefone.setNumero("(19) 3481 7014");
		    telefone.setTipo("casa");
		    telefone.setUserPessoa(21L);
		    
		    dao.SalvarTelefone(telefone);
			
		
		}//fim do metodo Salvar telefone
	
	
	@Test	
	public void testeCarregarFoneUser() {

		UserPosDao dao = new UserPosDao();

		try {
			List<BeanUserFone> list = dao.listUserfone(16L);
			for (BeanUserFone beanUserFone : list) {
				 
		        //System.out.println(beanUserFone);
				System.out.println(beanUserFone.getNome());
				System.out.println(beanUserFone.getNumero());
				System.out.println(beanUserFone.getEmail());
				System.out.println("--------------------------------");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	} //fim listar
		 
	}
	 
		


   
		

