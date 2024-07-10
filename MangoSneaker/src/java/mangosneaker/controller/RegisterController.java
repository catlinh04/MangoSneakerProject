/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mangosneaker.controller;

import mangosneaker.model.dao.CustomerDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mangosneaker.model.dto.CustomerDTO;

/**
 *
 * @author catlinh
 */
public class RegisterController extends HttpServlet {

    private final String AUTHENTICATION_PAGE_ACTION = "AuthenticationPage";
    private final String HOME_PAGE_ACTION = "HomePage";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fname_raw = request.getParameter("firstname");
        String lname_raw = request.getParameter("lastname");
        String uname_raw = request.getParameter("username");
        String phone_raw = request.getParameter("phone");
        String mail_raw = request.getParameter("mail");
        String pwd_raw = request.getParameter("password");
        CustomerDAO cd = new CustomerDAO(getServletContext());
        String action = null;
        try {
            if (mangosneaker.utils.Util.isValidPhoneNumber(phone_raw)) {
                CustomerDAO ad = new CustomerDAO(getServletContext());
                CustomerDTO newAcc = new CustomerDTO(fname_raw, lname_raw, mail_raw, uname_raw, pwd_raw, phone_raw, true);
                if (ad.add(newAcc) > 0) {
                    action = HOME_PAGE_ACTION;
                }
            }  else {
                request.setAttribute("ms", "CustomerDTO has not been created");
                action = AUTHENTICATION_PAGE_ACTION;
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            if (ex.getMessage().contains("PRIMARY KEY constraint")) {
                request.setAttribute("errUsername", "Username already exists.");
            } else if (ex.getMessage().contains("UQ__accounts__B43B145FB4B84601")) {
                request.setAttribute("errPhone", "Phone number already exists.");
            } else {
                request.setAttribute("err", "An unexpected database error occurred.");
            }
            action = AUTHENTICATION_PAGE_ACTION;
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
