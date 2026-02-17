package Main;

import Model.Dispositivo;
import View.VistaTechWorld;
import java.util.Scanner;

public class TechWorldApp {

    public static void main(String[] args) {

        VistaTechWorld View = new VistaTechWorld();
        Dispositivo dispositivo = null;
        Scanner sc = View.getScanner();
        int opcion;

        do {
            opcion = View.MostrarMenuPrincipal();

            switch (opcion) {

                case 1:
                    System.out.println("=== CREAR NUEVO DISPOSITIVO ===");
                    sc.nextLine();

                    System.out.print("Ingrese código(formato TIPO-###, ej: CEL-001): ");
                    String codigo = sc.nextLine();

                    System.out.print("Ingrese tipo (CELULAR/LAPTOP/TABLET): ");
                    String tipo = sc.nextLine();

                    System.out.print("Ingrese marca: ");
                    String marca = sc.nextLine();

                    System.out.print("Ingrese modelo: ");
                    String modelo = sc.nextLine();

                    System.out.print("Ingrese precio: ");
                    double precio = sc.nextDouble();

                    dispositivo = new Dispositivo(codigo, tipo, marca, modelo, precio);

                    System.out.println("\nDispositivo creado exitosamente.");
                    System.out.println("Stock inicial: 0 unidades");
                    System.out.println("Garantía: 3 meses");
                    System.out.println("¿En oferta?: " + (dispositivo.isEnOferta() ? "SI" : "NO"));
                    View.stop();
                    break;

                case 2:
                    if (dispositivo == null) {
                        System.out.println("No hay dispositivo creado.");
                    } else {
                        dispositivo.mostrarInformacion();
                    }
                    View.stop();
                    break;

                case 3:
                    if (dispositivo == null) {
                        System.out.println("No hay dispositivo creado.");
                        break;
                    }

                    System.out.println("1. Marca");
                    System.out.println("2. Modelo");
                    System.out.println("3. Precio");
                    System.out.println("4. Stock");
                    System.out.println("5. Garantía");
                    System.out.print("Seleccione: ");
                    int mod = sc.nextInt();
                    sc.nextLine();

                    switch (mod) {
                        case 1:
                            System.out.print("Nueva marca: ");
                            dispositivo.setMarca(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Nuevo modelo: ");
                            dispositivo.setModelo(sc.nextLine());
                            break;
                        case 3:
                            System.out.print("Nuevo precio: ");
                            dispositivo.setPrecio(sc.nextDouble());
                            break;
                        case 4:
                            System.out.print("Nuevo stock: ");
                            dispositivo.setStock(sc.nextInt());
                            break;
                        case 5:
                            System.out.print("Nueva garantía: ");
                            dispositivo.setGarantiaMeses(sc.nextInt());
                            break;
                    }
                    View.stop();
                    break;

                case 4:
                    if (dispositivo == null) {
                        System.out.println("No hay dispositivo creado.");
                        break;
                    }

                    System.out.print("Ingrese porcentaje descuento: ");
                    double porcentaje = sc.nextDouble();

                    double nuevoPrecio = dispositivo.calcularPrecioOferta(porcentaje);
                    System.out.printf("Precio con descuento: $%,.2f%n", nuevoPrecio);
                    View.stop();
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }
}
