package HospitalAppointmentSystem;

/**
 * @file Second Project
 * @description Our program provides hospital automation for users to perform
 * certain(limited) actions
 * @assignment Second Project HW
 * @date 15.01.2022
 * @author Emir Ozalp, emir.ozalp@stu.fsm.edu.tr
 */
public class Sehir {

    /*Sehir sınıfının degiskenleri oluşturuldu*/
    private String sehirAdi;
    private int plakaNo;

    /*Sehir sınıfına ait bir constructor oluşturuldu*/
    public Sehir(String sehirAdi, int plakaNo) {
        this.sehirAdi = sehirAdi;
        this.plakaNo = plakaNo;
    }

    //Sehir sınıfın değişkenlerine ulaşım sağlanması için get ve set metotları oluşturuldu
    public String getSehirAdi() {
        return sehirAdi;
    }

    public int getPlakaNo() {
        return plakaNo;
    }

    public void setSehirAdi(String sehirAdi) {
        this.sehirAdi = sehirAdi;
    }

    public void setPlakaNo(int plakaNo) {
        this.plakaNo = plakaNo;
    }

}
