package bankgakmaurugi.interfaces;

public interface TransferGlobal extends TransaksiDigital, LayananInternasional {

    void prosesTransaksiInter(String noRekTujuan, String negaraTujuan, double nominal, String kodeKursTujuan);

}
