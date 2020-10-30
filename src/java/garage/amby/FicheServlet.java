/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage.amby;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import garage.ndriamanarina.Client;
import garage.razafindramasy.Reparation;
/**
 *
 * @author liszt
 */
public class FicheServlet extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{   
       try{ 
        Reparation rep=new Reparation();
        String etat=req.getParameter("etat");
        Reparation[] repa = rep.get_reparation(etat);
        req.setAttribute("all_reps", repa);
        RequestDispatcher dispat = req.getRequestDispatcher("recherche.jsp");
        dispat.forward(req,res);
        }
       catch(Exception ex){}
   }
}
