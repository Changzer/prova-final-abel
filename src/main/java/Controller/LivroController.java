package Controller;

import DAO.GeneroDAO;
import DAO.LivroDAO;
import Model.Biblioteca;
import Model.Genero;
import Model.Livro;
import View.LivroView;

import java.sql.SQLException;
import java.util.List;

public class LivroController {
    private LivroView view;
    private LivroDAO dao = new LivroDAO();


    public LivroController(){
        this.view = new LivroView(this);
    }

    public Livro addLivros(Livro livro){
        return dao.createLivro(livro);
    }

    public List<Livro> getModels() {
        return dao.listLivros();
    }

    public void editeLivro(Livro livro){
        dao.editeLivro(livro);
    }

    public Livro getById(Long id){
        return dao.getById(id);
    }

  public void start(){
        view.Menu();
    }





}
