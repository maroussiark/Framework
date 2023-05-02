/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package etu1833.framework.servlet;

import helper.annotation.Url;
import etu1833.framework.Mapping;
import etu1833.framework.view.ModelView;
import helper.Treatement;
import helper.Utilitaire;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author maroussia
 */
public class FrontServlet extends HttpServlet {

    HashMap<String, Mapping> mappingUrls = new HashMap<>();

    public HashMap<String, Mapping> getMappingUrls() {
        return mappingUrls;
    }

    public void setMappingUrls(HashMap<String, Mapping> mappingUrls) {
        this.mappingUrls = mappingUrls;
    }
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>EH</title>");            
            out.println("</head>");
            out.println("<body>");
                  
                    try {
                        String link1 = Utilitaire.lien(request.getRequestURL().toString())[4];
                        Mapping mp = this.getMapping(link1);
                        
                        Object obj = Class.forName(mp.getClassName()).newInstance();
                        sendData(request, obj);
                        
                        ModelView model = getMv(mp, obj);
                        
                        out.println(model.getView());
                        
                        addData(request, model);
                        RequestDispatcher dispat = request.getRequestDispatcher("./page/"+model.getView());
                        dispat.forward(request,response);
            
                    } catch (Exception e) {
                       out.println("Erreur: "+e.getMessage());        

                       e.printStackTrace();

                    }
               
                //out.println("coucou");

                out.println("</body>");
                out.println("</html>");
            }catch(Exception e){
         
            }
                     
                           
     
    }
    
    public void addData(HttpServletRequest req,ModelView mv){
          for (Map.Entry<String,Object> obj: mv.getData().entrySet()) {
              req.setAttribute(obj.getKey(), obj.getValue());
          }
        
    }
    
    public void sendData(HttpServletRequest request,Object obj) throws Exception{
            Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            String value = request.getParameter(field.getName());
            if (value != null) {
                field.setAccessible(true);
                field.set(obj, field.getType().cast(value));
            }
        }

    }
    
    public ModelView getMv(Mapping map,Object obj) throws Exception {
       // String method = map.getMethod();

        // Object obj = Class.forName(classname).newInstance();

       // Method m = obj.getClass().getDeclaredMethod(method, (Class<?>) null);
        //m.setAccessible(true);
        System.out.println(map.getMethod());
        
        Method method = obj.getClass().getDeclaredMethod(map.getMethod());
        method.setAccessible(true);
        ModelView mv = (ModelView) method.invoke(obj);

        return mv;

    }
    public Mapping getMapping(String url) throws Exception{
         for (Map.Entry<String,Mapping> test: mappingUrls.entrySet()) {
                if(url.compareToIgnoreCase(test.getKey())==0){
                     return test.getValue();
                }
         }
         throw new Exception("URL NOT FOUND");
            
    }
    @Override
    public void init() throws ServletException{
        try {
            //get
            Class[] cls = Treatement.getAllClasses();
          
            for (Class cl : cls) {
                Method[] m = Treatement.getAllMethodWithAnnotation(cl, Url.class);
                if (m!=null) {
                    for (Method m1 : m) {
                        Url url = (Url) m1.getAnnotation(Url.class);
                        this.mappingUrls.put(url.valeur(), new Mapping(cl.getName(), m1.getName()));
                        
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
