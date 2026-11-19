package padroesestruturais.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private List<ContaBancaria> contas = new ArrayList<>();

    public void abrirConta(String numero, String titular, String numeroAgencia, String cidade, String estado) {
        Agencia agencia = AgenciaFactory.getAgencia(numeroAgencia, cidade, estado);
        contas.add(new ContaBancaria(numero, titular, agencia));
    }

    public List<String> listarContas() {
        List<String> saida = new ArrayList<>();
        for (ContaBancaria conta : contas) {
            saida.add(conta.getDados());
        }
        return saida;
    }

    public List<ContaBancaria> getContas() {
        return contas;
    }
}
