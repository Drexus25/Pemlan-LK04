package bankgakmaurugi.model;

import bankgakmaurugi.interfaces.TransferGlobal;
import bankgakmaurugi.security.ProtokolKeamanan;

import java.util.Scanner;

public class RekeningValas extends Rekening implements TransferGlobal {

    private final String kodeKursDasar = "IDR";
    private String riwayatTransaksiTerbaru;

    public RekeningValas(String noRek, double saldo) {
        super(noRek, saldo);
    }

    @Override
    public void prosesTransaksi(double nominal) {
        System.out.println("\n Memulai transaksi senilai: " + nominal + kodeKursDasar);

        ProtokolKeamanan.validasiTransaksi(getNomorRekening(), nominal);

        tarikSaldo(nominal);

        System.out.println("Transaksi berhasil!");
        System.out.println("Sisa saldo: " + cekSaldo());
    }

    @Override
    public boolean autentikasi() {
        int otpInt = (int) (Math.random() * 10000);
        System.out.println("OTP: " + otpInt);

        System.out.println("Masukkan OTP");
        int r = new Scanner(System.in).nextInt();
        if (r == otpInt) {
            System.out.println("OTP berhasil!");
            return true;
        }
        return false;
    }

    @Override
    public double KonversiUang(double nominal, String kodeKurs) {
        double nominalAsing = 0;
        switch (kodeKurs) {
            case "USD" -> {
                return nominal / 16800;
            }
            case "EUR" -> {
                return nominal / 19500;
            }
            case "CNY" -> {
                return nominal / 2450;
            }
            case "GBP" -> {
                return nominal / 22500;
            }
            default -> {
                System.out.println("Mata uang tidak didukung.");
                return nominalAsing;
            }
        }
    }


    @Override
    public void prosesTransaksiInter(String noRekTujuan, String negaraTujuan, double nominal, String kodeKursTujuan) {
        System.out.println("Tujuan: " + noRekTujuan + " (" + negaraTujuan + ")");
        System.out.println("Nominal: " + nominal + " " + kodeKursDasar + " -> " + kodeKursTujuan);

        if (!autentikasi()){
            System.out.println("Autentikasi gagal!");
            return;
        }

        double jumlahKonversi = KonversiUang(nominal, kodeKursTujuan);

        prosesTransaksi(nominal);

        riwayatTransaksiTerbaru = "Transfer global ke " + noRekTujuan +" (" + negaraTujuan + ") sebesar " + jumlahKonversi + " berhasil!";
        System.out.println("Transaksi selesai.");

    }

    @Override
    public void cetakBuktiTransaksi() {
        System.out.println("\n==============================");
        System.out.println("  BUKTI TRANSAKSI");
        System.out.println("==============================");
        System.out.println("  No. Rekening : " + getNomorRekening());
        System.out.println("  Valuta Dasar : " + kodeKursDasar);
        System.out.println("  Saldo Saat Ini: " + cekSaldo() + " " + kodeKursDasar);
        System.out.println("  Detail      : " + riwayatTransaksiTerbaru);
        System.out.println("==============================\n");
    }

}
