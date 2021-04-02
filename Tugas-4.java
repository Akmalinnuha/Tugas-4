package Java;

public class contoh {
    public static void main(String[] args) {
        Manusia[] person = new Manusia[3];
        Mahasiswa[] stud = new Mahasiswa[3];
        Pekerja[] worker = new Pekerja[3];
        Manager[] pengelola = new Manager[3];
        person[0] = new Manusia("Faridah","109",false,false);
        person[1] = new Manusia("Raden","213",true,true);
        person[2] = new Manusia("Handoko","643",false,true);
        stud[0] = new Mahasiswa("Cecil","221",false,false,"193203698725410",3.4);
        stud[1] = new Mahasiswa("Feby","110",false,false,"198701300981265",3.6);
        stud[2] = new Mahasiswa("Regita","309",false,false,"191024723140856",3.55);
        worker[0] = new Pekerja(9,24,"653098423711","Rian","444",true,true);
        worker[1] = new Pekerja(5,30,"195443109432","Fina","123",true,false);
        worker[2] = new Pekerja(7,28,"376509678342","Karim","564",false,true);
        pengelola[0] = new Manager(10,6,20,"503201398760","Santoso","115",true,true);
        pengelola[1] = new Manager(14,8,23,"245678965090","Hilmi","666",true,true);
        pengelola[2] = new Manager(20,5,21,"465712192888","Iyan","420",true,true);
        for(int i = 0;i < 3;i++) {
            System.out.println(person[i].toString());
        }

        for(int i = 0;i < 3;i++) {
            System.out.println(stud[i].toString());
        }

        for(int i = 0;i < 3;i++) {
            System.out.println(worker[i].toString());
        }

        for(int i = 0;i < 3;i++) {
            System.out.println(pengelola[i].toString());
        }
    }
}

class Manusia {
    String nama;
    String NIK;
    boolean jenisKelamin;
    boolean menikah;

    Manusia() {}

    Manusia(String a,String b, boolean c,boolean d) {
        nama = a;
        NIK = b;
        jenisKelamin = c;
        menikah = d;
    }
    
    public String toString() {
        String aran = "Nama         : "+nama+"\n";
        String kep = "NIK          : "+NIK+"\n";
        String sex;
        if (jenisKelamin == true) {
            sex = "jenisKelamin : Laki-laki \n";
        } else {
            sex = "jenisKelamin : Perempuan \n";
        }
        String pay = "Pendapatan   : "+getPendapatan()+"$ \n";
        return aran +kep + sex +pay;

    }

    public double getTunjangan() {
        if (menikah == true) {
            if (jenisKelamin == true) {
                return 25.0;
            } else {
                return 20.0;
            }
        } else {
            return 15.0;
        }
    }

    public double getPendapatan() {
        return getTunjangan();
    }
}

class Mahasiswa extends Manusia{
    String NIM;
    double IPK;
    
    Mahasiswa() {
        super();
    }

    Mahasiswa(String a,String b, boolean c,boolean d,String e,double f) {
        super(a,b,c,d);
        NIM = e;
        IPK = f;
    }

    String getStatus() {
        String kasijo = NIM.substring(0, 2);
        int angkatan = Integer.parseInt(kasijo);
        angkatan += 2000;
        String prodi = NIM.substring(6, 7);
        String major = "";
        switch (prodi) {
            case "2":
                major = "Teknik Meniup Gelembung";
                break;
            case "3":
                major = "Teknik Berburu Ubur Ubur";
                break;
            case "4":
                major = "Sistem Perhamburgeran";
                break;
            case "6":
                major = "Pendidikan Chum Bucket";
                break;
            case "7":
                major = "Teknologi Telepon Kerang";
                break;
        }
        String point = "status       : "+major+", "+angkatan;
        return point;
    }

    @Override
    public String toString() {
        double pay = getBeasiswa()+getPendapatan();
        String id = "Nama         : "+nama+"\n"+"NIK          : "+NIK+"\n";
        String sex;
        if (jenisKelamin == true) {
            sex = "jenisKelamin : Laki-laki \n";
        } else {
            sex = "jenisKelamin : Perempuan \n";
        }
        String pendapatan = "Pendapatan   : "+pay+"$ \n";
        String nim = "NIM          : "+NIM+"\n";
        String ipk = "IPK          : "+IPK+"\n";
        String stat = getStatus()+"\n";
        return id+sex+pendapatan+nim+ipk+stat;
    }

    double getBeasiswa() {
        double beasiswa = 0;
        if (IPK > 3.5 && IPK <= 4.0) {
            beasiswa = 75.0;
        } else if (IPK >= 3.0 && IPK <= 3.5) {
            beasiswa = 50.0;
        }
        return beasiswa;
    }
}

class Pekerja extends Manusia {
    double gaji = 0.0;
    static double bonus = 0.0;
    int jamKerja;
    int hariKerja;
    String NIP;

    Pekerja() {super();}

    Pekerja(int jamKerja, int hariKerja, String NIP,String a,String b, boolean c,boolean d) {
        super(a,b,c,d);
        this.jamKerja = jamKerja;
        this.hariKerja = hariKerja;
        this.NIP = NIP;
    }

    double getGaji() {
        if (jamKerja>7) {
            gaji = 7*10*hariKerja;
        } else {
            gaji = jamKerja*10*hariKerja;
        }
        return gaji;
    }

    double getBonus() {
        bonus = 0;
        if (jamKerja>7) {
            bonus += ((jamKerja-7)*15*5*4);
        }
        for(int i = 1;i <= hariKerja;i++) {
            if ((i+1)%7==0 || i%7==0) {
                bonus += (20*jamKerja);
            }
        }
        return bonus;
    }

    public void setBonus(double adding) {
        bonus = adding;
    }

    String getStatus() {
        String kantor = NIP.substring(0, 1);
        char cabang = NIP.charAt(2);
        String departemen = NIP.substring(6, 7);
        String office = "", div = "";
        switch (kantor) {
            case "1":
                office = "Mondstadt";
                break;
            case "2":
                office = "Liyue";
                break;
            case "3":
                office = "Inazuma";
                break;
            case "4":
                office = "Sumeru";
                break;
            case "5":
                office = "Fontaine";
                break;
            case "6":
                office = "Natlan";
                break;
            case "7":
                office = "Snezhnaya";
                break;
            default:
                break;
        }

        switch (departemen) {
            case "1":
                div = "Pemasaran";
                break;
            case "2":
                div = "Humas";
                break;
            case "3":
                div = "Riset";
                break;
            case "4":
                div = "Teknologi";
                break;
            case "5":
                div = "Personalia";
                break;
            case "6":
                div = "Akademik";
                break;
            case "7":
                div = "Administrasi";
                break;
            case "8":
                div = "Operasional";
                break;
            case "9":
                div = "Pembangunan";
                break;
            default:
                break;
        }
        String complete = "Status       : "+div+", "+office+" cabang "+cabang;
        return complete;
    }

    @Override
    public String toString() {
        double pay = getPendapatan()+getGaji()+getBonus();
        String id = "Nama         : "+nama+"\n"+"NIK          : "+NIK+"\n";
        String sex;
        if (jenisKelamin == true) {
            sex = "jenisKelamin : Laki-laki \n";
        } else {
            sex = "jenisKelamin : Perempuan \n";
        }
        String pendapatan = "Pendapatan   : "+pay+"$ \n";
        String Bonus = "Bonus        : "+getBonus()+"$ \n";
        String Gaji = "Gaji         : "+getGaji()+"$ \n";
        String stat = getStatus()+"\n";
        return id+sex+pendapatan+Bonus+Gaji+stat;
    }

}

class Manager extends Pekerja {
    int lamaKerja;

    Manager(){super();}
// saya bingung kenapa boolean menikah dan jenisKelaminnya ditukar di konstruktor manager ini
// padahal sebenarnya tidak perlu ditukar kan?    
    Manager(int lamaKerja, int jamKerja, int hariKerja, String NIP,String a,String b, boolean c,boolean d) {
        super(jamKerja, hariKerja,NIP, a,b,d,c);
        this.lamaKerja = lamaKerja;
    }

    @Override
    public String toString() {
        setBonus(getBonus()+(getBonus()*0.35));
        double pay = getPendapatan()+getGaji()+Pekerja.bonus+15;
        String id = "Nama         : "+nama+"\n"+"NIK          : "+NIK+"\n";
        String sex;
        if (jenisKelamin == true) {
            sex = "jenisKelamin : Laki-laki \n";
        } else {
            sex = "jenisKelamin : Perempuan \n";
        }
        String pendapatan = "Pendapatan   : "+pay+"$ \n";
        String Bonus = "Bonus        : "+Pekerja.bonus+"$ \n";
        String Gaji = "Gaji         : "+getGaji()+"$ \n";
        String stat = getStatus()+"\n";
        String sueMenggawe = "Lama Kerja   : "+lamaKerja+" Tahun";
        return id+sex+pendapatan+Bonus+Gaji+stat+sueMenggawe;
    }
}
