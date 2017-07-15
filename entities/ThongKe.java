package entities;

public class ThongKe {
    
    private Room room;
    private Float tongtien;

    public ThongKe(Room room, Float tongtien) {
        this.room = room;
        this.tongtien = tongtien;
    }

    public ThongKe() {
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Float getTongtien() {
        return tongtien;
    }

    public void setTongtien(Float tongtien) {
        this.tongtien = tongtien;
    }
  
    
}
