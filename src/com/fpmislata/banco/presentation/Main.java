/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentation;

import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.persistence.dao.EntidadBancariaDAO;
import com.fpmislata.banco.persistence.dao.impl.jdbc.EntidadBancariaDAOImplJDBC;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alumno
 */
public class Main {
         
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //lel ramon y vicente
        EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImplJDBC();
        EntidadBancaria entidadBancaria = new EntidadBancaria("Bonkia", 011, new Date(), "Calle Verdadera 3", "456468a");
        EntidadBancaria entidadBancaria2 = new EntidadBancaria("DeustcheBank", 022, new Date(), "Calle Deuts", "9999999");
        EntidadBancaria entidadBancaria3 = new EntidadBancaria("Banco", 333, new Date(), "Calle Banco 3", "AAAAAA");

        //entidadBancariaDAO.insert(entidadBancaria);
        //entidadBancariaDAO.insert(entidadBancaria2);
        //entidadBancariaDAO.insert(entidadBancaria3);
        //System.out.println(entidadBancariaDAO.get(1).toString());
        EntidadBancaria entidadBancariaUpd = new EntidadBancaria(1, "Bonkia", 011, new Date(), "Calle Verdadera 3", "456468a");
        System.out.println(entidadBancariaDAO.update(entidadBancariaUpd).toString());
        //System.out.println(entidadBancariaDAO.delete(1));
        //List<EntidadBancaria> entidades = entidadBancariaDAO.findAll();
        //for(EntidadBancaria e: entidades){
        //  System.out.println(e.toString()+"\n");
        //}

        List<EntidadBancaria> entidades = entidadBancariaDAO.findByNombre("Banco");
        for (EntidadBancaria e : entidades) {
            System.out.println(e.toString());
        }
    }

}
