package garage.model;
import java.sql.ResultSet;
import java.sql.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import garage.connex.Connexion;
import garage.model.Voiture;

public class Reparation {
    String idR;
    String idV;
    String typedeRepar;
    String daterep;
    String etatrep;

    public String get_idV(){return this.idV;}
    public void set_idV(String id){this.idV=id;}

    public int manisa(ResultSet res) throws Exception{
        int val=0;
        res.beforeFirst();
        while(res.next()==true)
        {
            val++;
        }
        return val;
    }

    public Reparation(String id,String type,String dte) {
        this.idR=id;
        this.typedeRepar=type;
        this.daterep=dte;
    }
    public Voiture makavoiture()throws Exception{
        Connexion con=new Connexion();
        Statement st=con.connect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        String req="SELECT*FROM Voiture where idV='"+this.idV+"'";  
        ResultSet res=st.executeQuery(req);
        res.beforeFirst();
        Voiture voi=new Voiture();
        while(res.next()==true)
        {
            
            voi.set_idV(res.getString("idV"));
            voi.set_idC(res.getString("idC"));
            voi.set_marqueVoiture(res.getString("marqueVoiture"));
            voi.set_numero(res.getString("numero"));
        }

        return voi;
    }
    
    public int getcountrep()throws Exception{
        Connexion con=new Connexion();
        Statement st=con.connect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        String req="SELECT count(idR) as isa FROM Reparation";  
        ResultSet res=st.executeQuery(req);
        int val=0;
        while(res.next()==true){
            val=res.getInt("isa");
        }
        return val;
    }
    
    public int getoccu(int n)throws Exception{
            int nbr=getcountrep();
            int r=nbr;
            int compteur=0;
            while(r>0){
                if(r>3){
                   compteur++;
                }
                r=r-n;
            }
            if(r<0){
                compteur++;
            }
            return compteur;      
    }
    

    public Reparation(){}
    
    public void set_idR(String id){ this.idR= id;}
    public void set_typedeRepar(String type){ this.typedeRepar= type;}
    public void set_daterep(String rep){ this.daterep=rep;}
    public void set_etatrep(String rep){ this.etatrep=rep;}

    public String get_idR(){ return this.idR;}
    public String get_typedeRepar(){ return this.typedeRepar;}
    public String get_daterep(){ return this.daterep;}
    public String get_etatrep(){ return this.etatrep;}

    public Reparation[] get_reparation(int n)throws Exception{
        ArrayList<Reparation> vect=new ArrayList();
        Connexion con=new Connexion();
        Statement st=con.connect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        String req="Select * From Reparation where idR not in (Select idR from Reparation where rownum<="+n+"*3) and rownum<=3"; 
        if(n==0){
           req="SELECT*FROM Reparation where rownum<=3";   
        }
        ResultSet res=st.executeQuery(req);
        int isaina=manisa(res);
        Reparation ilaina[]= new Reparation[isaina];
        res.beforeFirst();
        int compteur=0;
        while(res.next()==true)
        {
            ilaina[compteur]=new Reparation();
            ilaina[compteur].set_idR(res.getString("idR"));
            ilaina[compteur].set_idV(res.getString("idV"));
            ilaina[compteur].set_typedeRepar(res.getString("typedeRepar"));
            ilaina[compteur].set_daterep(res.getString("daterep"));
            ilaina[compteur].set_etatrep(res.getString("etatrep"));
            vect.add(ilaina[compteur]);
            compteur++;
        }

        return ilaina;
    }

    public Reparation[] get_reparation(String rep)throws Exception{
        ArrayList<Reparation> vect=new ArrayList();
        Connexion con=new Connexion();
        Statement st=con.connect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        String req="SELECT*FROM Reparation where typedeRepar LIKE'%"+rep+"%'";  
        ResultSet res=st.executeQuery(req);
        int isaina=manisa(res);
        Reparation ilaina[]= new Reparation[isaina];
        res.beforeFirst();
        int compteur=0;
        while(res.next()==true)
        {
            ilaina[compteur]=new Reparation();
            ilaina[compteur].set_idR(res.getString("idR"));
            ilaina[compteur].set_idV(res.getString("idV"));
            ilaina[compteur].set_typedeRepar(res.getString("typedeRepar"));
            ilaina[compteur].set_daterep(res.getString("daterep"));
            ilaina[compteur].set_etatrep(res.getString("etatrep"));
            vect.add(ilaina[compteur]);
            compteur++;
        }

        return ilaina;
    }

    public Reparation get_reparationbyid(String idr)throws Exception{
        Connexion con=new Connexion();
        Statement st=con.connect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        String req="SELECT*FROM Reparation where idR='"+idr+"'";  
        ResultSet res=st.executeQuery(req);
        res.beforeFirst();
        Reparation ilaina=new Reparation();
        while(res.next()==true)
        {
            ilaina.set_idR(res.getString("idR"));
            ilaina.set_idV(res.getString("idV"));
            ilaina.set_typedeRepar(res.getString("typedeRepar"));
            ilaina.set_daterep(res.getString("daterep"));
            ilaina.set_etatrep(res.getString("etatrep"));
        }
        return ilaina;
    }

    public void insert_reparation(String idv,String type)throws Exception
    {
        Connexion conect=new Connexion();
        Statement st=conect.connect().createStatement();
        SimpleDateFormat dte=null;
        Date auj=new Date(); 
        dte=new SimpleDateFormat("dd/MM/yyyy");
        String datere=dte.format(auj);
        String id="idRepare.nextval";
        String req="INSERT INTO Reparation VALUES ("+id+",'"+idv+"','"+type+"','"+datere+"','0')";     
        System.out.println(req);
        int res=st.executeUpdate(req);
    }

    public void update_reparation(String id)throws Exception
    {
        Connexion conect=new Connexion();
        Statement st=conect.connect().createStatement();
        String req="Update Reparation SET etatrep='1' where idR='"+id+"'";     
        System.out.println(req);
        int res=st.executeUpdate(req);
    }

    public void modifier_reparation(String rep,String id)throws Exception
    {
        Connexion conect=new Connexion();
        Statement st=conect.connect().createStatement();
        String req="Update Reparation SET typedeRepar='"+rep+"' where idR='"+id+"'";     
        System.out.println(req);
        int res=st.executeUpdate(req);
    }

     public void delete_reparation(String id,String idvo)throws Exception
    {
        Connexion conect=new Connexion();
        Statement st=conect.connect().createStatement();
        String req1="DELETE Voiture where idV='"+idvo+"'"; 
        String req="DELETE Reparation where etatrep='0' and idR='"+id+"'";     
        System.out.println(req);
        System.out.println(req);
        int res2=st.executeUpdate(req);
        int res=st.executeUpdate(req1);
        
    }
    
    public static void main (String[] args)throws Exception{
        Reparation vao=new Reparation();
        // Reparation[] res=vao.get_reparation();
        
        // for(int i=0;i<res.length;i++){
        //     System.out.println(res[i].get_marqueV()); 
        // }
//        String n="Audi";
       // String m="Q7";
       // vao.insert_reparation(m);
       
    }
}