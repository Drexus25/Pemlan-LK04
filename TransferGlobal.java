package bankgakmaurugi;

public interface TransferGlobal extends TransaksiDigital, LayananInternasional {
    
    void prosesTransaksi(String negaraTujuan, double nominal);

}
