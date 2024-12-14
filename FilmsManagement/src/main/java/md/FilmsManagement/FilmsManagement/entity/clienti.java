package md.FilmsManagement.FilmsManagement.entity;

public class clienti {
    private int id_client;
    private String nume;
    private String email;
    private String telefon;


    public clienti(int id_client, String nume, String email, String telefon) {
        this.id_client = id_client;
        this.nume = nume;
        this.email = email;
        this.telefon = telefon;
    }


    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}

