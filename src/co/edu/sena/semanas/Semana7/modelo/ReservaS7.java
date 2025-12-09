package co.edu.sena.semanas.Semana7.modelo;

public class ReservaS7 {
    private ClienteS7 cliente;
    private DestinoS7 destino;
    private String codigo;

    public ReservaS7(ClienteS7 cliente, DestinoS7 destino, String codigo) {
        this.cliente = cliente;
        this.destino = destino;
        this.codigo = codigo;
    }

    public ClienteS7 getCliente() {
        return cliente;
    }

    public DestinoS7 getDestino() {
        return destino;
    }

    public String getCodigo() {
        return codigo;
    }
}

