package com.crisfa.model;

import java.util.Calendar;

/**
 *
 * @author rflpazini
 */
public class User extends UserLogin {
    private int userId;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private int profi;
    private Calendar bday;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getSenha() {
        return senha;
    }

    @Override
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
     public int getProfi() {
        return profi;
    }

    public void setProfi(int profi) {
        this.profi = profi;
    }

    public Calendar getBday() {
        return bday;
    }

    public void setBday(Calendar bday) {
        this.bday = bday;
    }

    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
}