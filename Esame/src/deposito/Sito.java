/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;

/**
 *
 * @author franc
 */
public class Sito {
    private String office;
    private String area;
    private String workspaceNote;

    public Sito(String office, String area) {
        this.office = office;
        this.area = area;
    }

    public Sito(String office, String area, String workspaceNote) {
        this.office = office;
        this.area = area;
        this.workspaceNote = workspaceNote;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getWorkspaceNote() {
        return workspaceNote;
    }

    public void setWorkspaceNote(String workspaceNote) {
        this.workspaceNote = workspaceNote;
    }
    
    
    
}
