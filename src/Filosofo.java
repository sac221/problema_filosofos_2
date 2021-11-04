import java.util.logging.Level;
import java.util.logging.Logger;

public class Filosofo extends Thread{
    private int id_filosofo;
    private Palillo izda, dcha;
    private Silla silla;

    public Filosofo (int id_filosofo, Palillo izda,Palillo dcha, Silla silla){
        this. id_filosofo=id_filosofo;
        this.izda=izda;
        this.dcha=dcha;
        this.silla=silla;
    }

    public void run(){
        while(true){
            try{
                silla.ocupar_silla(id_filosofo);
                izda.agarrarPalillo(id_filosofo);
                dcha.agarrarPalillo(id_filosofo);
                //comer
                dcha.dejarPalillo(id_filosofo);
                izda.dejarPalillo(id_filosofo);
                silla.libres_sillas(id_filosofo);
            }catch (InterruptedException exception){
                Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, exception);
            }
        }
    }
}
