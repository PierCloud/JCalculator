package uni.c.calculator;


/*import*/
import javax.swing.JFrame;

/*
 *Gestore pannelli
 *classe utilizzata per lo swapping dei pannelli
 */
public final class GestorePannelli {

    private Menu mioMenu;
    private Calculator app;
    private final JFrame finestra;
    private Introduzione miaIntro;
    public int stato=0;

    /**
     Costruttore GestorePannelli
     @param finestra paramentro riferenete Al Jfarme frame
      * @throws java.lang.Exception

     */
    public GestorePannelli(JFrame finestra) throws Exception{
        System.out.println("SONO IN GESTORE");
        this.finestra=finestra;

        gestione();
    }

    /**
     *metodo gestione
     *effettua la gestione vera e proprio dello swap dei vari pannelli
     * @throws java.lang.Exception
     */
    public void gestione() throws Exception{


        if(stato==0){
            mioMenu=new Menu(finestra,this);
            mioMenu.setVisible(true);
            System.out.println("CARICO MENU");
        }

        else if(stato==1){
            miaIntro= new Introduzione(finestra,this);
            System.out.println("pannello app: "+stato);
            app=new Calculator(finestra,this);
            app.setVisible(true);
            mioMenu.setVisible(false);
            miaIntro.setVisible(true);

        }

        else if(stato==2){
            mioMenu.setVisible(true);
            app.setVisible(false);
            System.out.println("RICARICO MENU");
        }

        else if(stato==3){
            miaIntro= new Introduzione(finestra,this);
            miaIntro.setVisible(true);
            mioMenu.setVisible(false);

        }

        else if(stato==4){

            miaIntro.setVisible(false);
            mioMenu.setVisible(true);

        }

    }

}