package uni.c.calculator;

/*import*/
import java.awt.Dimension;
import javax.swing.JFrame;


/**
 * Classe Frame
 * rappresenta la finestra Frame di visualizzazione pannelli
 */
public  class Frame {

    private final String name= " INTERFACCIA";
    private final int larghezza=1080;
    private final int altezza=710;
    private GestorePannelli gestore;
    public int frameX=0;

    public Frame() throws Exception{

        JFrame finestra=new JFrame("INTERFACCIA_1");
        Dimension dimensioneGioco=new Dimension(larghezza,altezza);
        finestra.setPreferredSize(dimensioneGioco);
        finestra.setResizable(false);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gestore=new GestorePannelli(finestra);
        finestra.pack();
        finestra.setVisible(true);

    }


}