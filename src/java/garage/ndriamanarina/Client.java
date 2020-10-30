package garage.ndriamanarina;
import java.sql.ResultSet;
import java.sql.*;
import java.util.*;
import garage.connex.Connexion;

public class Client{

	String idC;
	String nomClient;
	String tel;

	public int manisa(ResultSet res) throws Exception{
        int val=0;
        res.beforeFirst();
        while(res.next()==true)
        {
            val++;
        }

        return val;
    }

	public String get_idC(){return this.idC;}
	public String get_nomClient(){return this.nomClient;}
	public String get_tel(){return this.tel;}

	public void set_idC(String id){this.idC=id;}
	public void set_nomClient(String nom){this.nomClient=nom;}
	public void set_tel(String te){this.tel=te;}	

	public Client (String id,String nom, String te){
		this.idC=id;
		this.nomClient=nom;
		this.tel=te;
	}
         
	public Client(){}

	public Client[] get_Client()throws Exception{
	   ArrayList<Client> vect=new ArrayList();
            Connexion con=new Connexion();
            Statement st=con.connect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String req="SELECT*FROM Client";  
            ResultSet res=st.executeQuery(req);
            int isaina=manisa(res);
            Client ilaina[]= new Client[isaina];
            res.beforeFirst();
            int compteur=0;
            while(res.next()==true)
            {
                ilaina[compteur]=new Client();
                ilaina[compteur].set_idC(res.getString("idC"));
                ilaina[compteur].set_nomClient(res.getString("nomClient"));
                ilaina[compteur].set_tel(res.getString("tel"));
                vect.add(ilaina[compteur]);
                compteur++;
            }
            return ilaina;
	}
        
        public Client[] get_Clientid(String id)throws Exception{
	   ArrayList<Client> vect=new ArrayList();
            Connexion con=new Connexion();
             String req="SELECT*FROM Client where idC='?'";  
            PreparedStatement st=con.connect().prepareStatement(req);
            st.setString(1, id);
            ResultSet res=st.executeQuery(req);
            int isaina=manisa(res);
            Client ilaina[]= new Client[isaina];
            res.beforeFirst();
            int compteur=0;
            while(res.next()==true)
            {
                ilaina[compteur]=new Client();
                ilaina[compteur].set_idC(res.getString("idC"));
                ilaina[compteur].set_nomClient(res.getString("nomClient"));
                ilaina[compteur].set_tel(res.getString("tel"));
                vect.add(ilaina[compteur]);
                compteur++;
            }
            
            return ilaina;
	}

}