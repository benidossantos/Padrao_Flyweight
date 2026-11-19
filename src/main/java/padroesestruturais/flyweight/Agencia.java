package padroesestruturais.flyweight;

public class Agencia {

    private String numero;
    private String cidade;
    private String estado;

    public Agencia(String numero, String cidade, String estado) {
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }
}
