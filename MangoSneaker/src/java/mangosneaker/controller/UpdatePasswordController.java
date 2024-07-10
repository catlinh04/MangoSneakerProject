/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mangosneaker.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mangosneaker.model.dao.CustomerDAO;
import mangosneaker.model.dto.CustomerDTO;

/**
 *
 * @author catlinh
 */
public class UpdatePasswordController extends HttpServlet {

    private final String PROFILE_PAGE_ACTION = "ProfilePage&tab=change-password";
    private final String AUTHENTICATION_PAGE_ACTION = "AuthenticationPage";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String curPwd = request.getParameter("curPwd");
        String newPwd = request.getParameter("newPwd");
        String reNewPwd = request.getParameter("reNewPwd");
        String action = null;
        CustomerDAO cd = new CustomerDAO(getServletContext());
        HttpSession session = request.getSession();
        CustomerDTO cus = (CustomerDTO) session.getAttribute("information");
        try {
            if (cd.checkExisedtAccount(cus.getUsername(), curPwd) > 0) {
                if (cd.updatePwd(newPwd, reNewPwd, cus.getUsername()) > 0) {
                    action = AUTHENTICATION_PAGE_ACTION;
                } else {
                    request.setAttribute("err", "The new password and repeat new password are not matching.");
                    action = PROFILE_PAGE_ACTION;
                }
            } else {
                request.setAttribute("err", "The current password is wrong.");
                action = PROFILE_PAGE_ACTION;
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            request.getRequestDispatcher("MainAuthenticationController?action=" + action ).forward(request, response);
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
