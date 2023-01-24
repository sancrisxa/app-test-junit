public class Conta {
    private double saldo;
    private boolean ativo;

    public double getSaldo() {
        return saldo;
    }

    public void ativar() {
        this.ativo = true;
    }

    public void inativar() {
        this.ativo = false;
    }

    public boolean depositar(double valor) {

        if (this.ativo) {
            this.saldo += valor;
            return true;
        } else {
            throw new RuntimeException("Conta Inativa! Não pode depositar.");
        }
    }

    public boolean sacar(double valor) {

        if (this.ativo && ((this.saldo - valor) >= 0)) {
            this.saldo -= valor;
            return true;
        } else {
            throw new RuntimeException("Conta Inativa ou Saldo inferior ao valor de Saque! Não foi possível sacar.");
        }
    }
}
