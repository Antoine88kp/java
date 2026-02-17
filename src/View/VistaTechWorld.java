package View;

import java.util.Scanner;

public class VistaTechWorld {

    public Scanner scanner = new Scanner(System.in);

    public int MostrarMenuPrincipal() {
        System.out.println("=================================================");
        System.out.println("    TECHWORLD - SISTEMA DE DISPOSITIVOS");
        System.out.println("=================================================");
        System.out.println("1. Crear nuevo dispositivo");
        System.out.println("2. Ver información del dispositivo actual");
        System.out.println("3. Modificar datos del dispositivo");
        System.out.println("4. Aplicar descuento y ver precio final");
        System.out.println("0. Salir");
        System.out.println("=================================================");

        System.out.print("Seleccione opción:  ");
        return scanner.nextInt();
    }

    public void stop() {
        System.out.println("\nPresione ENTER para continuar...");
        scanner.nextLine();
        scanner.nextLine();
    }

    public Scanner getScanner() {
        return scanner;
    }
}
