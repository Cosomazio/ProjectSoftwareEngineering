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
public interface InterfaceActivity {
    public String toString();
    public int getId();
    public void setId(int id);
    public Sito getSito();
    public void setSito(Sito sito);
    public String getTipologia();
    public void setTipologia(String tipologia);
    public String getDescrizione();
    public void setDescrizione(String descrizione);
    public int getTempo();
    public void setTempo(int tempo);
    public List<String> getMateriali();
    public void setMateriali(List<String> materiali);
    public int getWeek();
    public void setWeek(int week);
    public Boolean getInterrompibile();
    public void setInterrompibile(Boolean interrompibile);
    public Procedure getProcedura();
    public void setProcedura(Procedure procedura);
    public String getWnotes();
    public void setWnotes(String wNotes);
    public List<String> getCompetenze();
    public void setCompetenze(List<String> competenze);
    public int compareTo(Object other);
}
