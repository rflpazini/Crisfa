package com.crisfa.dao;

import com.crisfa.controller.DBConnection;
import com.crisfa.model.UserLogin;
import com.crisfa.model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author rflpazini
 */
public class UserDAO {

    private Connection con;
    private DBConnection dbCon;

    public UserDAO() {
        this.dbCon = new DBConnection();
    }

    public void addUser(User user) {
        try {
            String sql = "INSERT INTO users(first_name, last_name, email, senha, id_prof, bday)"
                    + " VALUES(?, ?, ?, ?, ?, ?)";

            this.dbCon.openConnection();
            this.dbCon.setPstmp(this.dbCon.getCon().prepareStatement(sql));
            this.dbCon.getPstmp().setString(1, user.getNome());
            this.dbCon.getPstmp().setString(2, user.getSobrenome());
            this.dbCon.getPstmp().setString(3, user.getEmail());
            this.dbCon.getPstmp().setString(4, user.getSenha());
            this.dbCon.getPstmp().setInt(5, user.getProfi());
            Date data = new Date(user.getBday().getTimeInMillis());
            this.dbCon.getPstmp().setDate(6, data);

            this.dbCon.getPstmp().executeUpdate();
            this.dbCon.closeConnection();
        } catch (SQLException e) {
            System.out.println("ERRO UserDAO addUser: " + e.getMessage());
        }
    }

    public void removeUser(int userId) {
        try {
            String sql = "DELETE FROM users u WHERE u.id_user= ?";

            this.dbCon.openConnection();
            this.dbCon.setPstmp(this.dbCon.getCon().prepareStatement(sql));
            this.dbCon.getPstmp().setInt(1, userId);

            this.dbCon.getPstmp().executeQuery();
            this.dbCon.closeConnection();
        } catch (SQLException e) {
            System.out.println("ERRO UserDAO removeUser: " + e.getMessage());
        }
    }

    public User userLogin(User user) throws SQLException {
        
        String sql = "SELECT * FROM users WHERE email = ?"+
                " AND senha = ?";

        User returnUser = new User();

        this.dbCon.openConnection();
        this.dbCon.setPstmp(this.dbCon.getCon().prepareStatement(sql));
        this.dbCon.getPstmp().setString(1, user.getEmail());
        this.dbCon.getPstmp().setString(2, user.getSenha());
        this.dbCon.setResultSet(this.dbCon.getPstmp().executeQuery());

        if (this.dbCon.getResultSet().next()) {
            returnUser.setUserId(this.dbCon.getResultSet().getInt("id_user"));
            returnUser.setEmail(this.dbCon.getResultSet().getString("email"));
            returnUser.setSenha(this.dbCon.getResultSet().getString("senha"));
            returnUser.setNome(this.dbCon.getResultSet().getString("first_name"));
            returnUser.setSobrenome(this.dbCon.getResultSet().getString("last_name"));
        }
        this.dbCon.closeConnection();

        return returnUser;
    }
}
