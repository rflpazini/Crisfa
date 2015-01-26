/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webcrud.controller;

import br.com.webcrud.dao.PersonDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.webcrud.model.Person;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author rflpazini
 */
@WebServlet(name = "PersonController", urlPatterns = {"/PersonController"})
public class PersonController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String insertEdit = "/create.jsp";
    private static String listPerson = "/list.jsp";
    private PersonDao personDao;
    
    public PersonController(){
        super();
        personDao = new PersonDao();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        String forward = "";
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("delete")){
            int personId = Integer.parseInt(request.getParameter("personId"));
            personDao.removePerson(personId);
            forward = listPerson;
            
            try {
              request.setAttribute("persons", personDao.getPersons());
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        else if(action.equalsIgnoreCase("edit")){
            forward = insertEdit;
            int personId = Integer.parseInt(request.getParameter("personId"));
            
            try {
                Person person = personDao.getPersonById(personId);
                request.setAttribute("person", person);                
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        else if (action.equalsIgnoreCase("listPerson")){
            forward = listPerson;
            
            try {
                request.setAttribute("persons", personDao.getPersons());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        else {
            forward = insertEdit;
        }
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        Person person = new Person();
        person.setName(request.getParameter("name"));
        person.setPhone(request.getParameter("phone"));
        person.setProfession("profession");
        String personId = request.getParameter("personId");
        
        if(personId == null || personId.isEmpty()){
            personDao.addPerson(person);
        }
        else{
            person.setPersonId(Integer.parseInt(personId));
            personDao.updatePerson(person);
        }
        response.sendRedirect(request.getContextPath()+"index.jsp");
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PersonController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PersonController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }

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
