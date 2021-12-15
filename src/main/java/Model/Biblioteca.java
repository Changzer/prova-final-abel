package Model;

import java.util.List;

public class Biblioteca extends Livro {
    private Long id_biblioteca;
    private String nome_biblioteca;


    public Biblioteca(Long id_biblioteca, String nome_biblioteca, List<Livro> titulo_livro) {
        this.id_biblioteca = id_biblioteca;
        this.nome_biblioteca = nome_biblioteca;

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



}
