package com.crisfa.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rflpazini
 */
public class DBConnection {

    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet resultSet;
    private String driverName = "org.postgresql.Driver";

    public PreparedStatement getPstmp() {
        return pstmt;
    }

    public void setPstmp(PreparedStatement pstmp) {
        this.pstmt = pstmp;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public DBConnection() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void openConnection() {
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/crisfa", "postgres", "asd");
            System.out.println("Conexão efetuada");
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    public void closeConnection() {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
