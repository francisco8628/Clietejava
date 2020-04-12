package ClasseTestes;

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
	public  void InsereBanco() {     //insere dados no banco
		
		UserPosDao userPosDao = new UserPosDao();
		UserPosJava userPosJava = new UserPosJava();//objeto de modelo
		
		//userPosDao.savar(userPosJava);//passar o objeto com dados estaticos
		
		//userPosJava.setId(5L);  
		userPosJava.setNome("Mel");
		userPosJava.setEmail("mel@gamail.com");
        
		userPosDao.Salvar(userPosJava);//passar o objeto modelo como parametro para  Dao
	}

}
