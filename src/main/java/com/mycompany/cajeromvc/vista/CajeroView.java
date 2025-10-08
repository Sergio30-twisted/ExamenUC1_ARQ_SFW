package com.mycompany.cajeromvc.vista;
import com.mycompany.cajeromvc.modelo.Cuenta;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Sergio Aboytia
 */
public class CajeroView {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenuRetiro(List<Double> montosDisponibles) {
        System.out.println("\n---- RETIRO DE EFECTIVO ----");
        System.out.println("Seleccione un monto a retirar:");
        for (int i = 0; i < montosDisponibles.size(); i++) {
            System.out.println((i + 1) + ". $" + montosDisponibles.get(i));
        }
        System.out.print("OpciOn: ");
    }

    public int leerOpcion() {
        return scanner.nextInt();
    }

    public void mostrarEstadoCuenta(Cuenta cuenta, double monto, double comision) {
        System.out.println("\n---- ESTADO DE CUENTA ----");
        System.out.println("Cliente: " + cuenta.getNombre());
        System.out.println("Saldo actual: $" + cuenta.getSaldo());
        System.out.println("Cantidad a retirar: $" + monto);
        System.out.println("Comision por retiro: $" + comision);
        double montoFinal = cuenta.getSaldo() - monto - comision;
        System.out.println("Saldo final si realiza el retiro: $" + montoFinal);
    }

    public boolean confirmarRetiro() {
        System.out.print("\n¿Desea retirar efectivo? (s/n): ");
        String respuesta = scanner.next();
        return respuesta.equalsIgnoreCase("s");
    }

    public void mostrarRecibo(Cuenta cuenta, double monto, double comision) {
        System.out.println("\n---- RECIBO DE RETIRO ----");
        String ultimos4 = cuenta.getNumeroCuenta()
                                .substring(cuenta.getNumeroCuenta().length() - 4);
        System.out.println("Cuenta: **** **** **** " + ultimos4);
        System.out.println("Cliente: " + cuenta.getNombre());
        System.out.println("Monto retirado: $" + monto);
        System.out.println("Comision aplicada: $" + comision);
        System.out.println("Gracias por usar nuestro cajero.\n");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
