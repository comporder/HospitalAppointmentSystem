package HospitalAppointmentSystem;

/**
 * @file Second Project
 * @description Our program provides hospital automation for users to perform
 * certain(limited) actions
 * @assignment Second Project HW
 * @date 15.01.2022
 * @author Emir Ozalp, emir.ozalp@stu.fsm.edu.tr
 */

/* Oluşturduğumuz İnsan isimli sınıftan kalıtım alarak yeni bir Doktor isimli sınıf ürettik */
public class Doktor extends Insan {

    private Randevu[] randevuListesi; // randevu nesnelerini alan randevu listesi oluşturuldu
    private int randevuAdeti; // doktorların randevu adetlerinin kayıt altına alınması için oluşturuldu

    public Doktor(){ //default constructor oluşturuldu, test sınıfında kullanılacak    
    }
    
    /*Sadece String değişkene bağlı olan bir overloaded constructor oluşturuldu*/
    public Doktor(String adSoyad) {
        super(adSoyad);
        this.randevuListesi = new Randevu[5]; //şimdilik programımız sade ve kısa olması için doktor maksimum 5 randevu alabilir
    }

    /*Kalıtım alınan İnsan sınıfından getAdSoyad metodu override edildi*/
    @Override
    public String getAdSoyad() {
        return super.getAdSoyad();
    }

    /*Doktor sınıfına ait değişkenlerin üzerinde dışarıdan işlem yapılabilmesi için get ve set metotları oluşturuldu*/
    public int getRandevuAdeti() {
        return randevuAdeti;
    }

    public Randevu[] getRandevuListesi() {
        return randevuListesi;
    }

    public void setRandevuListesi(Randevu[] randevuListesi) {
        this.randevuListesi = randevuListesi;
    }

    public void setRandevuAdeti(int randevuAdeti) {
        this.randevuAdeti = randevuAdeti;
    }

    /*Hasta sınıfında kullanılması için Doktor sınıfında randevuEkle metodu oluşturuldu*/
    public void randevuEkle(Randevu randevu) {
        for (int i = 0; i < this.randevuListesi.length; i++) {
            if (this.randevuListesi[i] == null) {
                randevuListesi[i] = randevu;
                break;
            }
        }
    }

    /*Doktora ait olan randevuların listelenmesi için randevuListele metodu oluşturuldu*/
    public void randevuListele() {
        for (int i = 0; i < this.randevuListesi.length; i++) {
            if (randevuListesi[i] != null) {
                System.out.println(getAdSoyad() + " isimli doktora ait olan randevu özellikleri " + randevuListesi[i].toString());
            }
        }
    }
}
