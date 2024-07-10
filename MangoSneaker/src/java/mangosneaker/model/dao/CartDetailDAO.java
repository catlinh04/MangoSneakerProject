/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangosneaker.model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import mangosneaker.utils.DBContext;

/**
 *
 * @author Nhatthang
 */
public class CartDetailDAO implements Serializable {

    private ServletContext sc = null;

    public CartDetailDAO(ServletContext sc) {
        this.sc = sc;
    }

    public void addToCart(int customerID, int productId, int quantity, int size) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO [dbo].[CartDetail]\n"
                + "           ([CustomerID]\n"
                + "           ,[ProductID]\n"
                + "           ,[SizeNumber]\n"
                + "           ,[Quantity])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, ?)";
        
        try ( Connection con = new DBContext(sc).getConnection();  PreparedStatement st = con.prepareStatement(sql);) {
            st.setInt(1, customerID);
            st.setInt(2, productId);
            st.setInt(3, size);
            st.setInt(4, quantity);
            System.out.println("customerID: " + customerID);
            System.out.println("productId: " + productId);
            System.out.println("size: " + size);
            System.out.println("quantity: " + quantity);
            st.executeUpdate();
            
        }
    }

}
