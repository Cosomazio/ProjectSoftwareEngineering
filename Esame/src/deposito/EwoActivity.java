/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;

import java.util.List;

/**
 *
 * @author Luigi
 */
public class EwoActivity extends UnplannedActivity{
    private int ewoID;
    public enum MaintainerState{sent,received,read};
    private MaintainerState manStatus;
    public enum AreaState{received,sent,notSent};
    private AreaState areaStatus;
    public enum GeneralState{notStarted,inProgress,closed};
    private GeneralState generalStatus;
    public EwoActivity(int ewoId,int id, Sito sito, String tipologia, String descrizione, int tempo, List<String> materiali, int week, Boolean interrompibile, Procedure procedura,String wNotes) {
        super(id, sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura,wNotes);
        this.ewoID=ewoId;
        this.manStatus=MaintainerState.sent;
        this.areaStatus=AreaState.notSent;
        this.generalStatus=GeneralState.notStarted;
    }
    
    
    
    @Override
    public String toString() {
        return super.toString()+"EwoActivity{" + "ewoID=" + ewoID + '}';
    }

    public int getEwoID() {
        return ewoID;
    }

    public void setEwoID(int ewoID) {
        this.ewoID = ewoID;
    }

    public MaintainerState getManStatus() {
        return manStatus;
    }

    public void setManStatus(MaintainerState manStatus) {
        this.manStatus = manStatus;
    }

    public AreaState getAreaStatus() {
        return areaStatus;
    }

    public void setAreaStatus(AreaState areaStatus) {
        this.areaStatus = areaStatus;
    }

    public GeneralState getGeneralStatus() {
        return generalStatus;
    }

    public void setGeneralStatus(GeneralState generalStatus) {
        this.generalStatus = generalStatus;
    }
    
    
}
