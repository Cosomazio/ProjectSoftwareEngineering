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
    
    private static Comunicatore instance;
    private Connection c;

//  gestione del Singleton per il comunicatore
    public static synchronized Comunicatore getInstance(){
        if(instance==null){
            instance = new Comunicatore();
        }
        return instance;
    }
    
    private Comunicatore(){} //costruttore privato a causa del singleton
    
    //consente l'apertura della connessione da parte del comunicatore
    public synchronized Connection apri() throws SQLException {
        this.c = DriverManager.getConnection("jdbc:postgresql://kandula.db.elephantsql.com:5432/figslypy", "figslypy", "lwHyJdBS_3DZCU4mlrffKxLP7hwmyZio");
        return this.c;
    }
    
    //gestisce una queri di inserimento all'interno del db.
    //Parametri: String table: nome della tabella in cui inserire
    //           HashMap<String, Object> params: mappa conenente nomi e valori dei parametri che si vogliono inserire nella tabella
    //lancia una SQLException nel caso in cui ci sia un errore con l'inserimento nel DB
    public int insertQuery(String table, HashMap<String, Object> params) throws SQLException {
        int i, j;
        Object par;
        String query = "insert INTO" + " " + table + " (";

        ArrayList<String> l = setToArray(params.keySet());

        query=this.virgole(l, query) + ")";
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
        
        //System.out.println(query + values);

        return this.eseguiUpdate(query + values);
    }
    
    //gestisce una query di acnellazione dalla tabella table all'interno del DB
    //Parametri: String table: nome della tabella da cui si vuole cancellare
    //           HashMap<String, Object> params: mappa contenente i nomi degli 
    //  attributi e i rispettivi valori secondo cui cancellare un elemento tramite la clausola where
    
    public int deleteQuery(String table, HashMap<String, Object> params) throws SQLException {
        int i = 0;
        Object p;

        String query = "DELETE FROM " + table;
        String values = " WHERE ";

        ArrayList<String> l = setToArray(params.keySet());
        
        String s=this.clausolaWhere(l, params);
        values=values+s;
        
        //System.out.println(query + values);
        return this.eseguiUpdate(query + values);
    }
    
    //quey di aggiornamento
    //Parametri: String table nome della tabella in cui si vuole aggiornare
    //           HashMap<String, Object> params: mappa contenente i nomi degli attributi
    //                                          e i corrispondenti valori che verranno aggiornati
    //           HashMap<String, Object> chiavi: mappa delle chiavi per la clausola where
    
    public int updateQuery(String table, HashMap<String, Object> params, HashMap<String, Object> chiavi) throws SQLException {
        int i = 0;
        Object p;

        String query = "UPDATE " + table;
        String values = " SET ";
        ArrayList<String> chiaviParams = setToArray(params.keySet());
        ArrayList<String> keys = setToArray(chiavi.keySet());

        if (chiaviParams.size() > 1) {
            for (i = 0; i < chiaviParams.size() - 1; i++) {
                p = params.get(chiaviParams.get(i));
                if (p instanceof String) {
                    p = "'" + p + "'";
                }
                values = values + chiaviParams.get(i) + " = " + p + ", ";
            }
        }
        p = params.get(chiaviParams.get(i));
        if (p instanceof String) {
            p = "'" + p + "'";
        }
        values = values + chiaviParams.get(i) + " = " + p;

        values = values + " WHERE ";
        String s= this.clausolaWhere(keys, chiavi);
        values=values+s;
        //System.out.println(query + values);

        return this.eseguiUpdate(query + values);
    }
    
    /* Effettua una query di selezione da una tabella e lancia un'eccezione nel caso ci siano problemi col database
    Parametri: String table nome della tabella da cui si vuole selezionare
               ArrayList<String> lista delle colonne della tabella che ci si vuol fare restituire
               HashMap<String, Object> mappa dei valori per la clausola where
    
    per selezionare tutta la tabella basta passare 2° e 3° parametro a null
    */
    public ResultSet selectionQuery(String table, ArrayList<String> colonne, HashMap<String, Object> dove) throws SQLException{
        ArrayList<String> chiavi;
        String fine;
        
        String query="SELECT ";
        String values= " FROM ";
        String luogo= " WHERE ";
        
        if(dove==null && colonne==null){
            query=query+"*";
            values=values+table;
            
            //System.out.println(query+values);
            return this.eseguiSelezione(query+values);
        }
        else if(colonne == null){
            query=query+"*";
            values=values+table;
            chiavi = this.setToArray(dove.keySet());
            fine= this.clausolaWhere(chiavi, dove);
            luogo = luogo+fine;
            
            //System.out.println(query+values+luogo);
            return this.eseguiSelezione(query+values+luogo);
        }
        else if(dove == null){
            query=this.virgole(colonne, query);
            values=values+table;
            //System.out.println(query+values);
            return this.eseguiSelezione(query+values);
        }
        
        query=this.virgole(colonne, query);
        values=values+table;
        chiavi=this.setToArray(dove.keySet());
        fine=this.clausolaWhere(chiavi, dove);
        luogo=luogo+fine;
        
        //System.out.println(query+values+luogo);
        return this.eseguiSelezione(query+values+luogo);
    }

    /*utility privata per consentire la manipolazione degli attributi per la 
        query in modo da aggiungere le virgole dopo i valori degli attributi
        rispettando la sintassi SQL
    */
    private String virgole(ArrayList<String> strings, String query){
        int i;
        for(i=0; i<strings.size()-1;i++){
            query = query + strings.get(i)+", ";
        }
        query=query+strings.get(i);
        return query;
    }
    
    /*  utility privata che consente, dato l'array delle chiavi e la mappa 
        dei parametri, restituisce la parte della query per la clausola where
        rispettando la sintassi SQL
    */
    private String clausolaWhere(ArrayList<String> array, HashMap<String, Object> cont){
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
    
    //utility per la tarsformazione di un set in un arrayList
    private ArrayList<String> setToArray(Set<String> set) {
        ArrayList<String> l = new ArrayList<>();
        for (String chiave : set) {
            l.add(chiave);
        }
        return l;
    }
    
    // utility per l'esecuzione effettiva della query di aggiornamento in senso
    // SQL lancia un'eccezione nel caso in cui si siano problemi con DB
    private int eseguiUpdate(String query) throws SQLException{
            Statement pt = c.createStatement();
            return pt.executeUpdate(query);
    }
    
    //utility per l'esecuzione di una query di selezione, lancia una eccexione
    // nel caso di problemi col DataBAse
    private ResultSet eseguiSelezione(String query) throws SQLException{
        Statement st;
        st = c.createStatement();
        return st.executeQuery(query);
    }
    
    //chiude la connesione con il DB, lancia un'eccezione in caso di errori
    public void chiudi() throws SQLException {
        this.c.close();
    }

}
