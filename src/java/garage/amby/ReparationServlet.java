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
public class ReparationServlet extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{   
       try{ 
        Reparation rep=new Reparation();
        int n=0;
        String nn=req.getParameter("nbr");
        Reparation[] repa = rep.get_reparation(n);
        if(nn!=null){
            int i=Integer.parseInt(nn);
            repa=rep.get_reparation(i);
        }
        req.setAttribute("all_rep", repa);
        RequestDispatcher dispat = req.getRequestDispatcher("reparation.jsp");
        dispat.forward(req,res);
        }
       catch(Exception ex){}
   }
}

