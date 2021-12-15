package Model;

import java.util.List;

public class Biblioteca {
    private Long id_biblioteca;
    private String nome_biblioteca;
    private List<Livro> titulo_livro;

    public Biblioteca(Long id_biblioteca, String nome_biblioteca, List<Livro> titulo_livro) {
        this.id_biblioteca = id_biblioteca;
        this.nome_biblioteca = nome_biblioteca;
        this.titulo_livro = titulo_livro;
    }

    public Biblioteca() {

    }

    public Long getId_biblioteca() {
        return id_biblioteca;
    }

    public void setId_biblioteca(Long id_biblioteca) {
        this.id_biblioteca = id_biblioteca;
    }

    public String getNome_biblioteca() {
        return nome_biblioteca;
    }

    public void setNome_biblioteca(String nome_biblioteca) {
        this.nome_biblioteca = nome_biblioteca;
    }

    public List<Livro> getTitulo_livro() {
        return titulo_livro;
    }

    public void setTitulo_livro(List<Livro> titulo_livro) {
        this.titulo_livro = titulo_livro;
    }


}
