/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mangosneaker.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author catlinh
 */
public class MainAuthenticationController extends HttpServlet {

    private final String ERROR_PAGE = "error.jsp";

    private final String HOME_PAGE_ACTION = "HomePage";
    private final String HOME_PAGE = "HomePage.jsp";

    private final String LOGIN_CONTROLLER_ACTION = "Login";
    private final String LOGIN_CONTROLLER = "LoginController";

    private final String REGISTER_CONTROLLER_ACTION = "Register";
    private final String REGISTER_CONTROLLER = "RegisterController";

    private final String AUTHENTICATION_PAGE_ACTION = "AuthenticationPage";
    private final String AUTHENTICATION_PAGE = "AuthenticationPage.jsp";

    private final String LOGOUT_CONTROLLER_ACTION = "Logout";
    private final String LOGOUT_CONTROLLER = "LogoutController";

    private final String PROFILE_PAGE_ACTION = "ProfilePage";
    private final String PROFILE_PAGE = "ProfilePage.jsp";

    private final String UPDATE_CUSTOMER_PAGE_ACTION = "UpdateCustomerPage";
    private final String UPDATE_CUSTOMER_PAGE = "UpdateCustomerPage.jsp";
    private final String UPDATE_CUSTOMER_CONTROLLER_ACTION = "UpdateCustomer";
    private final String UPDATE_CUSTOMER_CONTROLLER = "UpdateCustomerController";

    private final String UPDATE_PASSWORD_CONTROLLER_ACTION = "UpdatePwd";
    private final String UPDATE_PASSWORD_CONTROLLER = "UpdatePasswordController";

    private final String DELETE_PASSWORD_CONTROLLER_ACTION = "DeleteAccount";
    private final String DELETE_PASSWORD_CONTROLLER = "DeleteCustomerController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = ERROR_PAGE;
        try {
            String action = request.getParameter("action");
            System.out.println("action = " + action);
            switch (action) {
                case LOGIN_CONTROLLER_ACTION:
                    url = LOGIN_CONTROLLER;
                    break;
                case REGISTER_CONTROLLER_ACTION:
                    url = REGISTER_CONTROLLER;
                    break;
                case AUTHENTICATION_PAGE_ACTION:
                    url = AUTHENTICATION_PAGE;
                    break;
                case PROFILE_PAGE_ACTION:
                    url = PROFILE_PAGE;
                    break;
                case HOME_PAGE_ACTION:
                    url = HOME_PAGE;
                    break;
                case LOGOUT_CONTROLLER_ACTION:
                    url = LOGOUT_CONTROLLER;
                    break;
                case UPDATE_CUSTOMER_CONTROLLER_ACTION:
                    System.out.println("o day");
                    url = UPDATE_CUSTOMER_CONTROLLER;
                    break;
                case UPDATE_PASSWORD_CONTROLLER_ACTION:
                    System.out.println("o day");
                    url = UPDATE_PASSWORD_CONTROLLER;
                    break;
                case UPDATE_CUSTOMER_PAGE_ACTION:
                    url = UPDATE_CUSTOMER_PAGE;
                    break;
                case DELETE_PASSWORD_CONTROLLER_ACTION:
                    url = DELETE_PASSWORD_CONTROLLER;
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (Exception e) {
            System.out.println("Error at Main Authentication Controller" + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
