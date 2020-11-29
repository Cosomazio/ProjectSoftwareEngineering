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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franc
 */
public class Comunicatore {

    private Connection c;

    public synchronized Connection apri() throws SQLException {
        this.c = DriverManager.getConnection("jdbc:postgresql://kandula.db.elephantsql.com:5432/figslypy", "figslypy", "lwHyJdBS_3DZCU4mlrffKxLP7hwmyZio");
        return this.c;
    }

    public int insertQuery(String table, HashMap<String, Object> params) {
        int i, j;
        Object par;
        String query = "insert INTO" + " " + table + " (";

        ArrayList<String> l = preparazione(params.keySet());

        for (i = 0; i < l.size() - 1; i++) {
            query = query + l.get(i) + ",";
        }
        query = query + l.get(i) + ")";
        String values = " values (";
        for (j = 0; j < l.size() - 1; j++) {
            par = params.get(l.get(j));
            if (par instanceof String) 
                par="'"+par+"'";
            
            values = values + par + ",";
        }
        par = params.get(l.get(j));
        if(par instanceof String)
            par = "'"+par+"'";
        values = values + par+ ")";
        
        System.out.println(query + values);

        return this.eseguiUpdate(query + values);
    }

    public int deleteQuery(String table, HashMap<String, Object> params) {
        int i = 0;
        Object p;

        String query = "DELETE FROM " + table;
        String values = " WHERE ";

        ArrayList<String> l = preparazione(params.keySet());
        
        String s=this.manipolazioneQuery(l, params);
        values=values+s;
        
        System.out.println(query + values);
        return this.eseguiUpdate(query + values);
    }

    public int updateQuery(String table, HashMap<String, Object> params, HashMap<String, Object> chiavi) {
        int i = 0;
        Object p;

        String query = "UPDATE " + table;
        String values = " SET ";
        ArrayList<String> l = preparazione(params.keySet());
        ArrayList<String> keys = preparazione(chiavi.keySet());

        if (l.size() > 1) {
            for (i = 0; i < l.size() - 1; i++) {
                p = params.get(l.get(i));
                if (p instanceof String) {
                    p = "'" + p + "'";
                }
                values = values + l.get(i) + " = " + p + ", ";
            }
        }
        p = params.get(l.get(i));
        if (p instanceof String) {
            p = "'" + p + "'";
        }
        values = values + l.get(i) + " = " + p;

        values = values + " WHERE ";
        String s= this.manipolazioneQuery(keys, chiavi);
        values=values+s;
        System.out.println(query + values);

        return this.eseguiUpdate(query + values);
    }
    
    public ResultSet selectionQuery(String table, ArrayList<String> colonne, HashMap<String, Object> dove){
        ArrayList<String> chiavi;
        String fine;
        
        String query="SELECT ";
        String values= " FROM ";
        String luogo= " WHERE ";
        
        if(dove==null && colonne==null){
            query=query+"*";
            values=values+table;
            return this.eseguiSelezione(query+values);
        }
        else if(colonne == null){
            query=query+"*";
            values=values+table;
            chiavi = this.preparazione(dove.keySet());
            fine= this.manipolazioneQuery(chiavi, dove);
            luogo = luogo+fine;
            
            return this.eseguiSelezione(query+values+luogo);
        }
        else if(dove == null){
            for(String s:colonne){
                query=query+s+", ";
            }
            values=values+table;
            return this.eseguiSelezione(query+values);
        }
        for(String s: colonne){
            query=query+s+", ";
        }
        values=values+table;
        chiavi=this.preparazione(dove.keySet());
        fine=this.manipolazioneQuery(chiavi, dove);
        luogo=luogo+fine;
        
        return this.eseguiSelezione(query+values+luogo);
    }

    private String manipolazioneQuery(ArrayList<String> array, HashMap<String, Object> cont){
        int i=0;
        Object p;
        String values="";
        if (array.size()> 1) {
            for (i = 0; i < array.size() - 1; i++) {
                p = cont.get(array.get(i));
                if (p instanceof String) {
                    p = "'" + p + "'";
                }
                values = values + array.get(i) + " = " + p + " and ";
            }
        }
            p = cont.get(array.get(i));
            if (p instanceof String)
                p = "'" + p + "'";
            values = values + array.get(i) + " = " + p;
        return values;
    }
    
    private ArrayList<String> preparazione(Set<String> set) {
        ArrayList<String> l = new ArrayList<>();
        for (String chiave : set) {
            l.add(chiave);
        }
        return l;
    }

    private int eseguiUpdate(String query) {
        int res = -1;
        try {
            Statement pt = c.createStatement();
            res = pt.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("ERRORE NELLA QUERY: "+ ex.getSQLState());
        }
        return res;
    }
    
    private ResultSet eseguiSelezione(String query){
        ResultSet rs=null;
        Statement st;
        try {
            st = c.createStatement();
            rs=st.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("ERRORE NELLA SELECTION QUERY: "+ ex.getSQLState());
        }
        return rs;
    }

    public void chiudi() throws SQLException {
        this.c.close();
    }

}
