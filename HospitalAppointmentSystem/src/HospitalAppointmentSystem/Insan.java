package HospitalAppointmentSystem;

/**
 * @file Second Project
 * @description Our program provides hospital automation for users to perform
 * certain(limited) actions
 * @assignment Second Project HW
 * @date 15.01.2022
 * @author Emir Ozalp, emir.ozalp@stu.fsm.edu.tr
 */

/*Diğer sınıflardan bazılarının kalıtım alabilmesi için İnsan sınıfı oluşturuldu*/
public class Insan {

    /*Insan sınıfının tek değişkeni tanımlandı*/
    private String adSoyad;

    public Insan() {
    } // default constructor tanımlandı

    /*String isim alan bir overloaded constructor oluşturuldu*/
    public Insan(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    /*Insan sınıfının get ve set metotları*/
    public String getAdSoyad() {
        return this.adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

}
