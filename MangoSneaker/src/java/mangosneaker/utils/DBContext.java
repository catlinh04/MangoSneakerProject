//<<<<<<< HEAD
//=======
//
//
//>>>>>>> feature/customer-merge-test
package mangosneaker.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletContext;

import java.sql.SQLException;



public class DBContext {
    private String hostname;
    private String instance;
    private String port;
    private String dbName;
    private String user;
    private String pwd;

    public DBContext(ServletContext sc) {
        this.hostname = sc.getInitParameter("hostname");
        this.instance = sc.getInitParameter("instance");
        this.port = sc.getInitParameter("port");
        this.dbName = sc.getInitParameter("dbName");
        this.user = sc.getInitParameter("user");
        this.pwd = sc.getInitParameter("pwd");
    }
    
    public String getURLString(){
        String fm = "jdbc:sqlserver://%s:%s;instanceName=%s;DatabaseName=%s;user=%s;password=%s";
        return String.format(fm, this.hostname,  this.port,this.instance.trim(),
                            this.dbName, this.user, this.pwd);
    }
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       return DriverManager.getConnection(getURLString());
    }
//<<<<<<< HEAD
}
//=======
//}
//>>>>>>> feature/customer-merge-test
