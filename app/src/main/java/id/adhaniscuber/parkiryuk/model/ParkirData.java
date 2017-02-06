package id.adhaniscuber.parkiryuk.model;

/**
 * Created by adhaniscuber on 23/01/17.
 */

public class ParkirData {
    private String nama, alamat, kota, jenis, biayaMotor, biayaMotorTambah, biayaMobil, biayaMobilTambah, maxBiayaMotor, maxBiayaMobil, motor, mobil, totalKendaraan, keterangan;
    private Double pylatitude, pylongitude;

    public ParkirData(){

    }

    public ParkirData(String nama, String alamat, String kota, String jenis, String biayaMotor, String biayaMobil, String biayaMotorTambah, String biayaMobilTambah, String maxBiayaMotor, String maxBiayaMobil, String keterangan, String motor, String mobil, String totalKendaraan, Double pylongitude, Double pylatitude) {
        this.nama = nama;
        this.alamat = alamat;
        this.kota = kota;
        this.jenis = jenis;
        this.biayaMotor = biayaMotor ;
        this.biayaMobil = biayaMobil ;
        this.biayaMotorTambah = biayaMotorTambah ;
        this.biayaMobilTambah = biayaMobilTambah ;
        this.maxBiayaMotor = maxBiayaMotor ;
        this.maxBiayaMobil = maxBiayaMobil ;
        this.keterangan = keterangan ;
        this.totalKendaraan = totalKendaraan ;


        this.motor = motor;
        this.mobil = mobil;

        this.pylatitude = pylatitude;
        this.pylongitude = pylongitude;
    }


    // nama
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Alammat
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    // kota
    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    // jenis
    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    // biaya motor
    public String getBiayaMotor() {
        return biayaMotor;
    }

    public void setBiayaMotor(String biayaMotor) {
        this.biayaMotor = biayaMotor;
    }

    // biaya motor tambah
    public String getBiayaMotorTambah() {
        return biayaMotorTambah;
    }

    public void setBiayaMotorTambah(String biayaMotorTambah) {
        this.biayaMotorTambah = biayaMotorTambah;
    }

    // biaya mobil
    public String getBiayaMobil() {
        return biayaMobil;
    }

    public void setBiayaMobil(String biayaMobil) {
        this.biayaMobil = biayaMobil;
    }

    // biaya mobil tambah
    public String getBiayaMobilTambah() {
        return biayaMobilTambah;
    }

    public void setBiayaMobilTambah(String biayaMobilTambah) {
        this.biayaMobilTambah = biayaMobilTambah;
    }

    // max biaya motor
    public String getMaxBiayaMotor() {
        return maxBiayaMotor;
    }

    public void setMaxBiayaMotor(String maxBiayaMotor) {
        this.maxBiayaMotor= maxBiayaMotor;
    }

    // max biaya mobil
    public String getMaxBiayaMobil() {
        return maxBiayaMobil;
    }

    public void setMaxBiayaMobil(String maxBiayaMobil) {
        this.maxBiayaMobil = maxBiayaMobil;
    }

    // motor
    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    // mobil
    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    // total kendaraan
    public String getTotalKendaraan() {
        return totalKendaraan;
    }

    public void setTotalKendaraan(String totalKendaraan) {
        this.totalKendaraan = totalKendaraan;
    }

    // mobil
    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    // pylatitude
    public Double getPylatitude() {
        return pylatitude;
    }

    public void setPylatitude(Double pylatitude) {
        this.pylongitude = pylatitude;
    }

    // pylongitude
    public Double getPylongitude() {
        return pylongitude;
    }

    public void setPylongitude(Double pylongitude) {
        this.pylongitude = pylongitude;
    }

}
