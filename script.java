public class Main {
    
    static class ContaBancaria {
        private String numeroConta;
        private String titular;
        private double saldo;

        public ContaBancaria(String numeroConta, String titular, double saldoInicial) {
            this.numeroConta = numeroConta;
            this.titular = titular;
            this.saldo = saldoInicial;
        }

        public void depositar(double valor) {
            if (valor > 0) {
                saldo += valor;
                System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
            } else {
                System.out.println("Valor de depósito inválido.");
            }
        }

        public void sacar(double valor) {
            if (valor > 0 && valor <= saldo) {
                saldo -= valor;
                System.out.println("Saque de R$" + valor + " realizado com sucesso.");
            } else {
                System.out.println("Saldo insuficiente ou valor inválido.");
            }
        }

        public void transferir(ContaBancaria destino, double valor) {
            if (valor > 0 && valor <= saldo) {
                this.sacar(valor);
                destino.depositar(valor);
                System.out.println("Transferência de R$" + valor + " para conta " + destino.getNumeroConta() + " realizada.");
            } else {
                System.out.println("Transferência não pode ser realizada.");
            }
        }

        public void verSaldo() {
            System.out.println("Saldo atual da conta " + numeroConta + ": R$" + saldo);
        }

        public String getNumeroConta() {
            return numeroConta;
        }

        public String getTitular() {
            return titular;
        }

        public double getSaldo() {
            return saldo;
        }
    }

    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaBancaria("12345", "João Silva", 1000.0);
        ContaBancaria conta2 = new ContaBancaria("67890", "Maria Souza", 500.0);

        System.out.println("\n--- Sistema Bancário Simples ---");
        conta1.verSaldo();
        conta2.verSaldo();

        System.out.println("\nOperações na conta 1:");
        conta1.depositar(200.0);
        conta1.verSaldo();

        conta1.sacar(50.0);
        conta1.verSaldo();

        System.out.println("\nTransferência entre contas:");
        conta1.transferir(conta2, 300.0);
        conta1.verSaldo();
        conta2.verSaldo();

        System.out.println("\nTentativa de saque inválido:");
        conta1.sacar(1000.0);

        System.out.println("\n--- Saldos Finais ---");
        conta1.verSaldo();
        conta2.verSaldo();
    }
}