/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mangosneaker.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class UpdateCustomerController extends HttpServlet {

    private final String AUTHENTICATION_PAGE_ACTION = "AuthenticationPage";
    private final String UPDATE_CUSTOMER_PAGE_ACTION = "UpdateCustomerPage";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String fname_raw = request.getParameter("firstName");
        String lname_raw = request.getParameter("lastName");
        String uname_raw = request.getParameter("username");
        String phone_raw = request.getParameter("phone");
        String mail_raw = request.getParameter("mail");
        String id_raw = request.getParameter("customerId");
        System.out.println(id_raw);
        CustomerDAO cd = new CustomerDAO(getServletContext());
        String action = null;

        try {
            int id = Integer.parseInt(id_raw);
            System.out.println(fname_raw);
            if (mangosneaker.utils.Util.isValidPhoneNumber(phone_raw)) {
                System.out.println("hi");
                CustomerDAO ad = new CustomerDAO(getServletContext());
                CustomerDTO updateAcc = new CustomerDTO(id, fname_raw, lname_raw, mail_raw, uname_raw, phone_raw, false);
                System.out.println(updateAcc);
                if (ad.update(updateAcc) > 0) {
                    action = AUTHENTICATION_PAGE_ACTION;
                } 
            } else {
                throw new Exception();
            }

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            if (ex.getMessage().contains("[UQ_Customer_Username]")) {
                request.setAttribute("err", "Username already exists.");
                System.out.println("err");
            } else if (ex.getMessage().contains("UQ_Customer_Phone")) {
                request.setAttribute("err", "Phone number already exists.");
            } else if (ex.getMessage().contains("[UQ_Customer_Mail]")) {
                request.setAttribute("err", "Mail already exists.");
            } else {
                request.setAttribute("err", "An unexpected database error occurred.");
}
            action = UPDATE_CUSTOMER_PAGE_ACTION;
        } catch (Exception ex) {
            request.setAttribute("err", "Invalid."
                    + "Begin with either 03, 05, 07, or 09, and it must consist of exactly 10 digits.");
            action = UPDATE_CUSTOMER_PAGE_ACTION;
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