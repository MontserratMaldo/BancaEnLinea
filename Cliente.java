import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private Long idCliente;
    public String nombreCliente;
    public List<Cuenta> cuentas = new ArrayList<>();

    Cliente(Long idCliente, String nombreCliente){
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
    }

    public Long getIdCliente(){
        return idCliente;
    }
    public String getNombreCliente(){
        return nombreCliente;
    }
    
    public void setId(Long idCliente){
        this.idCliente = idCliente;
    }
    public void setNombreCliente(String nombreCliente){
        this.nombreCliente = nombreCliente;
    }
    public List<Cuenta> getCuentas() {
        return cuentas;
    }
    public void agregarCuenta(Cuenta cuenta){
        cuentas.add(cuenta);
    }

}
