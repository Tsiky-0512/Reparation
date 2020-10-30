package garage.connex;
import java.sql.*;
public class Connexion
{
	Statement state;
	public Connection connect()throws Exception
	{
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="garage";	
		String mdp="12345678";
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con=DriverManager.getConnection(url,user,mdp);
		if(con!=null){
			System.out.println("Connexion reussi");
		}else{
			System.out.println("Connexion echoue");	
		}
		return con;
	}
	
}