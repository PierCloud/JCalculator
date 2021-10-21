package uni.c.calculator;
/*
 CLASSE GUI PANNELLO INTRODUZIONE
 */

/*import*/
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 Classe dedicata al Pannello introduzione
 pannello esplicativo
 */
public  class Introduzione extends JPanel implements ActionListener{

    private final CaricatoreImmagini mioCaricatoreI;

    private BufferedImage sfondo;
    private BufferedImage bottoneSinistra;
    private BufferedImage bottoneDestra;
    private BufferedImage bottoneIndietro;
    private BufferedImage bottoneAvanti;
    private BufferedImage bottonePanel;
    private BufferedImage bottoneAuto;
    private BufferedImage bottoneStart;

    private ImageIcon iconaDestra;
    private ImageIcon iconaSinistra;
    private ImageIcon iconaIndietro;
    private ImageIcon iconaAvanti;
    private ImageIcon iconaPanel;
    private ImageIcon iconaAuto;
    private ImageIcon iconaStart;

    private JButton pulsanteDestra;
    private JButton pulsanteSinistra;
    private JButton pulsanteIndietro;
    private JButton pulsanteAvanti;
    private JButton pulsantePanel;
    private JButton pulsanteAuto;
    private JButton pulsanteStart;

    private JFrame finestra;
    private GestorePannelli gestore;

    private int stato;
    private boolean caricate=false;



    /**
     Costruttore Pannello introduzione
     @param finestra JFrame frame
      * @param gestore GestorePannelli
     */
    public Introduzione (JFrame finestra,GestorePannelli gestore){
        System.out.println("COSTRUTTORE - Intro");
        this.gestore=gestore;
        this.finestra=finestra;
        mioCaricatoreI=new CaricatoreImmagini();


        System.out.println(stato);
        System.out.println(gestore.stato);

        if(gestore.stato==3){
            caricaImmagini();
        }

        if(gestore.stato==1){
            caricaImmagini();
        }
        if(caricate){
            System.out.println("caricate");
            setLayout(null);
            finestra.getContentPane().add(this);
            pulsanteStart=new JButton(iconaStart);
            pulsanteStart.setFocusPainted(false);
            pulsanteStart.setContentAreaFilled(false);
            pulsanteStart.setOpaque(false);
            pulsanteStart.setBorder(null);
            pulsanteStart.setLocation(800,490);
            pulsanteStart.setSize(210,210);
            pulsanteStart.addActionListener(this);
            add(pulsanteStart);
            System.out.println("caricate");

        }



    }


    /*
      metodo carica immagini
      Button Cliccabili START
      */
    public void caricaImmagini(){

        sfondo=mioCaricatoreI.caricatoreImmagini("Cattura.PNG");

        bottoneStart=mioCaricatoreI.caricatoreImmagini("start.png");
        iconaStart=mioCaricatoreI.caricaIcona(bottoneStart);
        iconaStart.getImage();
        this.caricate=true;
        System.out.println("carica_imm");


    }

    /**
     Ovveride metodo Awt paint compoent
     * caricamento sfondo
     @param grafica paramentro di assegnazione

     */
    @Override
    public void paintComponent(Graphics grafica){

        super.paintComponent(grafica);
        grafica.drawImage(sfondo, 0,0,1080,720,null);
        System.out.println("paint");

    }


    /**
     MouseEntered visualizzazione pulsanti
     * caricamento sfondo
     @param me di tipo : Mouse event
     */
    public void mouseEntered(MouseEvent me) {

        pulsanteDestra.setFocusPainted(true);
        pulsantePanel.setFocusPainted(true);

    }

    /**
     actionPerformed metodo attivabile tramite click
     * effettua un cambiamento del frame visualizzato
     gestisce il cambio dei pannelli
     */
    @Override
    public void actionPerformed(ActionEvent ae){

        gestore.stato=4;
        System.out.println("pannello");
        try {
            gestore.gestione();
        } catch (Exception ex) {
            Logger.getLogger(Introduzione.class.getName()).log(Level.SEVERE, null, ex);
        }

    }



}
