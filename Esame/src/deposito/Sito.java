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

    public Sito(String office, String area) {
        this.office = office;
        this.area = area;
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

    @Override
    public String toString() {
        return "Sito{" + "office=" + office + ", area=" + area + '}';
    }
    
    
    
}
