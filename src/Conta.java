public class Conta {
   public String titular;
   private int saldo;

   public Conta(String titular, int saldo){
    this.titular = titular;
    this.saldo = saldo;
   }
   
   public int getSaldo(){
    return this.saldo;
   }

   public void sacar(int valor){
    this.saldo = this.saldo - valor;
   }

   public void depositar(int valor){
    this.saldo = this.saldo + valor;
   }

   public void transferir(int valor, Conta contaDestino){
    this.saldo = this.saldo - valor;
    contaDestino.saldo = contaDestino.saldo + valor;
   }
}
