/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;
import java.sql.*;

import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;

/**
 *
 * @author franc
 */
public class Comunicatore {
    private Connection c;

    public Comunicatore() throws SQLException {
        this.c = DriverManager.getConnection("jdbc:postgresql://kandula.db.elephantsql.com:5432/figslypy", "figslypy", "lwHyJdBS_3DZCU4mlrffKxLP7hwmyZio");
    }
    
    public int insertQuery(String table, HashMap<String, Object> params){
        int res=-1;
        int i, j;
        String query="insert INTO"+ " "+table+ " (";
        Set<String> k=params.keySet();
        ArrayList<String> l= new ArrayList<>();
        for(String chiave: k){
            l.add(chiave);
        }
        
        for(i=0; i<k.size()-1; i++){
            query=query + l.get(i)+",";
        }
        query=query+l.get(i)+")";
        String values=" values (";
        for(j=0; j<k.size()-1; j++){
            Object par=params.get(l.get(j));
            if (par instanceof Integer || par instanceof Boolean){
                values=values+""+par+""+",";
            }
            else{
            values=values+"'"+par+"'"+",";
            }
        }
        values=values+"'"+params.get(l.get(j))+"'"+")";
        System.out.println(query+values);
        try {    
            Statement pt = c.createStatement();
            res=pt.executeUpdate(query+values);
        
        } catch (SQLException ex) {
            System.out.println("ERRORE NELLA QUERY");
        }
        
        return res;
    }
    
    public int deleteQuery(String table, HashMap<String, Object> params){
        int res=-1;
        int i=0,j;
        String query="DELETE FROM "+table;
        String values= "WHERE";
        
        Set<String> k=params.keySet();
        ArrayList<String> l= new ArrayList<>();
        for(String chiave: k){
            l.add(chiave);
        }
        
        if(k.size()>1){
            for(i=0; i<k.size()-1; i++){
                values = values+l.get(i)+ "="+ params.get(l.get(i)) + " and ";
        }
            values = values+l.get(i)+ "="+ params.get(l.get(i));
        }
        else{
            values= values+ l.get(i)+ "="+ params.get(l.get(i));
        }
        
        System.out.println(query+values);
        
        try{
            Statement pt = c.createStatement();
            res=pt.executeUpdate(query+values);
        }catch(SQLException ex){
            System.out.println("LA QUERY è ANDATA IN ERRORE");
        }
        
        return res;
    }

    public void chiudi() throws SQLException{
        this.c.close();
    }

}
