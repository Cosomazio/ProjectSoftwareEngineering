/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;

import java.util.*;

/**
 *
 * @author tomma
 */
public abstract class AbstractActivity implements InterfaceActivity {
    private int id;
    private Sito sito;
    private String tipologia;
    private String descrizione;
    private int tempo;
    private List<String> materiali;
    private int week;
    private Boolean interrompibile;
    private Procedure procedura;
    
    public AbstractActivity(int id, Sito sito,String tipologia,
             String descrizione,int tempo,List<String> materiali,
                int week,Boolean interrompibile,Procedure procedura){
        this.id=id;
        this.sito=sito;
        this.tipologia=tipologia;
        this.descrizione=descrizione;
        this.tempo=tempo;
        this.materiali=materiali;
        this.week=week;
        this.interrompibile=interrompibile;
        this.procedura=procedura;
    }

    @Override
    public String toString() {
        return "AbstractActivity{" + "id=" + id + ", sito=" + sito + ", tipologia=" + tipologia + ", descrizione=" + descrizione + ", tempo=" + tempo + ", materiali=" + materiali + ", week=" + week + ", interrompibile=" + interrompibile + ", procedura=" + procedura + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sito getSito() {
        return sito;
    }

    public void setSito(Sito sito) {
        this.sito = sito;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public List<String> getMateriali() {
        return materiali;
    }

    public void setMateriali(List<String> materiali) {
        this.materiali = materiali;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public Boolean getInterrompibile() {
        return interrompibile;
    }

    public void setInterrompibile(Boolean interrompibile) {
        this.interrompibile = interrompibile;
    }

    public Procedure getProcedura() {
        return procedura;
    }

    public void setProcedura(Procedure procedura) {
        this.procedura = procedura;
    }
    
}
