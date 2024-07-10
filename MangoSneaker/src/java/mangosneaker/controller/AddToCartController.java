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
import mangosneaker.model.dao.CartDetailDAO;

/**
 *
 * @author Nhatthang
 */
public class AddToCartController extends HttpServlet {

    private final String GET_SINGLE_PRODUCT_CONTROLLER_ACTION = "GetSingleProduct";
    private final String CART_PAGE_ACTION = "CartPage";
    private final String AUTHENTICATION_PAGE_ACTION = "AuthenticationPage";

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
        HttpSession sess = request.getSession();
        if (sess.getAttribute("information") == null) {
            request.getRequestDispatcher("MainAuthenticationController?action=" + AUTHENTICATION_PAGE_ACTION).forward(request, response);
        } else {
            int customerId = 1;
            int productId = Integer.parseInt(request.getParameter("productId"));
            int quantity = Integer.parseInt(request.getParameter("productQuantity"));

            if (request.getParameter("productSize").isEmpty()) {
                request.getRequestDispatcher("DispatcherProductController?action=" + GET_SINGLE_PRODUCT_CONTROLLER_ACTION).forward(request, response);
            } else {
                int size = Integer.parseInt(request.getParameter("productSize"));
                CartDetailDAO cartDAO = new CartDetailDAO(getServletContext());

                try {
                    cartDAO.addToCart(customerId, productId, quantity, size);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AddToCartController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(AddToCartController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            request.getRequestDispatcher("DispatcherProductController?action=" + CART_PAGE_ACTION).forward(request, response);
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
