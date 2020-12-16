/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;

/**
 *
 * @author Luigi
 */
public interface InterfaceUtente {
    public String getUsername();
    public String getPassword();
    public String getNome();
    public String getEmail();
    public int getId();
    public void setUsername(String username);
    public void setPassword(String password);
    public void setNome(String nome);
    public void setEmail(String email);
    public void setId(int id);
    public String toString();
    public int hashCode();
    public boolean equals(Object obj);
}
