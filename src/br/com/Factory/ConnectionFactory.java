
package br.com.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    
     public Connection getConnection() {
    
    try {
     //local
        return DriverManager.getConnection("jdbc:mysql://localhost/bd_gsa_mysql", "root","LzYtHKagjliYYqLB");
       //LzYtHKagjliYYqLB
    }
    catch (SQLException excecao) {
            throw new RuntimeException (excecao);
            }
    }
    
}
