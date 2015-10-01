/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author alumno
 */
public class ConnectionFactoryImplDataSource implements ConnectionFactory{

    @Override
    public Connection getConnection() {
        DataSource dataSource = null;
        try {
            Connection connection = null;
            InitialContext initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            dataSource = (DataSource) envCtx.lookup("jdbc/banco");
            connection = dataSource.getConnection();
            
            return connection;
        } catch (NamingException ex) {
            throw new RuntimeException("Error al inicializar objeto InitialContext. "+ex.getMessage());
        } catch (SQLException ex) {
            throw new RuntimeException("Error SQL: "+ex.getMessage()+" ERROR CODE Nº: "+ex.getSQLState());
        }
    }

    @Override
    public void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
             throw new RuntimeException("Error SQL: "+ex.getMessage()+" ERROR CODE Nº: "+ex.getSQLState());
        }
    }
    
}
