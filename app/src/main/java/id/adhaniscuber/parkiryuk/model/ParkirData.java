package id.adhaniscuber.parkiryuk.model;

/**
 * Created by adhaniscuber on 23/01/17.
 */

public class ParkirData {

    private String nama, jalan, kelurahan, kecamatan, kota, kodepos, pylatitude, pylongitude, motor, mobil;

    public ParkirData() {
        this.nama = nama;
        this.jalan = jalan;
        this.kelurahan = kelurahan;
        this.kecamatan = kecamatan;
        this.kota = kota;
        this.kodepos = kodepos;
        this.pylatitude = pylatitude;
        this.pylongitude = pylongitude;
        this.motor = motor;
        this.mobil = mobil;
    }


    // nama
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // jalan
    public String getJalan() {
        return jalan;
    }

    public void setJalan(String jalan) {
        this.jalan = jalan;
    }

    // kelurahan
    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    // kecamatan
    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    // kota
    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    // kodepos
    public String getKodepos() {
        return kodepos;
    }

    public void setKodepos(String kodepos) {
        this.kodepos = kodepos;
    }

    // pylatitude
    public String getPylatitude() {
        return pylatitude;
    }

    public void setPylatitude(String pylatitude) {
        this.pylongitude = pylatitude;
    }

    // pylongitude
    public String getPylongitude() {
        return pylongitude;
    }

    public void setPylongitude(String pylongitude) {
        this.pylongitude = pylongitude;
    }

    // motor
    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.mobil = motor;
    }

    // mobil
    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }
}
