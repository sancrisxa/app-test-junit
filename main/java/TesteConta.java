public class TesteConta {
    public static void main(String[] args) {

        // Conta ativa
        Conta conta = new Conta();
        conta.ativar();
        conta.depositar(100.00);
        System.out.println("Conta ativa");
        System.out.println("Saldo: " + conta.getSaldo());

        // Conta Inativa
        Conta contaInativa = new Conta();
        contaInativa.inativar();
        contaInativa.depositar(100.00);
        System.out.println("Conta inativa");
        System.out.println("Saldo: " + contaInativa.getSaldo());
    }
}
