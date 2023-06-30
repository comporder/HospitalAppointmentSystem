package HospitalAppointmentSystem;

/**
 * @file Second Project
 * @description Our program provides hospital automation for users to perform
 * certain(limited) actions
 * @assignment Second Project HW
 * @date 15.01.2022
 * @author Emir Ozalp, emir.ozalp@stu.fsm.edu.tr
 */
public class Randevu {

    /*Randevu sınıfının değişkenleri tanımlandı*/
    private int randevuId;
    private Doktor doktor;
    private Tarih tarih;
    private int saat;
    private int sabit; //test kısmında kullanılması için

    /*Randevu sınıfının constructor oluşturuldu*/
    public Randevu(int randevuId, Doktor doktor, Tarih tarih, int saat) {
        this.randevuId = randevuId;
        this.doktor = doktor;
        this.tarih = tarih;
        this.saat = saat;
        this.sabit = 1; // randevu adedini veren değişken sabit olarak 1 tanımlandı
    }

    //Randevu sınıfın get ve set metotları oluşturuldu
    public int getSabit() {
        return sabit;
    }

    public int getRandevuId() {
        return this.randevuId;
    }

    public Doktor getDoktor() {
        return this.doktor;
    }

    public String getTarihtoString() {
        return tarih.toString();
    }

    public int getTarihGun() {
        return this.tarih.getGun();
    }

    public int getTarihAy() {
        return this.tarih.getAy();
    }

    public int getTarihYil() {
        return this.tarih.getYil();
    }

    public Tarih getTarih() {
        return tarih;
    }

    public int getSaat() {
        return this.saat;
    }

    public void setRandevuId(int randevuId) {
        this.randevuId = randevuId;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    public void setTarih(Tarih tarih) {
        this.tarih = tarih;
    }

    public void setSaat(int saat) {
        this.saat = saat;
    }

    public void setSabit(int sabit) {
        this.sabit = sabit;
    }

    /*Object sınıfın toString metodu Randevu sınıfının bilgilerinin verilmesi içim override edildi*/
    @Override
    public String toString() {
        return "{" + "ID No:" + randevuId + " || Doktorun İsmi: " + doktor.getAdSoyad() + " || Tarih: " + tarih.toString() + " || Saat: " + this.saat + ".00" + '}';
    }

}
