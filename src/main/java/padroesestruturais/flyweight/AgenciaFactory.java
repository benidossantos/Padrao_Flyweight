package padroesestruturais.flyweight;

import java.util.HashMap;
import java.util.Map;

public class AgenciaFactory {

    private static Map<String, Agencia> agencias = new HashMap<>();

    public static Agencia getAgencia(String numero, String cidade, String estado) {
        String chave = numero + "-" + cidade + "-" + estado;
        Agencia agencia = agencias.get(chave);
        if (agencia == null) {
            agencia = new Agencia(numero, cidade, estado);
            agencias.put(chave, agencia);
        }
        return agencia;
    }

    public static int getTotalAgencias() {
        return agencias.size();
    }

    public static void limpar() {
        agencias.clear();
    }
}
