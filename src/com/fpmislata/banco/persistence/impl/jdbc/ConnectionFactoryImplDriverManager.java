/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.impl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alumno
 */
public class ConnectionFactoryImplDriverManager implements ConnectionFactory{

    @Override
    public Connection getConnection() {
        Connection connection = null;
         try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "root");

        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Fallo al registrar el Driver.");
        } catch (SQLException ex) {
            throw new RuntimeException("Fallo al conectar con la DB.");
        }
         return connection;
    }

    @Override
    public void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Failed to close connection.");
        }
    }
    
}
