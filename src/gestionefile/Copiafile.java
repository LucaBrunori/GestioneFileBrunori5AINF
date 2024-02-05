package gestionefile;

import java.nio.file.*;

public class Copiafile {
    String percorsoInput;
    String percorsoOutput;

    public Copiafile(String percorsoInput, String percorsoOutput) {
        this.percorsoInput = percorsoInput;
        this.percorsoOutput = percorsoOutput;
    }
/*La parte qui sottostante mi dava problemi e rimanendoci bloccato quasi una settimana ho
chiesto a chatgpt di correggere il codice però tutt'ora non copia
 */
    public void copiaFile() {
        try {
            // Ottieni i percorsi dei file
            Path pathInput = Paths.get(percorsoInput);
            Path pathOutput = Paths.get(percorsoOutput);
            byte[] content = Files.readAllBytes(pathInput);
            Files.copy(pathInput, pathOutput, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Il file è stato copiato con successo.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

