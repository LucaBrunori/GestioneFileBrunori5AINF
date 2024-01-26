package gestionefile;

import java.util.Scanner;
/**
 *
 * @author Luca Brunori
 * @version 12/01/23
 */
public class GestioneFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        //1)LETTURA
        Lettore lettore = new Lettore("user.json");
        lettore.start();
        
        //2)ELABORAZIONE
        //INSERIRE US PWD
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Inserisci l'username: ");
        String username = scanner.nextLine();
        
        System.out.print("Inserisci la password: ");
        String password = scanner.nextLine();
        
        
        scanner.close();
        //3) SCRITTURA
        Scrittore scrittore = new Scrittore("output.csv");
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
        //FileInputStream inputStream = new FileInputStream(inFile);
    }
    
}
