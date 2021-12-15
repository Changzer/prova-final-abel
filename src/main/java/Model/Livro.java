package Model;

import java.util.ArrayList;
import java.util.List;

public class Livro extends Genero {
    private Long id_livro;
    private String titulo_livro;
    private String nome_genero;

    public Livro(Long id_livro, String titulo_livro, String nome_genero) {
        this.id_livro = id_livro;
        this.titulo_livro = titulo_livro;
        this.nome_genero = nome_genero;
    }

    public Livro() {

    }

    public Long getId_livro() {
        return id_livro;
    }

    public void setId_livro(Long id_livro) {
        this.id_livro = id_livro;
    }

    public String getTitulo_livro() {
        return titulo_livro;
    }

    public void setTitulo_livro(String titulo_livro) {
        this.titulo_livro = titulo_livro;
    }

    public String getNome_genero() {
        return nome_genero;
    }

    public void setNome_genero(String nome_genero) {
        this.nome_genero = nome_genero;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id_livro=" + id_livro +
                ", titulo_livro='" + titulo_livro + '\'' +
                ", nome_genero='" + nome_genero + '\'' +
                '}';
    }
}
