package md.FilmsManagement.FilmsManagement.entity;

public class inchirieri{

    private int id_inchirieri;
    private int id_film;
    private int id_client;
    private int data_inchirieri;



    public inchirieri(int id_inchirieri, int id_film, int id_client, int data_inchirieri) {
        this.id_inchirieri = id_inchirieri;
        this.id_film = id_film;
        this.id_client = id_client;
        this.data_inchirieri = data_inchirieri;
    }
    public int getId_inchirieri() {
        return id_inchirieri;
    }

    public void setId_inchirieri(int id_inchirieri) {
        this.id_inchirieri = id_inchirieri;
    }

    public int getId_film() {
        return id_film;
    }

    public void setId_film(int id_film) {
        this.id_film = id_film;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }
    public int getData_inchirieri() {
        return data_inchirieri;
    }

    public void setData_inchirieri(int data_inchirieri) {
        this.data_inchirieri = data_inchirieri;
    }

    @Override
    public String toString() {
        return "inchirieri{" +
                "id_inchirieri=' " + id_inchirieri +'\'' +
                ", id_film=' " + id_film + '\'' +
                ", id_client=' " + id_client + '\'' +
                ", data_inchirieri=' " + data_inchirieri +
                '}';
    }
}
