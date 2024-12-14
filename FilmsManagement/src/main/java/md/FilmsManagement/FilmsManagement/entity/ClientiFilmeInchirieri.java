package md.FilmsManagement.FilmsManagement.entity;

import java.util.List;

public class ClientiFilmeInchirieri {

    private String id_film;
    private String titlu;
    private int an_lansare;
    @lombok.Setter
    private List<clienti> clientiList;

    public ClientiFilmeInchirieri(String id_film, String titlu, int an_lansare, List<clienti> clientiList) {
        this.id_film = id_film;
        this.titlu = titlu;
        this.an_lansare = an_lansare;
        this.clientiList = clientiList;
    }

    public String getId() {
        return id_film;
    }

    public void setId_film(String id_film) {
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

    public List<clienti> getClientiList() {
        return clientiList;
    }

    public void setClientiList(List<clienti> clientiList) {
        this.clientiList = clientiList;
    }

    @Override
    public String toString() {
        return "UniversityStudent{" +
                "id_film=" + id_film +
                ", titlu='" + titlu + '\'' +
                ", an_lansare='" + an_lansare + '\'' +
                ", clientiList=" + clientiList +
                '}';
    }
}