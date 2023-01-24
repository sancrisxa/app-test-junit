import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ContaTest {

    private Conta conta;
    private static double depositoIncial;
    private static double saqueValido;
    private static double saqueInvalido;
    private static double saldoZerado;

    @BeforeAll
    protected static void definirValoresPadrao() {
        depositoIncial = 100;
        saqueValido = 70;
        saqueInvalido = 110.00;
        saldoZerado = 0.00;
    }

    @BeforeEach
    protected void inicializarConta() {
        conta = new Conta();
        conta.ativar();
    }

    @Test
    @DisplayName("Deve Depositar Com Conta Ativa")
    public void deveDepositarComContaAtiva() {

        Assertions.assertTrue(conta.depositar(this.depositoIncial));

        Assertions.assertEquals(this.depositoIncial, conta.getSaldo());
    }

    @Test
    @DisplayName("Não Deve Depositar Com Conta Inativa")
    public void naoDeveDepositarComContaInativa() {

        conta.inativar();
        Assertions.assertThrows(RuntimeException.class, () -> conta.depositar(this.depositoIncial));

        Assertions.assertEquals(saldoZerado, conta.getSaldo());
    }

    @Test
    @DisplayName("Deve Sacar Com Conta Ativa e Saldo Maior que o Valor de Saque")
    public void deveSacarComContaAtivaESaldoMaiorQueOValorDeSaque() {

        Assertions.assertTrue(conta.depositar(this.depositoIncial));
        Assertions.assertTrue(conta.sacar(this.saqueValido));

        Assertions.assertEquals(this.depositoIncial - this.saqueValido, conta.getSaldo());
    }

    @Test
    @DisplayName("Não Deve Sacar Com Conta Inativa")
    public void naoDeveSacarComContaInativa() {

        Assertions.assertTrue(conta.depositar(this.depositoIncial));

        conta.inativar();
        Assertions.assertThrows(RuntimeException.class, () -> conta.sacar(this.saqueValido));

        Assertions.assertEquals(this.depositoIncial, conta.getSaldo());
    }

    @Test
    @DisplayName("Não Deve Sacar Com Conta Ativa e Saldo Menor que o Valor de Saque")
    public void naoDeveSacarComContaAtivaESaldoMenorQueOValorDeSaque() {

        Assertions.assertTrue(conta.depositar(this.depositoIncial));

        Assertions.assertThrows(RuntimeException.class, () -> conta.sacar(saqueInvalido));

        Assertions.assertEquals(this.depositoIncial, conta.getSaldo());
    }
}
