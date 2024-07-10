/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mangosneaker.controller;

import mangosneaker.model.dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mangosneaker.model.dao.CategoryDAO;
import mangosneaker.model.dto.CategoryDTO;
import mangosneaker.model.dto.ProductDTO;

/**
 *
 * @author Nhatthang
 */
public class GetAllProductsController extends HttpServlet {

    private final String SHOP_PAGE_ACTION = "ShopPage";

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
        ProductDAO proDao = new ProductDAO(getServletContext());
        CategoryDAO cateDao = new CategoryDAO(getServletContext());

        List<ProductDTO> proList = null;
        List<CategoryDTO> cateList = null;

        String cid = request.getParameter("cid");
        String searchNameValue = request.getParameter("searchNameValue");
        String sortType = request.getParameter("sortType");
        
        System.out.println("cid: " + cid);
        System.out.println("searchNameValue: " + searchNameValue);
        
        try {
            cateList = cateDao.getAll();
            proList = proDao.getProducts((cid == null || cid.isEmpty() ? null : Integer.parseInt(cid)), searchNameValue, sortType);       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GetAllProductsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GetAllProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("cateList", cateList);
        request.setAttribute("proList", proList);
        request.getRequestDispatcher("DispatcherProductController?action=" + SHOP_PAGE_ACTION).forward(request, response);
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
