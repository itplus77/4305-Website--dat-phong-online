package entities;

public class Khach {
    private String cmnd;
    private String nameK;
    private String sdt;
    private String email;

    public Khach(String cmnd, String nameK, String sdt, String email) {
        this.cmnd = cmnd;
        this.nameK = nameK;
        this.sdt = sdt;
        this.email = email;
    }

    public Khach() {
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getNameK() {
        return nameK;
    }

    public void setNameK(String nameK) {
        this.nameK = nameK;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
