
public class Cuenta {
    public Long idCuenta;
    public double saldo;
    public Cliente cliente;


    Cuenta(Long idCuenta, double saldo, Cliente cliente){
        this.idCuenta = idCuenta;

        this.saldo = saldo;
        this.cliente = cliente;
    }

    
    public Long getIdCuenta() {
        return idCuenta;
    }
    public double getSaldo(){
        return saldo;
    }
    public Cliente getCliente(){
        return cliente;
    }

    
    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void retirar(double saldo) {
        setSaldo(getSaldo() - saldo);
        System.out.println("Retiro exitoso. Nuevo saldo: " + getSaldo());
        }
    public void depositar(double saldo) {
        if ( saldo >= 0 ) {
            setSaldo(getSaldo() + saldo);
            System.out.println("Deposito exitoso. Nuevo saldo: " + getSaldo());
        }
    }
    public void consultarSaldo() {
        System.out.println("Saldo de la cuenta corriente: " + getSaldo());
    }
}
