package garage.razafindramasy;
import java.sql.ResultSet;
import java.sql.*;
import java.util.*;
import garage.connex.Connexion;
import garage.razafindramasy.Reparation;
import garage.ndriamanarina.Client;

public class Facture{

	String idF;
	float prixpaye;
	String etatfact;
        String idR;
        String idC;

    public int manisa(ResultSet res) throws Exception{
        int val=0;
        res.beforeFirst();
        while(res.next()==true)
        {
            val++;
        }
        return val;
    }

    public void set_idR(String id){ this.idR= id;}
	public void set_idF(String id){this.idF=id;}
	public void set_prixpaye(float prix){this.prixpaye=prix;}
	public void set_etatfact(String etat){this.etatfact=etat;}
    public void set_idC(String id){this.idC=id;}

    public String get_idC(){return this.idC;}
	public String get_idF(){return this.idF;}
	public float get_prixpaye(){return this.prixpaye;}
	public String get_etatfact(){return this.etatfact;}
    public String get_idR(){ return this.idR;}

    public void insert_facture(String idr,String idc,float type)throws Exception
    {
        Connexion conect=new Connexion();
        String req="INSERT INTO Facture VALUES ('?','?','?','?')"; 
        PreparedStatement st=conect.connect().prepareStatement(req);
        String id="idFact.nextval";
        
        st.setString(1,id);
        st.setString(2,idr);
        st.setString(3,idc);
        st.setFloat(4,type);
        System.out.println(req);
        st.executeUpdate(req);
    }


	public Facture[] get_FactureRestant()throws Exception{
            ArrayList<Facture> vect=new ArrayList();
            Connexion con=new Connexion();
             String req="SELECT*FROM Facture where etatfact='?'";
            PreparedStatement st=con.connect().prepareStatement(req);
             st.setString(1,"0");
            ResultSet res=st.executeQuery(req);
            int isaina=manisa(res);
            Facture ilaina[]= new Facture[isaina];
            res.beforeFirst();
            int compteur=0;
            while(res.next()==true)
            {
                ilaina[compteur]=new Facture();
                ilaina[compteur].set_idF(res.getString("idF"));
                ilaina[compteur].set_idR(res.getString("idR"));
                ilaina[compteur].set_idC(res.getString("idC"));
                ilaina[compteur].set_prixpaye(res.getFloat("prixpaye"));
                ilaina[compteur].set_etatfact(res.getString("etatfact"));          
                vect.add(ilaina[compteur]);
                compteur++;
            }

            return ilaina;
	}

	public Facture[] get_FacturePayer()throws Exception{
            ArrayList<Facture> vect=new ArrayList();
            Connexion con=new Connexion();
              String req="SELECT*FROM Facture where etatfact='?'";
            PreparedStatement st=con.connect().prepareStatement(req);
             st.setString(1,"0");
            ResultSet res=st.executeQuery(req);
            int isaina=manisa(res);
            Facture ilaina[]= new Facture[isaina];
            res.beforeFirst();
            int compteur=0;
            while(res.next()==true)
            {
                ilaina[compteur]=new Facture();
                ilaina[compteur].set_idF(res.getString("idF"));
                ilaina[compteur].set_idR(res.getString("idR"));
                ilaina[compteur].set_idC(res.getString("idC"));
                 ilaina[compteur].set_prixpaye(res.getFloat("prixpaye"));
                ilaina[compteur].set_etatfact(res.getString("etatfact"));
                vect.add(ilaina[compteur]);
                compteur++;
            }

            return ilaina;
	}

    public Facture get_factureid(String idr)throws Exception{
        Connexion con=new Connexion();
           String req="SELECT*FROM Facture where idR='?'";
            PreparedStatement st=con.connect().prepareStatement(req);
             st.setString(1,idR); 
        ResultSet res=st.executeQuery(req);
        res.beforeFirst();
        Facture ilaina=new Facture();
        while(res.next()==true)
        {
            ilaina.set_idF(res.getString("idF"));
            ilaina.set_idR(res.getString("idR"));
            ilaina.set_idC(res.getString("idC"));
            ilaina.set_prixpaye(res.getFloat("prixpaye"));
            ilaina.set_etatfact(res.getString("etatfact"));
        }
        return ilaina;
    }

	public float get_Gain()throws Exception{
            float val=0;
            Connexion con=new Connexion();
                String req="SELECT SUM(prixpaye) as prixpaye FROM Facture where etatfact='?'";  
            PreparedStatement st=con.connect().prepareStatement(req);
             st.setString(1,"1");
         
            ResultSet res=st.executeQuery(req);
            while(res.next()==true){
                val=res.getFloat("prixpaye");
            }
            return val;
	}

}