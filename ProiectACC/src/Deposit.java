import java.util.Comparator;

public class Deposit{
    private int id;
    private int cordX;
    private int cordY;
    private int requires;

    public Deposit(int id, int cordX, int cordY, int requires)  {
        this.id = id;
        this.cordX = cordX;
        this.cordY = cordY;
        this.requires = requires;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCordX() {
        return cordX;
    }

    public void setCordX(int cordX) {
        this.cordX = cordX;
    }

    public int getCordY() {
        return cordY;
    }

    public void setCordY(int cordY) {
        this.cordY = cordY;
    }

    public int getRequires() {
        return requires;
    }

    public void setRequires(int requires) {
        this.requires = requires;
    }

}
