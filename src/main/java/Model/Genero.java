package Model;

public class Genero {
    private long id_genero;
    private String nome_genero;

    public Genero(long id_genero, String nome_genero) {
        this.id_genero = id_genero;
        this.nome_genero = nome_genero;
    }

    public Genero() {

    }

    public long getId_genero() {
        return id_genero;
    }

    public void setId_genero(long id_genero) {
        this.id_genero = id_genero;
    }

    public String getNome_genero() {
        return nome_genero;
    }

    public void setNome_genero(String nome_genero) {
        this.nome_genero = nome_genero;
    }
}
