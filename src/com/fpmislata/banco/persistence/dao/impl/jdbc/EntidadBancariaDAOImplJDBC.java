/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao.impl.jdbc;

import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.persistence.dao.EntidadBancariaDAO;
import com.fpmislata.banco.util.DateConverter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class EntidadBancariaDAOImplJDBC implements EntidadBancariaDAO {

    ConnectionFactory connectionFactory;

    public EntidadBancariaDAOImplJDBC() {
        //ConnectionFactory connectionFactory = new ConnectionFactoryImplDriverManager();
        connectionFactory = new ConnectionFactoryImplDataSource();
    }

    @Override
    public EntidadBancaria get(int idEntidadBancaria) {
        Connection connection = connectionFactory.getConnection();

        EntidadBancaria entidadBancaria;
        ResultSet resultSet;
        String sql = "SELECT * from entidadBancaria WHERE idEntidadBancaria = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idEntidadBancaria);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
                entidadBancaria = new EntidadBancaria(resultSet.getString("nombre"), resultSet.getInt("codigoEntidad"), resultSet.getDate("fechaCreacion"), resultSet.getString("direccion"), resultSet.getString("cif"));

            } else {
                entidadBancaria = null;
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error SQL: " + ex.getMessage() + " ERROR CODE: " + ex.getSQLState());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Error al cerrar la conexión. " + ex.getMessage());
            }
        }
        return entidadBancaria;
    }

    @Override
    public void insert(EntidadBancaria entidadBancaria) {
        Connection connection = connectionFactory.getConnection();
        try {
            String sql = "INSERT INTO entidadBancaria VALUES (null,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, entidadBancaria.getNombre());
            preparedStatement.setInt(2, entidadBancaria.getCodigoEntidad());
            java.sql.Date fechaSQL = new java.sql.Date(entidadBancaria.getFechaCreacion().getTime());
            preparedStatement.setDate(3, fechaSQL);
            preparedStatement.setString(4, entidadBancaria.getDireccion());
            preparedStatement.setString(5, entidadBancaria.getCif());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error SQL: " + ex.getMessage() + " ERROR CODE: " + ex.getSQLState());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Error al cerrar la conexión. " + ex.getMessage());
            }
        }

    }

    @Override
    public EntidadBancaria update(EntidadBancaria entidadBancaria) {
        Connection connection = connectionFactory.getConnection();

        try {
            String sql = "UPDATE entidadBancaria set nombre=?,codigoEntidad=?,fechaCreacion=?,direccion=?,cif=? where idEntidadBancaria = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entidadBancaria.getNombre());
            preparedStatement.setInt(2, entidadBancaria.getCodigoEntidad());
            preparedStatement.setDate(3, DateConverter.utilDateToSqlDate(entidadBancaria.getFechaCreacion()));
            preparedStatement.setString(4, entidadBancaria.getDireccion());
            preparedStatement.setString(5, entidadBancaria.getCif());
            preparedStatement.setInt(6, entidadBancaria.getIdEntidadBancaria());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error SQL: " + e.getMessage() + " ERROR CODE: " + e.getSQLState());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Error al cerrar la conexión. " + ex.getMessage());
            }
        }
        return entidadBancaria;
    }

    @Override
    public boolean delete(int idEntidadBancaria) {
        Connection connection = connectionFactory.getConnection();
        boolean borrado;
        String sql = "DELETE from entidadBancaria WHERE idEntidadBancaria = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idEntidadBancaria);
            int numeroFilasBorradas = preparedStatement.executeUpdate();
            if (numeroFilasBorradas == 0) {
                borrado = false;
            } else if (numeroFilasBorradas == 1) {
                borrado = true;
            } else {
                throw new RuntimeException("Error al borrar. " + numeroFilasBorradas);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error SQL: " + e.getMessage() + " ERROR CODE: " + e.getSQLState());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Error al cerrar la conexión. " + ex.getMessage());
            }
        }
        return borrado;
    }

    @Override
    public List<EntidadBancaria> findAll() {
        Connection connection = connectionFactory.getConnection();
        List<EntidadBancaria> entidades = new ArrayList();
        String sql = "SELECT * FROM entidadBancaria;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EntidadBancaria entidadBancaria = new EntidadBancaria(resultSet.getInt("idEntidadBancaria"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("codigoEntidad"),
                        resultSet.getDate("fechaCreacion"),
                        resultSet.getString("direccion"),
                        resultSet.getString("cif"));
                entidades.add(entidadBancaria);

            }
        } catch (SQLException e) {
            throw new RuntimeException("Error SQL: " + e.getMessage() + " ERROR CODE: " + e.getSQLState());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Error al cerrar la conexión. " + ex.getMessage());
            }
        }

        return entidades;
    }

    @Override
    public List<EntidadBancaria> findByNombre(String nombre) {
        Connection connection = connectionFactory.getConnection();
        List<EntidadBancaria> entidades = new ArrayList<>();
        String sql = "SELECT * FROM entidadBancaria WHERE nombre = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nombre);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                EntidadBancaria entidadBancaria = new EntidadBancaria(resultSet.getInt("idEntidadBancaria"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("codigoEntidad"),
                        resultSet.getDate("fechaCreacion"),
                        resultSet.getString("direccion"),
                        resultSet.getString("cif"));

                entidades.add(entidadBancaria);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error SQL: " + e.getMessage() + " ERROR CODE: " + e.getSQLState());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Error al cerrar la conexión. " + ex.getMessage());
            }
        }
        return entidades;
    }
}
