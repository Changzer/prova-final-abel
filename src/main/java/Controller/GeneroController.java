package Controller;

import DAO.GeneroDAO;
import Model.Genero;
import Model.Livro;
import View.GeneroView;

import java.util.List;

public class GeneroController {
    private GeneroView view;
    private GeneroDAO dao = new GeneroDAO();

    public GeneroController(){
        this.view = new GeneroView(this);
    }

    public Genero addGenero(Genero genero){
        return dao.createGenero(genero);
    }

    public void start() { view.menu();}

    public List<Genero>  getModels() {
        return dao.listGenero();
    }

    public void editeGenero(Genero genero) {dao.editeGenero(genero);}

    public Genero getById(Long id) { return dao.getById(id);}

    public List<Genero> buscaLivro(Long id) { return dao.buscaLivro(id);}


}
