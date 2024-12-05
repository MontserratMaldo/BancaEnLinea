import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Operaciones {
    private List<Cliente> clientes;

    public Operaciones(List<Cliente> clientes) {
        this.clientes = new ArrayList<>();
    }

    public Cliente crearCliente(Long idCliente, String nombreCliente){
        Cliente nuevoCliente = new Cliente(idCliente, nombreCliente);
        clientes.add(nuevoCliente);
        return nuevoCliente;
    }
    public List<Cliente> obtenerClientes(){
        return clientes;
    }
    public Cliente buscarClienteId(Long idCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente().equals(idCliente)) {
                return cliente;
            }
        }
        return null;
    }
    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }
    public void abrirCuenta(Cliente cliente, double saldo){
        Cuenta nuevaCuenta = null;
        nuevaCuenta = new Cuenta(generarIdCuenta(), saldo, cliente);

        if (nuevaCuenta != null) {
            cliente.agregarCuenta(nuevaCuenta);
            System.out.println("Cuenta creadacon éxito para " + cliente.getNombreCliente());
        }
    }
    public void depositar(Cliente clienteDeposito, Long idCliente, double saldo){
        Cuenta cuenta = buscarCuentaPorId(clienteDeposito, idCliente);
        cuenta.depositar(saldo);

    }
    public void retirar(Cliente clienteDeposito, Long idCliente, double saldo) {
        Cuenta cuenta = buscarCuentaPorId(clienteDeposito, idCliente);
        cuenta.retirar(saldo);

    }

    public void consultarSaldo(Cliente cliente, Long numeroCuenta) {
        Cuenta cuenta = buscarCuentaPorId(cliente, numeroCuenta);
        if (cuenta != null) {
            System.out.println("Saldo de la cuenta " + numeroCuenta + ": " + cuenta.getSaldo());
        }
    }

    private Cuenta buscarCuentaPorId(Cliente cliente, Long idCuenta) {
        for (Cuenta cuenta : cliente.getCuentas()) {
            if (cuenta.getIdCuenta().equals(idCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    private Long generarIdCuenta() {
        return System.currentTimeMillis();
    }

}
