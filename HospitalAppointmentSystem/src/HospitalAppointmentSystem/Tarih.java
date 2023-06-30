package HospitalAppointmentSystem;

/**
 * @file Second Project
 * @description Our program provides hospital automation for users to perform
 * certain(limited) actions
 * @assignment Second Project HW
 * @date 15.01.2022
 * @author Emir Ozalp, emir.ozalp@stu.fsm.edu.tr
 */
public class Tarih {

    /*Tarih sınıfına ait yıl, ay ve gün değerler alan integer değişkenler tanımlandı*/
    private int yil;
    private int ay;
    private int gun;

    /*Bu değişkenleri direkt olarak kullanan bir constructor oluşturuldu*/
    public Tarih(int yil, int ay, int gun) {
        this.yil = yil;
        this.ay = ay;
        this.gun = gun;
    }

    //Tarih sınıfının değişkenlerine diğer sınıflar tarafından ulaşım sağlanması için get ve set metotları oluşturuldu
    public int getYil() {
        return yil;
    }

    public void setYil(int yil) {
        this.yil = yil;
    }

    public int getAy() {
        return ay;
    }

    public void setAy(int ay) {
        this.ay = ay;
    }

    public int getGun() {
        return gun;
    }

    public void setGun(int gun) {
        this.gun = gun;
    }

    /*Tarihi String olarak döndüren ve Object sınıfına ait olan toString metodu override edildi*/
    @Override
    public String toString() {
        return this.gun + "." + this.ay + "." + this.yil;
    }

    /*Test sınıfında kulllanılan ve büyük öneme sahip olan iki tarihi kıyaslayan
     *sonraMi metodu oluşturuldu, bu metot geriye boolean sonuç üretir */
    public boolean sonraMi(Tarih tarih1, Tarih tarih2) {
        if (tarih1.yil - tarih2.yil >= 0 && tarih1.ay - tarih2.ay >= 0 && tarih1.gun - tarih2.gun >= 0) {
            return true;
        } else {
            return false;
        }
    }

}
