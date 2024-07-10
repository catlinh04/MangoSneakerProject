/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mangosneaker.controller;

import mangosneaker.model.dao.CustomerDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mangosneaker.model.dto.CustomerDTO;

/**
 *
 * @author catlinh
 */
public class LoginController extends HttpServlet {

    private final String AUTHENTICATION_PAGE_ACTION = "AuthenticationPage";
    private final String HOME_PAGE_ACTION = "HomePage";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         String action = null;
        String username = request.getParameter("username");
        String pwd = request.getParameter("password");
        System.out.println("pwd " + pwd);
        CustomerDAO cd = new CustomerDAO(getServletContext());
        try {
            CustomerDTO customer = cd.getAccount(username);

            int existed = cd.checkExisedtAccount(username, pwd);
            if (existed == 1) {
                action = HOME_PAGE_ACTION;
                HttpSession session = request.getSession();
                session.setAttribute("information", customer);
                Cookie cu = new Cookie("username", username);
                Cookie cp = new Cookie("password", pwd);
                Cookie cr = new Cookie("remember", "1");

                String rmb = request.getParameter("remember");
                if (rmb == null) {
                    cu.setMaxAge(0);
                    cp.setMaxAge(0);
                    cr.setMaxAge(0);
                } else {
                    cu.setMaxAge(60 * 60 * 24 * 60);
                    cp.setMaxAge(60 * 60 * 24 * 60);
                    cr.setMaxAge(60 * 60 * 24 * 60);
                }
                response.addCookie(cu);
                response.addCookie(cp);
                response.addCookie(cr);
            } else {
                if (existed == -1) {
                    request.setAttribute("err", "The acccount not existed");
                } else {
                    request.setAttribute("err", "Username or password is wrong");
                }
                action = AUTHENTICATION_PAGE_ACTION;
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            request.getRequestDispatcher("MainAuthenticationController?action=" + action).forward(request, response);
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
//        processRequest(request, response);
//        request.getRequestDispatcher("authentication.jsp").forward(request, response);
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
