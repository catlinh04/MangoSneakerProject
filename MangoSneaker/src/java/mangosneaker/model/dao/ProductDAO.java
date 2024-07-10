/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangosneaker.model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import mangosneaker.model.dto.ProductDTO;
import mangosneaker.utils.DBContext;

/**
 *
 * @author Nhatthang
 */
public class ProductDAO implements Serializable {

    private ServletContext sc = null;

    public ProductDAO(ServletContext sc) {
        this.sc = sc;
    }

    public List<ProductDTO> getProducts(Integer cid, String searchNameValue, String sortType) throws ClassNotFoundException, SQLException {
        List<ProductDTO> proList = null;
        StringBuilder sql = new StringBuilder("SELECT [ID]\n"
                + "      ,[CategoryID]\n"
                + "      ,[ProductName]\n"
                + "      ,[Price]\n"
                + "      ,[Image]\n"
                + "      ,[Discount]\n"
                + "      ,[Description]\n"
                + "  FROM [dbo].[Product]\n"
                + "  WHERE 1 = 1\n");
        if (cid != null && cid > 0) {
            sql.append("AND CategoryID = ?\n");
        }
        if (searchNameValue != null && !searchNameValue.isEmpty()) {
            sql.append("AND ProductName LIKE ?\n");
        }
        if (sortType != null) {
            if (sortType.equals("priceLowHigh")) {
                sql.append("ORDER BY Price\n");
            } else if (sortType.equals("priceHighLow")) {
                sql.append("ORDER BY Price DESC\n");
            }
        }

        try ( Connection con = new DBContext(sc).getConnection();  PreparedStatement st = con.prepareStatement(sql.toString());) {
            int index = 1;
            if (cid != null && cid > 0) {
                st.setInt(index++, cid);
            }
            if (searchNameValue != null && !searchNameValue.isEmpty()) {
                st.setString(index++, "%" + searchNameValue + "%");
            }
            try ( ResultSet rs = st.executeQuery();) {
                while (rs.next()) {
                    ProductDTO p = new ProductDTO(rs.getInt("ID"), new CategoryDAO(sc).getCategoryByCid(rs.getInt("CategoryID")), rs.getString("ProductName"),
                            rs.getDouble("Price"), rs.getString("Image"), rs.getDouble("Discount"), rs.getString("Description"));
                    if (proList == null) {
                        proList = new ArrayList<>();
                    }
                    proList.add(p);
                }
            }
        }
        return proList;
    }

    public ProductDTO getProductById(int pId) throws ClassNotFoundException, SQLException {
        ProductDTO product = null;
        String sql = "SELECT [ID]\n"
                + "      ,[CategoryID]\n"
                + "      ,[ProductName]\n"
                + "      ,[Price]\n"
                + "      ,[Image]\n"
                + "      ,[Discount]\n"
                + "      ,[Description]\n"
                + "  FROM [dbo].[Product]\n"
                + "  WHERE ID = ?\n";

        try ( Connection con = new DBContext(sc).getConnection();  PreparedStatement st = con.prepareStatement(sql.toString());) {
            st.setInt(1, pId);
            try ( ResultSet rs = st.executeQuery();) {
                if (rs.next()) {
                    product = new ProductDTO(rs.getInt("ID"), new CategoryDAO(sc).getCategoryByCid(rs.getInt("CategoryID")), rs.getString("ProductName"),
                            rs.getDouble("Price"), rs.getString("Image"), rs.getDouble("Discount"), rs.getString("Description"));
                }
            }
        }
        return product;
    }

    public HashMap<Integer, Integer> getSizeNQuantity(int pId) throws ClassNotFoundException, SQLException {
        HashMap<Integer, Integer> szQuan = null;
        String sql = "SELECT [SizeNumber]\n"
                + "      ,[Quantity]\n"
                + "  FROM [dbo].[ProductSize]"
                + "  WHERE [ProductID] = ?";
        try ( Connection con = new DBContext(sc).getConnection(); PreparedStatement st = con.prepareStatement(sql);) {
            st.setInt(1, pId);
            try ( ResultSet rs = st.executeQuery()) {
                while(rs.next()) {
                    if (szQuan == null) {
                        szQuan = new HashMap<>();
                    }
                    szQuan.put(rs.getInt("SizeNumber"), rs.getInt("Quantity"));
                }
            }
        }
        return szQuan;
    }
}
