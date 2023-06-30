package HospitalAppointmentSystem;

/**
 * @file Second Project
 * @description Our program provides hospital automation for users to perform
 * certain(limited) actions
 * @assignment Second Project HW
 * @date 15.01.2022
 * @author Emir Ozalp, emir.ozalp@stu.fsm.edu.tr
 */

/*Oluşturduğumuz İnsan isimli sınıftan kalıtım alarak yeni bir Hasta isimli sınıf ürettik*/
public class Hasta extends Insan {

    //Hasta sınıfının değişkenleri tanımlandı
    private String tcNo;
    private Randevu[] randevuListesi;
    private int randevuAdet;
    private int gun;

    //Hasta sınıfına ait değişkensiz constructor
    public Hasta() {
    }

    //Hasta sınıfına ait sadece String değişken alan overloaded constructor
    public Hasta(String adSoyad) {
        super(adSoyad);
        this.randevuListesi = new Randevu[5];// bir hasta max 5 randevu alabilir şimdilik
        this.randevuAdet = 0;
        this.gun = 24;
    }

    //Hasta sınıfına ait iki tane farklı String değişken değerleri alan overloaded constructor
    public Hasta(String adSoyad, String tcNo) {
        super(adSoyad);
        this.tcNo = tcNo;
        this.randevuAdet = 0;
        this.randevuListesi = new Randevu[5];// bir hasta max 5 randevu alabilir şimdilik
        this.gun = 24;
    }

    /*Kalıtım alınan İnsan sınıfından getAdSoyad metodu override edildi*/
    @Override
    public String getAdSoyad() {
        return super.getAdSoyad();
    }

    /*Hasta sınıfına ait değişkenlerin üzerinde dışarıdan işlem yapılabilmesi için get ve set metotları oluşturuldu*/
    public String getTcNo() {
        return tcNo;
    }

    public int getGun() {
        return gun;
    }

    public int getRandevuAdet() {
        return this.randevuAdet;
    }

    public Randevu[] getRandevuListesi() {
        return randevuListesi;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public void setRandevuListesi(Randevu[] randevuListesi) {
        this.randevuListesi = randevuListesi;
    }

    public void setRandevuAdet(int randevuAdet) {
        this.randevuAdet = randevuAdet;
    }

    public void setGun(int gun) {
        this.gun = gun;
    }

    /*Değişken olarak bir randevu alan bir randevuAl metodu ürettik*/
    public void randevuAl(Randevu yeniRandevu) {
        boolean ayniRandevuMu = false;
        for (int i = 0; i < this.randevuListesi.length; i++) {
            if (this.randevuListesi[i] != null && this.randevuListesi[i].getDoktor().getAdSoyad().equals(yeniRandevu.getDoktor().getAdSoyad()) && this.randevuListesi[i].getSaat() == yeniRandevu.getSaat()) {
                ayniRandevuMu = true;
                break;
            }
        }
        if (ayniRandevuMu == false) {
            for (int i = 0; i < this.randevuListesi.length; i++) {
                if (this.randevuListesi[i] == null) {
                    this.randevuListesi[i] = yeniRandevu;
                    this.randevuAdet++;
                    yeniRandevu.getDoktor().randevuEkle(yeniRandevu);
                    yeniRandevu.getDoktor().setRandevuAdeti(yeniRandevu.getDoktor().getRandevuAdeti() + 1);
                    break;
                }
            }
        } else {
            System.out.println(yeniRandevu.getRandevuId() + " ID numarasına sahip randevu zaten alınmıştır ! ");
        }
    }

    /*Hastaya ait randevuları listeleyen randevuListele metodu ürettik*/
    public void randevuListele() {
        for (int i = 0; i < this.randevuListesi.length; i++) {
            if (randevuListesi[i] != null) {
                System.out.println(getTcNo() + " kimlik numaralı, ismi " + getAdSoyad() + " olan hastanın " + this.randevuListesi[i].toString() + " belirtilen özelliklere sahip olan randevusu vardır.");
            }

        }

    }

    /*Hastaya ait olan herhangi bir randevunun silinmesi için sadece değişken sınıfı Randevu alan bir randevuSil metodu ürettik*/
    public void randevuSil(Randevu randevu) {
        for (int i = 0; i < randevuListesi.length; i++) {
            if (randevuListesi[i].toString().equals(randevu.toString())) {
                randevuListesi[i] = null;
                System.out.println(randevu.toString() + " özellikli randevu silindi.");
                this.randevuAdet--;
                randevu.getDoktor().setRandevuAdeti((randevu.getDoktor().getRandevuAdeti() - 1));
                break;
            }

        }
    }

    /*Hastanın herhangi bir randevusunun bir diğeriyle değiştirilmesi için iki tane Randevu sınıfına ait değişken alan randevuDegis metodu ürettik*/
    public void randevuDegis(Randevu randevu1, Randevu randevu2) {
        if (randevu1.getTarihGun() - this.gun > 0 && randevu2.getTarihGun() - this.gun > 0) { //tarihlerini kıyasladık ve eğer uyumluysa değiştirdik
            this.randevuSil(randevu1);
            randevuAl(randevu2);
        } else {
            System.out.println(randevu1.getRandevuId() + " ID numarasına sahip olan randevu değiştirilemez.");
        }
    }

}
