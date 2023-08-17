/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica1;

/**
 *
 * @author Usuario
 */
import java.util.Scanner;

public class ArrendadoraDeAutos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] inventario = new String[100][4]; // Matriz para almacenar el inventario (marca, modelo, cantidad, precio)
        String[] clientes = new String[100]; // Vector para almacenar nombres de clientes
        int[] reservaciones = new int[100]; // Vector para almacenar reservaciones de clientes
        String adminUsername = "admin";
        String adminPassword = "password";
        boolean adminLoggedIn = false;
        boolean clientLoggedIn = false;
        int clienteActual = -1;

        while (true) {
            System.out.println("Bienvenido a la Arrendadora de Autos");
            System.out.println("1. Iniciar sesión como administrador");
            System.out.println("2. Iniciar sesión como cliente");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después del entero

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de usuario: ");
                    String username = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    String password = scanner.nextLine();
                    
                    if (username.equals(adminUsername) && password.equals(adminPassword)) {
                        adminLoggedIn = true;
                        System.out.println("Sesión de administrador iniciada.");
                    } else {
                        System.out.println("Nombre de usuario o contraseña incorrectos.");
                    }
                    break;
                
                case 2:
                    if (adminLoggedIn) {
                        System.out.println("Ya has iniciado sesión como administrador.");
                        break;
                    }
                    System.out.print("Ingrese su nombre: ");
                    String nombreCliente = scanner.nextLine();
                    clienteActual = buscarCliente(clientes, nombreCliente);
                    
                    if (clienteActual == -1) {
                        clienteActual = registrarCliente(clientes, nombreCliente);
                    }
                    clientLoggedIn = true;
                    System.out.println("Sesión de cliente iniciada.");
                    break;
                
                case 3:
                    System.out.println("¡Hasta luego!");
                    System.exit(0);
                    break;
                
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
            
            if (adminLoggedIn) {
                // Aquí iría el código para las opciones del administrador (agregar vehículos, emitir reportes, etc.)
            }
            
            if (clientLoggedIn) {
                // Aquí iría el código para las opciones del cliente (realizar reservaciones, aplicar descuentos, etc.)
            }
        }
    }

    // Método para buscar un cliente en el vector de clientes
    public static int buscarCliente(String[] clientes, String nombre) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null && clientes[i].equals(nombre)) {
                return i;
            }
        }
        return -1;
    }

    // Método para registrar un nuevo cliente
    public static int registrarCliente(String[] clientes, String nombre) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
                clientes[i] = nombre;
                return i;
            }
        }
        return -1; // No se pudo registrar el cliente
    }
}
