/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.util;

/**
 *
 * @author alumno
 */
public class DateConverter {
    public static java.sql.Date utilDateToSqlDate(java.util.Date utilDate) {
        return new java.sql.Date(utilDate.getTime());
        
    }
    
//    static java.util.Date SqlDateToUtilDate(java.sql.Date sqlDate) {
//        
//    }
}
