package conexaJdbc;
import java.sql.Connection;
import java.sql.DriverManager;


public class SingleConnection{//padraõ singletn - 
	
	   private static String url ="jdbc:postgresql://localhost:5432/posjava";//url para conexao padrao do POSTGRES
	   private static String password = "admin";
	   private static String user= "postgres";
	   private static Connection conection = null;   //tem que ser do pacote SQL java
	   
	   static {
		   
		   conectar();
	   }
	   
	   
	    public  SingleConnection() {
	    	
	    	conectar();
	    }
	    
		private static void conectar() {
			try {
				if (conection==null) {
					Class.forName("org.postgresql.Driver");
					conection = DriverManager.getConnection(url, user, password);
					conection.setAutoCommit(false);//setar falso para nao salvar automatico
					System.out.println("Conexão OK");//para teste da conexão
				} else {

				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		public static Connection getConnection() {  //metodo que retorna a conexão
			
			return conection;
		}

	}
