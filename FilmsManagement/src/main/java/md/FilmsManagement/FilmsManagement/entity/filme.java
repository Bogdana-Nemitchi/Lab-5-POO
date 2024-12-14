package md.FilmsManagement.FilmsManagement.entity;

public class filme {

    private int id_film;
    private String titlu;
    private int an_lansare;


    public filme(int id_film, String titlu, int an_lansare) {
        this.id_film = id_film;
        this.titlu = titlu;
        this.an_lansare = an_lansare;
    }
    public int getId_film() {
        return id_film;
    }

    public void setId_film(int id_film) {
        this.id_film = id_film;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public int getAn_lansare() {
        return an_lansare;
    }

    public void setAn_lansare(int an_lansare) {
        this.an_lansare = an_lansare;
    }

    @Override
    public String toString() {
        return "filme{" +
                "id_film=' " + id_film +'\'' +
                ", titlu=' " + titlu + '\'' +
                ", an_lansare=' " + an_lansare +
                '}';
    }
}
