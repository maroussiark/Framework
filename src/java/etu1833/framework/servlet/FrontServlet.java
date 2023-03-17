/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package etu1833.framework.servlet;

import etu1833.framework.Mapping;
import helper.Fonction;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilitaire.Utilitaire;
import annotation.Url;

/**
 *
 * @author maroussia
 */
public class FrontServlet extends HttpServlet {
    HashMap<String,Mapping> MappingUrls;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response,String url)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FrontServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FrontServlet at " + request.getContextPath() + "</h1>");
            
            String link = Utilitaire.getUrl(url,request.getContextPath());
            out.println(link);
            out.println(this.MappingUrls.isEmpty());

            
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    public void init() throws ServletException{
        Fonction fn  = new Fonction();
        try {
            //get
            Class[] cls = fn.getAllClass("modele");
          
            for (Class cl : cls) {
                Method[] m = fn.getAllMethodWithAnnotation(cl, Url.class);
                if (m!=null) {
                    for (Method m1 : m) {
                        Url url = (Url) m1.getAnnotation(Url.class);
                        this.MappingUrls.put(url.valeur(), new Mapping(cl.getName(), m1.getName()));
                    }
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response,request.getRequestURL().toString());
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *url
     * @param request servlet request
     * @param response serurlvlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             processRequest(request, response,request.getRequestURL().toString());

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
