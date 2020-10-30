/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage.controller;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import garage.model.Client;
import garage.model.Reparation;
/**
 *
 * @author liszt
 */
public class ModifierServlet extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{   
       try{ 
        Reparation rep=new Reparation();
        String id=req.getParameter("idr");
        String type=req.getParameter("type");
        rep.modifier_reparation(type,id);
        res.sendRedirect("repa");
        }
       catch(Exception ex){}
   }
}

