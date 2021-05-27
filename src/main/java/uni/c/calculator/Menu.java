package uni.c.calculator;
/*import*/
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 Classe dedicata al Pannello Menu'
 pannello di avvio
 */
public  class Menu extends JPanel implements ActionListener{

    private CaricatoreImmagini mioCaricatoreI;
    private BufferedImage sfondo;
    private BufferedImage iconaUni;
    private BufferedImage bottoneStart;
    private ImageIcon iconaStart;
    private JButton pulsanteStart;
    private JButton pulsantePanel;
    private ImageIcon iconaInfo;
    private BufferedImage bottoneInfo;
    private JFrame finestra;
    private GestorePannelli gestore;
    private int stato;
    private boolean caricate=false;


    /**
     Costruttore Pannello Menu
     @param finestra JFrame frame
      * @param gestore GestorePannelli
     */
    public Menu(JFrame finestra,GestorePannelli gestore){
        System.out.println("COSTRUTTORE MENU'");
        this.gestore=gestore;
        this.finestra=finestra;
        mioCaricatoreI=new CaricatoreImmagini();

        System.out.println(stato);
        System.out.println(gestore.stato);

        if(gestore.stato==0){
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

            pulsantePanel=new JButton(iconaInfo);
            pulsantePanel.setFocusPainted(false);
            pulsantePanel.setContentAreaFilled(false);
            pulsantePanel.setOpaque(false);
            pulsantePanel.setBorder(null);
            pulsantePanel.setLocation(-300,495);
            pulsantePanel.setSize(900,200);
            pulsantePanel.addMouseListener(new MioListner());
            add(pulsantePanel);

            JLabel LABEL1 = new JLabel("CALCOLATRICE");
            LABEL1.setForeground(Color.DARK_GRAY);
            LABEL1.setFont(new Font("CALCOLATRICE-AUTOMATED", Font.PLAIN, 40));
            LABEL1.setBounds(100,-50,2000,200);
            add(LABEL1);


            JLabel LABEL2 = new JLabel("A CURA DI : Piergiuseppe Di Pilla");
            LABEL2.setForeground(Color.gray);
            LABEL2.setFont(new Font("CALCOLATRICE-AUTOMATED", Font.PLAIN, 25));
            LABEL2.setBounds(150,300,2000,200);
            add(LABEL2);
        }

    }

    /*
      metodo carica immagini
      Button Cliccabili START,INFO
      */
    public void caricaImmagini(){

        sfondo=mioCaricatoreI.caricatoreImmagini("src/main/java/immagini/sfondo.jpg");
        bottoneStart=mioCaricatoreI.caricatoreImmagini("src/main/java/immagini/start.png");
        iconaStart=mioCaricatoreI.caricaIcona(bottoneStart);
        iconaUni=mioCaricatoreI.caricatoreImmagini("src/main/java/immagini/logo_uni.png");
        bottoneInfo=mioCaricatoreI.caricatoreImmagini("src/main/java/immagini/pulsante_info.png");
        iconaInfo=mioCaricatoreI.caricaIcona(bottoneInfo);
        iconaInfo.getImage();
        iconaStart.getImage();
        this.caricate=true;

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
        grafica.drawImage(iconaUni,250,100,500,250,this);

    }



    /**
     actionPerformed metodo attivabile tramite click
     * effettua un cambiamento del frame visualizzato
     gestisce il cambio dei pannelli
     */
    @Override
    public void actionPerformed(ActionEvent ae){

        gestore.stato=1;
        System.out.println("cliuck2");
        try {
            gestore.gestione();
        } catch (Exception ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * MioListner
     metodo che permette di tornare al pannello precedente
     */
    private class MioListner extends MouseAdapter{

        public void mouseClicked(MouseEvent me) {

            gestore.stato=3;
            System.out.println("cliuck");
            try {
                gestore.gestione();
            } catch (Exception ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public void mousePressed(MouseEvent me) {

        }
        public void mouseReleased(MouseEvent me) {

        }

    }

}
