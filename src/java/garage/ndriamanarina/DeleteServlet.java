/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage.ndriamanarina;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import garage.razafindramasy.Reparation;
/**
 *
 * @author liszt
 */
public class DeleteServlet extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{   
       try{ 
        Reparation rep=new Reparation();
        String id=req.getParameter("id");
        String id1=req.getParameter("id1");
        rep.delete_reparation(id,id1);
        res.sendRedirect("repa");
        }
       catch(Exception ex){}
   }
}

