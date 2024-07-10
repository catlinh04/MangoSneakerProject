/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package mangosneaker.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mangosneaker.model.dto.ProductDTO;

/**
 *
 * @author Nhatthang
 */
public class DispatcherProductController extends HttpServlet {
   
    private final String HOME_PAGE_ACTION = "HomePage";
    private final String HOME_PAGE = "HomePage.jsp";
    
    private final String SHOP_PAGE_ACTION = "ShopPage";
    private final String SHOP_PAGE = "ShopPage.jsp";
    
    private final String GET_ALL_PRODUCTS_CONTROLLER_ACTION = "GetAllProducts";
    private final String GET_ALL_PRODUCTS_CONTROLLER = "GetAllProductsController";
    
    private final String GET_ALL_CATEGORIES_CONTROLLER_ACTION = "GetAllCategories";
    private final String GET_ALL_CATEGORIES_CONTROLLER = "GetAllCategoriesController";
    
    private final String SHOP_SINGLE_PAGE_ACTION = "ShopSinglePage";
    private final String SHOP_SINGLE_PAGE = "ShopSinglePage.jsp";
    
    private final String GET_SINGLE_PRODUCT_CONTROLLER_ACTION = "GetSingleProduct";
    private final String GET_SINGLE_PRODUCT_CONTROLLER= "GetSingleProductController";
    
    private final String ADD_TO_CART_CONTROLLER_ACTION = "AddToCart";
    private final String ADD_TO_CART_CONTROLLER = "AddToCartController";
    
    private final String CART_PAGE_ACTION = "CartPage";
    private final String CART_PAGE = "CartPage.jsp";
    
    
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String action = request.getParameter("action");
        String url = HOME_PAGE;
        System.out.println("Dispatcher: " + action);
        switch (action) {
            case HOME_PAGE_ACTION:
                url = HOME_PAGE;
                break;
            case SHOP_PAGE_ACTION:
                url = SHOP_PAGE;
                break;
            case GET_ALL_PRODUCTS_CONTROLLER_ACTION:
                url = GET_ALL_PRODUCTS_CONTROLLER;
                break;
            case SHOP_SINGLE_PAGE_ACTION:
                url = SHOP_SINGLE_PAGE;
                break;
            case GET_SINGLE_PRODUCT_CONTROLLER_ACTION:
                url = GET_SINGLE_PRODUCT_CONTROLLER;
                break;  
            case ADD_TO_CART_CONTROLLER_ACTION:
                url = ADD_TO_CART_CONTROLLER;
                break;
            case CART_PAGE_ACTION:
                url = CART_PAGE;
                break;
        }
        request.getRequestDispatcher(url).forward(request, response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
