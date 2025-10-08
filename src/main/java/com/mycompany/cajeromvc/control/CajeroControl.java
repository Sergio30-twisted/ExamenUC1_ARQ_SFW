package com.mycompany.cajeromvc.control;

import com.mycompany.cajeromvc.modelo.Cuenta;
import com.mycompany.cajeromvc.vista.CajeroView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sergio Aboytia
 */
public class CajeroControl {
    private Cuenta cuenta;
    private CajeroView vista;
    private List<Double> montosDisponibles;

    public CajeroControl(Cuenta cuenta, CajeroView vista) {
        this.cuenta = cuenta;
        this.vista = vista;
        this.montosDisponibles = generarMontos();
    }

    private List<Double> generarMontos() {
        List<Double> montos = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            montos.add(i * 200.0);
        }
        return montos;
    }

    public void iniciar() {
        vista.mostrarMenuRetiro(montosDisponibles);
        int opcion = vista.leerOpcion();

        if (opcion < 1 || opcion > montosDisponibles.size()) {
            vista.mostrarMensaje("Opcion inválida.");
            return;
        }

        double monto = montosDisponibles.get(opcion - 1);
        double comision = calcularComision(monto);

        vista.mostrarEstadoCuenta(cuenta, monto, comision);

        if (vista.confirmarRetiro()) {
            if (cuenta.getSaldo() >= (monto + comision)) {
                cuenta.retirar(monto, comision);
                vista.mostrarRecibo(cuenta, monto, comision);
            } else {
                vista.mostrarMensaje("Fondos insuficientes para realizar el retiro.");
            }
        } else {
            vista.mostrarMensaje("Operacion cancelada por el usuario.");
        }
    }

    private double calcularComision(double monto) {
        return monto * 0.01; 
    }
}
