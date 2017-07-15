package entities;

public class PhieuDat {
    
    private String idphieu;
    private Room room;
    private String datein;
    private String dateout;
    private Khach khach;
    private boolean kichhoat;

    public PhieuDat(String idphieu, Room room, String datein, String dateout, Khach khach, boolean kichhoat) {
        this.idphieu = idphieu;
        this.room = room;
        this.datein = datein;
        this.dateout = dateout;
        this.khach = khach;
        this.kichhoat = kichhoat;
    }

    
    public PhieuDat(Room room, String datein, String dateout, Khach khach) {
        this.room = room;
        this.datein = datein;
        this.dateout = dateout;
        this.khach = khach;
    }

    public PhieuDat() {
    }

    public String getIdphieu() {
        return idphieu;
    }

    public void setIdphieu(String idphieu) {
        this.idphieu = idphieu;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getDatein() {
        return datein;
    }

    public void setDatein(String datein) {
        this.datein = datein;
    }

    public String getDateout() {
        return dateout;
    }

    public void setDateout(String dateout) {
        this.dateout = dateout;
    }

    public Khach getKhach() {
        return khach;
    }

    public void setKhach(Khach khach) {
        this.khach = khach;
    }

    public boolean isKichhoat() {
        return kichhoat;
    }

    public void setKichhoat(boolean kichhoat) {
        this.kichhoat = kichhoat;
    }
    
    
}
