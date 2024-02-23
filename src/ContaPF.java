public class ContaPF extends Conta {

    private int cpf;
    public static double imposto = 0.05;

    public ContaPF(String titular, double saldo, int cpf){
     super(titular, saldo);
     this.cpf = cpf;
    } 

    public void sacar(double valor){
     this.saldo = this.saldo - valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino){
        this.saldo = this.saldo - (valor *(1.00+imposto));
        contaDestino.saldo = contaDestino.saldo + valor;
    }
}
