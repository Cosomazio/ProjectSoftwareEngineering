/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import deposito.*;
import factories.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
        

/**
 *
 * @author Luigi
 */
public class PlannerDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String sc="";
        int scelta=0;
        String tipologia="";
        String descrizione="";
        String i="";
        String j="";
        String h="";
        String tipo="";
        int bool=0;
        Boolean b=false;
        int settimana=0;
        int tempo=0;
        
            
        PlannerBuilder builder= new PlannerBuilder();
        builder.reset("luca", "adminPlanner", "adminPlanner", "ciccio@ciccio.com");
        Planner p=builder.getResult();
        System.out.println("Benvenuto Planner "+p.getNome()+"\n");
        do{
            System.out.println("Scegli cosa fare: \n");
            System.out.println("1- Crea Attività\n");
            System.out.println("2- Modifica Attività \n");
            System.out.println("3- Cancella Attività \n");
            System.out.println("4- Assegna Manutentore \n");
            System.out.println("5- Visualizza ore manutentore\n");
            System.out.println("6- Tabella percentuali ore del manutentore \n");
            System.out.println("7- Arresta sistema \n");
            try{
            
            BufferedReader scanf= new BufferedReader(new InputStreamReader(System.in));
            sc= scanf.readLine();
            scelta=Integer.parseInt(sc);
            System.out.println("\n");
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
            
        if(scelta==1) {  
        
        System.out.println("Crea un'attività:\n ");
        System.out.println("Inserisci tipologia:");
        try{
            BufferedReader scanf= new BufferedReader(new InputStreamReader(System.in));
            tipologia= scanf.readLine();
            System.out.println("\n");
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Inserisci Descrizione: ");
        try{
            BufferedReader scanf= new BufferedReader(new InputStreamReader(System.in));
            descrizione= scanf.readLine();
            System.out.println("\n");
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Inserisci Tempo stimato: ");
        try{
            BufferedReader scanf= new BufferedReader(new InputStreamReader(System.in));
            i= scanf.readLine();
            tempo= Integer.parseInt(i);
            System.out.println("\n");
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Inserire settimana: ");
        try{
            BufferedReader scanf= new BufferedReader(new InputStreamReader(System.in));
            j= scanf.readLine();
            settimana= Integer.parseInt(j);
            System.out.println("\n");
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("inserisci se è interrompibile: (1=true,0=false)");
        try{
            BufferedReader scanf= new BufferedReader(new InputStreamReader(System.in));
            h= scanf.readLine();
            bool= Integer.parseInt(h);
            if (bool==1){
                b=true;
            }
            System.out.println("\n");
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
        try{
            do{
            System.out.println("Tipo Attività (valori ammessi: Planned, Unplanned, Extra, Ewo): \n"); 
            BufferedReader scanf= new BufferedReader(new InputStreamReader(System.in));
            tipo= scanf.readLine();
           
                
            }while(!(tipo.equals("Planned")|| tipo.equals("Unplanned") || tipo.equals("Extra") || tipo.equals("Ewo")));
            System.out.println("\n");
        
        ArrayList <String> a= new ArrayList<>();
        a.add("martello");
        a.add("cemento");
        Set <String> Competenze=new HashSet<>();
        Competenze.add("pippo");
        Competenze.add("paperino");
        File f=null;
        p.createActivity(new Sito("ufficio","area"), tipologia, descrizione, tempo,a, settimana, b,new Procedure(f,Competenze,"pippo") ,tipo);
        System.out.println("Elenco attività: \n");
        ArrayList <AbstractActivity> arr=p.viewActivities();
        for(AbstractActivity att : arr){
            System.out.println(att.toString()+"\n");
        }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        //end if
        }else if(scelta==2){
            //modifica
            int q=0;
            String num;
            int k;
            ArrayList <AbstractActivity> arr= p.viewActivities();
            System.out.println("Scegli quale modificare: \n");
            for(AbstractActivity att : arr){
            System.out.println(q+"- "+att.toString()+"\n");
            q++;
            }
            //prendi
            try{
            do{
            System.out.println("Inserisci un numero valido: \n"); 
            BufferedReader scanf= new BufferedReader(new InputStreamReader(System.in));
            num= scanf.readLine();
            k=Integer.parseInt(num);
                
            }while(!(k>=0 && k<arr.size()));
            System.out.println("\n");
            System.out.println("Inserisci tipologia: ");
        try{
            BufferedReader scanf= new BufferedReader(new InputStreamReader(System.in));
            tipologia= scanf.readLine();
            System.out.println("\n");
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Inserisci Descrizione: ");
        try{
            BufferedReader scanf= new BufferedReader(new InputStreamReader(System.in));
            descrizione= scanf.readLine();
            System.out.println("\n");
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Inserisci Tempo stimato: ");
        try{
            BufferedReader scanf= new BufferedReader(new InputStreamReader(System.in));
            i= scanf.readLine();
            tempo= Integer.parseInt(i);
            System.out.println("\n");
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Inserire settimana: ");
        try{
            BufferedReader scanf= new BufferedReader(new InputStreamReader(System.in));
            j= scanf.readLine();
            settimana= Integer.parseInt(j);
            System.out.println("\n");
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("inserisci se è interrompibile: (1=true,0=false)");
        try{
            BufferedReader scanf= new BufferedReader(new InputStreamReader(System.in));
            h= scanf.readLine();
            bool= Integer.parseInt(h);
            if (bool==1){
                b=true;
            }
            System.out.println("\n");
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
        
        ArrayList <String> a= new ArrayList<>();
        a.add("martello");
        a.add("cemento");
        Set <String> Competenze=new HashSet<>();
        Competenze.add("pippo");
        Competenze.add("paperino");
        File f=null;
        int index=arr.get(k).getClass().getName().indexOf('A');
        
        p.modifyActivity( arr.get(k),new Sito("ufficio","area"), tipologia, descrizione, tempo,a, settimana, b,new Procedure(f,Competenze,"pippo") );
        System.out.println("Elenco attività: \n");
        ArrayList <AbstractActivity> arro=p.viewActivities();
        for(AbstractActivity att : arro){
            System.out.println(att.toString()+"\n");
        }
                
        
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
          
            
        //end if    
        }else if(scelta==3){
        //cancella
            int q=0;
            String num;
            int k;
            ArrayList <AbstractActivity> arr= p.viewActivities();
            System.out.println("Scegli quale cancellare: \n");
            for(AbstractActivity att : arr){
            System.out.println(q+"- "+att.toString()+"\n");
            q++;
            }
            
            try{
            do{
            System.out.println("Inserisci un numero valido: \n"); 
            BufferedReader scanf= new BufferedReader(new InputStreamReader(System.in));
            num= scanf.readLine();
            k=Integer.parseInt(num);
                
            }while(!(k>=0 && k<arr.size()));
            System.out.println("\n");
            p.deleteActivity(arr.get(k));
            ArrayList <AbstractActivity> arro=p.viewActivities();
            for(AbstractActivity att : arro){
            System.out.println(att.toString()+"\n");
            }
            
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
            
        //end if
        }else if (scelta == 4){
            //assegna Mantainer
            int q=0;
            String num;
            int k;
            int kk;
            String gg;
            int giorno;
            String or;
            int ora;
            ArrayList <AbstractActivity> arr= p.sortedActivities();
            System.out.println("Scegli un'attività: \n");
            for(AbstractActivity att : arr){
            System.out.println(q+"- "+att.toString()+"\n");
            q++;
            }
            
            try{
            do{
            System.out.println("Inserisci un numero valido: \n"); 
            BufferedReader scanf= new BufferedReader(new InputStreamReader(System.in));
            num= scanf.readLine();
            k=Integer.parseInt(num);
                
            }while(!(k>=0 && k<arr.size()));
            
            //maintainer elenco
            SystemAdministrator admin=new SystemAdministrator("admin","admin","luigi","ciccio@ciccio.com",1);
            q=0;
            ArrayList <Maintainer> man=admin.viewMaintainer();
            System.out.println("Scegli Maintainer: \n");
            for(AbstractUtente att : man){
            System.out.println(q+"- "+att.toString()+"\n");
            q++;
            }
            
           
            do{
            System.out.println("Inserisci un numero valido: \n"); 
            BufferedReader scanf= new BufferedReader(new InputStreamReader(System.in));
            num= scanf.readLine();
            kk=Integer.parseInt(num);
                
            }while(!(kk>=0 && kk<man.size()));
                do{
                System.out.println("Inserisci giorno (tra 1 e 5):");
                
                BufferedReader scanf= new BufferedReader(new InputStreamReader(System.in));
                gg= scanf.readLine();
                giorno=Integer.parseInt(gg);    
                }while(!(giorno>=1 && giorno<=5));
                do{
                System.out.println("Inserisci orario:");
                 
                BufferedReader scanf= new BufferedReader(new InputStreamReader(System.in));
                 or= scanf.readLine();
                 ora=Integer.parseInt(or);
                }while(!((ora>=8 && ora<12)||(ora>=14 && ora<17)));
                HashMap<Integer,String> mappa=new HashMap<>();
                mappa.put(8, "o8_9");
                mappa.put(9, "o9_10");
                mappa.put(10, "o10_11");
                mappa.put(11, "o11_12");
                mappa.put(14, "o14_15");
                mappa.put(15, "o15_16");
                mappa.put(16, "o16_17");
                String orario=mappa.get(ora);
                p.assegnaMan(man.get(kk), arr.get(k), giorno, orario);
                System.out.println("Modifica avvenuta con successo \n");
                
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
            
            //end if
        }else if(scelta == 5){
            //stampa ore
             int q=0;
            String num;
            int k;
            String gg;
            int giorno;
            SystemAdministrator admin=new SystemAdministrator("admin","admin","luigi","ciccio@ciccio.com",1);
            q=0;
            ArrayList <Maintainer> man=admin.viewMaintainer();
            System.out.println("Scegli Maintainer: \n");
            for(AbstractUtente att : man){
            System.out.println(q+"- "+att.toString()+"\n");
            q++;
            }
            
            try{
            do{
            System.out.println("Inserisci un numero valido: \n"); 
            BufferedReader scanf= new BufferedReader(new InputStreamReader(System.in));
            num= scanf.readLine();
            k=Integer.parseInt(num);   
            }while(!(k>=0 && k<man.size()));
            
            do{
                System.out.println("Inserisci giorno (tra 1 e 5):");
                
                BufferedReader scanf= new BufferedReader(new InputStreamReader(System.in));
                gg= scanf.readLine();
                giorno=Integer.parseInt(gg);    
            }while(!(giorno>=1 && giorno<=5));
            
            HashMap <Integer,Integer> mappa=p.maintainerAval(man.get(k), giorno);
            HashMap<String,String> mappabuona=new HashMap<>();
            for(int io=1;io<=mappa.size();io++){
                Integer cc=mappa.get(io);
                switch (io) {
                    case 1:
                        mappabuona.put("o8_9 ", cc+" minuti");
                        break;
                    case 2:
                        mappabuona.put("o9_10 ", cc+" minuti");
                        break;
                    case 3:
                        mappabuona.put("o10_11 ", cc+" minuti");
                        break;
                    case 4:
                        mappabuona.put("o11_12 ", cc+" minuti");
                        break;
                    case 5:
                        mappabuona.put("o14_15 ", cc+" minuti");
                        break;
                    case 6:
                        mappabuona.put("o15_16 ", cc+" minuti");
                        break;
                    case 7:
                        mappabuona.put("o16_17 ", cc+" minuti");
                        break;
                    default:
                        break;
                }
                
            }
                System.out.println("Giorno = "+giorno+" "+mappabuona.toString());
                System.out.println("\n");
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        //end if
        }else if(scelta==6){
            int q;
            String num;
            int k;
            SystemAdministrator admin=new SystemAdministrator("admin","admin","luigi","ciccio@ciccio.com",1);
            q=0;
            ArrayList <Maintainer> man=admin.viewMaintainer();
            System.out.println("Scegli Maintainer: \n");
            for(AbstractUtente att : man){
            System.out.println(q+"- "+att.toString()+"\n");
            q++;
            }
            
            try{
            do{
            System.out.println("Inserisci un numero valido: \n"); 
            BufferedReader scanf= new BufferedReader(new InputStreamReader(System.in));
            num= scanf.readLine();
            k=Integer.parseInt(num);   
            }while(!(k>=0 && k<man.size()));
            
            ArrayList<HashMap> mappa=p.maintainerAvalPerc(man.get(k));
            
            int w=1;
            HashMap <String,Object> mappa1=new HashMap<>();
            for (int r=0; r<mappa.size(); r++){
                mappa1=mappa.get(r);
                System.out.println("Giorno "+w+" = "+mappa1.toString());
                w++;
            }
                System.out.println("\n");
            
            
            
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }else if(scelta==7){
            break;
        }else{
            System.out.println("Inserisci un numero valido \n");
        }
        
        }while(true);
        
        
        
    }
    
}
