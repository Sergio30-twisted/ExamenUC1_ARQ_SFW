import com.mycompany.cajeromvc.control.CajeroControl;
import com.mycompany.cajeromvc.modelo.Cuenta;
import com.mycompany.cajeromvc.vista.CajeroView;

/**
 *
 * @author Sergio Aboytia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta("PLUTARCO ELIAS CALLES", "1234567890123456", 5000.00);
        CajeroView vista = new CajeroView();
        CajeroControl controlador = new CajeroControl(cuenta, vista);

        controlador.iniciar();
    
    }
    
}
