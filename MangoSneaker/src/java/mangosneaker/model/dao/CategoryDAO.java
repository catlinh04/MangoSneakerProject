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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import mangosneaker.model.dto.CategoryDTO;
import mangosneaker.model.dto.ProductDTO;
import mangosneaker.utils.DBContext;

/**
 *
 * @author Nhatthang
 */
public class CategoryDAO implements Serializable {

    private ServletContext sc = null;

    public CategoryDAO(ServletContext sc) {
        this.sc = sc;
    }

    public List<CategoryDTO> getAll() throws ClassNotFoundException, SQLException {
        List<CategoryDTO> cateList = null;
        String sql = "SELECT [ID]\n"
                + "      ,[CategoryName]\n"
                + "  FROM [dbo].[Category]";
        try ( Connection con = new DBContext(sc).getConnection();  PreparedStatement st = con.prepareStatement(sql);) {
            try ( ResultSet rs = st.executeQuery();) {
                while (rs.next()) {
                    CategoryDTO cate = new CategoryDTO(rs.getInt("ID"), rs.getString("CategoryName"));
                    if (cateList == null) {
                        cateList = new ArrayList<>();
                    }
                    cateList.add(cate);
                }
            }
        } 
        return cateList;
    }
    
    public CategoryDTO getCategoryByCid(int cid) throws ClassNotFoundException, SQLException {
        CategoryDTO cate = null;
        String sql = "SELECT [ID]\n"
                + "      ,[CategoryName]\n"
                + "  FROM [dbo].[Category]"
                + "  WHERE ID = ?";
        try ( Connection con = new DBContext(sc).getConnection();  PreparedStatement st = con.prepareStatement(sql);) {
            st.setInt(1, cid);
            try ( ResultSet rs = st.executeQuery();) {
                if (rs.next()) {
                    cate = new CategoryDTO(rs.getInt("ID"), rs.getString("CategoryName"));
                }
            }
        } 
        return cate;
    }
}
