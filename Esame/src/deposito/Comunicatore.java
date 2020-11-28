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

        return eseguiUpdate(query + values);
    }

    public int deleteQuery(String table, HashMap<String, Object> params) {
        int i = 0;
        Object p;

        String query = "DELETE FROM " + table;
        String values = " WHERE ";

        ArrayList<String> l = preparazione(params.keySet());
        
        if (l.size()> 1) {
            for (i = 0; i < l.size() - 1; i++) {
                p = params.get(l.get(i));
                if (p instanceof String) {
                    p = "'" + p + "'";
                }
                values = values + l.get(i) + " = " + p + " and ";
            }
        }
            p = params.get(l.get(i));
            if (p instanceof String)
                p = "'" + p + "'";
            values = values + l.get(i) + " = " + p;
        

        System.out.println(query + values);
        return eseguiUpdate(query + values);
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

        if (keys.size() > 1) {
            for (i = 0; i < keys.size()- 1; i++) {
                p = chiavi.get(keys.get(i));
                if (p instanceof String) {
                    p = "'" + p + "'";
                }
                values = values + keys.get(i) + " = " + p + " and ";
            }
        }
        p = chiavi.get(keys.get(i));
        if (p instanceof String) {
            p = "'" + p + "'";
        }
        values = values + keys.get(i) + " = " + p;

        System.out.println(query + values);

        return eseguiUpdate(query + values);
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
            System.out.println("ERRORE NELLA QUERY");
        }
        return res;
    }

    public void chiudi() throws SQLException {
        this.c.close();
    }

}
