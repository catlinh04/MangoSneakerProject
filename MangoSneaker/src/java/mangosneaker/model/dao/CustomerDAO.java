/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangosneaker.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletContext;
import mangosneaker.model.dto.CustomerDTO;
import mangosneaker.utils.DBContext;

/**
 *
 * @author catlinh
 */
public class CustomerDAO implements GenericDAO<CustomerDTO> {

    ServletContext sc = null;

    public CustomerDAO(ServletContext sc) {
        this.sc = sc;
    }

    // 1 existed 
    // 0 not existed
    //-1 existed but deleted
    public int checkExisedtAccount(String username, String pwd) throws SQLException, ClassNotFoundException {
            String sql = "SELECT [Username]\n"
                    + "      [isDeleted]\n"
                    + "  FROM [dbo].[Customer]\n"
                    + "  WHERE [Username] = ? AND [Password] = ?";
            int res = 1;
            try (Connection connection = new DBContext(sc).getConnection(); PreparedStatement st = connection.prepareStatement(sql);) {
                st.setString(1, username);
                st.setString(2, pwd);

                ResultSet rs = st.executeQuery();
                if (rs.isBeforeFirst()) {
                    rs.next();
                    if (rs.getBoolean("isDeleted")) {
                        res = -1;
                    } 
                } else {
                    res = 0;
                }
                System.out.println("rsDAO " + res);
            }
            return res;
    }

//    public boolean checkCurPwd(String pwd) throws SQLException, ClassNotFoundException {
//        String sql = "SELECT [Password]\n"
//                + "  FROM [dbo].[Customer]\n"
//                + "  WHERE[Username] = ?";
//        try (Connection connection = new DBContext(sc).getConnection(); PreparedStatement st = connection.prepareStatement(sql);) {
//            st.setString(1, username);}
//        
//    }
    public CustomerDTO getAccount(String username) throws ClassNotFoundException, SQLException {
        String sql = "SELECT [ID]\n"
                + "      ,[FirstName]\n"
                + "      ,[LastName]\n"
                + "      ,[Mail]\n"
                + "      ,[Username]\n"
                + "      ,[Phone]\n"
                + "      ,[isDeleted]\n"
                + "  FROM [dbo].[Customer]\n"
                + "  WHERE [Username] = ?;";

        try (Connection connection = new DBContext(sc).getConnection(); PreparedStatement st = connection.prepareStatement(sql);) {
            st.setString(1, username);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                CustomerDTO u = new CustomerDTO(rs.getInt("ID"), rs.getString("FirstName"),
                        rs.getString("LastName"), rs.getString("Mail"), rs.getString("Username"),
                        rs.getString("Phone"), rs.getBoolean("isDeleted"));
                return u;
            }
        }
        return null;
    }

    @Override
    public int add(CustomerDTO customer) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO [dbo].[Customer]\n"
                + "           ([FirstName]\n"
                + "           ,[LastName]\n"
                + "           ,[Mail]\n"
                + "           ,[Username]\n"
                + "           ,[Password]\n"
                + "           ,[Phone]\n"
                + "           ,[isDeleted])"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";
        int rs = 0;
        try (Connection connection = new DBContext(sc).getConnection(); PreparedStatement st = connection.prepareStatement(sql);) {
            st.setString(1, customer.getFirstName());
            st.setString(2, customer.getLastName());
            st.setString(3, customer.getMail());
            st.setString(4, customer.getUsername());
            st.setString(5, customer.getPassword());
            st.setString(6, customer.getPhone());
            st.setBoolean(7, customer.isIsDeleted());
            rs = st.executeUpdate();

        }
        return rs;
    }

    public int updatePwd(String newPwd, String reNewPwd, String username) throws ClassNotFoundException, SQLException {
        if (newPwd.equals(reNewPwd)) {
            String sql = "UPDATE [dbo].[Customer]\n"
                    + "   SET [Password] = ?\n"
                    + " WHERE [Username] = ?";
            int rs = 0;
            try (Connection connection = new DBContext(sc).getConnection(); PreparedStatement st = connection.prepareStatement(sql);) {
                st.setString(1, newPwd);
                st.setString(2, username);
                rs = st.executeUpdate();

            }
            return rs;
        }
        return 0;
    }

    @Override
    public int update(CustomerDTO customer) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE [dbo].[Customer]\n"
                + "   SET [FirstName] = ?\n"
                + "      ,[LastName] = ?\n"
                + "      ,[Mail] = ?\n"
                + "      ,[Username] = ?\n"
                + "      ,[Phone] = ?\n"
                + "      ,[isDeleted] = ?\n"
                + " WHERE [ID] = ?";
        int rs = 0;
        try (Connection connection = new DBContext(sc).getConnection(); PreparedStatement st = connection.prepareStatement(sql);) {
            st.setString(1, customer.getFirstName());
            st.setString(2, customer.getLastName());
            st.setString(3, customer.getMail());
            st.setString(4, customer.getUsername());
            st.setString(5, customer.getPhone());
            st.setBoolean(6, customer.isIsDeleted());
            st.setInt(7, customer.getId());
            rs = st.executeUpdate();
        }
        return rs;
    }

    @Override
    public List<CustomerDTO> getAll() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int delete(CustomerDTO obj) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE [dbo].[Customer]\n"
                + "   SET [isDeleted] = 1\n"
                + " WHERE [Username] = ?";
        int rs = 0;
        try (Connection connection = new DBContext(sc).getConnection(); PreparedStatement st = connection.prepareStatement(sql);) {
            st.setString(1, obj.getUsername());
            rs = st.executeUpdate();
        }
        return rs;
    }
}
