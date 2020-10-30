/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage.ndriamanarina;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import garage.ndriamanarina.Client;
import garage.razafindramasy.Reparation;
import garage.amby.Voiture;

public class InsertReparation extends HttpServlet {

   public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{   
       try{ 
        String id=req.getParameter("id");
        String marque=req.getParameter("marque");
        String num=req.getParameter("numero");
        String type=req.getParameter("type");
        Voiture vo=new Voiture();
        vo.insert_voiture(id,marque, num);
        String idv=vo.get_idVoiture(id);
        Reparation rep=new Reparation();
        rep.insert_reparation(idv,type);
        res.sendRedirect("repa");
        }
       catch(Exception ex){}
   }
}

