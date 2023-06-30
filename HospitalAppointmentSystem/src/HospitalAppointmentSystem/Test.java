package HospitalAppointmentSystem;

import java.util.Scanner;

/**
 *
 * @author emiro
 */
public class Test {

    public static void main(String[] args) {
        boolean sureklilik = true;//uygulamanın uyarı alındıkça süreki olarak çalışması için bir döngü değişkeni oluşturduk
        while (sureklilik == true) {//değişken doğru olduğu sürece program çalışır

            /*islemler metodumuzu try-catch içerisine aldık ve eğer bir exception yakalanırsa 
            *uyarı mesajı verip uygulamayı tekrardan işleme sokmak için girdi mesajı verdik*/
            try {
                islemler();
            } catch (Exception e) {
                System.out.println(e.toString() + " uyarısı alıyorsunuz !" + "\n"
                        + " ---------------------------------------------------------------------------------------");
                islemler();
            }

        }

    }

    public static void islemler() {
        /*Oluşturduğumuz her sınıftan nesneler üretiyoruz */

        //Sehir sınıfı sadece projenin daha detaylı olması için oluşturulmuştur
        Sehir sehir = new Sehir("İstanbul", 34);

        // İstanbul şehrinde 2 tane hastane ürettik
        Hastane[] hastaneler = new Hastane[2];
        hastaneler[0] = new Hastane("Baypark", sehir);
        hastaneler[1] = new Hastane("Kolan", sehir);

        // 5 tane doktor ürettik, sadece 1 tane doktora randevu atamadık onun amacı ise doktor silmek istediğimizde farklı çıktıları görebilmek için
        Doktor[] doktorlar = new Doktor[5];
        doktorlar[0] = new Doktor("Emir");
        doktorlar[1] = new Doktor("Nur");
        doktorlar[2] = new Doktor("Berk");
        doktorlar[3] = new Doktor("Eray");
        doktorlar[4] = new Doktor("Erhan"); // randevu atanmayan doktor

        // Her hastane başına iki klinik olacak şekilde 4 tane klinik ürettik
        Klinik[] klinikler = new Klinik[4];
        klinikler[0] = new Klinik("1", doktorlar[0]);
        klinikler[1] = new Klinik("2", doktorlar[1]);
        klinikler[2] = new Klinik("3", doktorlar[2]);
        klinikler[3] = new Klinik("4", doktorlar[3]);

        /*Ürettiğimiz kliniklerin her iki tanesini aynı hastaneye atadık*/
        hastaneler[0].klinikEkle(klinikler[0]);
        hastaneler[0].klinikEkle(klinikler[1]);
        hastaneler[1].klinikEkle(klinikler[2]);
        hastaneler[1].klinikEkle(klinikler[3]);

        //4 tane farklı hasta oluşturduk sunumda karışıklık olmaması için yapıcı metotlara şimdilik sadece kısaca isimler koyduk
        Hasta[] hastalar = new Hasta[4];
        hastalar[0] = new Hasta("Haydar", "21698260644");
        hastalar[1] = new Hasta("Aysenur", "12749326092");
        hastalar[2] = new Hasta("Alp", "14895612356");
        hastalar[3] = new Hasta("Ceren", "45615947581");

        // geçmiş ve gelecek randevular için 5 tane  farklı tarih ürettik
        Tarih[] randevuTarihleri = new Tarih[5];
        randevuTarihleri[0] = new Tarih(2022, 01, 25);
        randevuTarihleri[1] = new Tarih(2022, 01, 26);
        randevuTarihleri[2] = new Tarih(2022, 01, 12);
        randevuTarihleri[3] = new Tarih(2022, 01, 17);
        randevuTarihleri[4] = new Tarih(2022, 01, 28);

        // hastaların randevu oluşturması için 7 tane randevu ürettik ve iki tanesini hastalara atamadık
        Randevu[] randevular = new Randevu[7];
        randevular[0] = new Randevu(1, doktorlar[0], randevuTarihleri[0], 15);
        randevular[1] = new Randevu(2, doktorlar[1], randevuTarihleri[4], 18);
        randevular[2] = new Randevu(3, doktorlar[2], randevuTarihleri[0], 13);//hiçbir hastaya ait değil
        randevular[3] = new Randevu(4, doktorlar[3], randevuTarihleri[2], 14);
        randevular[4] = new Randevu(5, doktorlar[0], randevuTarihleri[1], 17);
        randevular[5] = new Randevu(6, doktorlar[0], randevuTarihleri[3], 16);
        randevular[6] = new Randevu(7, doktorlar[2], randevuTarihleri[0], 12);//hiçbir hastaya ait değil

        /*her hastaya randevular atadık ve ileride randevu değişikliği yapılması için 2 randevu hiç bir hastaya atanmadı*/
        hastalar[0].randevuAl(randevular[0]);
        hastalar[1].randevuAl(randevular[1]);
        hastalar[2].randevuAl(randevular[3]);
        hastalar[3].randevuAl(randevular[4]);
        hastalar[0].randevuAl(randevular[5]);

        try {

            Scanner scanner = new Scanner(System.in);
            Scanner input = new Scanner(System.in);
            System.out.print("                      YAPMAK İSTEDİĞİNİZ İŞLEMİ BİR SAYI İLE SEÇİNİZ" + "\n"
                    + " ---------------------------------------------------------------------------------------" + "\n"
                    + "|    [1] Adı girilen hastane ve klinik bilgileri                                        |" + "\n"
                    + "|    [2] Şimdiye kadar alınmış farklı kliniklerden olan randevuların listelenmesi       |" + "\n"
                    + "|    [3] En çok randevusu olan hastanın tüm randevu bilgilerinin listelenmesi           |" + "\n"
                    + "|    [4] Adı girilen hastanın geçmişteki ve gelecekteki randevularının listelenmesi     |" + "\n"
                    + "|    [5] Adı girilen hastanın herhangi bir randevusunun iptal edilmesi                  |" + "\n"
                    + "|    [6] İsim ile hasta araması yapmak ve bu hastanın randevularına ulaşılması          |" + "\n"
                    + "|    [7] Adı girilen hastanenin herhangi bir kliniğinin silinmesi                       |" + "\n"
                    + "|    [8] Adı girilen doktorun silinmesi                                                 |" + "\n"
                    + "|    [9] Verilen tarihler arasındaki bütün tamamlanmış randevuların listelenmesi        |" + "\n"
                    + "|   [10] Verilen tarihler arasındaki bütün tamamlanmamış randevuların listelenmesi      |" + "\n"
                    + "|   [11] Doktorlara ait maksimum, minimum ve ortalama randevu sayılarının listelenmesi  |" + "\n"
                    + " ---------------------------------------------------------------------------------------" + "\n");

            while (true) {


                /*Kullanıcıdan işlem yapabilmesi için bir sayı değeri girmesini istedik*/
                int sayi = scanner.nextInt();
                if (sayi == 1) {
                    System.out.print("Arama yapmak istediğiniz hastane adını giriniz: ");
                    String a = scanner.next();
                    boolean bulunduMu = false;
                    for (int i = 0; i < hastaneler.length; i++) { // kullanıcının girdiği hastane ismini hastaneler dizisindeki nesnelerin adlarıyla karşılaştırıyoruz
                        if (hastaneler[i].getHastaneAd().equalsIgnoreCase(a)) {//eğer aynı ada sahip hastaneye ulaşılırsa bu hastanenin kliniklerini listeliyoruz
                            System.out.println("\n" + hastaneler[i].getHastaneAd() + " Hastanesi'nde iki klinik bulunmaktadır ve bu kliniklerin bilgileri şöyledir:" + "\n"
                                    + "------------------------------------------------------------------------------------");
                            hastaneler[i].klinikListele();
                            bulunduMu = true;
                            break;
                        }
                    }
                    if (bulunduMu == false) {//hastane adları uyuşmazsa uyarı mesajı atıyoruz
                        System.out.println("Böyle bir hastane bulunamadı.");
                    }

                } else if (sayi == 2) {//kliniklerdeki doktorların alınmış randevularını listeliyoruz
                    System.out.println("Şimdiye kadar alınmış farklı kliniklerden olan randevular şöyledir: " + "\n" + "-------------------------------------------------------------------");
                    for (int i = 0; i < klinikler.length; i++) {
                        klinikler[i].getDoktor().randevuListele();
                    }
                    System.out.println("\n");
                } else if (sayi == 3) {
                    int maksRandevu = 0;
                    Hasta enCokRandevulu = new Hasta();//en çok randevulu hastanın kayıt altına alınması için yeni bir hasta oluşturuyoruz
                    for (int i = 1; i < hastalar.length; i++) {
                        maksRandevu = hastalar[0].getRandevuAdet();// en çok randevuyu önce dizideki ilk hastanın randevu adedine atayıp sonra if - else blokları ile asıl sahibini buluyoruz
                        if (hastalar[i].getRandevuAdet() > maksRandevu) {
                            maksRandevu = hastalar[i].getRandevuAdet();
                            enCokRandevulu = hastalar[i];
                        } else {
                            enCokRandevulu = hastalar[0];
                        }
                    }
                    System.out.println("En çok randevuya sahip olan hastanın ismi " + enCokRandevulu.getAdSoyad() + ", kimlik numarası: " + enCokRandevulu.getTcNo() + " ve son olarak sahip olduğu randevu adeti " + enCokRandevulu.getRandevuAdet() + " tanedir.");
                    System.out.println("Ayrıca randevuları şöyledir: ");
                    enCokRandevulu.randevuListele();
                } else if (sayi == 4) {
                    System.out.print("Tüm randevularını öğrenmek istediğiniz hastanın adını giriniz: ");
                    String degisken = input.nextLine();
                    boolean durum = false;
                    for (int i = 0; i < hastalar.length; i++) {//girilen ad ile hastalar dizisinin elemanlarının adları karşılaştırılır
                        if (hastalar[i].getAdSoyad().equalsIgnoreCase(degisken)) {//eğer adlar uyuşursa hastanın randevularını listeliyoruz
                            hastalar[i].randevuListele();
                            durum = true;
                        }
                    }
                    if (durum == false) {//adlar aynı değilse uyarı mesajı veriyoruz
                        System.out.println(degisken + " isimli bir hasta bulunamadı.");
                    }

                } else if (sayi == 5) {
                    System.out.print("Herhangi bir randevusunu iptal etmek istediğiniz hastanın adını giriniz: ");
                    String hastaAd = input.nextLine();
                    boolean durum = false;
                    for (int i = 0; i < hastalar.length; i++) {//girilen hasta ismi hastalar dizisinin elemanlarının isimleriyle karşılaştırılır
                        if (hastalar[i].getAdSoyad().equalsIgnoreCase(hastaAd)) {
                            durum = true;
                            System.out.print("İptal etmek istediğiniz randevunun ID numarasını giriniz: ");//eğer isimler uyuşursa iptal etmek istenen randevunun ID numarası istenir
                            int randevuId = input.nextInt();
                            Randevu[] hastaRandevu = hastalar[i].getRandevuListesi();//isimi eşleşen hastanın randevuları bir diziye atanır
                            for (int j = 0; j < hastalar[i].getRandevuListesi().length; j++) {
                                if (hastaRandevu[j].getRandevuId() == randevuId) {//eğer randevu ID numarası bu dizideki randevu ID lerinden herhangi birisi ile uyuşursa tarihe bakılır
                                    if (hastaRandevu[j].getTarihGun() - hastalar[i].getGun() > 0) {//silinmek istenen randevunun tarihi, bugünün tarihi ile kıyaslanır yani ayın 24'ü
                                        hastalar[i].randevuSil(hastaRandevu[j]); // bugünden ileri bir tarihse randevu silinebilir
                                        break;
                                    } else {//tarih uyuşumu olmazsa uyarı mesajı verir
                                        System.out.println("İptal etmek istediğiniz " + randevuId + " ID numaralı randevunun tarihi, bir randevuyu silmek için gerekli tarih koşullarına uymamaktadır.");
                                    }
                                } else {//ID uyuşması olmazsa uyarı mesajı verir
                                    System.out.println(hastaAd + " isimli hastanın " + randevuId + " ID numaralı bir randevusu bulunmamaktadır.");
                                    break;
                                }
                            }

                        }

                    }
                    if (durum == false) {// hasta isimi uyuşumu olmazsa uyarı verir
                        System.out.println(hastaAd + " isimli bir hasta bulunmamaktadır.");

                    }

                } else if (sayi == 6) {
                    System.out.print("Arama yapmak istediğiniz hastanın ismini giriniz: ");
                    String s = input.next();
                    boolean varMi = false;
                    for (int i = 0; i < hastalar.length; i++) {//girilen hasta ismi hastalar dizisinin elemanlarının isimleriyle karşılaştırılır
                        if (hastalar[i].getAdSoyad().equalsIgnoreCase(s)) {//eğer isimler eşleşirse hastanın randevularını listeler
                            hastalar[i].randevuListele();
                            varMi = true;
                        }
                    }
                    if (varMi == false) {//eğer hastanın adı uyuşmazsa uyarı mesajı verir
                        System.out.println(s + " isimli bir hasta bulunamamıştır.");

                    }

                } else if (sayi == 7) {
                    System.out.print("Silmek istediğiniz klinik için önce bir hastane adı giriniz:");
                    String hastaneAd = input.nextLine();
                    boolean durum1 = false;
                    boolean durum2 = false;
                    for (int i = 0; i < hastaneler.length; i++) {
                        if (hastaneler[i].getHastaneAd().equalsIgnoreCase(hastaneAd)) {//girilen hastane adı hastaneler dizisinin elemanlarının adları ile karşılaştırılır
                            durum1 = true;
                            System.out.print("Silmek istediğiniz klinik için klinik numarasını giriniz: ");//eğer hastene isimleri uyuşursa klinik numarası alınır
                            String klinikNo = input.next();
                            for (int j = 0; j < hastaneler[i].getKlinikListesi().length; i++) {//alınan klinik numarası adı eşleşen hastanenin klinikleri içerisinde aranır
                                if (hastaneler[i].getKlinikListesi()[j].getKlinikNo().equals(klinikNo)) {//eğer klinik numaraları eşleşirse klinik silinir
                                    durum2 = true;
                                    hastaneler[i].klinikSil(hastaneler[i].getKlinikListesi()[j]);
                                    break;
                                } else {
                                    durum2 = false;
                                    break;
                                }

                            }
                            if (durum2 == false) {//klinik numaraları eşleşmezse uyarı mesajı verilir
                                System.out.println(hastaneAd + " hastanesinde " + klinikNo + " numaralı bir klinik bulunamadı.");
                            }
                        }
                    }
                    if (durum1 == false) {//hastane adları eşleşmezse uyarı mesajı verilir
                        System.out.println(hastaneAd + " isimli bir hastane bulunamadı.");
                    }
                } else if (sayi == 8) {
                    System.out.print("Silmek istediğiniz doktorun adını giriniz: ");
                    String silDoktor = input.nextLine();
                    boolean durum = false;
                    for (int i = 0; i < doktorlar.length; i++) {// bir doktor ismi alınır ve alınan isim doktorlar dizisinin elemanlarının isimleri ile karşılaştırılır
                        if (doktorlar[i].getAdSoyad().equalsIgnoreCase(silDoktor)) {//eğer isimler eşleşmişse diğer koşul (if) satırına geçilir
                            durum = true;
                            if (doktorlar[i].getRandevuAdeti() == 0) { //adı eşleşen doktorun randevusu yoksa, bu doktor silinir
                                System.out.println("İsmi " + doktorlar[i].getAdSoyad() + " olan doktorumuz silinmiştir.");
                                doktorlar[i] = null;
                            } else {//doktor randevuya sahip ise bu doktorun silinemeyeceği hakkında bilgi verir
                                System.out.println("Bu doktor randevulara sahip olduğundan silinemez.");
                                break;
                            }
                        }
                    }
                    if (durum == false) {//doktor isimleri eşleşmezse uyarı mesajı verilir
                        System.out.println(silDoktor + " isimli bir doktor bulunamadı.");
                    }

                } else if (sayi == 9) {
                    try {
                        System.out.print("Verilen tarihler arasındaki bütün tamamlanmış randevuların listelenmesi için önce ilk tarih giriniz (örn: yy/aa/gg şeklinde) : ");
                        String ilkTarih = input.nextLine();
                        String[] ilkTarih1 = ilkTarih.split("/");//alınan ilk tarih "/" değerine göre ayırılarak String bir diziye atanır
                        System.out.print("Şimdi ise ikinci tarihi giriniz:");
                        String ikinciTarih = input.nextLine();
                        String[] ikinciTarih1 = ikinciTarih.split("/");//alınan ikinci tarih "/" değerine göre ayırılarak String bir diziye atanır
                        /*oluşturulan tarih dizilerinin elemanları sırasıyla Tarih sınıfın constructor'ına girilir*/
                        Tarih ilk = new Tarih(Integer.parseInt(ilkTarih1[0]), Integer.parseInt(ilkTarih1[1]), Integer.parseInt(ilkTarih1[2]));//ilk tarih
                        Tarih iki = new Tarih(Integer.parseInt(ikinciTarih1[0]), Integer.parseInt(ikinciTarih1[1]), Integer.parseInt(ikinciTarih1[2]));//ikinci tarih
                        Tarih bugununTarihi = new Tarih(2022, 01, 24);//bugünün tarihi(sunumda kolaylık olması adına oluşturulur)
                        boolean durum2 = false;
                        for (int i = 0; i < randevular.length; i++) {//randevular dizisinin elemanlarının tarihlerine ulaşmak için döngü kurulur
                            Tarih araTarih = randevular[i].getTarih();//randevular dizisinin elemanlarının her birinin tarih değerieri bir sabit değere atanır
                            /*bu sabit tarih, girilen ilk tarihten sonra mı, ikinci tarihten önce mi, bugünün tarihinden önce mi diye bakılır*/
                            if (araTarih.sonraMi(ilk, araTarih) == false && araTarih.sonraMi(iki, araTarih) == true && araTarih.sonraMi(bugununTarihi, araTarih) == true) {
                                System.out.println(randevular[i].toString());//eğer koşullar uyarsa randevu yazdırılır
                                durum2 = true;
                            }
                        }
                        if (durum2 == false) {//tarih aralıkları uyuşmazsa uyarı mesajı verilir
                            System.out.println("Girdiğiniz tarih aralıklarında herhangi tamamlanmış bir randevu bulunmamaktadır.");

                        }
                    } catch (Exception e) {
                        System.out.println(e.toString() + " uyarısı alıyorsunuz !");
                    }

                } else if (sayi == 10) {
                    try {

                        System.out.print("Verilen tarihler arasındaki bütün tamamlanmamış/gelecekteki randevuların listelenmesi için önce ilk tarihi giriniz (örn: yy/aa/gg şeklinde) :");
                        String ilkTarih = input.nextLine();
                        String[] ilkTarih1 = ilkTarih.split("/");//alınan ilk tarih "/" değerine göre ayırılarak String bir diziye atanır
                        System.out.print("Şimdi ise ikinci tarihi giriniz:");
                        String ikinciTarih = input.nextLine();
                        String[] ikinciTarih1 = ikinciTarih.split("/");//alınan ikinci tarih "/" değerine göre ayırılarak String bir diziye atanır
                        /*oluşturulan tarih dizilerinin elemanları sırasıyla Tarih sınıfın constructor'ına girilir*/
                        Tarih ilk = new Tarih(Integer.parseInt(ilkTarih1[0]), Integer.parseInt(ilkTarih1[1]), Integer.parseInt(ilkTarih1[2]));//ilk tarih
                        Tarih iki = new Tarih(Integer.parseInt(ikinciTarih1[0]), Integer.parseInt(ikinciTarih1[1]), Integer.parseInt(ikinciTarih1[2]));//ikinci tarih
                        Tarih bugununTarihi = new Tarih(2022, 01, 24);//bugünün tarihi(sunumda kolaylık olması adına oluşturulur)
                        boolean durum2 = false;
                        for (int i = 0; i < randevular.length; i++) {//randevular dizisinin elemanlarının tarihlerine ulaşmak için döngü kurulur
                            Tarih araTarih = randevular[i].getTarih();//randevular dizisinin elemanlarının her birinin tarih değerieri bir sabit değere atanır
                            /*bu sabit tarih, girilen ilk tarihten sonra mı, ikinci tarihten önce mi, bugünün tarihinden sonra mı diye bakılır*/
                            if (araTarih.sonraMi(ilk, araTarih) == false && araTarih.sonraMi(iki, araTarih) == true && araTarih.sonraMi(bugununTarihi, araTarih) == false) {
                                System.out.println(randevular[i].toString());//eğer koşullar uyarsa randevu yazdırılır
                                durum2 = true;
                            }
                        }
                        if (durum2 == false) {//tarih aralıkları uyuşmazsa uyarı mesajı verilir
                            System.out.println("Girdiğiniz tarih aralıklarında herhangi tamamlanmamış/gelecekte bir randevu bulunmamaktadır.");

                        }
                    } catch (Exception e) {
                        System.out.println(e.toString() + " uyarısı alıyorsunuz !");
                    }

                } else if (sayi == 11) {
                    System.out.println("Doktorlara ait maksimum, minimum ve ortalama randevu adetleri" + "\n" + "--------------------------------------------------------------");
                    int maks = 0, toplam = 0, min = 0;//maksimum, minimum ve toplam randevu değerlerini tutan değişkenler
                    Doktor maksDoktor = new Doktor();//maksimum randevuya sahip olan doktorların verileri tutulur
                    Doktor minDoktor = new Doktor();//minimum randevuya sahip olan doktorların verileri tutulur                   
                    for (int i = 1; i < doktorlar.length; i++) {//doktorların randevu adetlerine ulaşmak için doktorlar dizisinin elemanları döngüye alınır
                        toplam += doktorlar[i].getRandevuAdeti();//toplam randevu adetini bulmak için dizinin indis olarak [0] elemanı hariç toplanmaya başlar
                        maks = doktorlar[0].getRandevuAdeti();//maksimum randevu adeti sabit olarak dizinin ilk elemanı(indis olarak [0])'na atılır
                        maksDoktor = doktorlar[0];//maksimum randevuya sahip olan doktorda dizinin ilk elemanına atılır
                        if (doktorlar[i].getRandevuAdeti() > maks) {//eğer diğer elemanlardan birisinin randevu adedi daha fazla ise
                            maks = doktorlar[i].getRandevuAdeti();//maksimum randevu adedi o doktorun randevu adedine eşit olur
                            maksDoktor = doktorlar[i];//ve maksDoktor değişkeni de bu doktora atanır
                        } else if (doktorlar[i].getRandevuAdeti() < maks) {
                            min = doktorlar[i].getRandevuAdeti();//eğer diğer elemanlardan birisi birisinin randevu adedi daha az ise minimum adet bu doktorunki olur
                            minDoktor = doktorlar[i];//minDoktor değişkeni de bu doktora atanır
                        }
                    }
                    /*döngüden çıkan toplam adedine dizinin ilk
                    *elemanının randevu adedi de eklenip dizinin uzunluğuna bölünür*/
                    int ortalama = (toplam + doktorlar[0].getRandevuAdeti()) / doktorlar.length;
                    System.out.print("Maksimum randevu adeti " + maksDoktor.getAdSoyad() + " isimli doktora ait ve randevu adeti " + maks + " tanedir." + "\n"
                            + "Ayrıca randevular şöyledir: " + "\n");
                    maksDoktor.randevuListele();
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Minimum randevu adeti " + minDoktor.getAdSoyad() + " isimli doktora ait ve randevu adeti " + min + " tanedir." + "\n" + "--------------------------------------------------------------" + "\n"
                            + "Ayrıca toplam ortalama randevu adeti " + ortalama + " tanedir." + "\n" + "");

                } else {//eğer 0 ve 12 arasında bir sayı girilmezse uyarı verir
                    System.out.println("Yanlış işlem girdiniz");
                }

            }
        } catch (Exception e) {
            System.out.println(e.toString() + " uyarısı alıyorsunuz !" + "\n"
                    + " ---------------------------------------------------------------------------------------");
        }
    }
}
