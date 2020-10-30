/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage.razafindramasy;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import garage.razafindramasy.Facture;


public class FactureServlet extends HttpServlet {

   public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{   
       try{ 
        Facture fact=new Facture();   
        String id=req.getParameter("idr");
        String idc=req.getParameter("idc");
        String prix=req.getParameter("prix");
        float p=Float.parseFloat(prix);
        fact.insert_facture(id,idc,p);
        res.sendRedirect("repa");
        }
       catch(Exception ex){}
   }
}

