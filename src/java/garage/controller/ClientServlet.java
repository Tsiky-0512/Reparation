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

/**
 *
 * @author liszt
 */
public class ClientServlet extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{   
       try{ 
        Client vao=new Client();
        Client[] all = vao.get_Client();
        req.setAttribute("all_client", all);
        RequestDispatcher dispats = req.getRequestDispatcher("insert.jsp");
        dispats.forward(req,res);
        }
       catch(Exception ex){}
   }

}

