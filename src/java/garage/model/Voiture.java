package garage.model;
import java.sql.ResultSet;
import java.sql.*;
import java.util.*;
import garage.connex.Connexion;
import garage.model.Client;

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
        Statement st=con.connect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        String req="SELECT*FROM Client where idC='"+this.idC+"'";  
        ResultSet res=st.executeQuery(req);
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
        Statement st=conect.connect().createStatement();
        String id="idVoi.nextval";
        String req="INSERT INTO Voiture VALUES ("+id+",'"+ids+"','"+marque+"','"+nums+"')";
        System.out.println(req);
        int res=st.executeUpdate(req);
    }

    public String get_idVoiture(String idc)throws Exception{
            String val="";
            Connexion con=new Connexion();
            Statement st=con.connect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String req="SELECT idV FROM Voiture where idC='"+idc+"'";  
            ResultSet res=st.executeQuery(req);
            while(res.next()==true){
                val=res.getString("idV");
            }
            return val;
	}


}