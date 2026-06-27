package org.gabriel.repositorio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoRepositorio {
        public static Connection connection () throws SQLException {
            return DriverManager.getConnection("jdbc:mysql://sql3.freesqldatabase.com:3306/sql3831488","sql3831488","yKc3A9uj37");
        }
}
