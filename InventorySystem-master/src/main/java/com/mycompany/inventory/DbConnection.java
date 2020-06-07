
package com.mycompany.inventory;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author XYZ
 */
public class DbConnection {
    public static Connection getConnection()
    {
        
        Connection cnx=null;
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setUser("root");
        dataSource.setPassword("");
        dataSource.setDatabaseName("inventory_db");
        dataSource.setPortNumber(3306);
        
        try {
            cnx=dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger("Get Connection_-> "+DbConnection.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        return cnx;
    }
}
