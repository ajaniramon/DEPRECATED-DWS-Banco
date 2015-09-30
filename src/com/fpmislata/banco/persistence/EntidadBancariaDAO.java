/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence;

import com.fpmislata.banco.business.domain.EntidadBancaria;
import java.util.List;

/**
 *
 * @author alumno
 */
public interface EntidadBancariaDAO {
    EntidadBancaria get(int idEntidadBancaria);
    void insert(EntidadBancaria entidadBancaria);
    EntidadBancaria update(EntidadBancaria entidadBancaria);
    boolean delete(int idEntidadBancaria);
    List<EntidadBancaria> findAll();
    List<EntidadBancaria> findByNombre(String nombre);
}
