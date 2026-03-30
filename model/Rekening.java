package bankgakmaurugi.model;

public class Rekening {
    private String nomorRekening;
    private double saldo;

    public Rekening(String noRek, double saldo) {
        this.nomorRekening = noRek;
        this.saldo = saldo;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public double cekSaldo() {
        return saldo;
    }

    public void tambahSaldo(double saldo) {
        this.saldo += saldo;
    }

    public void tarikSaldo(double saldo) {
        this.saldo -= saldo;
    }

}
