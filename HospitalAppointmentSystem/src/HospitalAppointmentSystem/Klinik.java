package HospitalAppointmentSystem;

/**
 * @file Second Project
 * @description Our program provides hospital automation for users to perform
 * certain(limited) actions
 * @assignment Second Project HW
 * @date 15.01.2022
 * @author Emir Ozalp, emir.ozalp@stu.fsm.edu.tr
 */
public class Klinik {

    /*Klinik sınıfının değişkenleri tanımlandı*/
    private String klinikNo;
    private Doktor doktor;

    /*String ve Doktor sınıfına ait objeler alan bir constructor oluşturuldu*/
    public Klinik(String no, Doktor doktor) {
        this.klinikNo = no;
        this.doktor = doktor;
    }

    /*Klinik sınıfın get ve set metotları oluşturuldu*/
    public String getKlinikNo() {
        return this.klinikNo;
    }

    public Doktor getDoktor() {
        return doktor;
    }

    /*Diğer sınıflarda ihtiyaç duyulacağı için direkt olarak doktorun adını alan get metotu oluşturuldu*/
    public String getDoktorAdSoyad() {
        return doktor.getAdSoyad();
    }

    public void setKlinikNo(String klinikNo) {
        this.klinikNo = klinikNo;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

}
