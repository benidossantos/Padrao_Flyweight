package padroesestruturais.flyweight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BancoTest {

    @BeforeEach
    void setUp() {
        AgenciaFactory.limpar();
    }

    @Test
    void deveListarContas() {
        Banco banco = new Banco();
        banco.abrirConta("1001", "Maria", "0001", "Juiz de Fora", "MG");
        banco.abrirConta("1002", "João", "0002", "Rio de Janeiro", "RJ");

        List<String> saida = Arrays.asList(
                "Conta: 1001 - Titular: Maria - Agência: 0001 (Juiz de Fora/MG)",
                "Conta: 1002 - Titular: João - Agência: 0002 (Rio de Janeiro/RJ)");

        assertEquals(saida, banco.listarContas());
    }

    @Test
    void deveCompartilharAgenciaEntreContas() {
        Banco banco = new Banco();
        banco.abrirConta("1001", "Maria", "0001", "Juiz de Fora", "MG");
        banco.abrirConta("1002", "João", "0001", "Juiz de Fora", "MG");
        banco.abrirConta("1003", "Ana", "0001", "Juiz de Fora", "MG");

        assertSame(banco.getContas().get(0).getAgencia(), banco.getContas().get(2).getAgencia());
        assertEquals(1, AgenciaFactory.getTotalAgencias());
    }

    @Test
    void deveCriarAgenciasDistintas() {
        Banco banco = new Banco();
        banco.abrirConta("1001", "Maria", "0001", "Juiz de Fora", "MG");
        banco.abrirConta("1002", "João", "0002", "Rio de Janeiro", "RJ");
        banco.abrirConta("1003", "Ana", "0001", "Juiz de Fora", "MG");
        banco.abrirConta("1004", "Pedro", "0002", "Rio de Janeiro", "RJ");

        assertNotSame(banco.getContas().get(0).getAgencia(), banco.getContas().get(1).getAgencia());
        assertEquals(2, AgenciaFactory.getTotalAgencias());
    }

    @Test
    void deveRetornarMesmaAgenciaPelaFactory() {
        Agencia a1 = AgenciaFactory.getAgencia("0001", "Juiz de Fora", "MG");
        Agencia a2 = AgenciaFactory.getAgencia("0001", "Juiz de Fora", "MG");
        assertSame(a1, a2);
    }
}
