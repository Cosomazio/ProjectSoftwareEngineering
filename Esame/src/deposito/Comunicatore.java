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
        this.c = DriverManager.getConnection("jdbc:postesql://kandula.db.elephantsql.com:5432/figslypy", "figslypy", "lwHyJdBS_3DZCU4mlrffKxLP7hwmyZio");
    }
    
    public int insertQuery(String table, HashMap<String, String> params){
        int res=-1;
        int i=0, j=0;
        String query="insert INTO"+ " "+table+ " (";
        Set<String> k=params.keySet();
        String[] l=(String[]) k.toArray();
        
        for(i=0; i<k.size()-1; i++){
            query=query + l[i]+",";
        }
        query=query+l[i]+")";
        String values=" values (";
        for(j=0; j<k.size()-1; j++){
            values=values+params.get(l[j]);
        }
        values=values+params.get(l[j])+")";
        try {    
            PreparedStatement pt = c.prepareStatement(query+values);
            res=pt.executeUpdate(query+values);
        
        } catch (SQLException ex) {
            System.out.println("ERRORE");
        }
        
        return res;
    }
    

 

}
