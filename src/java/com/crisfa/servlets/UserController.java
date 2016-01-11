package com.crisfa.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crisfa.dao.UserDAO;
import com.crisfa.model.User;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
import com.crisfa.utils.Encrypt;

/**
 *
 * @author rflpazini
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserDAO userDao;

    public UserController() {
        super();
        userDao = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = new User();
        user.setNome(request.getParameter("first-name"));
        user.setSobrenome(request.getParameter("last-name"));
        String profId = request.getParameter("professions");
        user.setProfi(Integer.parseInt(profId));
        user.setEmail(request.getParameter("email"));

        try {
            String password = request.getParameter("pass");
            String valPass = request.getParameter("valPass");
            if (valPass.equals(password)) {
                String passMd5 = Encrypt.md5(valPass);
                user.setSenha(passMd5);
            }
        } catch (Exception e) {
            System.out.println("Erro ao validar senha: " + e.getMessage());
        }

        String dataB = request.getParameter("data");
        Calendar dataNascimento = null;

        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataB);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
        } catch (Exception e) {
            System.out.println("Erro conversão da data");
        }

        user.setBday(dataNascimento);

        userDao.addUser(user);
        response.sendRedirect(request.getContextPath() + "/index.html");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserController at " + request.getContextPath() + "</h1>");
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
