package bankgakmaurugi.security;

public final class ProtokolKeamanan {
    private static final String ID_SERVER =  "GAKMAURUGI-SERVER-01";
    private static final double BATAS_TRANSAKSI_MAKSIMUM = 12_000_000;

    public static void validasiTransaksi(String noRek, double jumlah){
        System.out.println("Memvalidasi transaksi...");

        if (noRek == null || noRek.isBlank()){
            System.out.println("Nomor rekening tidak boleh kosong.");
            System.exit(0);
        }
        if (jumlah <= 0){
            System.out.println("Jumlah transaksi tidak valid.");
            System.exit(0);
        }
        if (jumlah > BATAS_TRANSAKSI_MAKSIMUM){
            System.out.println("Jumlah transaksi melebih batas maksimal.");
            System.exit(0);
        }

        System.out.println("Validasi berhasil!");

    }

    

}
