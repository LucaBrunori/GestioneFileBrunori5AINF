package gestionefile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luca Brunori
 * @version 26/01/23
 */

public class Scrittore implements Runnable{

    String nomeFile;
    String username;
    String password;
    
    public Scrittore(String nomeFile){
        this.nomeFile = nomeFile;
    }
    
    public Scrittore(String nomeFile, String username, String password){
        this.nomeFile = nomeFile;
        this.username = username;
        this.password = password;
    }
    
    @Override
    public void run() {
        scriviUP();
    }
    /**
     * Scrive un file di testo usando la classe BufferedWriter
     */
    public void scriviUP(){
        BufferedWriter br=null;
        
        try {
            //1) apro il file
            br = new BufferedWriter(
                    new FileWriter(nomeFile));
            //2) scrivo nel buffer
            br.write(username + ";" + password);
            br.write("\n\r");
            //3) svuoto il buffer e salvo nel file i dati
            br.flush();         
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (br!=null)
                try {
                    //4)chiudo lo stream in uscita
                    br.close();
            } catch (IOException ex) {
                Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
    }
}
