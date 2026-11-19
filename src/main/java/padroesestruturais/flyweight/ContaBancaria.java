package padroesestruturais.flyweight;

public class ContaBancaria {

    private String numero;
    private String titular;
    private Agencia agencia;

    public ContaBancaria(String numero, String titular, Agencia agencia) {
        this.numero = numero;
        this.titular = titular;
        this.agencia = agencia;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public String getDados() {
        return "Conta: " + numero + " - Titular: " + titular +
                " - Agência: " + agencia.getNumero() + " (" + agencia.getCidade() + "/" + agencia.getEstado() + ")";
    }
}
