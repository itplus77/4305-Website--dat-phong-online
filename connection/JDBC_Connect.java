package connection;

import java.sql.*;
import java.util.logging.*;

public class JDBC_Connect {
    
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.ibm.db2.jcc.DB2Driver";
    static final String DB_URL = "jdbc:db2://localhost:50000/test1?useUnicode=true&characterEncoding=utf-8";
    public static final String URL = "http://localhost:8080/WebAppJSP/";
    // Database credentials
    static final String USER = "db2admin";
    static final String PASS = "admin";

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            return connection;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBC_Connect.class.getName()).log(Level.SEVERE, null, ex);
            return connection;
        }
    }
}
