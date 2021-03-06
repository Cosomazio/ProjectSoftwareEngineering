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
    public enum MaintainerState{
        received("received"),sent("sent"),read("read");
        private String status;
        MaintainerState(String manStat) {
            this.status = manStat;
        }
        public String getString() {
            return status;
        }
    };
    private MaintainerState manStatus;
    
    public enum AreaState{
        received("received"),sent("sent"),notSent("notSent");
        private String status;
        AreaState(String areaStat) {
            this.status = areaStat;
        }
        public String getString() {
            return status;
        }
    };
    private AreaState areaStatus;
    
    public enum GeneralState{
        notStarted("notStarted"),inProgress("inProgress"),closed("closed");
        private String status;
        GeneralState(String genStat) {
            this.status = genStat;
        }
        public String getString() {
            return status;
        }
    };
    private GeneralState generalStatus;
    
    public EwoActivity(int ewoId,int id, Sito sito, String tipologia, String descrizione, int tempo, List<String> materiali, int week, Boolean interrompibile, Procedure procedura,String wnotes) {
        super(id, sito, tipologia, descrizione, tempo, materiali, week, interrompibile, procedura,wnotes);
        this.ewoID=ewoId;
        this.manStatus=MaintainerState.read;
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
