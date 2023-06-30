package HospitalAppointmentSystem;

/**
 * @file Second Project
 * @description Our program provides hospital automation for users to perform
 * certain(limited) actions
 * @assignment Second Project HW
 * @date 15.01.2022
 * @author Emir Ozalp, emir.ozalp@stu.fsm.edu.tr
 */
public class Hastane {

    //Hastane sınıfının değişkenleri tanımlandı
    private String ad;
    private Sehir sehir;
    private Klinik[] klinikListesi;

    /*Bir String bir de Sehir sınınfan değer constructor oluşturuldu*/
    public Hastane(String ad, Sehir sehir) {
        this.ad = ad;
        this.sehir = sehir;
        this.klinikListesi = new Klinik[10]; //bir hastanede maksimum 10 klinik olabilir şimdilik
    }

    /*Hastane sınıfına ait değişkenlerin üzerinde dışarıdan işlem yapılabilmesi için get ve set metotları oluşturuldu*/
    public String getHastaneAd() {
        return this.ad;
    }

    public Klinik[] getKlinikListesi() {
        return klinikListesi;
    }

    public String getAd() {
        return ad;
    }

    public Sehir getSehir() {
        return sehir;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public void setSehir(Sehir sehir) {
        this.sehir = sehir;
    }

    public void setKlinikListesi(Klinik[] klinikListesi) {
        this.klinikListesi = klinikListesi;
    }

    /*İstenen bir kliniği alarak bu hastanenin klinik listesinden ayıklayıp silen klinikSil metodu oluşturuldu*/
    public void klinikSil(Klinik klinik) {
        boolean durum = false;
        for (int i = 0; i < klinikListesi.length; i++) {
            if (klinikListesi[i].getKlinikNo().equals(klinik.getKlinikNo())) { //silinmek istenen klinik numarası ile oluşturulmuş kliniklerin numaraları karşılaştırılır
                System.out.println(getHastaneAd() + " Hastanesi'nde ki " + klinikListesi[i].getKlinikNo() + " numaralı ve " + klinikListesi[i].getDoktorAdSoyad() + " isimli doktora ait olan klinik silinmiştir.");
                klinikListesi[i] = null;
                durum = true;
                break;
            }
        }
        if (durum == false) {
            System.out.println(klinik.getKlinikNo() + " numaralı klinik silinememiştir.");
        }
    }

    /*Hastaneye Klinik sınıfına ait bir değişken alarak yeni bir klinik ekleyen metot oluşturuldu*/
    public void klinikEkle(Klinik klinik) {
        boolean ayniKlinikMi = false;
        for (int i = 0; i < this.klinikListesi.length; i++) {
            if (this.klinikListesi[i] != null && this.klinikListesi[i] == klinik) {
                ayniKlinikMi = true;
                break;
            }

        }
        if (ayniKlinikMi == false) {
            for (int i = 0; i < this.klinikListesi.length; i++) {
                if (this.klinikListesi[i] == null) {
                    this.klinikListesi[i] = klinik;
                    break;
                }
            }
        } else {
            System.out.println(klinik.getKlinikNo() + " numaralı klinik zaten " + getHastaneAd() + " hastanesine eklenmiştir !");
        }
    }

    /*Bu hastane sınıfında bulunan kliniklerin listelenmesi için klinikListele metodu oluşturuldu*/
    public void klinikListele() {
        for (int i = 0; i < this.klinikListesi.length; i++) {
            if (this.klinikListesi[i] != null) {
                System.out.println(this.klinikListesi[i].getKlinikNo() + " numaralı klinik, ismi " + this.klinikListesi[i].getDoktorAdSoyad() + " olan doktorumuza aittir. ");
                System.out.println("");
            }
        }
    }

}
