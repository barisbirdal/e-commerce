import java.util.Scanner;

// Ürün Sınıfı
class Urun {
    String isim;
    double fiyat;
    int stok;

    Urun(String isim, double fiyat, int stok) {
        this.isim = isim;
        this.fiyat = fiyat;
        this.stok = stok;
    }

    void urunBilgileriniGoster() {
        System.out.println("Ürün: " + isim + ", Fiyat: " + fiyat + ", Stok: " + stok);
    }

    boolean stokAzalt(int miktar) {
        if (stok >= miktar) {
            stok -= miktar;
            System.out.println("Stok azaltıldı. Yeni stok: " + stok);
            return true;
        } else {
            System.out.println("Yetersiz stok. Mevcut stok: " + stok);
            return false;
        }
    }

    double getFiyat() {
        return fiyat;
    }
}

// Sepet Sınıfı
class Sepet {
    double toplamTutar;

    void toplamHesapla(Urun urun, int miktar) {
        if (urun.stokAzalt(miktar)) {
            toplamTutar = urun.getFiyat() * miktar;
            System.out.println("Toplam tutar: " + toplamTutar);
        } else {
            toplamTutar = 0;
        }
    }

    void satinAlmaTamamla(String iban, String adres) {
        System.out.println("Ödeme başarılı! IBAN: " + iban);
        System.out.println("Ürün gönderiliyor: " + adres);
        System.out.println("Satın alma tamamlandı.");
    }
}

// Main Class
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Akıllı saat
        Urun akilliSaat = new Urun("Akıllı Saat", 87.55, 100);

        // Ürün bilgileri
        akilliSaat.urunBilgileriniGoster();

        System.out.print("Satın alınacak miktarı girin: ");
        int miktar = scanner.nextInt();

        // Sepet
        Sepet sepet = new Sepet();

        // Toplamı hesapla ve onayla
        sepet.toplamHesapla(akilliSaat, miktar);

        if (miktar > 0 && miktar <= 100) {
            System.out.print("Ödemeye devam etmek istiyor musunuz? (evet/hayır): ");
            String onay = scanner.next().toLowerCase();

            if (onay.equals("evet")) {
                System.out.print("IBAN'ı girin (16 hane): ");
                String iban = scanner.next();

                if (iban.length() == 16) {
                    System.out.print("Kargo adresinizi girin: ");
                    scanner.nextLine();  // Boşluğu temizle
                    String adres = scanner.nextLine();

                    // Satın alma işlemini tamamla
                    sepet.satinAlmaTamamla(iban, adres);
                } else {
                    System.out.println("Geçersiz IBAN. Satın alma iptal edildi.");
                }
            } else {
                System.out.println("Satın alma iptal edildi.");
            }
        }

        scanner.close();
    }
}
