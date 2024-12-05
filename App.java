import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        List<Cliente> listaClientes = new ArrayList<>();
        Operaciones operaciones = new Operaciones(listaClientes);

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Crear cliente");
            System.out.println("2. Abrir cuenta");
            System.out.println("3. Depositar");
            System.out.println("4. Retirar");
            System.out.println("5. Consultar saldo");
            System.out.println("6. Listar clientes");
            System.out.println("7. Recuperar cuentas de un cliente");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el ID del cliente: ");
                    Long idCliente = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();

                    Cliente nuevoCliente = operaciones.crearCliente(idCliente, nombreCliente);
                    System.out.println("Cliente creado con éxito: " + nuevoCliente.getNombreCliente());
                    break;

                case 2:
                    System.out.print("Ingrese el ID del cliente para abrir una cuenta: ");
                    Long idClienteCuenta = scanner.nextLong();
                    scanner.nextLine();
                    Cliente clienteCuenta = operaciones.buscarClienteId(idClienteCuenta);

                    if (clienteCuenta != null) {
                        System.out.print("Ingrese el saldo inicial de la cuenta: ");
                        int saldo = scanner.nextInt();
                        scanner.nextLine();
                        operaciones.abrirCuenta(clienteCuenta, saldo);
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el ID del cliente: ");
                    Long idClienteDeposito = scanner.nextLong();
                    scanner.nextLine();
                    Cliente clienteDeposito = operaciones.buscarClienteId(idClienteDeposito);

                    if (clienteDeposito != null) {
                        System.out.print("Ingrese el ID de la cuenta: ");
                        Long idCuentaDeposito = scanner.nextLong();
                        scanner.nextLine();
                        System.out.print("Ingrese el monto a depositar: ");
                        double montoDeposito = scanner.nextDouble();
                        scanner.nextLine();
                        operaciones.depositar(clienteDeposito, idCuentaDeposito, montoDeposito);
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el ID del cliente: ");
                    Long idClienteRetiro = scanner.nextLong();
                    scanner.nextLine();
                    Cliente clienteRetiro = operaciones.buscarClienteId(idClienteRetiro);

                    if (clienteRetiro != null) {
                        System.out.print("Ingrese el ID de la cuenta: ");
                        Long idCuentaRetiro = scanner.nextLong();
                        scanner.nextLine();
                        System.out.print("Ingrese el monto a retirar: ");
                        double montoRetiro = scanner.nextDouble();
                        scanner.nextLine();
                        operaciones.retirar(clienteRetiro, idCuentaRetiro, montoRetiro);
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese el ID del cliente: ");
                    Long idClienteConsulta = scanner.nextLong();
                    scanner.nextLine();
                    Cliente clienteConsulta = operaciones.buscarClienteId(idClienteConsulta);

                    if (clienteConsulta != null) {
                        System.out.print("Ingrese el ID de la cuenta: ");
                        Long idCuentaConsulta = scanner.nextLong();
                        scanner.nextLine();
                        operaciones.consultarSaldo(clienteConsulta, idCuentaConsulta);
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("Lista de clientes:");
                    for (Cliente cliente : operaciones.obtenerClientes()) {
                        System.out.println("ID: " + cliente.getIdCliente() + ", Nombre: " + cliente.getNombreCliente());
                    }
                    break;

                case 7:
                    System.out.print("Ingrese el ID del cliente para recuperar sus cuentas: ");
                    Long idClienteRecuperar = scanner.nextLong();
                    scanner.nextLine();
                    Cliente clienteRecuperar = operaciones.buscarClienteId(idClienteRecuperar);

                    if (clienteRecuperar != null) {
                        System.out.println("Cuentas del cliente " + clienteRecuperar.getNombreCliente() + ":");
                        for (Cuenta cuenta : clienteRecuperar.getCuentas()) {
                            System.out.println("  - ID Cuenta: " + cuenta.getIdCuenta() + ", Saldo: " + cuenta.getSaldo());
                        }
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 8:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scanner.close();
    }
}
