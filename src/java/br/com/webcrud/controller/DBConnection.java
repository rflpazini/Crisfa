/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webcrud.controller;

import com.oracle.jrockit.jfr.ContentType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rflpazini
 */
public class DBConnection {
    public Connection getConnection() throws SQLException{
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/testes","postgres","asd");
    }
}
