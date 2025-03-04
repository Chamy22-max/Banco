package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<CuentaBancaria> lstCuentaBancaria = new ArrayList<>();

        int op1, op2, cuentaSeleccionada;
        double cantidad;
        String titular, numeroCuenta;
        double saldo;

        while (true) {
            System.out.println("MENÚ:");
            System.out.println("1. Agregar nueva cuenta");
            System.out.println("2. Realizar operación en cuenta");
            System.out.println("3. Ver cuentas");
            System.out.println("4. Salir");
            op1 = sc.nextInt();

            switch (op1) {
                case 1:
                    sc.nextLine();
                    System.out.println("Ingrese el nombre completo del titular (primer nombre y apellido):");
                    titular = sc.nextLine();

                    System.out.println("Ingrese el número de cuenta (solo números):");
                    numeroCuenta = sc.nextLine();
                    while (!numeroCuenta.matches("\\d+")) {
                        System.out.println("Error, intente nuevamente");
                        numeroCuenta = sc.nextLine();
                    }

                    System.out.println("Ingrese el monto:");
                    saldo = sc.nextDouble();

                    CuentaBancaria nuevaCuenta = new CuentaBancaria(titular, saldo, numeroCuenta);
                    lstCuentaBancaria.add(nuevaCuenta);
                    System.out.println("Cuenta creada con éxito.");
                    break;

                case 2:
                    System.out.println("Seleccione una cuenta:");
                    for (int i = 0; i < lstCuentaBancaria.size(); i++) {
                        System.out.println((i + 1) + ". " + lstCuentaBancaria.get(i).getTitular() + " - " + lstCuentaBancaria.get(i).getNumeroCuenta());
                    }
                    cuentaSeleccionada = sc.nextInt();

                    if (cuentaSeleccionada < 1 || cuentaSeleccionada > lstCuentaBancaria.size()) {
                        System.out.println("Error!!");
                        break;
                    }

                    CuentaBancaria cuenta = lstCuentaBancaria.get(cuentaSeleccionada - 1);

                    System.out.println("1. DEPOSITAR");
                    System.out.println("2. RETIRAR");
                    System.out.println("3. MOSTRAR SALDO");
                    op2 = sc.nextInt();

                    switch (op2) {
                        case 1:
                            System.out.println("Ingrese la cantidad a depositar:");
                            cantidad = sc.nextDouble();
                            cuenta.depositar(cantidad);
                            break;

                        case 2:
                            System.out.println("Ingrese la cantidad a retirar:");
                            cantidad = sc.nextDouble();
                            cuenta.retirar(cantidad);
                            break;

                        case 3:
                            cuenta.mostrarInformacion();
                            break;

                        default:
                            System.out.println("Error!!");
                    }
                    break;

                case 3:
                    System.out.println("Lista de cuentas:");
                    for (CuentaBancaria cuentaBancaria : lstCuentaBancaria) {
                        cuentaBancaria.mostrarInformacion();
                        System.out.println("-------------------------");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del sistema...");
                    return;

                default:
                    System.out.println("Error!!");
            }
        }
    }
}
