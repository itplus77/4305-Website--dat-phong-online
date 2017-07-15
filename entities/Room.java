package entities;

public class Room {
    
    private String idroom;
    private String nameP;
    private String type;

    public Room(String idroom, String nameP, String type) {
        this.idroom = idroom;
        this.nameP = nameP;
        this.type = type;
    }

    public Room(String idroom) {
        this.idroom = idroom;
    }

    public Room() {
    }

    public String getIdroom() {
        return idroom;
    }

    public void setIdroom(String idroom) {
        this.idroom = idroom;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
