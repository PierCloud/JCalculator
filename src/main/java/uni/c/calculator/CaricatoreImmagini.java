package uni.c.calculator;

/*
CLASSE GUI CARICATORE IMMAGINI
 */


/*import*/
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Caricatore immagini
 classe che viene usata per il caricamento delle immagini
 * contenute nella cartella immagini
 */
public class CaricatoreImmagini {
    private BufferedImage immagine;
    private ImageIcon icona;

    /**
     * metodo carica immagini
     * @param posizione
     * @return immagine (image)
     */
    public BufferedImage caricatoreImmagini(String posizione){

        try {
            //serve per Andare nella cartella risorse e caricare le immagine la contenute
            immagine=ImageIO.read(getClass().getClassLoader().getResource(posizione));
        } catch (IOException ex) {
            Logger.getLogger(CaricatoreImmagini.class.getName()).log(Level.SEVERE, null, ex);
        }

        return immagine;

    }

    /**
     * metodo carica icone
     * @param image
     * @return icona
     */
    public ImageIcon caricaIcona(BufferedImage image){

        icona = new ImageIcon(image);
        return icona;

    }


}
