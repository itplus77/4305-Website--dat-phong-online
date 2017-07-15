package entities;

public class ThanhToan {
    
    private String idthanhtoan;
    private PhieuDat phieuDat;
    private Float ThanhTien;

    public ThanhToan(String idthanhtoan, PhieuDat phieuDat, Float ThanhTien) {
        this.idthanhtoan = idthanhtoan;
        this.phieuDat = phieuDat;
        this.ThanhTien = ThanhTien;
    }

    public ThanhToan(PhieuDat phieuDat, Float ThanhTien) {
        this.phieuDat = phieuDat;
        this.ThanhTien = ThanhTien;
    }

    public ThanhToan() {
    }

    public String getIdthanhtoan() {
        return idthanhtoan;
    }

    public void setIdthanhtoan(String idthanhtoan) {
        this.idthanhtoan = idthanhtoan;
    }

    public PhieuDat getPhieuDat() {
        return phieuDat;
    }

    public void setPhieuDat(PhieuDat phieuDat) {
        this.phieuDat = phieuDat;
    }

    public Float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(Float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
    
}
