package garage.amby;
import java.sql.ResultSet;
import java.sql.*;
import java.util.*;
import garage.connex.Connexion;
import garage.ndriamanarina.Client;

public class Voiture{

	String idV;
	String marqueVoiture;
	String numero;
	String idC;

	public String get_idV(){return this.idV;}
	public String get_marqueVoiture(){return this.marqueVoiture;}
	public String get_numero(){return this.numero;}
	public String get_idC(){return this.idC;}
	
	public void set_idC(String id){this.idC=id;}
	public void set_idV(String id){this.idV=id;}
	public void set_marqueVoiture(String m){this.marqueVoiture=m;}
	public void set_numero(String num){this.numero=num;}

	public Voiture (String id,String marque, String num){
		this.idV=id;
		this.marqueVoiture=marque;
		this.numero=num;
	}

	public Voiture(){}

	public Client makaclient()throws Exception{
		Connexion con=new Connexion();
                String req="SELECT*FROM Client where idC='?'";  
        PreparedStatement st=con.connect().prepareStatement(req);       
        ResultSet res=st.executeQuery(req);
        st.setString(1,this.idC);
        res.beforeFirst();
        Client cli=new Client();
        while(res.next()==true)
        {
            
           cli.set_idC(res.getString("idC"));
           cli.set_nomClient(res.getString("nomClient"));
           cli.set_tel(res.getString("tel"));
        }

        return cli;

	}

	public void insert_voiture(String ids,String marque,String nums)throws Exception
    {
        Connexion conect=new Connexion();
           String req="INSERT INTO Voiture VALUES ('?','?','?','?')";
        PreparedStatement st=conect.connect().prepareStatement(req);
        String id="idVoi.nextval";
        st.setString(1,id);
        st.setString(2,ids);
        st.setString(3,marque);
        st.setString(4,nums);
        System.out.println(req);
      st.executeUpdate(req);
    }

    public String get_idVoiture(String idc)throws Exception{
            String val="";
             String req="SELECT idV FROM Voiture where idC='?'";  
            Connexion con=new Connexion();
            PreparedStatement st=con.connect().prepareStatement(req);
           
            ResultSet res=st.executeQuery(req);
            st.setString(1,idC);
            while(res.next()==true){
                val=res.getString("idV");
            }
            return val;
	}


}