/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webcrud.dao;

import br.com.webcrud.controller.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.webcrud.model.Person;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author rflpazini
 */
public class PersonDao {
    private Connection connection;
    
    public PersonDao() {
        DBConnection dbCon = new DBConnection();
        
        try {
            connection = dbCon.getConnection();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void addPerson(Person person){
        try {
            String sql = "INSERT INTO person(name, phone, profession)"+
                    "VALUES ('" + person.getName() + "', '" + person.getPhone() + "', '" + person.getProfession() + "')";
            
            Statement stmt = connection.createStatement();
            stmt.executeQuery(sql);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void removePerson(int personId) {
        String sql = "DELETE FROM person p WHERE p.idperson = "+ personId+"";
        try {
            Statement stmt = connection.createStatement();
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updatePerson(Person person){
        String sql = "update person set person.name='" + person.getName() + "', person.phone='" + person.getPhone()
                + "', person.profession='" + person.getProfession() + "' where person.idperson = " + person.getPersonId() + " ";
        System.out.println(sql);
        
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Person> getPersons() throws SQLException{
        String sql = "SELECT * FROM person";
        
        ArrayList<Person> persons = new ArrayList<Person>();
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);
        
        while (res.next()) {
            Person person =  new Person();
            person.setName(res.getString("name"));
            person.setPhone(res.getString("phone"));
            person.setProfession(res.getString("profession"));
            person.setPersonId(res.getInt("idperson"));
            persons.add(person);
        }
        return persons;
    }
    
    public Person getPersonById(int personId) throws SQLException{
        Person person = new Person();
        String sql = "SELECT * FROM person p WHERE p.idperson = "+personId+" ";
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);
        
        if(res.next()){
            person.setName(res.getString("name"));
            person.setPhone(res.getString("phone"));
            person.setProfession(res.getString("profession"));
            person.setPersonId(res.getInt("idperson"));
        }
        return person;
    }
}
