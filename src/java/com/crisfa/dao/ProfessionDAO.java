package com.crisfa.dao;

import com.crisfa.controller.DBConnection;
import com.crisfa.model.Profession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rflpazini
 */
public class ProfessionDAO {

    private DBConnection dbCon;

    public ProfessionDAO() {
        this.dbCon = new DBConnection();
    }

    public void addProfession(Profession prof) {
        String sql = "INSERT INTO profissao(prof) VALUES(?)";

        try {
            this.dbCon.openConnection();
            this.dbCon.setPstmp(this.dbCon.getCon().prepareStatement(sql));
            this.dbCon.getPstmp().setString(1, prof.getDescProfession());

            this.dbCon.getPstmp().executeQuery();
            this.dbCon.closeConnection();
        } catch (SQLException e) {
            System.out.println("ERRO ProfessionDAO addProfession: " + e.getMessage());
        }
    }

    public List<Profession> getProfessions() throws SQLException {
        String sql = "SELECT * FROM profissao "
                + "ORDER BY prof ASC";
        List<Profession> professions = new ArrayList<Profession>();

        this.dbCon.openConnection();
        this.dbCon.setPstmp(this.dbCon.getCon().prepareStatement(sql));
        this.dbCon.setResultSet(this.dbCon.getPstmp().executeQuery());

        while (this.dbCon.getResultSet().next()) {
            Profession prof = new Profession();
            prof.setDescProfession(this.dbCon.getResultSet().getString("prof"));
            prof.setIdProfession(this.dbCon.getResultSet().getInt("id_prof"));
            professions.add(prof);
        }
        this.dbCon.closeConnection();
        return professions;
    }
}
